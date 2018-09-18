package view;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Font;

public class FrmPrincipal extends JFrame{

	private static final long serialVersionUID = 1L;
	protected static final String GUIproyecto = null;
	public static JLabel lblEstado;
	
	/**
	 * Create the application.
	 */
	public FrmPrincipal() {
		getContentPane().setBackground(new Color(135, 206, 250));
		setTitle("FLIGHT COMPANY");
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 424, 21);
		getContentPane().add(menuBar);
		
		JMenu mnBase = new JMenu("Base");
		mnBase.setBackground(new Color(204, 153, 255));
		menuBar.add(mnBase);
		
		JMenuItem mntmProyectos = new JMenuItem("Proyectos");
		mntmProyectos.setBackground(new Color(204, 153, 255));
		mntmProyectos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					controller.CtrProyectos.inicio();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnBase.add(mntmProyectos);
		
		JMenuItem mntmTrabajadores = new JMenuItem("Trabajadores");
		mntmTrabajadores.setBackground(new Color(204, 153, 255));
		mntmTrabajadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					controller.CtrTrabajadores.inicio();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		mnBase.add(mntmTrabajadores);
		
		JSeparator separator = new JSeparator();
		mnBase.add(separator);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.setBackground(new Color(153, 102, 255));
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		mnBase.add(mntmSalir);
		
		JMenu mnGestion = new JMenu("Gestion");
		menuBar.add(mnGestion);
		
		JMenuItem mntmEquipos = new JMenuItem("Equipos");
		mntmEquipos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.CtrEquipos.inicio();
			}
		});
		mntmEquipos.setBackground(new Color(0, 255, 255));
		mnGestion.add(mntmEquipos);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Usuario\\Desktop\\ISAAC-NO BORRAR\\ECLIPSE\\Empresa_Flight\\Img\\telegram.png"));
		lblNewLabel_1.setBounds(253, 85, 115, 128);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblFlight = new JLabel("FLIGHT");
		lblFlight.setFont(new Font("Bradley Hand ITC", Font.BOLD | Font.ITALIC, 16));
		lblFlight.setBackground(new Color(0, 191, 255));
		lblFlight.setBounds(267, 54, 87, 27);
		getContentPane().add(lblFlight);
		
		lblEstado = new JLabel("");
		lblEstado.setBounds(263, 224, 105, 26);
		getContentPane().add(lblEstado);
		setVisible(true);
	}
}
