package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.contolador;
import modelo.Jugador;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class panel extends JFrame {

	private JPanel contentPane;
	private JTextField ID;
	private JTextField Nombre;
	private JTextField Dorsal;
	private JTextField Altura;
	private JLabel lblAltura;
	private JLabel lblId;
	private JButton añadir;
	private JButton eliminar;
	private JButton lista;
	private contolador controlador = new contolador();
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					panel frame = new panel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public panel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 259, 212);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ID = new JTextField();
		ID.setBounds(10, 110, 46, 20);
		contentPane.add(ID);
		ID.setColumns(10);
		
		Nombre = new JTextField();
		Nombre.setColumns(10);
		Nombre.setBounds(10, 43, 76, 20);
		contentPane.add(Nombre);
		
		Dorsal = new JTextField();
		Dorsal.setColumns(10);
		Dorsal.setBounds(91, 43, 66, 20);
		contentPane.add(Dorsal);
		
		Altura = new JTextField();
		Altura.setColumns(10);
		Altura.setBounds(167, 43, 61, 20);
		contentPane.add(Altura);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 29, 76, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNJugador = new JLabel("Nº Jugador");
		lblNJugador.setHorizontalAlignment(SwingConstants.CENTER);
		lblNJugador.setBounds(91, 29, 66, 14);
		contentPane.add(lblNJugador);
		
		lblAltura = new JLabel("Altura");
		lblAltura.setHorizontalAlignment(SwingConstants.CENTER);
		lblAltura.setBounds(167, 29, 61, 14);
		contentPane.add(lblAltura);
		
		lblId = new JLabel("ID");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setBounds(10, 95, 46, 14);
		contentPane.add(lblId);
		
		añadir = new JButton("Añadir");
		añadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ID.getText().equals("")) {
					
					Jugador	jugador = new Jugador(controlador.modificarID(), Nombre.getText(), Integer.parseInt(Dorsal.getText()), Double.parseDouble(Altura.getText()));
					
					controlador.guardarenbasesededatos(jugador);
					
				}else {
					
					Jugador	jugador = new Jugador(Integer.parseInt(ID.getText()), Nombre.getText(), Integer.parseInt(Dorsal.getText()), Double.parseDouble(Altura.getText()));

					if(controlador.exiteenbasdedatos(jugador)){
						
						
						controlador.modificarenbasadedatos(jugador);
						
					}else {
						
						
						JOptionPane.showInternalMessageDialog(null, "La ID puesta No existe");
						
					}
					
					
					
				}
					
					
						

			}
		});
		añadir.setBounds(66, 91, 76, 23);
		contentPane.add(añadir);
		
		eliminar = new JButton("Eliminar");
		eliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!ID.getText().equals("")) {
					
					Jugador	jugador = new Jugador(Integer.parseInt(ID.getText()),null,0,0.0);
					
					if(controlador.exiteenbasdedatos(jugador)) {
						
						controlador.eliminardelabasededatos(jugador);
						
						
					}else {
						
						
						JOptionPane.showInternalMessageDialog(null, "La ID puesta No existe");
						
					}
					
				}else {
					
					JOptionPane.showInternalMessageDialog(null, "No has puesto una ID puesta");
					
				}

			}
		});
		eliminar.setBounds(66, 125, 76, 23);
		contentPane.add(eliminar);
		
		lista = new JButton("Lista");
		lista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, controlador.listarbasededatos());
				
			}
		});
		lista.setBounds(152, 91, 76, 57);
		contentPane.add(lista);
	}
}
