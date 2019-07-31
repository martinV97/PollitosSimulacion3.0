package view;

import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import logic.Client;

@SuppressWarnings("serial")
public class PanelTable extends JPanel {
	private JTable waitTable;
	private JTable serveTable;
	private JTable paymentTable;
	private JTable satisfiedTable;

	private DefaultTableModel defaultTableModelWait;
	private DefaultTableModel defaultTableModelServe;
	private DefaultTableModel defaultTableModelPayment;
	private DefaultTableModel defaultTableModelSatisfied;

	private JScrollPane paneWaitClients;
	private JScrollPane paneServeClients;
	private JScrollPane panePayClients;
	private JScrollPane paneTotalClients;
	int aux = 1;

	private String[] headerTableWait = { "Cliente", "Hora LLegada" };
	private String[] headerTableOrder = { "Cliente", "Pedido" };
	private String[] headerTableSatisfied = { "Cliente", "Cuenta" };

	public PanelTable() {
		this.setLayout(new GridLayout(1, 5));
		defaultTableModelWait = new DefaultTableModel(headerTableWait, 0) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}

		};

		waitTable = new JTable(defaultTableModelWait);
		waitTable.setEditingColumn(0);
		paneWaitClients = new JScrollPane(waitTable);
		TitledBorder bf = BorderFactory.createTitledBorder("Clientes en Espera");
		paneWaitClients.setBorder(bf);
		this.add(paneWaitClients);

		defaultTableModelServe = new DefaultTableModel(headerTableOrder, 0) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}

		};
		serveTable = new JTable(defaultTableModelServe);
		paneServeClients = new JScrollPane(serveTable);
		TitledBorder bf2 = BorderFactory.createTitledBorder("Clientes en mesa");
		paneServeClients.setBorder(bf2);
		this.add(paneServeClients);

		defaultTableModelPayment = new DefaultTableModel(headerTableSatisfied, 0) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}

		};
		paymentTable = new JTable(defaultTableModelPayment);
		panePayClients = new JScrollPane(paymentTable);
		TitledBorder bf3 = BorderFactory.createTitledBorder("Clientes en Caja");
		panePayClients.setBorder(bf3);
		this.add(panePayClients);

		defaultTableModelSatisfied = new DefaultTableModel(headerTableWait, 0) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}

		};
		satisfiedTable = new JTable(defaultTableModelSatisfied);
		paneTotalClients = new JScrollPane(satisfiedTable);
		TitledBorder bf4 = BorderFactory.createTitledBorder("Clientes Totales");
		paneTotalClients.setBorder(bf4);
		this.add(paneTotalClients);

	}

	public void addTableOne(ArrayList<ArrayList<Client>> arrayList, int pedido) {
		for (int j = 0; j < arrayList.size(); j++) {
			String[] b = { "pedido", "" + (j + 1) };
			defaultTableModelWait.addRow(b);
			for (int i = 0; i < arrayList.get(j).size(); i++) {
				String[] s = { "" + (i + 1), "" + arrayList.get(j).get(i).getHoraLlegada() };
				defaultTableModelWait.addRow(s);
			}
		}
	}

	public void addTableTwo(ArrayList<Client> cliente, int id) {
		for (int i = 0; i < cliente.size(); i++) {
			String[] a = { "" + cliente.get(i).getHoraLlegada(), "" + addOrder(cliente.get(i)) };
			defaultTableModelServe.addRow(a);
		}
	}

	public void addTableThree(ArrayList<Client> cliente, int id) {
		for (int i = 0; i < cliente.size(); i++) {
			String[] a = { "" + cliente.get(i).getHoraLlegada(), "" + cliente.get(i).getCuenta() };
			defaultTableModelPayment.addRow(a);
			aux++;
		}
	}
	
	public void addTableFour(ArrayList<Client> client, int id) {
		for (int i = 0; i < client.size(); i++) {
			String[] a = { "" + aux, "" + client.get(i).getHoraLlegada() };
			defaultTableModelSatisfied.addRow(a);
		}
	}

	public String addOrder(Client client) {
		String aux = "";
		if (client.getOrders().getEntrances() != null) {
			aux += client.getOrders().getEntrances().getNombre() + "," + client.getOrders().getMainCourse().getNombre()
					+ ",";
		} else {
			if (client.getOrders().getMainCourse() != null) {
				aux += client.getOrders().getMainCourse().getNombre() + ",";
			}
		}
		if (client.getOrders().getDesserts().size() > 1) {
			aux += client.getOrders().getDesserts().get(0).getNombre() + ","
					+ client.getOrders().getDesserts().get(1).getNombre();
		} else {
			if (client.getOrders().getDesserts().size() == 1) {
				aux += client.getOrders().getDesserts().get(0).getNombre();
			}
		}
		
		return aux;
	}
	
	public int getCantidad1() {
		return defaultTableModelWait.getRowCount();
	}

	public int getCantidad2() {
		return defaultTableModelServe.getRowCount();
	}

	public int getCantidad3() {
		return defaultTableModelPayment.getRowCount();
	}


	public void deleteAll() {
		int filas = defaultTableModelWait.getRowCount();
		int filas2 = defaultTableModelServe.getRowCount();
		int filas3 = defaultTableModelPayment.getRowCount();
		int filas4 = defaultTableModelSatisfied.getRowCount();

		for (int i = 0; i < filas; i++) {
			defaultTableModelWait.removeRow(0);
		}
		for (int i = 0; i < filas2; i++) {
			defaultTableModelServe.removeRow(0);
		}
		for (int i = 0; i < filas3; i++) {
			defaultTableModelPayment.removeRow(0);
		}
		for (int i = 0; i < filas4; i++) {
			defaultTableModelSatisfied.removeRow(0);
		}

	}

	public void deleteAlltableOne() {
		int filas = defaultTableModelWait.getRowCount();
		for (int i = 0; i < filas; i++) {
			defaultTableModelWait.removeRow(0);
		}
	}

	public void deleteAllTableTwo() {
		int filas = defaultTableModelServe.getRowCount();
		for (int i = 0; i < filas; i++) {
			defaultTableModelServe.removeRow(0);
		}
	}

	public void deleteAllTableThree() {
		int filas = defaultTableModelPayment.getRowCount();
		for (int i = 0; i < filas; i++) {
			defaultTableModelPayment.removeRow(0);
		}
	}

	public void deleteTableOne(int size) {
		for (int i = 0; i < (size + 1); i++) {
			defaultTableModelWait.removeRow(0);
		}

	}

	public void deleteMesa2(int size) {
		for (int i = 0; i < size; i++) {
			defaultTableModelServe.removeRow(0);
		}

	}

	public void deleteMesa3(int size) {
		for (int i = 0; i < size; i++) {
			defaultTableModelPayment.removeRow(0);
		}

	}
}
