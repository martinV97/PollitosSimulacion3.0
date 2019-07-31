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
	
	private static final long serialVersionUID = 1L;
	private JLabel lblTitleWindow;
	private JLabel lblSimulationTime;
	private JLabel lblSimulationDay;
	private JLabel lblSimulationTimeChange;
	private JTextField textFieldTime;
	private JTextField textFieldTimeChange;
	private JTextField textFieldOrderAmount;
	private JTextField textFieldOrderTableOne;
	private JTextField txtDaysOfSimulation;
	private JButton buttonStart;
	private JButton buttonChangeTime;
	private PanelTable panelTables;
	private PanelData panelData;

	public MainWindow(Controller controller) {
		setWindowsParameters();
		lblTitleWindow = new JLabel("Pollito's 3.0");
		lblTitleWindow.setBounds(655, 20, 300, 30);
		lblTitleWindow.setFont(new Font("Courier New", Font.ITALIC, 24));
		this.add(lblTitleWindow);
		startDataLabels();
		addPanels();	
		startControlButtons(controller);
		
	}

	private void addPanels() {
		panelData = new PanelData();
		panelData.setBounds(40, 155, 650, 530);
		panelData.setBorder(BorderFactory.createLineBorder(Color.black));
		panelData.setVisible(true);
		this.add(panelData);
		
		panelTables = new PanelTable();
		panelTables.setBounds(730, 155, 745, 530);
		panelTables.setBorder(BorderFactory.createLineBorder(Color.black));
		panelTables.setVisible(true);
		this.add(panelTables);
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
		lblSimulationTime = new JLabel("Tiempo:");
		lblSimulationTime.setBounds(300, 60, 80, 30);
		this.add(lblSimulationTime);
		
		lblSimulationTimeChange = new JLabel("Nuevo Tiempo (día):");
		lblSimulationTimeChange.setBounds(750, 60, 150, 30);
		lblSimulationTimeChange.setEnabled(true);
		this.add(lblSimulationTimeChange);

		textFieldTime = new JTextField();
		textFieldTime.setBounds(380, 60, 100, 30);
		textFieldTime.setEditable(false);
		this.add(textFieldTime);

		textFieldTimeChange = new JTextField();
		textFieldTimeChange.setBounds(910, 60, 100, 30);
		textFieldTimeChange.setEditable(true);
		this.add(textFieldTimeChange);
		
		lblSimulationDay = new JLabel("Día:");
		lblSimulationDay.setBounds(300, 110, 80, 30);
		this.add(lblSimulationDay);
		
		txtDaysOfSimulation = new JTextField();
		txtDaysOfSimulation.setBounds(380, 110, 100, 30);
		txtDaysOfSimulation.setEditable(false);
		this.add(txtDaysOfSimulation);
	}

	private void startControlButtons(Controller controlador) {
		buttonStart = new JButton("Iniciar");
		buttonStart.setBounds(625, 720, 190, 30);
		buttonStart.addActionListener(controlador);
		buttonStart.setActionCommand(Constants.START);
		this.add(buttonStart);
		
		buttonChangeTime = new JButton("Cambiar");
		buttonChangeTime.setBounds(1025, 60, 90, 30);
		buttonChangeTime.addActionListener(controlador);
		buttonChangeTime.setActionCommand(Constants.CHANGE);
		this.add(buttonChangeTime);
	}

	public void addTables() {
		panelTables.setVisible(true);
		this.repaint();

	}

	public void unableButtonStart() {
		buttonStart.setEnabled(false);
	}

	public void enableButtonStart() {
		buttonStart.setEnabled(true);
	}

	public JTextField getTxtPedidosMesa1() {
		return textFieldOrderTableOne;
	}

	public void setTxtPedidosMesa1(String txtPedidosMesa1) {
		this.textFieldOrderTableOne.setText(txtPedidosMesa1);
	}

	public JTextField getTxtDaysOfSimulation() {
		return txtDaysOfSimulation;
	}

	public void setTxtPedidosMesa2(String txtPedidosMesa2) {
		this.txtDaysOfSimulation.setText(txtPedidosMesa2);
	}
	public JTextField getTimeTxt() {
		return textFieldTime;
	}

	public void setTxttiempo(JTextField txttiempo) {
		this.textFieldTime = txttiempo;
	}

	public JTextField getTxtnumeropedidos() {
		return textFieldOrderAmount;
	}

	public void setTxtnumeropedidos(JTextField txtnumeropedidos) {
		this.textFieldOrderAmount = txtnumeropedidos;
	}

	public PanelTable getPanelTables() {
		return panelTables;
	}

	public void setPanelTablas(PanelTable panelTablas) {
		this.panelTables = panelTablas;
	}

	public PanelData getPanelData() {
		return panelData;
	}

	public void setPanelData(PanelData panelData) {
		this.panelData = panelData;
	}

	public JTextField getTextFieldTimeChange() {
		return textFieldTimeChange;
	}

	public void setTextFieldTimeChange(JTextField textFieldTimeChange) {
		this.textFieldTimeChange = textFieldTimeChange;
	}

	public JButton getButtonChangeTime() {
		return buttonChangeTime;
	}

	public void setButtonChangeTime(JButton buttonChangeTime) {
		this.buttonChangeTime = buttonChangeTime;
	}

	
}
