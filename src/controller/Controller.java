package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import constants.Constants;
import constants.Utils;
import logic.Restaurant;
import view.MainWindow;

public class Controller implements ActionListener {

	MainWindow mainWindow;
	Restaurant restaurant;
	Timer timer;
	Timer timerTwo;
	Timer timerThree;
	Timer timerFour;
	Timer timerFive;
	int workPerDay = 10;
	
	
	
	public Controller() {
		mainWindow = new MainWindow(this);
		mainWindow.setVisible(true);
		restaurant = new Restaurant();
		restaurant.startTables();
		restaurant.startSimulationEnvironments(restaurant.getListOfDaysOne());
		restaurant.startSimulationEnvironments(restaurant.getListOfDaysTwo());
		restaurant.startSimulationEnvironments(restaurant.getListOfDaysThree());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case Constants.START:
			restaurant.attendClients(restaurant.getListOfDaysOne());
			restaurant.attendClients(restaurant.getListOfDaysTwo());
			restaurant.attendClients(restaurant.getListOfDaysThree());
			mainWindow.getPanelTables().deleteAll();
			mainWindow.addTables();
			addTables();
			addAtendedClients();
			addToPayment();
			addSatisfiedClient();

			break;
		case Constants.CHANGE:
			workPerDay = Integer.parseInt(mainWindow.getTextFieldTimeChange().getText());
			mainWindow.getTextFieldTimeChange().setText("");
			break;
		default:
			break;
		}
	}

	
	public void addDataLisOfDaysOne(){
		restaurant.countDishes(restaurant.getListOfDaysOne());
		restaurant.setScore(restaurant.getListOfDaysOne());
		mainWindow.getPanelData().set1(restaurant.getMostScoredEntrance());
		mainWindow.getPanelData().set2(restaurant.getMostScoredMainCourse());
		mainWindow.getPanelData().set3(restaurant.getMostScoredDessert());
		mainWindow.getPanelData().set4(restaurant.getMostSelledEntrance());
		mainWindow.getPanelData().set5(restaurant.getMostSelledMainCourse());
		mainWindow.getPanelData().set6(restaurant.getMostSelledDessert());
		mainWindow.getPanelData().set7("Mesero "+restaurant.setWaiter().getId());	
	}
	
	public void addDataLisOfDaysTwo(){
		restaurant.startSimulationEnvironments(restaurant.getListOfDaysTwo());
		restaurant.attendClients(restaurant.getListOfDaysTwo());
		restaurant.countDishes(restaurant.getListOfDaysTwo());
		restaurant.setScore(restaurant.getListOfDaysTwo());
		mainWindow.getPanelData().set8(restaurant.getMostScoredEntrance());
		mainWindow.getPanelData().set9(restaurant.getMostScoredMainCourse());
		mainWindow.getPanelData().set10(restaurant.getMostScoredDessert());
		mainWindow.getPanelData().set11(restaurant.getMostSelledEntrance());
		mainWindow.getPanelData().set12(restaurant.getMostSelledMainCourse());
		mainWindow.getPanelData().set13(restaurant.getMostSelledDessert());
		mainWindow.getPanelData().set14("Mesero "+restaurant.setWaiter().getId());	
	}

	public void addDataLisOfDaysThree(){
		restaurant.startSimulationEnvironments(restaurant.getListOfDaysThree());
		restaurant.attendClients(restaurant.getListOfDaysThree());
		restaurant.countDishes(restaurant.getListOfDaysThree());
		restaurant.setScore(restaurant.getListOfDaysThree());
		mainWindow.getPanelData().set15(restaurant.getMostScoredEntrance());
		mainWindow.getPanelData().set16(restaurant.getMostScoredMainCourse());
		mainWindow.getPanelData().set17(restaurant.getMostScoredDessert());
		mainWindow.getPanelData().set18(restaurant.getMostSelledEntrance());
		mainWindow.getPanelData().set19(restaurant.getMostSelledMainCourse());
		mainWindow.getPanelData().set20(restaurant.getMostSelledDessert());
		mainWindow.getPanelData().set21("Mesero "+restaurant.setWaiter().getId());		
	}
	
	public void addTables() {
		timer = new Timer(getRandomNumber(500.0, 1500.0), new ActionListener() {
			int day = 0;
			@Override
			public void actionPerformed(ActionEvent e) {
				mainWindow.getPanelTables().addTableOne(restaurant.getListOfDaysOne().get(day).getClients(), day);
				day++;
				if (restaurant.getListOfDaysOne().size() == day) {
					timer.stop();
				}
			}
		});
		timer.start();
		time();
		mainWindow.unableButtonStart();
	}
	
	public void addAtendedClients() {
		restaurant.attendClients(restaurant.getListOfDaysOne());
		timerFour = new Timer(130, new ActionListener() {
			int day = 0;
			int f = 0;
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (day < 7 && mainWindow.getPanelTables().getCantidad2() < 60) {
					if (mainWindow.getPanelTables().getCantidad1() > restaurant.getListOfDaysOne().get(day)
							.getClients().get(f).size()) {
						mainWindow.getPanelTables()
						.deleteTableOne(restaurant.getListOfDaysOne().get(day).getClients().get(f).size());
						mainWindow.getPanelTables()
						.addTableTwo(restaurant.getListOfDaysOne().get(day).getClients().get(f), day);
					}
					f++;
					if (restaurant.getListOfDaysOne().get(day).getClients().size() == f) {
						day++;
						f = 0;
					}
				}
				if (day == 7) {
					mainWindow.getPanelTables().deleteAlltableOne();
				}
			}
		});
		timerFour.start();
	}

	public void addToPayment() {
		timerThree = new Timer(130, new ActionListener() {
			int day = 0;
			int f = 0;

			@Override
			public void actionPerformed(ActionEvent e) {
				if (day < 7) {
					if (mainWindow.getPanelTables().getCantidad2() > restaurant.getListOfDaysOne().get(day)
							.getClients().get(f).size()) {
						mainWindow.getPanelTables()
								.deleteMesa2(restaurant.getListOfDaysOne().get(day).getClients().get(f).size());
						mainWindow.getPanelTables()
								.addTableThree(restaurant.getListOfDaysOne().get(day).getClients().get(f), day);
					}
					f++;
					if (restaurant.getListOfDaysOne().get(day).getClients().size() == f) {
						day++;
						f = 0;
					}
				}

				if (day == 7) {
					mainWindow.getPanelTables().deleteAllTableTwo();
				}
			}
		});
		timerThree.start();

	}

	public void addSatisfiedClient() {
		timerFive = new Timer(130, new ActionListener() {
			int day = 0;
			int f = 0;

			@Override
			public void actionPerformed(ActionEvent e) {
				if (day < 7) {
					if (mainWindow.getPanelTables().getCantidad3() > restaurant.getListOfDaysOne().get(day)
							.getClients().get(f).size()) {
						mainWindow.getPanelTables()
								.deleteMesa3(restaurant.getListOfDaysOne().get(day).getClients().get(f).size());
						mainWindow.getPanelTables()
								.addTableFour(restaurant.getListOfDaysOne().get(day).getClients().get(f), day);

					}
					f++;
					if (restaurant.getListOfDaysOne().get(day).getClients().size() == f) {
						day++;
						f = 0;
					}
				}

				if (day == 7) {
					mainWindow.getPanelTables().deleteAllTableThree();
					mainWindow.enableButtonStart();
				}
			}
		});
		timerFive.start();
	}


	public void time() {
		timerTwo = new Timer(215, new ActionListener() {
			int hour = 1;
			int day = 0;

			@Override
			public void actionPerformed(ActionEvent e) {
				mainWindow.getTimeTxt().setText(hour + " horas");
				hour++;
				if (hour % workPerDay == 0) {
					day++;
					mainWindow.getTxtDaysOfSimulation().setText(day + " día");
				}
				if (hour == 211) {
					timerTwo.stop();
					addDataLisOfDaysOne();
					addDataLisOfDaysTwo();
					addDataLisOfDaysThree();	
				}
			}

		});
		timerTwo.start();
	}

	private int getRandomNumber(double a, double b) {
		int ale = 0;
		ale = (int) (Utils.getRandomNumber(a, b));
		return ale;
	}
}
