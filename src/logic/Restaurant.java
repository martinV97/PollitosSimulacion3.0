package logic;

import java.util.ArrayList;
import constants.Utils;
import model.MyQueue;

public class Restaurant{
	private MyQueue<Table> availableTables;
	private MyQueue<Table> fillTables;
	private ArrayList<Day> listOfDaysOne;
	private ArrayList<Day> listOfDaysTwo;
	private ArrayList<Day> listOfDaysThree;
	private Waiter waiterOne = new Waiter(1);
	private Waiter waiterTwo = new Waiter(2);
	private int tipOne = 0;
	private int tipTwo = 0;
	private ArrayList<Integer> amountMainCourse = new ArrayList<>();
	private ArrayList<Integer> amountDessert = new ArrayList<>();
	private ArrayList<Integer> amountEntrance = new ArrayList<>();
	private ArrayList<Double> scoreMainCourse;
	private ArrayList<Double> scoreEntrances;
	private ArrayList<Double> scoreDesserts;
	private Kitchen kitchen = new Kitchen();
	private PaymentBox paymentBox = new PaymentBox();
	private Chef entrancesChef = new Chef(1);
	private Chef dessertChef = new Chef(2);

	public Restaurant() {
		scoreEntrances = new ArrayList<>();
		scoreMainCourse = new ArrayList<>();
		scoreDesserts = new ArrayList<>();
		listOfDaysOne = new ArrayList<>();
		listOfDaysTwo = new ArrayList<>();
		listOfDaysThree = new ArrayList<>();
		availableTables = new MyQueue<>();
		fillTables = new MyQueue<>();
	}

	public void startSimulationEnvironments(ArrayList<Day> ventana) {
		int aux = 0;
		while (aux != 7) {
			Day day = new Day(aux);
			clientsPerDay(day);
			ventana.add(day);
			aux++;
		}
	}

	public void clientsPerDay(Day day) {
		int suma = 0;
		while (suma < 36000) {
			ArrayList<Client> listOfClients = arrivalClients();
			day.getClients().add(listOfClients);
			suma += listOfClients.get(0).getHoraLlegada();
		}
	}

	public void startTables() {
		int auxi = 1;
		while (availableTables.size() < 14) {
			Table table = new Table(auxi, true, false);
			availableTables.put(table);
			auxi++;
		}
	}

	private ArrayList<Client> arrivalClients() {
		ArrayList<Client> listOfClientsInTable = new ArrayList<>();
		int amountClients = (int) Utils.getRandomNumber(1.0, 4.1);
		int arrivalHour = (int) Utils.getRandomNumber(1.0, 1500.1);
		for (int i = 0; i < amountClients; i++) {
			int pirority = (int) Utils.getRandomNumber(0.0, 1.1);
			int payType = (int) Utils.getRandomNumber(0.0, 1.1);
			Order orders = new Order(pirority);
			Client client = new Client(orders, arrivalHour, payType);
			listOfClientsInTable.add(client);
		}
		return listOfClientsInTable;

	}

	public void attendClients(ArrayList<Day> listOfDays) {
		for (int i = 0; i < listOfDays.size(); i++) {
			Day days = listOfDays.get(i);
			for (int j = 0; j < days.getClients().size(); j++) {
				setAvailableTable(days.getClients().get(j));
			}
		}

	}

	public void setAvailableTable(ArrayList<Client> clientes) {
		if (availableTables.size() > 0) {
			Table table = availableTables.get();
			Waiter waiter = setWaiter();
			if (waiter != null) {
				waiter.getTables().put(table);
				table.setWaiter(waiter);
				fillTables.put(table);
				takeOrder(clientes);
				sendOrderToKitchen(clientes);
				table.setClientes(clientes);
				bringOrder(table);

			}
		}

	}

	public Waiter setWaiter() {
		int waiterChance = (int) Utils.getRandomNumber(0.0, 1.9);
		if (waiterChance == 1) {
			return waiterOne;
		} else {
			return waiterTwo;
		}
	}

	public void takeOrder(ArrayList<Client> cliente) {
		for (int i = 0; i < cliente.size(); i++) {
			askOrder(cliente.get(i));
		}
	}

