package logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;

import javax.swing.Timer;

import model.MyQueue;

/**
 * clase que permite realizar todos los procesos para simular las 150 hortas de
 * trabajo.
 * 
 * @author XIMENA , JUAN DAVID ROJAS David gonzales
 *
 */
public class Restaurante implements ActionListener {
	private MyQueue<Mesa> mesasDisponibles;
	private MyQueue<Mesa> mesasOcupadas;

	private ArrayList<Dia> ventana1;
	private ArrayList<Dia> ventana2;
	private ArrayList<Dia> ventana3;
	

	private Mesero mesero1 = new Mesero(1);
	private Mesero mesero2 = new Mesero(2);

	private int propina1 = 0;
	private int propina2 = 0;

	ArrayList<Integer> conteoFuerte = new ArrayList<>();
	ArrayList<Integer> conteoPostre = new ArrayList<>();
	ArrayList<Integer> conteoEntradas = new ArrayList<>();

	ArrayList<Double> calFuerte;
	ArrayList<Double> calEntradas;
	ArrayList<Double> calpostres;

	private Cocina cocina = new Cocina();

	private Caja caja = new Caja();

	private Cocinero cocinero1 = new Cocinero(1);
	private Cocinero cocinero2 = new Cocinero(2);

	Uniforme uniforme = new Uniforme();

	public Restaurante() {
		calEntradas = new ArrayList<>();
		calFuerte = new ArrayList<>();
		calpostres = new ArrayList<>();

		ventana1 = new ArrayList<>();
		ventana2 = new ArrayList<>();
		ventana3 = new ArrayList<>();
		mesasDisponibles = new MyQueue<>();
		mesasOcupadas = new MyQueue<>();

	}

	/**
	 * Generar las jornadas para cada dia asi como los comensales que se atendieron
	 * en solo un dia
	 */
	public void generarVentanas(ArrayList<Dia> ventana) {
		int suma = 0;
		while (suma != 7) {
			Dia dia = new Dia(suma);
			clientesAldia(dia);
			ventana.add(dia);
			suma++;
		}
	}

	public void clientesAldia(Dia dia) {
		int suma = 0;
		while (suma < 36000) {
			ArrayList<Cliente> comensales = llegadaComensales();
			dia.getClientes().add(comensales);
			suma += comensales.get(0).getHoraLlegada();
		}
	}

	public void crearMesas() {
		int auxi = 1;
		while (mesasDisponibles.size() < 14) {
			Mesa mesa = new Mesa(auxi, true, false);
			mesasDisponibles.put(mesa);
			auxi++;
		}
	}

	private ArrayList<Cliente> llegadaComensales() {
		ArrayList<Cliente> personasenmesa = new ArrayList<>();
		int numeroClientes = (int) uniforme.pseudoaleatorios(1.0, 4.1);
		int horaLLegada = (int) uniforme.pseudoaleatorios(1.0, 1500.1);
		for (int i = 0; i < numeroClientes; i++) {
			int prioridad = (int) uniforme.pseudoaleatorios(0.0, 1.1);
			int tipopago = (int) uniforme.pseudoaleatorios(0.0, 1.1);
			Pedido pedidos = new Pedido(prioridad);
			Cliente cliente = new Cliente(pedidos, horaLLegada, tipopago);
			personasenmesa.add(cliente);
		}
		return personasenmesa;

	}

	public void atenderClientes(ArrayList<Dia> ventana) {
		for (int i = 0; i < ventana.size(); i++) {
			Dia dia = ventana.get(i);
			for (int j = 0; j < dia.getClientes().size(); j++) {
				asignarMesadesocupada(dia.getClientes().get(j));
			}
		}

	}

	public void asignarMesadesocupada(ArrayList<Cliente> clientes) {
		if (mesasDisponibles.size() > 0) {
			Mesa mesa = mesasDisponibles.get();
			Mesero mesero = asignarMesero();
			if (mesero != null) {
				mesero.getMesasAcargo().put(mesa);
				mesa.setMesero(mesero);
				mesasOcupadas.put(mesa);
				tomaOrden(clientes);
				enviarPedidoAcocina(clientes);
				mesa.setClientes(clientes);
				traerPedido(mesa);

			}
		}

	}

