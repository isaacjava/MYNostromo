package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

import java.awt.Color;

public class DiaTrabajador extends JDialog {

	private static final long serialVersionUID = 1L;

	public static JTextField textDni;
	public static JTextField textNombre;
	public static JTextField textApellidos;
	public static JTextField textGenero;

	/**
	 * Create the application.
	 */
	public DiaTrabajador() {
		getContentPane().setBackground(new Color(176, 224, 230));
		crearVentana();
		controller.CtrTrabajadores.rellenarCuadros();
		/*if (controller.CtrTrabajadores.frameMode != 1) {
			
			textDni.setEnabled(controller.CtrTrabajadores.frameMode == 2);
			textNombre.setEnabled(controller.CtrTrabajadores.frameMode == 2);
			textApellidos.setEnabled(controller.CtrTrabajadores.frameMode == 2);
			textGenero.setEnabled(controller.CtrTrabajadores.frameMode == 2);
		}*/
		setVisible(true);
	}

	

	/**
	 * Initialize the contents of the frame.
	 */
	public void crearVentana() {
		
		setTitle("TRABAJADORES DETALLE");
		setBounds(100, 100, 274, 272);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("DNI:");
		lblNewLabel.setBounds(10, 11, 70, 21);
		getContentPane().add(lblNewLabel);

		JLabel lblPresupuesto = new JLabel("Nombre:");
		lblPresupuesto.setBounds(10, 43, 89, 21);
		getContentPane().add(lblPresupuesto);

		JLabel lblFechaInicio = new JLabel("Apellidos:");
		lblFechaInicio.setBounds(10, 75, 70, 21);
		getContentPane().add(lblFechaInicio);

		textDni = new JTextField();
		textDni.setBounds(114, 11, 86, 20);
		getContentPane().add(textDni);
		textDni.setColumns(10);

		textNombre = new JTextField();
		textNombre.setColumns(10);
		textNombre.setBounds(114, 43, 86, 20);
		getContentPane().add(textNombre);

		textApellidos = new JTextField();
		textApellidos.setColumns(10);
		textApellidos.setBounds(114, 75, 86, 20);
		getContentPane().add(textApellidos);

		JLabel lblNewLabel_1 = new JLabel("Genero:");
		lblNewLabel_1.setBounds(10, 111, 56, 21);
		getContentPane().add(lblNewLabel_1);

		textGenero = new JTextField();
		textGenero.setColumns(10);
		textGenero.setBounds(114, 111, 86, 20);
		getContentPane().add(textGenero);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					controller.CtrTrabajadores.guardarTrabajador();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnGuardar.setBounds(74, 167, 89, 23);
		getContentPane().add(btnGuardar);

		/*if (controller.CtrTrabajadores.frameMode == 1) {
			JButton btnCrear = new JButton("CREAR");
			btnCrear.setIcon(new ImageIcon("C:\\Users\\Usuario\\Desktop\\ISAAC-NO BORRAR\\ECLIPSE\\Empresa_Flight\\Img\\ok,p.png"));
			btnCrear.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					controller.CtrTrabajadores.crear(textDni.getText(),
							textNombre.getText(), textApellidos.getText(),
							textGenero.getText());
					dispose();
				}
			});
			btnCrear.setBounds(62, 181, 150, 35);
			getContentPane().add(btnCrear);
		}

		if (controller.CtrTrabajadores.frameMode == 2) {
			JButton btnGuardarCambios = new JButton("GUARDAR CAMBIOS");
			btnGuardarCambios.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					controller.CtrTrabajadores.editar(textDni.getText(),
							textNombre.getText(), textApellidos.getText(),
							textGenero.getText());
					dispose();
				}
			});
			btnGuardarCambios.setBounds(26, 181, 101, 23);
			getContentPane().add(btnGuardarCambios);
		}*/

	}
}