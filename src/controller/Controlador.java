package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

import org.omg.CORBA.VersionSpecHelper;

import logic.Dia;
import logic.Pedido;
import logic.Restaurante;
import logic.Uniforme;
import view.JDDatosObteinidos;
import view.MainWindow;

/**
 * Clase que permite gestionar todas las actividades que tendra el sistema
 * 
 * @author XIMENA y Juan David
 *
 */
public class Controlador implements ActionListener {
	public static final String EMPEZAR_SIMULACION = "EMPEZAR SIMULACION";
	public static final String DAO = "Datos";
	MainWindow jframePrincipal;
	JDDatosObteinidos jdDatosObteinidos;
	Restaurante restaurante;
	Uniforme uniforme;
	Timer timer;
	Timer timer2;
	Timer timer3;
	Timer timer4;
	Timer timer5;
	
	
	
	public Controlador() {
		jdDatosObteinidos = new JDDatosObteinidos();
		uniforme = new Uniforme();
		jframePrincipal = new MainWindow(this);
		jframePrincipal.setVisible(true);

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
		case EMPEZAR_SIMULACION:
			restaurante.atenderClientes(restaurante.getVentana1());
			restaurante.atenderClientes(restaurante.getVentana3());
			
			jframePrincipal.getPanelTablas().deleteAll();
			jframePrincipal.vaciartxt();
			jframePrincipal.agregarTablas();

			agregaraTablas();
			agregaraAtendidos();
			agregaraACaja();
			agregaraASatisfechos();

			break;
		case DAO:
			agregarDatosAObtenidosv1();
			agregarDatosAObtenidosv2();
			agregarDatosAObtenidosv3();
			jdDatosObteinidos.setVisible(true);
			timer4= new Timer(100, new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					jdDatosObteinidos.repaint();
				}
			});
			
			
			break;
		default:
			break;
		}
	}

	public void agregarDatosAObtenidosv2(){
		restaurante.generarVentanas(restaurante.getVentana2());
		restaurante.atenderClientes(restaurante.getVentana2());

		restaurante.contarPlatos(restaurante.getVentana2());
		restaurante.calificacion(restaurante.getVentana2());

		jdDatosObteinidos.set8(restaurante.platoentradaMasCal());
		jdDatosObteinidos.set9(restaurante.platofuerteMasCal());
		jdDatosObteinidos.set10(restaurante.platoPostreMascal());
		jdDatosObteinidos.set11(restaurante.platoentradaMasVendido());
		jdDatosObteinidos.set12(restaurante.platofuerteMasVendido());
		jdDatosObteinidos.set13(restaurante.platoPostreMasVendido());
		jdDatosObteinidos.set14("Mesero "+restaurante.asignarMesero().getId());
		
	}

	public void agregarDatosAObtenidosv3(){
		restaurante.generarVentanas(restaurante.getVentana3());
		restaurante.atenderClientes(restaurante.getVentana3());

		restaurante.contarPlatos(restaurante.getVentana3());
		restaurante.calificacion(restaurante.getVentana3());

		jdDatosObteinidos.set15(restaurante.platoentradaMasCal());
		jdDatosObteinidos.set16(restaurante.platofuerteMasCal());
		jdDatosObteinidos.set17(restaurante.platoPostreMascal());
		jdDatosObteinidos.set18(restaurante.platoentradaMasVendido());
		jdDatosObteinidos.set19(restaurante.platofuerteMasVendido());
		jdDatosObteinidos.set20(restaurante.platoPostreMasVendido());
		jdDatosObteinidos.set21("Mesero "+restaurante.asignarMesero().getId());

		
	}
	
	
	public void agregarDatosAObtenidosv1(){
		restaurante.contarPlatos(restaurante.getVentana1());
		restaurante.calificacion(restaurante.getVentana1());

		jdDatosObteinidos.set1(restaurante.platoentradaMasCal());
		jdDatosObteinidos.set2(restaurante.platofuerteMasCal());
		jdDatosObteinidos.set3(restaurante.platoPostreMascal());
		jdDatosObteinidos.set4(restaurante.platoentradaMasVendido());
		jdDatosObteinidos.set5(restaurante.platofuerteMasVendido());
		jdDatosObteinidos.set6(restaurante.platoPostreMasVendido());
		jdDatosObteinidos.set7("Mesero "+restaurante.asignarMesero().getId());
		
	}
	
	
	

	/**
	 * metodo que permite agregar los valores a la tabla cada 100 milisegundos.
	 * aparte de esto tambien permite contar cuantos platos se han solicitado en
	 * cada una de las mesas y las va a agregando en este mismo intervalo de tiempo
	 */
	public void agregaraTablas() {
		timer = new Timer(aleatorio(500.0, 1500.0), new ActionListener() {
			int dia = 0;

			@Override
			public void actionPerformed(ActionEvent e) {
				jframePrincipal.getPanelTablas().agregaraMesa1(restaurante.getVentana1().get(dia).getClientes(), dia);

				dia++;
				if (restaurante.getVentana1().size() == dia) {
					timer.stop();

				}
			}
		});
		timer.start();
		tiempo();
		jframePrincipal.desabilitarboton();
		

	}

	public void agregaraACaja() {
		timer3 = new Timer(aleatorio(100.0, 150.0), new ActionListener() {
			int dia = 0;
			int f = 0;

			@Override
			public void actionPerformed(ActionEvent e) {
				if (dia < 7) {
					if (jframePrincipal.getPanelTablas().getCantidad2() > restaurante.getVentana1().get(dia)
							.getClientes().get(f).size()) {
						jframePrincipal.getPanelTablas()
								.deleteMesa2(restaurante.getVentana1().get(dia).getClientes().get(f).size());
						jframePrincipal.getPanelTablas()
								.agregaraMesa3(restaurante.getVentana1().get(dia).getClientes().get(f), dia);

					}
					f++;
					if (restaurante.getVentana1().get(dia).getClientes().size() == f) {
						dia++;
						f = 0;
					}
				}

				if (dia == 7) {
					jframePrincipal.getPanelTablas().deleteAllMesa2();
				}
			}
		});
		timer3.start();

	}

	public void agregaraASatisfechos() {
		timer5 = new Timer(aleatorio(100.0, 150.0), new ActionListener() {
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
					if (jframePrincipal.getPanelTablas().getCantidad3() > restaurante.getVentana1().get(dia)
							.getClientes().get(f).size()) {
						jframePrincipal.getPanelTablas()
								.deleteMesa3(restaurante.getVentana1().get(dia).getClientes().get(f).size());
						jframePrincipal.getPanelTablas()
								.agregaraMesa4(restaurante.getVentana1().get(dia).getClientes().get(f), dia);

					}
					f++;
					if (restaurante.getVentana1().get(dia).getClientes().size() == f) {
						dia++;
						f = 0;
					}
				}

				if (dia == 7) {
					jframePrincipal.getPanelTablas().deleteAllMesa3();
					jframePrincipal.getTxtnumeropedidos()
							.setText("" + (pedidosmesa1 + pedidosmesa2 + pedidosmesa3 + pedidosmesa4 + pedidosmesa5));
					jframePrincipal.habilitarboton();
					jframePrincipal.habilitarboton2();
				}
			}
		});
		timer5.start();

	}

	public void agregaraAtendidos() {
		restaurante.atenderClientes(restaurante.getVentana1());
		timer4 = new Timer(aleatorio(100.0, 150.0), new ActionListener() {
			int dia = 0;
			int f = 0;

			@Override
			public void actionPerformed(ActionEvent e) {
				if (dia < 7&&jframePrincipal.getPanelTablas().getCantidad2()<60) {
					if (jframePrincipal.getPanelTablas().getCantidad1() > restaurante.getVentana1().get(dia)
							.getClientes().get(f).size()) {
						jframePrincipal.getPanelTablas()
								.deleteMesa1(restaurante.getVentana1().get(dia).getClientes().get(f).size());
						jframePrincipal.getPanelTablas()
								.agregaraMesa2(restaurante.getVentana1().get(dia).getClientes().get(f), dia);

					}
					f++;
					if (restaurante.getVentana1().get(dia).getClientes().size() == f) {
						dia++;
						f = 0;
					}
				}

				if (dia == 7) {
					jframePrincipal.getPanelTablas().deleteAllMesa1();
				}
			}
		});
		timer4.start();

	}

	/*
	 * 
	 * metodo que permite contabilizar un tiempo aproximado hasta que se siimulen
	 * las 150 horas de trabajo
	 */
	public void tiempo() {
		timer2 = new Timer(200, new ActionListener() {
			int hora = 1;
			int dia=0;
			int ventana=0;
			int a=70;

			@Override
			public void actionPerformed(ActionEvent e) {
				jframePrincipal.getTxttiempo().setText(hora + "horas");
				hora++;
				if (hora%10==0) {
					dia++;
					jframePrincipal.getTxtPedidosMesa2().setText(dia+"");
				}
				if (hora==a) {
					a+=70;
					System.out.println("------------<¿>"+a);
					dia=0;
					ventana++;
					jframePrincipal.getTxtPedidosMesa1().setText(ventana+"");
				}
				
				if (hora == 210) {
					timer2.stop();
				}
			}

		});
		timer2.start();
	}

	private int aleatorio(double a, double b) {
		int ale = 0;
		ale = (int) (uniforme.pseudoaleatorios(a, b));
		return ale;
	}
}