	public Mesero asignarMesero() {
		int me = (int) uniforme.pseudoaleatorios(0.0, 1.9);
		if (me == 1) {
			return mesero1;
		} else {
			return mesero2;
		}
	}

	public void tomaOrden(ArrayList<Cliente> cliente) {
		for (int i = 0; i < cliente.size(); i++) {
			relizarOrden(cliente.get(i));

		}

	}

	public void enviarPedidoAcocina(ArrayList<Cliente> clientes) {
		for (int i = 0; i < clientes.size(); i++) {
			Pedido pedido = clientes.get(i).getPedidos();
			cocina.pedidos.put(pedido);
			if (pedido.getPostres().size() != 0) {
				if (pedido.getPostres().size() > 1) {
					cocinero1.platos.put(pedido.getPostres().get(0));
					cocinero1.platos.put(pedido.getPostres().get(1));
				}
				cocinero1.platos.put(pedido.getPostres().get(0));
			}
			if (pedido.getEntradas() != null) {
				cocinero2.platos.put(pedido.getEntradas());
			}
			cocinero2.platos.put(pedido.getFuertes());
		}
	}

	public void traerPedido(Mesa mesa) {

		int tipopago = (int) uniforme.pseudoaleatorios(1.0, 3.0);// americNO,IGUALES,TOdo
		for (int i = 0; i < mesa.getClientes().size(); i++) {
		Pedido pedido = cocina.pedidos.get();
		int tiempoServicio = 0;
		if (pedido.getEntradas() != null) {
			tiempoServicio = pedido.getEntradas().getTiempoPreparacion();
			pedido.getEntradas().setCalificacion( uniforme.pseudoaleatorios(0.0, 5.1));
		}
		if (pedido.getPostres().size() != 0) {
			for (int j = 0; j < pedido.getPostres().size(); j++) {
				pedido.getPostres().get(j).setCalificacion( uniforme.pseudoaleatorios(0.0, 5.1));
				tiempoServicio += pedido.getPostres().get(j).getTiempoPreparacion();
			}
		}
		tiempoServicio += pedido.getFuertes().getTiempoPreparacion();
		pedido.getFuertes().setCalificacion( uniforme.pseudoaleatorios(0.0, 5.1));
		pedido.setTiempoAtencion(tiempoServicio);

			if (mesa.getClientes().get(i).getPedidos().getId() == pedido.getId()) {
				mesa.setLimpia(false);
				mesa.setLimpia(true);

			}
			mesa.setTipopago(tipopago);
			generarCuentaTipo(mesa);
		}

	}

	public void generarCuentaTipo(Mesa mesa) {
		int cuenta = 0;

		if (mesa.getTipopago() == 1) {
			for (int i = 0; i < mesa.getClientes().size(); i++) {
				Cliente cliente = mesa.getClientes().get(i);
				cliente.setCuenta(cuenta(cliente));
				if (cliente.getTipoPago() == 0) {
					caja.pagoEfectivo.put(cliente);
				} else {
					caja.pagoTarjeta.put(cliente);
				}
			}

		} else {
			if (mesa.getTipopago() == 2) {
				tipopago2(mesa);
			} else {
				if (mesa.getTipopago() == 3) {
					tipopago3(mesa);
				}
			}
		}

		if (mesa.getMesero().getId() == 1) {
			propina1 += generarPropina(tipopago2(mesa));
			mesa.getMesero().setPropina(propina1);
		} else {
			propina2 += generarPropina(tipopago2(mesa));
			mesa.getMesero().setPropina(propina2);

		}

		if (mesasOcupadas.size() > 0) {
			Mesa aux = mesasOcupadas.get();
			mesasDisponibles.put(aux);
		}

	}

