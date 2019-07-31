package view;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PanelData extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JLabel jl1, jl2, jl3, jl4, jl5, jl6, jl7, jl8, jl9, jl10, jl11, jl12, jl13, jl14, jl15, jl16, jl17, jl18,
			jl19, jl20, jl21;
	
	private JPanel  panelinfo1, panelinfo2, panelinfo3;
	
	
	public PanelData() {
		setLayout(new GridLayout(1, 2));
		iniciarJlabels();
		
		panelinfo1 = new JPanel();
		panelinfo1.setLayout(new GridLayout(7, 2));
		panelinfo1.setBorder(new TitledBorder("Ventana 1, días 1 - 7"));
		panelinfo2 = new JPanel();
		panelinfo2.setLayout(new GridLayout(7, 2));
		panelinfo2.setBorder(new TitledBorder("Ventana 2, días 7 - 14"));
		panelinfo3 = new JPanel();
		panelinfo3.setLayout(new GridLayout(7, 2));
		panelinfo3.setBorder(new TitledBorder("Ventana 3, días 14 - 21"));
		
		panelinfo1.add(new JLabel("<html>Entrada mejor calificada"));
		panelinfo1.add(jl1);
		panelinfo1.add(new JLabel("<html>Plato Fuerte mejor calificado"));
		panelinfo1.add(jl2);
		panelinfo1.add(new JLabel("<html>Postre mejor calificado"));
		panelinfo1.add(jl3);
		panelinfo1.add(new JLabel("<html>Entrada mas vendida"));
		panelinfo1.add(jl4);
		panelinfo1.add(new JLabel("<html>Plato Fuerte mas vendido"));
		panelinfo1.add(jl5);
		panelinfo1.add(new JLabel("<html>Postre mas vendido"));
		panelinfo1.add(jl6);
		panelinfo1.add(new JLabel("<html>Mesero mejor calificado"));
		panelinfo1.add(jl7);
		
		
		panelinfo2.add(new JLabel("<html>Entrada mejor calificada"));
		panelinfo2.add(jl8);
		panelinfo2.add(new JLabel("<html>Plato Fuerte mejor calificado"));
		panelinfo2.add(jl9);
		panelinfo2.add(new JLabel("<html>Postre mejor calificado"));
		panelinfo2.add(jl10);
		panelinfo2.add(new JLabel("<html>Entrada mas vendida"));
		panelinfo2.add(jl11);
		panelinfo2.add(new JLabel("<html>Plato Fuerte mas vendido"));
		panelinfo2.add(jl12);
		panelinfo2.add(new JLabel("<html>Postre mas vendido"));
		panelinfo2.add(jl13);
		panelinfo2.add(new JLabel("<html>Mesero mejor calificado"));
		panelinfo2.add(jl14);
		
		
		panelinfo3.add(new JLabel("<html>Entrada mejor calificada"));
		panelinfo3.add(jl15);
		panelinfo3.add(new JLabel("<html>Plato Fuerte mejor calificado"));
		panelinfo3.add(jl16);
		panelinfo3.add(new JLabel("<html>Postre mejor calificado"));
		panelinfo3.add(jl17);
		panelinfo3.add(new JLabel("<html>Entrada mas vendida"));
		panelinfo3.add(jl18);
		panelinfo3.add(new JLabel("<html>Plato Fuerte mas vendido"));
		panelinfo3.add(jl19);
		panelinfo3.add(new JLabel("<html>Postre mas vendido"));
		panelinfo3.add(jl20);
		panelinfo3.add(new JLabel("<html>Mesero mejor calificado"));
		panelinfo3.add(jl21);

 
		add(panelinfo1);
		add(panelinfo2);
		add(panelinfo3);
	}
	
	private void iniciarJlabels() {

		jl1 = new JLabel("");
		jl1.setOpaque(true);

		jl2 = new JLabel("");
		jl2.setOpaque(true);

		jl3 = new JLabel("");
		jl3.setOpaque(true);

		jl4 = new JLabel("");
		jl4.setOpaque(true);

		jl5 = new JLabel("");
		jl5.setOpaque(true);

		jl6 = new JLabel("");
		jl6.setOpaque(true);

		jl7 = new JLabel("");
		jl7.setOpaque(true);

		jl8 = new JLabel("");
		jl8.setOpaque(true);

		jl9 = new JLabel("");
		jl9.setOpaque(true);

		jl10 = new JLabel("");
		jl10.setOpaque(true);

		jl11 = new JLabel("");
		jl11.setOpaque(true);

		jl12 = new JLabel("");
		jl12.setOpaque(true);

		jl13 = new JLabel("");
		jl13.setOpaque(true);

		jl14 = new JLabel("");
		jl14.setOpaque(true);
		
		jl15 = new JLabel("");
		jl15.setOpaque(true);
		
		jl16 = new JLabel("");
		jl16.setOpaque(true);
		
		jl17 = new JLabel("");
		jl17.setOpaque(true);
		
		jl18 = new JLabel("");
		jl18.setOpaque(true);
		
		jl19 = new JLabel("");
		jl19.setOpaque(true);

		jl20 = new JLabel("");
		jl20.setOpaque(true);
		
		jl21 = new JLabel("");
		jl21.setOpaque(true);
	}

	/*
	 * le asigna un valor al jlabel 7
	 */
	public void set1(String aux) {
		jl1.setText(aux);
	}

	/*
	 * le asigna un valor al jlabel 7
	 */
	public void set2(String aux) {
		jl2.setText(aux);
	}

	/*
	 * le asigna un valor al jlabel 7
	 */
	public void set3(String aux) {
		jl3.setText(aux);
	}

	/*
	 * le asigna un valor al jlabel 7
	 */
	public void set4(String aux) {
		jl4.setText(aux);
	}

	/*
	 * le asigna un valor al jlabel 7
	 */
	public void set5(String aux) {
		jl5.setText(aux);
	}

	/*
	 * le asigna un valor al jlabel 7
	 */
	public void set6(String aux) {
		jl6.setText(aux);
	}

	/*
	 * le asigna un valor al jlabel 7
	 */
	public void set7(String aux) {
		jl7.setText(aux);
	}

	/*
	 * le asigna un valor al jlabel 8
	 */
	public void set8(String aux) {
		jl8.setText(aux);
	}

	/*
	 * le asigna un valor al jlabel 9
	 */
	public void set9(String aux) {
		jl9.setText(aux);
	}

	/*
	 * le asigna un valor al jlabel 10
	 */
	public void set10(String aux) {
		jl10.setText(aux);
	}

	/*
	 * le asigna un valor al jlabel 11
	 */
	public void set11(String aux) {
		jl11.setText(aux);
	}

	/*
	 * le asigna un valor al jlabel 12
	 */
	public void set12(String aux) {
		jl12.setText(aux);
	}

	/*
	 * le asigna un valor al jlabel 13
	 */
	public void set13(String aux) {
		jl13.setText(aux);
	}

	/*
	 * le asigna un valor al jlabel 14
	 */
	public void set14(String aux) {
		jl14.setText(aux);
	}

	public void set15(String aux) {
		jl15.setText(aux);
	}

	public void set16(String aux) {
		jl16.setText(aux);
	}

	public void set17(String aux) {
		jl17.setText(aux);
	}

	public void set18(String aux) {
		jl18.setText(aux);
	}

	public void set19(String aux) {
		jl19.setText(aux);
	}

	public void set20(String aux) {
		jl20.setText(aux);
	}

	public void set21(String aux) {
		jl21.setText(aux);
	}

}
