package GUI;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaDatos extends JFrame implements ActionListener {

	private JTextField pantalla;
	private JButton suma, resta;
	private int pulsaciones = 0;
	private String pulsacionesString = "0";
	
	public VentanaDatos() {
		setSize(300, 200);
		setTitle("Atributos Jugador: ");
		setLayout(new FlowLayout());
		pantalla = new JTextField();
		pantalla.setColumns(20);
		pantalla.addActionListener(this);
		pantalla.setText(pulsacionesString);
		add(pantalla);
		
		JPanel botonera = new JPanel();
		botonera.setLayout(new GridLayout(1, 2));
		suma = new JButton("+");
		resta = new JButton("-");
		suma.addActionListener(this);
		resta.addActionListener(this);
		botonera.add(resta);
		botonera.add(suma);
		add(botonera);
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String tecla = arg0.getActionCommand();
		switch (tecla) {
		case "+":
			pulsaciones++;
			pantalla.setText(Integer.toString(pulsaciones));
			break;
		case "-":
			pulsaciones--;
			pantalla.setText(Integer.toString(pulsaciones));
			break;
		}
		
	}
}