	private int tipopago2(Mesa mesa) {
		int cuenta = 0;
		for (int i = 0; i < mesa.getClientes().size(); i++) {
			Cliente cliente = mesa.getClientes().get(i);
			cuenta += cuenta(cliente);

		}
		mesa.getClientes().get(0).setCuenta(cuenta);
		if (mesa.getClientes().get(0).getTipoPago() == 0) {
			caja.pagoEfectivo.put(mesa.getClientes().get(0));
		} else {
			caja.pagoTarjeta.put(mesa.getClientes().get(0));
		}
		return cuenta;
	}

	private double generarPropina(int cuenta) {
		return (cuenta * 0.1);
	}

	private int tipopago3(Mesa mesa) {
		int cuenta = 0;
		for (int i = 0; i < mesa.getClientes().size(); i++) {
			Cliente cliente = mesa.getClientes().get(i);
			cuenta += cuenta(cliente);

		}
		for (int i = 0; i < mesa.getClientes().size(); i++) {
			Cliente cliente = mesa.getClientes().get(i);
			cliente.setCuenta(cuenta / mesa.getClientes().size());
			if (cliente.getTipoPago() == 0) {
				caja.pagoEfectivo.put(cliente);
			} else {
				caja.pagoTarjeta.put(cliente);
			}
		}
		return cuenta;
	}

	public int cuenta(Cliente cliente) {
		int total = 0;
		if (cliente.getPedidos().getEntradas() != null) {
			total = cliente.getPedidos().getEntradas().getPrecio();
		}
		for (int i = 0; i < cliente.getPedidos().getPostres().size(); i++) {
			total += cliente.getPedidos().getPostres().get(i).getPrecio();
		}
		total += cliente.getPedidos().getFuertes().getPrecio();
		return total;

	}

	public void relizarOrden(Cliente cliente) {
		ArrayList<Plato> postres = new ArrayList<>();
		int numeroPostres = (int) uniforme.pseudoaleatorios(0.0, 2.1);
		int entrada = (int) uniforme.pseudoaleatorios(0.0, 1.1);
		for (int i = 0; i < numeroPostres; i++) {
			postres.add(postres());
		}
		cliente.getPedidos().setPostres(postres);
		if (entrada != 0) {
			cliente.getPedidos().setEntradas(entradas());
		}
		cliente.getPedidos().setFuertes(fuertes());

	}

	public Plato entradas() {
		int platoele = (int) uniforme.pseudoaleatorios(1.0, 5.5);
		int tiempoconsumo = (int) uniforme.pseudoaleatorios(240.0, 600.1);
		Plato plato = new Plato(platoele, 1, tiempoconsumo);
		return plato;
	}

	public Plato fuertes() {
		int platoele = (int) uniforme.pseudoaleatorios(1.0, 5.5);
		int tiempoconsumo = (int) uniforme.pseudoaleatorios(900.0, 1200.1);
		Plato plato = new Plato(platoele, 2, tiempoconsumo);
		return plato;
	}

	public Plato postres() {
		int platoele = (int) uniforme.pseudoaleatorios(1.0, 10.5);
		int tiempoconsumo = (int) uniforme.pseudoaleatorios(300.0, 900.1);
		Plato plato = new Plato(platoele, 3, tiempoconsumo);
		return plato;
	}

	public void contarPlatos(ArrayList<Dia> ventana) {
		llenarArayIn(conteoEntradas);
		llenarArayIn(conteoFuerte);
		llenarArayPIN(conteoPostre);
		int aux1 = 0;
		int aux2 = 0;
		int aux3 = 0;
		for (int i = 0; i < ventana.size(); i++) {
			ArrayList<ArrayList<Cliente>> clientes = ventana.get(i).getClientes();
			for (int j = 0; j < clientes.size(); j++) {
				for (int j2 = 0; j2 < clientes.get(j).size(); j2++) {

					int platoF = clientes.get(j).get(j2).getPedidos().getFuertes().getId() - 1;
					aux1 = conteoFuerte.get(platoF);
					aux1++;
					conteoFuerte.set(platoF, aux1);

					if (clientes.get(j).get(j2).getPedidos().getEntradas() != null) {
						int platoE = clientes.get(j).get(j2).getPedidos().getEntradas().getId() - 1;
						aux2 = conteoEntradas.get(platoE);
						aux2++;
						conteoEntradas.set(platoE, aux2);
					}
					if (clientes.get(j).get(j2).getPedidos().getPostres().size() > 0) {
						for (int k = 0; k < clientes.get(j).get(j2).getPedidos().getPostres().size(); k++) {
							int platoP = clientes.get(j).get(j2).getPedidos().getPostres().get(k).getId() - 1;
							aux3 = conteoPostre.get(platoP);
							aux3++;
							conteoPostre.set(platoP, aux3);
						}
					}

				}

			}
		}

	}

