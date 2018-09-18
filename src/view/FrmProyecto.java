package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import model.Proyecto;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import java.awt.ScrollPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;

//import unico.Principal;

public class FrmProyecto extends JFrame {

	private static final long serialVersionUID = 1L;
	public static JTable tableProyecto;

	/**
	 * Create the application.
	 */
	public FrmProyecto() {
		getContentPane().setBackground(new Color(255, 235, 205));
		getContentPane().setFont(new Font("Bradley Hand ITC", Font.PLAIN, 14));
		initialize();
		//actualizarListado();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		setTitle("PROYECTOS");
		setBounds(100, 100, 516, 399);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		getContentPane().setLayout(null);

		JButton btnNuevo = new JButton("NUEVO");
		btnNuevo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNuevo.setIcon(new ImageIcon("C:\\Users\\Usuario\\Desktop\\ISAAC-NO BORRAR\\ECLIPSE\\Empresa_Flight\\Img\\Male-user-accept-icon.png"));
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//controller.CtrProyectos.mostrarFrmDetalles(1, 0);
				//actualizarListado();
			}
		});
		btnNuevo.setBounds(10, 305, 104, 33);
		getContentPane().add(btnNuevo);

		JButton btnBorrar = new JButton("BORRAR");
		btnBorrar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnBorrar.setIcon(new ImageIcon("C:\\Users\\Usuario\\Desktop\\ISAAC-NO BORRAR\\ECLIPSE\\Empresa_Flight\\Img\\Male-user-remove-icon.png"));
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//controller.CtrProyectos.borrar(tableProyecto.getSelectedIndex());
				//actualizarListado();
			}
		});
		btnBorrar.setBounds(123, 305, 119, 33);
		getContentPane().add(btnBorrar);

		JButton btnEditar = new JButton("EDITAR");
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnEditar.setIcon(new ImageIcon("C:\\Users\\Usuario\\Desktop\\ISAAC-NO BORRAR\\ECLIPSE\\Empresa_Flight\\Img\\resume.png"));
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//controller.CtrProyectos.mostrarFrmDetalles(2, list.getSelectedIndex());
				//actualizarListado();
			}
		});
		btnEditar.setBounds(252, 305, 111, 33);
		getContentPane().add(btnEditar);

		JButton btnInfo = new JButton("INFO");
		btnInfo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnInfo.setIcon(new ImageIcon("C:\\Users\\Usuario\\Desktop\\ISAAC-NO BORRAR\\ECLIPSE\\Empresa_Flight\\Img\\info.png"));
		btnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//controller.CtrProyectos.mostrarFrmDetalles(3, list.getSelectedIndex());
			}
		});
		btnInfo.setBounds(373, 305, 103, 33);
		getContentPane().add(btnInfo);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Usuario\\Desktop\\ISAAC-NO BORRAR\\ECLIPSE\\Empresa_Flight\\Img\\telegram.png"));
		lblNewLabel.setBounds(310, 100, 126, 128);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("FLIGHT");
		lblNewLabel_1.setBackground(new Color(0, 191, 255));
		lblNewLabel_1.setFont(new Font("Bradley Hand ITC", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_1.setBounds(328, 71, 87, 27);
		getContentPane().add(lblNewLabel_1);
		
		JScrollPane scrollPaneProyecto = new JScrollPane();
		scrollPaneProyecto.setBounds(10, 11, 290, 283);
		getContentPane().add(scrollPaneProyecto);
		
		tableProyecto = new JTable();
		scrollPaneProyecto.setViewportView(tableProyecto);

		setVisible(true);

	}

	
}