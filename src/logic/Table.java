package logic;
import java.util.ArrayList;

public class Table {
	private int id;
	private boolean limpia;
	private boolean ocupada;
	private int tipopago; //americano, todaLacuenta, iguales
	private ArrayList<Client> clientes;	
	private Waiter mesero;
	
	public Table(int id, boolean limpia, boolean ocupada) {
		super();
		this.id = id;
		this.limpia = limpia;
		this.ocupada = ocupada;
		this.tipopago=0;
		clientes= new ArrayList<>();
	}
	
	public Waiter getMesero() {
		return mesero;
	}

	public void setMesero(Waiter mesero) {
		this.mesero = mesero;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isLimpia() {
		return limpia;
	}
	public void setLimpia(boolean limpia) {
		this.limpia = limpia;
	}
	public boolean isOcupada() {
		return ocupada;
	}
	public void setOcupada(boolean ocupada) {
		this.ocupada = ocupada;
	}

	public int getTipopago() {
		return tipopago;
	}

	public void setTipopago(int tipopago) {
		this.tipopago = tipopago;
	}

	public ArrayList<Client> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Client> clientes) {
		this.clientes = clientes;
	}


	
}