	private void llenarAray(ArrayList<Double> array) {
		for (int i = 0; i < 5; i++) {
			array.add(0.0);
		}
	}

	private void llenarArayP(ArrayList<Double> array) {
		for (int i = 0; i < 10; i++) {
			array.add(0.0);
		}
	}

	public void calificacion(ArrayList<Dia> ventana) {
		llenarAray(calEntradas);
		llenarAray(calFuerte);
		llenarArayP(calpostres);

		double aux1 = 0;
		double aux2 = 0;
		double aux3 = 0;
		for (int i = 0; i < ventana.size(); i++) {
			ArrayList<ArrayList<Cliente>> clientes = ventana.get(i).getClientes();
			for (int j = 0; j < clientes.size(); j++) {
				for (int j2 = 0; j2 < clientes.get(j).size(); j2++) {
					Pedido pedido = clientes.get(j).get(j2).getPedidos();
					int platoF = pedido.getFuertes().getId() - 1;
					aux1 = (calFuerte.get(platoF) + pedido.getFuertes().getCalificacion());
					calFuerte.set(platoF, aux1);
					if (pedido.getEntradas() != null) {
						int platoE = pedido.getEntradas().getId() - 1;
						aux2 = (calEntradas.get(platoE) + pedido.getEntradas().getCalificacion());
						calEntradas.set(platoE, aux2);

					}
					if (pedido.getPostres().size() > 0) {
						for (int k = 0; k < clientes.get(j).get(j2).getPedidos().getPostres().size(); k++) {
							int platoP = clientes.get(j).get(j2).getPedidos().getPostres().get(k).getId() - 1;
							aux3 = (calpostres.get(platoP) + pedido.getPostres().get(k).getCalificacion());
							calpostres.set(platoP, aux3);
						}
					}

				}
			}
		}

	}

	public Integer getMaximo(ArrayList<Integer> numeros) {
		int maximo = numeros.get(0);
		int retorno = 0;
		for (int i = 1; i < numeros.size(); i++) {
			if (maximo < numeros.get(i)) {
				maximo = numeros.get(i);
				retorno = i;
			}
		}
		return retorno;
	}

	private void llenarArayIn(ArrayList<Integer> array) {
		for (int i = 0; i < 5; i++) {
			array.add(0);
		}
	}

	private void llenarArayPIN(ArrayList<Integer> array) {
		for (int i = 0; i < 10; i++) {
			array.add(0);
		}
	}

	public String platofuerteMasVendido() {
		
		Plato plato = new Plato(getMaximo(conteoFuerte) + 1, 2, 0);
		return plato.getNombre();
	}

	public String platoentradaMasVendido() {
		System.out.println(conteoEntradas.size());
		Plato plato = new Plato(getMaximo(conteoEntradas) + 1, 1, 0);
		return plato.getNombre();
	}

	public String platoPostreMasVendido() {
		Plato plato = new Plato(getMaximo(conteoPostre) + 1, 3, 0);
		return plato.getNombre();
	}
	
	
	public String platofuerteMasCal() {
		Plato plato = new Plato(getMaximoD(calFuerte) + 1, 2, 0);
		return plato.getNombre();
	}

	public String platoentradaMasCal() {
		Plato plato = new Plato(getMaximoD(calEntradas) + 1, 1, 0);
		return plato.getNombre();
	}

