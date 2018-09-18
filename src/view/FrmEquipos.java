package view;

import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.CtrEquipos;

import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmEquipos extends JFrame {

	private static final long serialVersionUID = 1L;
	public static JTable table;
	public static JComboBox comboBoxProyecto;
	public static 	JScrollPane scrollPane ;

	/**
	 * Create the application.
	 */
	public FrmEquipos() {

		initialize();
		controller.CtrEquipos.rellenaCombo();
		controller.CtrEquipos.rellenaJtable2();
		setVisible(true);

	}

	
	private void initialize() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("Img\\FlyMasterSmall.png"));

		setSize(450, 350);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.WHITE);
		setTitle("Equipo");
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("PROYECTO:");
		lblNewLabel.setBounds(30, 53, 72, 14);
		getContentPane().add(lblNewLabel);

		comboBoxProyecto = new JComboBox();
		
		comboBoxProyecto.setModel(new DefaultComboBoxModel());
		comboBoxProyecto.setBounds(112, 50, 217, 20);
		getContentPane().add(comboBoxProyecto);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(112, 93, 217, 148);
		getContentPane().add(scrollPane);
		
				table = new JTable();
				//scrollPane.setViewportView(table);
				/*table.setModel(new DefaultTableModel(
				 
						
						new Object[][] { { null, null }, { null, null }, { null, null }, { null, null }, },
						new String[] { "NOMBRE", "CARGO" }));*/
		controller.CtrEquipos.tabla();
		scrollPane.setViewportView(table);
		JButton nuevo = new JButton("NUEVO");
		nuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
		nuevo.setBackground(new Color(204, 255, 255));
		nuevo.setIcon(new ImageIcon("C:\\Users\\Alfonso\\Desktop\\Java\\FLY\\Img\\A\u00F1adir.png"));
		nuevo.setBounds(10, 267, 107, 33);
		getContentPane().add(nuevo);

		JButton borrar = new JButton("BORRAR");
		borrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("INDICE DE TABLA: "+table.getSelectedRow());
				CtrEquipos.borrar(table.getSelectedRow());
				CtrEquipos.rellenaJtable2() ;
			}
		});
		borrar.setBackground(new Color(204, 255, 255));
		borrar.setIcon(new ImageIcon("C:\\Users\\Alfonso\\Desktop\\Java\\FLY\\Img\\Borrar.png"));
		borrar.setBounds(166, 267, 107, 33);
		getContentPane().add(borrar);

		JButton editar = new JButton("EDITAR");
		editar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
		editar.setBackground(new Color(204, 255, 255));
		editar.setIcon(new ImageIcon("C:\\Users\\Alfonso\\Desktop\\Java\\FLY\\Img\\Editar.png"));
		editar.setBounds(317, 267, 107, 33);
		getContentPane().add(editar);

	}
}