	public void sendOrderToKitchen(ArrayList<Client> clientsList) {
		for (int i = 0; i < clientsList.size(); i++) {
			Order order = clientsList.get(i).getOrders();
			kitchen.pedidos.put(order);
			if (order.getDesserts().size() != 0) {
				if (order.getDesserts().size() > 1) {
					entrancesChef.dishes.put(order.getDesserts().get(0));
					entrancesChef.dishes.put(order.getDesserts().get(1));
				}
				entrancesChef.dishes.put(order.getDesserts().get(0));
			}
			if (order.getEntrances() != null) {
				dessertChef.dishes.put(order.getEntrances());
			}
			dessertChef.dishes.put(order.getMainCourse());
		}
	}

	public void bringOrder(Table table) {
		int payType = (int) Utils.getRandomNumber(1.0, 3.0);
		for (int i = 0; i < table.getClients().size(); i++) {
		Order order = kitchen.pedidos.get();
		int serviceTime = 0;
		if (order.getEntrances() != null) {
			serviceTime = order.getEntrances().getTiempoPreparacion();
			order.getEntrances().setCalificacion( Utils.getRandomNumber(0.0, 5.1));
		}
		if (order.getDesserts().size() != 0) {
			for (int j = 0; j < order.getDesserts().size(); j++) {
				order.getDesserts().get(j).setCalificacion( Utils.getRandomNumber(0.0, 5.1));
				serviceTime += order.getDesserts().get(j).getTiempoPreparacion();
			}
		}
		serviceTime += order.getMainCourse().getTiempoPreparacion();
		order.getMainCourse().setCalificacion( Utils.getRandomNumber(0.0, 5.1));
		order.setTiempoAtencion(serviceTime);

			if (table.getClients().get(i).getOrders().getId() == order.getId()) {
				table.setLimpia(false);
				table.setLimpia(true);

			}
			table.setPayType(payType);
			generateTypeOfBill(table);
		}

	}

	public void generateTypeOfBill(Table table) {
		if (table.getPayType() == 1) {
			for (int i = 0; i < table.getClients().size(); i++) {
				Client client = table.getClients().get(i);
				client.setBill(bill(client));
				if (client.getPayType() == 0) {
					paymentBox.cashPay.put(client);
				} else {
					paymentBox.cardPay.put(client);
				}
			}

		} else {
			if (table.getPayType() == 2) {
				secondPayType(table);
			} else {
				if (table.getPayType() == 3) {
					thirdPayType(table);
				}
			}
		}

		if (table.getWaiter().getId() == 1) {
			tipOne += generateType(secondPayType(table));
			table.getWaiter().setType(tipOne);
		} else {
			tipTwo += generateType(secondPayType(table));
			table.getWaiter().setType(tipTwo);

		}

		if (fillTables.size() > 0) {
			Table aux = fillTables.get();
			availableTables.put(aux);
		}

	}

	private int secondPayType(Table table) {
		int bill = 0;
		for (int i = 0; i < table.getClients().size(); i++) {
			Client client = table.getClients().get(i);
			bill += bill(client);

		}
		table.getClients().get(0).setBill(bill);
		if (table.getClients().get(0).getPayType() == 0) {
			paymentBox.cashPay.put(table.getClients().get(0));
		} else {
			paymentBox.cardPay.put(table.getClients().get(0));
		}
		return bill;
	}

	private double generateType(int bill) {
		return (bill * 0.1);
	}

	private int thirdPayType(Table table) {
		int bill = 0;
		for (int i = 0; i < table.getClients().size(); i++) {
			Client client = table.getClients().get(i);
			bill += bill(client);

		}
		for (int i = 0; i < table.getClients().size(); i++) {
			Client client = table.getClients().get(i);
			client.setBill(bill / table.getClients().size());
			if (client.getPayType() == 0) {
				paymentBox.cashPay.put(client);
			} else {
				paymentBox.cardPay.put(client);
			}
		}
		return bill;
	}

	public int bill(Client cliente) {
		int total = 0;
		if (cliente.getOrders().getEntrances() != null) {
			total = cliente.getOrders().getEntrances().getPrecio();
		}
		for (int i = 0; i < cliente.getOrders().getDesserts().size(); i++) {
			total += cliente.getOrders().getDesserts().get(i).getPrecio();
		}
		total += cliente.getOrders().getMainCourse().getPrecio();
		return total;

	}

