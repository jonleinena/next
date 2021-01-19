package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
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
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 586, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnListadoempleados = new JButton("ListadoEmpleados");
		btnListadoempleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListadoEmpleados pantalla = new ListadoEmpleados();
				pantalla.setVisible(true);
				VentanaPrincipal.this.dispose();
			}
		});
		btnListadoempleados.setBounds(87, 169, 141, 35);
		contentPane.add(btnListadoempleados);
		
		JButton btnListadomaquinas = new JButton("ListadoMaquinas");
		btnListadomaquinas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoMaquinas pantalla = new ListadoMaquinas();
				pantalla.setVisible(true);
				VentanaPrincipal.this.dispose();
			}
		});
		btnListadomaquinas.setBounds(303, 169, 141, 35);
		contentPane.add(btnListadomaquinas);
	}
}
