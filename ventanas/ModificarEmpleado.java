package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Empleado;
import clases.Maquina;
import utilidades.Utilidades;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModificarEmpleado extends JFrame {

	private JPanel contentPane;
	private Empleado empleado;
	private ArrayList<Maquina> maquinas;

	/**
	 * Create the frame.
	 */
	public ModificarEmpleado(Empleado eempleado) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 857, 508);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		this.empleado = eempleado;
		this.maquinas = Utilidades.leerMaquinas("maquinas.txt");

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(106, 147, 299, 43);
		contentPane.add(comboBox);

		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
		for (Maquina maquina : maquinas) {
			model.addElement(maquina.getNombre());
		}
		comboBox.setModel(model);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(480, 147, 286, 43);
		contentPane.add(comboBox_1);
		DefaultComboBoxModel<String> model1 = new DefaultComboBoxModel<String>();
		for (Maquina maquina : maquinas) {
			model1.addElement(maquina.getNombre());
		}
		comboBox_1.setModel(model1);
		
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Maquina[] maquinas = new Maquina[2];
				maquinas[0] = new Maquina(""+comboBox.getSelectedItem());
				maquinas[1] = new Maquina((String)comboBox_1.getSelectedItem());
				empleado.setMaquinas(maquinas);
				
				Utilidades.guardarEmpleados(empleado);
				
				
				
			}
		});
		btnGuardar.setBounds(251, 320, 141, 35);
		contentPane.add(btnGuardar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(467, 320, 141, 35);
		contentPane.add(btnCancelar);

		

		JLabel lblMquina = new JLabel("M\u00E1quina 1");
		lblMquina.setBounds(133, 81, 179, 26);
		contentPane.add(lblMquina);

		JLabel lblMquina_1 = new JLabel("M\u00E1quina 2");
		lblMquina_1.setBounds(491, 81, 187, 26);
		contentPane.add(lblMquina_1);

	}
}
