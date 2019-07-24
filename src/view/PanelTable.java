package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import logic.Client;
import logic.Dish;

/**
 * panel que contiene las tablas que muestran los platos que se solicitaron en
 * cada una de las mesas.
 * 
 *
 */
@SuppressWarnings("serial")
public class PanelTable extends JPanel {
	JTable espera;
	JTable atendidos;
	JTable caja;
	JTable satisfechos;

	DefaultTableModel tabmesa1;
	DefaultTableModel tabmesa2;
	DefaultTableModel tabmesa3;
	DefaultTableModel tabmesa4;

	JScrollPane paneWaitClients;
	JScrollPane paneServeClients;
	JScrollPane panePayClients;
	JScrollPane paneTotalClients;
	int aux = 1;

	String[] cabecera = { "Cliente", "Hora LLegada" };
	String[] cabecera2 = { "Cliente", "Pedido" };
	String[] cabecera3 = { "Cliente", "Cuenta" };

	public PanelTable() {
		this.setLayout(new GridLayout(1, 5));
		tabmesa1 = new DefaultTableModel(cabecera, 0) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}

		};

		espera = new JTable(tabmesa1);
		espera.setEditingColumn(0);
		paneWaitClients = new JScrollPane(espera);
		TitledBorder bf = BorderFactory.createTitledBorder("Clientes en Espera");
		paneWaitClients.setBorder(bf);
		this.add(paneWaitClients);

		tabmesa2 = new DefaultTableModel(cabecera2, 0) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}

		};
		atendidos = new JTable(tabmesa2);
		paneServeClients = new JScrollPane(atendidos);
		TitledBorder bf2 = BorderFactory.createTitledBorder("Clientes en mesa");
		paneServeClients.setBorder(bf2);
		this.add(paneServeClients);

		tabmesa3 = new DefaultTableModel(cabecera3, 0) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}

		};
		caja = new JTable(tabmesa3);
		panePayClients = new JScrollPane(caja);
		TitledBorder bf3 = BorderFactory.createTitledBorder("Clientes en Caja");
		panePayClients.setBorder(bf3);
		this.add(panePayClients);

		tabmesa4 = new DefaultTableModel(cabecera, 0) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}

		};
		satisfechos = new JTable(tabmesa4);
		paneTotalClients = new JScrollPane(satisfechos);
		TitledBorder bf4 = BorderFactory.createTitledBorder("Clientes Totales");
		paneTotalClients.setBorder(bf4);
		this.add(paneTotalClients);

	}

	public void agregaraMesa1(ArrayList<ArrayList<Client>> arrayList, int pedido) {
		for (int j = 0; j < arrayList.size(); j++) {
			String[] b = { "pedido", "" + (j + 1) };
			tabmesa1.addRow(b);
			for (int i = 0; i < arrayList.get(j).size(); i++) {
				String[] s = { "" + (i + 1), "" + arrayList.get(j).get(i).getHoraLlegada() };
				tabmesa1.addRow(s);
			}
		}
	}

	public void agregaraMesa2(ArrayList<Client> cliente, int id) {
		for (int i = 0; i < cliente.size(); i++) {
			String[] a = { "" + cliente.get(i).getHoraLlegada(), "" + getPedido(cliente.get(i)) };
			tabmesa2.addRow(a);
		}
	}

	public void agregaraMesa3(ArrayList<Client> cliente, int id) {
		for (int i = 0; i < cliente.size(); i++) {
			String[] a = { "" + cliente.get(i).getHoraLlegada(), "" + cliente.get(i).getCuenta() };
			tabmesa3.addRow(a);
			aux++;
		}
	}
	
	public void agregaraMesa4(ArrayList<Client> cliente, int id) {
		for (int i = 0; i < cliente.size(); i++) {
			String[] a = { "" + aux, "" + cliente.get(i).getHoraLlegada() };
			tabmesa4.addRow(a);
		}
	}

	public String getPedido(Client cliente) {
		String aux = "";
		if (cliente.getPedidos().getEntradas() != null) {
			aux += cliente.getPedidos().getEntradas().getNombre() + "," + cliente.getPedidos().getFuertes().getNombre()
					+ ",";
		} else {
			if (cliente.getPedidos().getFuertes() != null) {
				aux += cliente.getPedidos().getFuertes().getNombre() + ",";
			}
		}
		if (cliente.getPedidos().getPostres().size() > 1) {
			aux += cliente.getPedidos().getPostres().get(0).getNombre() + ","
					+ cliente.getPedidos().getPostres().get(1).getNombre();
		} else {
			if (cliente.getPedidos().getPostres().size() == 1) {
				aux += cliente.getPedidos().getPostres().get(0).getNombre();
			}
		}
		
		return aux;
	}
	
	public int getCantidad1() {
		return tabmesa1.getRowCount();
	}

	public int getCantidad2() {
		return tabmesa2.getRowCount();
	}

	public int getCantidad3() {
		return tabmesa3.getRowCount();
	}


	public void deleteAll() {
		int filas = tabmesa1.getRowCount();
		int filas2 = tabmesa2.getRowCount();
		int filas3 = tabmesa3.getRowCount();
		int filas4 = tabmesa4.getRowCount();

		for (int i = 0; i < filas; i++) {
			tabmesa1.removeRow(0);
		}
		for (int i = 0; i < filas2; i++) {
			tabmesa2.removeRow(0);
		}
		for (int i = 0; i < filas3; i++) {
			tabmesa3.removeRow(0);
		}
		for (int i = 0; i < filas4; i++) {
			tabmesa4.removeRow(0);
		}

	}

	public void deleteAllMesa1() {
		int filas = tabmesa1.getRowCount();
		for (int i = 0; i < filas; i++) {
			tabmesa1.removeRow(0);
		}
	}

	public void deleteAllMesa2() {
		int filas = tabmesa2.getRowCount();
		for (int i = 0; i < filas; i++) {
			tabmesa2.removeRow(0);
		}
	}

	public void deleteAllMesa3() {
		int filas = tabmesa3.getRowCount();
		for (int i = 0; i < filas; i++) {
			tabmesa3.removeRow(0);
		}
	}

	public void deleteMesa1(int size) {
		for (int i = 0; i < (size + 1); i++) {
			tabmesa1.removeRow(0);
		}

	}

	public void deleteMesa2(int size) {
		for (int i = 0; i < size; i++) {
			tabmesa2.removeRow(0);
		}

	}

	public void deleteMesa3(int size) {
		for (int i = 0; i < size; i++) {
			tabmesa3.removeRow(0);
		}

	}
}
