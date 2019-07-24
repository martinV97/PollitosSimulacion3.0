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

import constants.Constants;
import controller.Controller;

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
	JLabel lblDay;
	JLabel lblpedidosMesa3;
	JLabel lblpedidosMesa4;
	JLabel lblpedidosMesa5;

	JTextField txttiempo;
	JTextField txtnumeropedidos;

	JTextField txtPedidosMesa1;
	JTextField txtDaysOfSimulation;
	JTextField txtPedidosMesa3;
	JTextField txtPedidosMesa4;
	JTextField txtPedidosMesa5;

	JButton btnIniciar;

	PanelTable panelTablas;
	PanelData panelData;
	
	private JButton btnDatos;

	public MainWindow(Controller controlador) {

		setWindowsParameters();

		lblTitulo = new JLabel("Pollito's 3.0");
		lblTitulo.setBounds(555, 20, 300, 30);
		lblTitulo.setFont(new Font("Courier New", Font.ITALIC, 24));
		this.add(lblTitulo);

		startDataLabels();
		
		panelData = new PanelData();
		panelData.setBounds(40, 155, 650, 530);
		panelData.setBorder(BorderFactory.createLineBorder(Color.black));
		panelData.setVisible(true);
		this.add(panelData);
		
		panelTablas = new PanelTable();
		panelTablas.setBounds(730, 155, 745, 530);
		panelTablas.setBorder(BorderFactory.createLineBorder(Color.black));
		panelTablas.setVisible(true);
		this.add(panelTablas);
		
		
		startControlButtons(controlador);
		
	}

	private void setWindowsParameters() {
		this.setResizable(true);
		this.setTitle("Pollito's");
		this.setSize(Constants.WIDTH_WINDOW, Constants.HEIGHT_WINDOW);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);
	}

	private void startDataLabels() {
		lbltiempo = new JLabel("Tiempo:");
		lbltiempo.setBounds(300, 60, 80, 30);
		this.add(lbltiempo);

		txttiempo = new JTextField();
		txttiempo.setBounds(380, 60, 100, 30);
		txttiempo.setEditable(false);
		this.add(txttiempo);

		lblDay = new JLabel("Día:");
		lblDay.setBounds(300, 110, 80, 30);
		this.add(lblDay);
		
		txtDaysOfSimulation = new JTextField();
		txtDaysOfSimulation.setBounds(380, 110, 100, 30);
		txtDaysOfSimulation.setEditable(false);
		this.add(txtDaysOfSimulation);
	}

	private void startControlButtons(Controller controlador) {
		btnDatos = new JButton("Datos Obtenidos");
		btnDatos.setBounds(525, 720, 190, 30);
		btnDatos.addActionListener(controlador);
		btnDatos.setActionCommand(Constants.DAO);
		btnDatos.setEnabled(false);
		this.add(btnDatos);

		btnIniciar = new JButton("Iniciar");
		btnIniciar.setBounds(725, 720, 190, 30);
		btnIniciar.addActionListener(controlador);
		btnIniciar.setActionCommand(Constants.START);
		this.add(btnIniciar);
	}

	public void agregarTablas() {
		panelTablas.setVisible(true);
		this.repaint();

	}

	public void desabilitarboton() {
		btnIniciar.setEnabled(false);
	}

	public void enableButtonStart() {
		btnIniciar.setEnabled(true);
	}

	public void enableButtonData() {
		btnDatos.setEnabled(true);
	}

	public JTextField getTxtPedidosMesa1() {
		return txtPedidosMesa1;
	}

	public void setTxtPedidosMesa1(String txtPedidosMesa1) {
		this.txtPedidosMesa1.setText(txtPedidosMesa1);
	}

	public JTextField getTxtDaysOfSimulation() {
		return txtDaysOfSimulation;
	}

	public void setTxtPedidosMesa2(String txtPedidosMesa2) {
		this.txtDaysOfSimulation.setText(txtPedidosMesa2);
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

	public PanelTable getPanelTablas() {
		return panelTablas;
	}

	public void setPanelTablas(PanelTable panelTablas) {
		this.panelTablas = panelTablas;
	}

	public PanelData getPanelData() {
		return panelData;
	}

	public void setPanelData(PanelData panelData) {
		this.panelData = panelData;
	}

	
}
