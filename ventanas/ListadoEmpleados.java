package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import clases.Empleado;
import clases.Maquina;
import utilidades.Utilidades;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListadoEmpleados extends JFrame {

	private JPanel contentPane;
	private JButton btnVer, btnModificar;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListadoEmpleados frame = new ListadoEmpleados();
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
	public ListadoEmpleados() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 625, 514);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JList<Empleado> list = new JList<Empleado>();
		list.setBounds(52, 37, 329, 351);
		contentPane.add(list);
		ArrayList<Empleado> arrayEmpleados = Utilidades.leerEmpleados();
		DefaultListModel<Empleado> model = new DefaultListModel<Empleado>();
		for (Empleado empleado : arrayEmpleados) {
			model.addElement(empleado);
		}
		list.setModel(model);
		list.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				if (list.getSelectedValue().getMaquinas()[0] == null
						&& list.getSelectedValue().getMaquinas()[1] == null) {
					btnVer.setEnabled(false);
				} else {
					btnVer.setEnabled(true);
				}
				
				if(list.getSelectedValue()!=null){
					btnModificar.setEnabled(true);
				}
				
				
			}
		});

		JButton btnVer = new JButton("Ver");
		this.btnVer = btnVer;
		btnVer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Maquina[] maquinas = list.getSelectedValue().getMaquinas();
				String texto = "Maquinas: ";
				for (int i = 0; i < maquinas.length; i++) {
					if (maquinas[i] != null) {
						texto += maquinas[i].getNombre() + " ";
					}
				}
				JOptionPane.showMessageDialog(ListadoEmpleados.this, texto);
			}
		});

		btnVer.setBounds(419, 49, 141, 35);
		contentPane.add(btnVer);

		JButton btnModificar = new JButton("Modificar");
		btnModificar.setEnabled(false);
		this.btnModificar = btnModificar;
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Empleado empleado = list.getSelectedValue();
				ModificarEmpleado pantalla = new ModificarEmpleado(empleado);
				pantalla.setVisible(true);
				ListadoEmpleados.this.dispose();
				
				
			}
		});
		btnModificar.setBounds(419, 115, 141, 35);
		contentPane.add(btnModificar);
	}
}