	public void askOrder(Client cliente) {
		ArrayList<Dish> desserts = new ArrayList<>();
		int amountOfDesserts = (int) Utils.getRandomNumber(0.0, 2.1);
		int entrance = (int) Utils.getRandomNumber(0.0, 1.1);
		for (int i = 0; i < amountOfDesserts; i++) {
			desserts.add(desserts());
		}
		cliente.getOrders().setPostres(desserts);
		if (entrance != 0) {
			cliente.getOrders().setEntradas(getRandomEntrance());
		}
		cliente.getOrders().setFuertes(getrandomMainCourse());

	}

	public Dish getRandomEntrance() {
		int selectedDish = (int) Utils.getRandomNumber(1.0, 5.5);
		int consumptionTime = (int) Utils.getRandomNumber(240.0, 600.1);
		Dish dish = new Dish(selectedDish, 1, consumptionTime);
		return dish;
	}

	public Dish getrandomMainCourse() {
		int selectedDish = (int) Utils.getRandomNumber(1.0, 5.5);
		int consumptionTime = (int) Utils.getRandomNumber(900.0, 1200.1);
		Dish dish = new Dish(selectedDish, 2, consumptionTime);
		return dish;
	}

	public Dish desserts() {
		int selectedDish = (int) Utils.getRandomNumber(1.0, 10.5);
		int consumptionTime = (int) Utils.getRandomNumber(300.0, 900.1);
		Dish dish = new Dish(selectedDish, 3, consumptionTime);
		return dish;
	}

	public void countDishes(ArrayList<Day> listOfDays) {
		fillArrayDishes(amountEntrance);
		fillArrayDishes(amountMainCourse);
		fillArrayDishesDessert(amountDessert);
		int aux1 = 0;
		int aux2 = 0;
		int aux3 = 0;
		for (int i = 0; i < listOfDays.size(); i++) {
			ArrayList<ArrayList<Client>> clients = listOfDays.get(i).getClients();
			for (int j = 0; j < clients.size(); j++) {
				for (int j2 = 0; j2 < clients.get(j).size(); j2++) {

					int dishMainCourse = clients.get(j).get(j2).getOrders().getMainCourse().getId() - 1;
					aux1 = amountMainCourse.get(dishMainCourse);
					aux1++;
					amountMainCourse.set(dishMainCourse, aux1);

					if (clients.get(j).get(j2).getOrders().getEntrances() != null) {
						int dishEntrance = clients.get(j).get(j2).getOrders().getEntrances().getId() - 1;
						aux2 = amountEntrance.get(dishEntrance);
						aux2++;
						amountEntrance.set(dishEntrance, aux2);
					}
					if (clients.get(j).get(j2).getOrders().getDesserts().size() > 0) {
						for (int k = 0; k < clients.get(j).get(j2).getOrders().getDesserts().size(); k++) {
							int dishDessert = clients.get(j).get(j2).getOrders().getDesserts().get(k).getId() - 1;
							aux3 = amountDessert.get(dishDessert);
							aux3++;
							amountDessert.set(dishDessert, aux3);
						}
					}

				}

			}
		}

	}


	public void setScore(ArrayList<Day> listOfDays) {
		fillArraysOfOrder(scoreEntrances);
		fillArraysOfOrder(scoreMainCourse);
		fillArrayDesserts(scoreDesserts);

		double aux1 = 0;
		double aux2 = 0;
		double aux3 = 0;
		for (int i = 0; i < listOfDays.size(); i++) {
			ArrayList<ArrayList<Client>> clients = listOfDays.get(i).getClients();
			for (int j = 0; j < clients.size(); j++) {
				for (int j2 = 0; j2 < clients.get(j).size(); j2++) {
					Order order = clients.get(j).get(j2).getOrders();
					int dishMainCourse = order.getMainCourse().getId() - 1;
					aux1 = (scoreMainCourse.get(dishMainCourse) + order.getMainCourse().getCalificacion());
					scoreMainCourse.set(dishMainCourse, aux1);
					if (order.getEntrances() != null) {
						int dishEntrance = order.getEntrances().getId() - 1;
						aux2 = (scoreEntrances.get(dishEntrance) + order.getEntrances().getCalificacion());
						scoreEntrances.set(dishEntrance, aux2);

					}
					if (order.getDesserts().size() > 0) {
						for (int k = 0; k < clients.get(j).get(j2).getOrders().getDesserts().size(); k++) {
							int dishDessert = clients.get(j).get(j2).getOrders().getDesserts().get(k).getId() - 1;
							aux3 = (scoreDesserts.get(dishDessert) + order.getDesserts().get(k).getCalificacion());
							scoreDesserts.set(dishDessert, aux3);
						}
					}

				}
			}
		}

	}

