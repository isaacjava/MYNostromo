package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;

import model.Proyecto;
import model.Trabajador;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;

//import unico.Principal;

public class FrmTrabajador extends JFrame {

	private static final long serialVersionUID = 1L;
	public static JTable tableTrabajador;

	/**
	 * Create the application.
	 */
	public FrmTrabajador() {
		getContentPane().setBackground(new Color(176, 224, 230));
		initialize();
		//actualizarListado();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		setTitle("TRABAJADORES");
		setBounds(100, 100, 517, 399);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		getContentPane().setLayout(null);

		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.setIcon(new ImageIcon("C:\\Users\\Usuario\\Desktop\\ISAAC-NO BORRAR\\ECLIPSE\\Empresa_Flight\\Img\\Male-user-accept-icon.png"));
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.CtrTrabajadores.mostrarFrmDetalles(1, 0);
				//actualizarListado();
			}
		});
		btnNuevo.setBounds(10, 302, 108, 36);
		getContentPane().add(btnNuevo);

		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.setIcon(new ImageIcon("C:\\Users\\Usuario\\Desktop\\ISAAC-NO BORRAR\\ECLIPSE\\Empresa_Flight\\Img\\Male-user-remove-icon.png"));
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					controller.CtrTrabajadores.borrarTrabajador();
					controller.CtrTrabajadores.rellenarTrabajador();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//actualizarListado();
			}
		});
		btnBorrar.setBounds(140, 302, 107, 36);
		getContentPane().add(btnBorrar);

		JButton btnEditar = new JButton("EDITAR");
		btnEditar.setIcon(new ImageIcon("C:\\Users\\Usuario\\Desktop\\ISAAC-NO BORRAR\\ECLIPSE\\Empresa_Flight\\Img\\resume.png"));
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					controller.CtrTrabajadores.editarTrabajador();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnEditar.setBounds(257, 302, 114, 36);
		getContentPane().add(btnEditar);

		JButton btnInfo = new JButton("INFO");
		btnInfo.setIcon(new ImageIcon("C:\\Users\\Usuario\\Desktop\\ISAAC-NO BORRAR\\ECLIPSE\\Empresa_Flight\\Img\\info.png"));
		btnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//controller.CtrTrabajadores.mostrarFrmDetalles(3, list.getSelectedIndex());
			}
		});
		btnInfo.setBounds(381, 302, 103, 36);
		getContentPane().add(btnInfo);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Usuario\\Desktop\\ISAAC-NO BORRAR\\ECLIPSE\\Empresa_Flight\\Img\\telegram.png"));
		lblNewLabel.setBounds(317, 99, 126, 128);
		getContentPane().add(lblNewLabel);
		
		JLabel lblFlight = new JLabel("FLIGHT");
		lblFlight.setFont(new Font("Bradley Hand ITC", Font.BOLD | Font.ITALIC, 16));
		lblFlight.setBackground(new Color(0, 191, 255));
		lblFlight.setBounds(335, 71, 87, 27);
		getContentPane().add(lblFlight);
		
		JScrollPane scrollTrabajador = new JScrollPane();
		scrollTrabajador.setBounds(10, 35, 284, 243);
		getContentPane().add(scrollTrabajador);
		
		tableTrabajador = new JTable();
		scrollTrabajador.setViewportView(tableTrabajador);

		setVisible(true);

	}

	/*public static void actualizarListado() {

		for (Trabajador pry : controller.CtrTrabajadores.lstTrabajador) {

			list.add("" + pry.getDni() + " / " + pry.getNombreT()+ " , "+pry.getApellidos());
		}
	}*/
}