	public String platoPostreMascal() {
		Plato plato = new Plato(getMaximoD(calpostres) + 1, 3, 0);
		return plato.getNombre();
	}

	
	
	public Integer getMaximoD(ArrayList<Double> numeros) {
		double maximo = numeros.get(0);
		int retorno = 0;
		for (int i = 1; i < numeros.size(); i++) {
			if (maximo < numeros.get(i)) {
				maximo = numeros.get(i);
				retorno = i;
			}
		}
		return retorno;
	}
	

	public ArrayList<Double> promedear(int cantidad, ArrayList<Double> platos) {
		ArrayList<Double> platosAux=platos;
		for (int i = 0; i < platos.size(); i++) {
			double aux=platos.get(i)/cantidad;
			platosAux.set(i, aux);
		}
		return platosAux;

	}

	public void imprimir() {
		generarVentanas(ventana1);
		atenderClientes(ventana1);
		contarPlatos(ventana1);
		calificacion(ventana1);

		System.out.println(mesero1.getPropina());
		System.out.println(mesero2.getPropina());

		System.out.println(platofuerteMasVendido() + "  ________________________________________*_*");

		for (int i = 0; i < conteoEntradas.size(); i++) {

			System.out.println(conteoEntradas.get(i) + "  " + i + " cont entr ");
			System.out.println(conteoFuerte.get(i) + "  " + i + " cont ffuert ");
			System.out.println("_______y eso es todo amigos.... _______________________");
			System.out.println(calEntradas.get(i) + "  mdskdmksmdks" + i);

		}

		for (int i = 0; i < ventana1.size(); i++) {
			System.out.println("_____________________dia  :" + ventana1.get(i).getId());
			System.out.println("__________numeroPersonas :" + ventana1.get(i).getClientes().size());
			for (int j = 0; j < ventana1.get(i).getClientes().size(); j++) {
				System.out.println("Hora Cliente: " + ventana1.get(i).getClientes().get(j).get(0).getHoraLlegada());
				System.out.println("Cuenta:" + ventana1.get(i).getClientes().get(j).get(0).getCuenta());
				for (int j2 = 0; j2 < ventana1.get(i).getClientes().get(j).size(); j2++) {
					System.out.println("plato:"
							+ ventana1.get(i).getClientes().get(j).get(j2).getPedidos().getFuertes().getNombre());

				}

			}
		}
	}

	public MyQueue<Mesa> getMesasDisponibles() {
		return mesasDisponibles;
	}

	public void setMesasDisponibles(MyQueue<Mesa> mesasDisponibles) {
		this.mesasDisponibles = mesasDisponibles;
	}

	public MyQueue<Mesa> getMesasOcupadas() {
		return mesasOcupadas;
	}

	public void setMesasOcupadas(MyQueue<Mesa> mesasOcupadas) {
		this.mesasOcupadas = mesasOcupadas;
	}

	public ArrayList<Dia> getVentana1() {
		return ventana1;
	}

	public void setVentana1(ArrayList<Dia> ventana1) {
		this.ventana1 = ventana1;
	}

	public ArrayList<Dia> getVentana2() {
		return ventana2;
	}

	public void setVentana2(ArrayList<Dia> ventana2) {
		this.ventana2 = ventana2;
	}

	public ArrayList<Dia> getVentana3() {
		return ventana3;
	}

	public void setVentana3(ArrayList<Dia> ventana3) {
		this.ventana3 = ventana3;
	}

	public Mesero getMesero1() {
		return mesero1;
	}

	public void setMesero1(Mesero mesero1) {
		this.mesero1 = mesero1;
	}

	public Mesero getMesero2() {
		return mesero2;
	}

	public void setMesero2(Mesero mesero2) {
		this.mesero2 = mesero2;
	}

	public int getPropina1() {
		return propina1;
	}

	public void setPropina1(int propina1) {
		this.propina1 = propina1;
	}

	public int getPropina2() {
		return propina2;
	}

	public void setPropina2(int propina2) {
		this.propina2 = propina2;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
