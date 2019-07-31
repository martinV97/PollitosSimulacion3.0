package logic;
import java.util.ArrayList;

public class Table {
	private int id;
	private boolean clean;
	private boolean busy;
	private int payType;
	private ArrayList<Client> listOfClients;	
	private Waiter waiter;
	
	public Table(int id, boolean limpia, boolean ocupada) {
		super();
		this.id = id;
		this.clean = limpia;
		this.busy = ocupada;
		this.payType=0;
		listOfClients= new ArrayList<>();
	}
	
	public Waiter getWaiter() {
		return waiter;
	}

	public void setWaiter(Waiter mesero) {
		this.waiter = mesero;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isLimpia() {
		return clean;
	}
	public void setLimpia(boolean limpia) {
		this.clean = limpia;
	}
	public boolean isOcupada() {
		return busy;
	}
	public void setOcupada(boolean ocupada) {
		this.busy = ocupada;
	}

	public int getPayType() {
		return payType;
	}

	public void setPayType(int tipopago) {
		this.payType = tipopago;
	}

	public ArrayList<Client> getClients() {
		return listOfClients;
	}

	public void setClientes(ArrayList<Client> clientes) {
		this.listOfClients = clientes;
	}


	
}
