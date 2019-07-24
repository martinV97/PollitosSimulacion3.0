package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import constants.Constants;
import constants.Utils;
import logic.Restaurante;
import view.JDResultData;
import view.MainWindow;

/**
 * Clase que permite gestionar todas las actividades que tendra el sistema
 *
 */
public class Controller implements ActionListener {

	MainWindow mainWindow;
	Restaurante restaurante;
	Timer timer;
	Timer timerTwo;
	Timer timerThree;
	Timer timerFour;
	Timer timerFive;
	
	
	
	public Controller() {
		mainWindow = new MainWindow(this);
		mainWindow.setVisible(true);

		restaurante = new Restaurante();
		restaurante.crearMesas();
		restaurante.generarVentanas(restaurante.getVentana1());
		restaurante.generarVentanas(restaurante.getVentana2());
		restaurante.generarVentanas(restaurante.getVentana3());
	}

	/**
	 * metodo que permite manejar los eventos y clasificarlos dependiendo de su
	 * origen. para este caso solo habra un boton que envciara el comando de empezar
	 * simulacion cada vez que se presione
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case Constants.START:
			restaurante.atenderClientes(restaurante.getVentana1());
			restaurante.atenderClientes(restaurante.getVentana3());
			
			mainWindow.getPanelTablas().deleteAll();
			mainWindow.agregarTablas();

			agregaraTablas();
			agregaraAtendidos();
			agregaraACaja();
			agregaraASatisfechos();

			break;
		case Constants.DAO:
			agregarDatosAObtenidosv1();
			agregarDatosAObtenidosv2();
			agregarDatosAObtenidosv3();
			timerFour= new Timer(100, new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
				}
			});
			
			
			break;
		default:
			break;
		}
	}

	
	public void agregarDatosAObtenidosv1(){
		restaurante.contarPlatos(restaurante.getVentana1());
		restaurante.calificacion(restaurante.getVentana1());
		
		mainWindow.getPanelData().set1(restaurante.platoentradaMasCal());
		mainWindow.getPanelData().set2(restaurante.platofuerteMasCal());
		mainWindow.getPanelData().set3(restaurante.platoPostreMascal());
		mainWindow.getPanelData().set4(restaurante.platoentradaMasVendido());
		mainWindow.getPanelData().set5(restaurante.platofuerteMasVendido());
		mainWindow.getPanelData().set6(restaurante.platoPostreMasVendido());
		mainWindow.getPanelData().set7("Mesero "+restaurante.asignarMesero().getId());
		
	}
	
	public void agregarDatosAObtenidosv2(){
		restaurante.generarVentanas(restaurante.getVentana2());
		restaurante.atenderClientes(restaurante.getVentana2());

		restaurante.contarPlatos(restaurante.getVentana2());
		restaurante.calificacion(restaurante.getVentana2());

		mainWindow.getPanelData().set8(restaurante.platoentradaMasCal());
		mainWindow.getPanelData().set9(restaurante.platofuerteMasCal());
		mainWindow.getPanelData().set10(restaurante.platoPostreMascal());
		mainWindow.getPanelData().set11(restaurante.platoentradaMasVendido());
		mainWindow.getPanelData().set12(restaurante.platofuerteMasVendido());
		mainWindow.getPanelData().set13(restaurante.platoPostreMasVendido());
		mainWindow.getPanelData().set14("Mesero "+restaurante.asignarMesero().getId());
		
	}

	public void agregarDatosAObtenidosv3(){
		restaurante.generarVentanas(restaurante.getVentana3());
		restaurante.atenderClientes(restaurante.getVentana3());

		restaurante.contarPlatos(restaurante.getVentana3());
		restaurante.calificacion(restaurante.getVentana3());

		mainWindow.getPanelData().set15(restaurante.platoentradaMasCal());
		mainWindow.getPanelData().set16(restaurante.platofuerteMasCal());
		mainWindow.getPanelData().set17(restaurante.platoPostreMascal());
		mainWindow.getPanelData().set18(restaurante.platoentradaMasVendido());
		mainWindow.getPanelData().set19(restaurante.platofuerteMasVendido());
		mainWindow.getPanelData().set20(restaurante.platoPostreMasVendido());
		mainWindow.getPanelData().set21("Mesero "+restaurante.asignarMesero().getId());

		
	}
	
	public void agregaraTablas() {
		timer = new Timer(getRandomNumber(500.0, 1500.0), new ActionListener() {
			int dia = 0;

			@Override
			public void actionPerformed(ActionEvent e) {
				mainWindow.getPanelTablas().agregaraMesa1(restaurante.getVentana1().get(dia).getClientes(), dia);

				dia++;
				if (restaurante.getVentana1().size() == dia) {
					timer.stop();

				}
			}
		});
		timer.start();
		tiempo();
		mainWindow.desabilitarboton();
		

	}

	public void agregaraACaja() {
		timerThree = new Timer(getRandomNumber(100.0, 150.0), new ActionListener() {
			int dia = 0;
			int f = 0;

			@Override
			public void actionPerformed(ActionEvent e) {
				if (dia < 7) {
					if (mainWindow.getPanelTablas().getCantidad2() > restaurante.getVentana1().get(dia)
							.getClientes().get(f).size()) {
						mainWindow.getPanelTablas()
								.deleteMesa2(restaurante.getVentana1().get(dia).getClientes().get(f).size());
						mainWindow.getPanelTablas()
								.agregaraMesa3(restaurante.getVentana1().get(dia).getClientes().get(f), dia);

					}
					f++;
					if (restaurante.getVentana1().get(dia).getClientes().size() == f) {
						dia++;
						f = 0;
					}
				}

				if (dia == 7) {
					mainWindow.getPanelTablas().deleteAllMesa2();
				}
			}
		});
		timerThree.start();

	}

	public void agregaraASatisfechos() {
		timerFive = new Timer(getRandomNumber(100.0, 150.0), new ActionListener() {
			int dia = 0;
			int f = 0;

			int pedidosmesa1 = 0;
			int pedidosmesa2 = 0;
			int pedidosmesa3 = 0;
			int pedidosmesa4 = 0;
			int pedidosmesa5 = 0;

			@Override
			public void actionPerformed(ActionEvent e) {
				if (dia < 7) {
					if (mainWindow.getPanelTablas().getCantidad3() > restaurante.getVentana1().get(dia)
							.getClientes().get(f).size()) {
						mainWindow.getPanelTablas()
								.deleteMesa3(restaurante.getVentana1().get(dia).getClientes().get(f).size());
						mainWindow.getPanelTablas()
								.agregaraMesa4(restaurante.getVentana1().get(dia).getClientes().get(f), dia);

					}
					f++;
					if (restaurante.getVentana1().get(dia).getClientes().size() == f) {
						dia++;
						f = 0;
					}
				}

				if (dia == 7) {
					mainWindow.getPanelTablas().deleteAllMesa3();
					mainWindow.enableButtonStart();
					mainWindow.enableButtonData();
				}
			}
		});
		timerFive.start();
	}

	public void agregaraAtendidos() {
		restaurante.atenderClientes(restaurante.getVentana1());
		timerFour = new Timer(getRandomNumber(100.0, 150.0), new ActionListener() {
			int dia = 0;
			int f = 0;

			@Override
			public void actionPerformed(ActionEvent e) {
				if (dia < 7 && mainWindow.getPanelTablas().getCantidad2() < 60) {
					if (mainWindow.getPanelTablas().getCantidad1() > restaurante.getVentana1().get(dia)
							.getClientes().get(f).size()) {
						mainWindow.getPanelTablas()
								.deleteMesa1(restaurante.getVentana1().get(dia).getClientes().get(f).size());
						mainWindow.getPanelTablas()
								.agregaraMesa2(restaurante.getVentana1().get(dia).getClientes().get(f), dia);

					}
					f++;
					if (restaurante.getVentana1().get(dia).getClientes().size() == f) {
						dia++;
						f = 0;
					}
				}

				if (dia == 7) {
					mainWindow.getPanelTablas().deleteAllMesa1();
				}
			}
		});
		timerFour.start();

	}

	/*
	 * 
	 * metodo que permite contabilizar un tiempo aproximado hasta que se siimulen
	 * las 150 horas de trabajo
	 */
	public void tiempo() {
		timerTwo = new Timer(210, new ActionListener() {
			int hora = 1;
			int dia=0;
			int ventana=0;
			int a=70;

			@Override
			public void actionPerformed(ActionEvent e) {
				mainWindow.getTxttiempo().setText(hora + " horas");
				hora++;
				if (hora%10==0) {
					dia++;
					mainWindow.getTxtDaysOfSimulation().setText(dia+"");
				}
				if (hora==a) {
					a+=70;
					ventana++;
				}
				
				if (hora == 210) {
					timerTwo.stop();
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
