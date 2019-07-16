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

import logic.Cliente;
import logic.Plato;

/**
 * panel que contiene las tablas que muestran los platos que se solicitaron en
 * cada una de las mesas.
 * 
 * @author XIMENA
 *
 */
public class PanelTablas extends JPanel {
	JTable espera;
	JTable atendidos;
	JTable caja;
	JTable satisfechos;

	DefaultTableModel tabmesa1;
	DefaultTableModel tabmesa2;
	DefaultTableModel tabmesa3;
	DefaultTableModel tabmesa4;

	JScrollPane pane1;
	JScrollPane pane2;
	JScrollPane pane3;
	JScrollPane pane4;
	int aux = 1;

	String[] cabecera = { "Cliente", "Hora LLegada" };
	String[] cabecera2 = { "Cliente", "Pedido" };
	String[] cabecera3 = { "Cliente", "Cuenta" };

	public PanelTablas() {
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
		pane1 = new JScrollPane(espera);
		TitledBorder bf = BorderFactory.createTitledBorder("Clientes en Espera");
		bf.setTitleFont(new Font("Forte", 0, 16));
		bf.setTitleColor(Color.decode("#36A8E1"));
		pane1.setBorder(bf);
		this.add(pane1);

		tabmesa2 = new DefaultTableModel(cabecera2, 0) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}

		};
		atendidos = new JTable(tabmesa2);
		pane2 = new JScrollPane(atendidos);
		TitledBorder bf2 = BorderFactory.createTitledBorder("Clientes Atendidos");
		bf2.setTitleFont(new Font("Forte", 0, 16));
		bf2.setTitleColor(Color.decode("#36A8E1"));
		pane2.setBorder(bf2);
		this.add(pane2);

		tabmesa3 = new DefaultTableModel(cabecera3, 0) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}

		};
		caja = new JTable(tabmesa3);
		pane3 = new JScrollPane(caja);
		TitledBorder bf3 = BorderFactory.createTitledBorder("Clientes en Caja");
		bf3.setTitleFont(new Font("Forte", 0, 16));
		bf3.setTitleColor(Color.decode("#36A8E1"));
		pane3.setBorder(bf3);
		this.add(pane3);

		tabmesa4 = new DefaultTableModel(cabecera, 0) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}

		};
		satisfechos = new JTable(tabmesa4);
		pane4 = new JScrollPane(satisfechos);
		TitledBorder bf4 = BorderFactory.createTitledBorder("Clientes Satisfechos");
		bf4.setTitleFont(new Font("Forte", 0, 16));
		bf4.setTitleColor(Color.decode("#36A8E1"));
		pane4.setBorder(bf4);
		this.add(pane4);

	}

	public void agregaraMesa1(ArrayList<ArrayList<Cliente>> arrayList, int pedido) {

		for (int j = 0; j < arrayList.size(); j++) {
			String[] b = { "pedido", "" + (j + 1) };
			tabmesa1.addRow(b);
			for (int i = 0; i < arrayList.get(j).size(); i++) {
				String[] s = { "" + (i + 1), "" + arrayList.get(j).get(i).getHoraLlegada() };
				tabmesa1.addRow(s);

			}
		}
	}

	public void agregaraMesa2(ArrayList<Cliente> cliente, int id) {
		for (int i = 0; i < cliente.size(); i++) {
			String[] a = { "" + cliente.get(i).getHoraLlegada(), "" + getPedido(cliente.get(i)) };
			tabmesa2.addRow(a);
		}
	}

	public String getPedido(Cliente cliente) {
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

	public void agregaraMesa3(ArrayList<Cliente> cliente, int id) {
		for (int i = 0; i < cliente.size(); i++) {
			String[] a = { "" + cliente.get(i).getHoraLlegada(), "" + cliente.get(i).getCuenta() };
			tabmesa3.addRow(a);
			aux++;
		}
	}

	public void agregaraMesa4(ArrayList<Cliente> cliente, int id) {
		for (int i = 0; i < cliente.size(); i++) {
			String[] a = { "" + aux, "" + cliente.get(i).getHoraLlegada() };
			tabmesa4.addRow(a);
		}
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
