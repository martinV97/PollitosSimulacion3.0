package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import controller.Controlador;

public class MainWindow extends JFrame {
	/**
	 * Ventana principal de la aplicacion junto con cada uno de sus componentes y
	 * paneles
	 */
	private static final long serialVersionUID = 1L;
	JLabel lblTitulo;
	JLabel lbltiempo;
	JLabel lblnumeroPedidos;

	JLabel lblpedidosMesa1;
	JLabel lblpedidosMesa2;
	JLabel lblpedidosMesa3;
	JLabel lblpedidosMesa4;
	JLabel lblpedidosMesa5;

	JTextField txttiempo;
	JTextField txtnumeropedidos;

	JTextField txtPedidosMesa1;
	JTextField txtPedidosMesa2;
	JTextField txtPedidosMesa3;
	JTextField txtPedidosMesa4;
	JTextField txtPedidosMesa5;

	JButton btnIniciar;

	PanelTablas panelTablas;
	private JButton btnDatos;

	public MainWindow(Controlador controlador) {

		this.setResizable(true);
		this.setTitle("Pollito's");
		this.setSize(1300, 720);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);

		lblTitulo = new JLabel("Restaurante Pollito's");
		lblTitulo.setFont(new Font("Forte", 0, 30));
		lblTitulo.setBounds(500, 20, 300, 30);
		this.add(lblTitulo);

		lbltiempo = new JLabel("Tiempo:");
		lbltiempo.setBounds(300, 60, 80, 30);
		this.add(lbltiempo);

		txttiempo = new JTextField();
		txttiempo.setBounds(380, 60, 100, 30);
		txttiempo.setEditable(false);
		this.add(txttiempo);

		lblnumeroPedidos = new JLabel("Total de pedidos en el tiempo trascurrido: ");
		lblnumeroPedidos.setBounds(560, 60, 240, 30);
		this.add(lblnumeroPedidos);

		txtnumeropedidos = new JTextField();
		txtnumeropedidos.setEditable(false);
		txtnumeropedidos.setBounds(820, 60, 100, 30);
		this.add(txtnumeropedidos);

		JPanel panelPedidos = new JPanel();
		panelPedidos.setBounds(20, 110, 1245, 60);
		panelPedidos.setLayout(new GridLayout(1, 4));
		TitledBorder bf2 = BorderFactory.createTitledBorder("Datos Simulación");
		bf2.setTitleFont(new Font("Forte", 0, 16));
		bf2.setTitleColor(Color.decode("#36A8E1"));
		panelPedidos.setBorder(bf2);
		lblpedidosMesa1 = new JLabel("Ventana:");
		panelPedidos.add(lblpedidosMesa1);

		txtPedidosMesa1 = new JTextField();
		txtPedidosMesa1.setEditable(false);
		panelPedidos.add(txtPedidosMesa1);

		lblpedidosMesa2 = new JLabel("Dia:");
		panelPedidos.add(lblpedidosMesa2);

		txtPedidosMesa2 = new JTextField(2);
		txtPedidosMesa2.setEditable(false);
		panelPedidos.add(txtPedidosMesa2);

		this.add(panelPedidos);

		btnIniciar = new JButton("Iniciar Simulación");
		btnIniciar.setBackground(Color.decode("#89CDF0"));
		btnIniciar.setFont(new Font("Forte", 0, 18));
		btnIniciar.setBounds(650, 200, 190, 30);
		btnIniciar.addActionListener(controlador);
		btnIniciar.setActionCommand(Controlador.EMPEZAR_SIMULACION);
		this.add(btnIniciar);

		btnDatos = new JButton("Datos Obtenidos");
		btnDatos.setBackground(Color.decode("#89CDF0"));
		btnDatos.setFont(new Font("Forte", 0, 18));
		btnDatos.setBounds(450, 200, 190, 30);
		btnDatos.addActionListener(controlador);
		btnDatos.setActionCommand(Controlador.DAO);
		btnDatos.setEnabled(false);
		
		this.add(btnDatos);
		panelTablas = new PanelTablas();
		panelTablas.setBounds(10, 255, 1245, 500);
		panelTablas.setVisible(false);
		this.add(panelTablas);

	}

	public void agregarTablas() {
		panelTablas.setVisible(true);
		this.repaint();

	}

	public void desabilitarboton() {
		btnIniciar.setEnabled(false);
	}

	
	
	public void habilitarboton() {
		btnIniciar.setEnabled(true);
	}

	public void habilitarboton2() {
		btnDatos.setEnabled(true);
	}

	
	public void vaciartxt() {
		txtnumeropedidos.setText("");
	}

	public JTextField getTxtPedidosMesa1() {
		return txtPedidosMesa1;
	}

	public void setTxtPedidosMesa1(String txtPedidosMesa1) {
		this.txtPedidosMesa1.setText(txtPedidosMesa1);
	}

	public JTextField getTxtPedidosMesa2() {
		return txtPedidosMesa2;
	}

	public void setTxtPedidosMesa2(String txtPedidosMesa2) {
		this.txtPedidosMesa2.setText(txtPedidosMesa2);
	}

	public JTextField getTxtPedidosMesa3() {
		return txtPedidosMesa3;
	}

	public void setTxtPedidosMesa3(JTextField txtPedidosMesa3) {
		this.txtPedidosMesa3 = txtPedidosMesa3;
	}

	public JTextField getTxtPedidosMesa4() {
		return txtPedidosMesa4;
	}

	public void setTxtPedidosMesa4(JTextField txtPedidosMesa4) {
		this.txtPedidosMesa4 = txtPedidosMesa4;
	}

	public JTextField getTxtPedidosMesa5() {
		return txtPedidosMesa5;
	}

	public void setTxtPedidosMesa5(JTextField txtPedidosMesa5) {
		this.txtPedidosMesa5 = txtPedidosMesa5;
	}

	public JTextField getTxttiempo() {
		return txttiempo;
	}

	public void setTxttiempo(JTextField txttiempo) {
		this.txttiempo = txttiempo;
	}

	public JTextField getTxtnumeropedidos() {
		return txtnumeropedidos;
	}

	public void setTxtnumeropedidos(JTextField txtnumeropedidos) {
		this.txtnumeropedidos = txtnumeropedidos;
	}

	public PanelTablas getPanelTablas() {
		return panelTablas;
	}

	public void setPanelTablas(PanelTablas panelTablas) {
		this.panelTablas = panelTablas;
	}

}