	private void fillArraysOfOrder(ArrayList<Double> array) {
		for (int i = 0; i < 5; i++) {
			array.add(0.0);
		}
	}
	
	private void fillArrayDesserts(ArrayList<Double> array) {
		for (int i = 0; i < 10; i++) {
			array.add(0.0);
		}
	}
	
	public Integer getMaximo(ArrayList<Integer> numeros) {
		int maximo = numeros.get(0);
		int retorno = 0;
		for (int i = 1; i < numeros.size(); i++) {
			if (maximo < numeros.get(i)) {
				maximo = numeros.get(i);
				retorno = i;
			}
		}
		return retorno;
	}

	private void fillArrayDishes(ArrayList<Integer> array) {
		for (int i = 0; i < 5; i++) {
			array.add(0);
		}
	}

	private void fillArrayDishesDessert(ArrayList<Integer> array) {
		for (int i = 0; i < 10; i++) {
			array.add(0);
		}
	}

	public String getMostSelledMainCourse() {
		Dish plato = new Dish(getMaximo(amountMainCourse) + 1, 2, 0);
		return plato.getNombre();
	}

	public String getMostSelledEntrance() {
		Dish plato = new Dish(getMaximo(amountEntrance) + 1, 1, 0);
		return plato.getNombre();
	}

	public String getMostSelledDessert() {
		Dish plato = new Dish(getMaximo(amountDessert) + 1, 3, 0);
		return plato.getNombre();
	}
	
	public String getMostScoredMainCourse() {
		Dish dish = new Dish(getMaximoD(scoreMainCourse) + 1, 2, 0);
		return dish.getNombre();
	}

	public String getMostScoredEntrance() {
		Dish dish = new Dish(getMaximoD(scoreEntrances) + 1, 1, 0);
		return dish.getNombre();
	}

	public String getMostScoredDessert() {
		Dish dish = new Dish(getMaximoD(scoreDesserts) + 1, 3, 0);
		return dish.getNombre();
	}

	
	
	public Integer getMaximoD(ArrayList<Double> numeros) {
		double maximo = numeros.get(0);
		int retorno = 0;
		for (int i = 1; i < numeros.size(); i++) {
			if (maximo < numeros.get(i)) {
				maximo = numeros.get(i);
				retorno = i;
			}
		}
		return retorno;
	}
	

	public ArrayList<Double> averageSelledOrders(int amount, ArrayList<Double> dishes) {
		ArrayList<Double> auxList = dishes;
		for (int i = 0; i < dishes.size(); i++) {
			double aux=dishes.get(i)/amount;
			auxList.set(i, aux);
		}
		return auxList;
	}

	public MyQueue<Table> getAvailableTables() {
		return availableTables;
	}

	public void setAvailableTables(MyQueue<Table> availableTables) {
		this.availableTables = availableTables;
	}

	public MyQueue<Table> getFillTables() {
		return fillTables;
	}

	public void setFillTables(MyQueue<Table> fillTables) {
		this.fillTables = fillTables;
	}

	public ArrayList<Day> getListOfDaysOne() {
		return listOfDaysOne;
	}

	public void setListOfDaysOne(ArrayList<Day> listOfDays) {
		this.listOfDaysOne = listOfDays;
	}

	public ArrayList<Day> getListOfDaysTwo() {
		return listOfDaysTwo;
	}

	public void setListOfDaysTwo(ArrayList<Day> listOfDays) {
		this.listOfDaysTwo = listOfDays;
	}

	public ArrayList<Day> getListOfDaysThree() {
		return listOfDaysThree;
	}

	public void listOfDaysThree(ArrayList<Day> listOfDays) {
		this.listOfDaysThree = listOfDays;
	}

	public Waiter getWaiterOne() {
		return waiterOne;
	}

	public void setWaiterOne(Waiter mesero1) {
		this.waiterOne = mesero1;
	}

	public Waiter getWaiterTwo() {
		return waiterTwo;
	}

	public void setWaiterTwo(Waiter mesero2) {
		this.waiterTwo = mesero2;
	}

	public int getTipeOne() {
		return tipOne;
	}

	public void setTipOne(int propina1) {
		this.tipOne = propina1;
	}

	public int getTipTwo() {
		return tipTwo;
	}

	public void setTipTwo(int propina2) {
		this.tipTwo = propina2;
	}
}
