package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class FrmPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JTable table;
	
	public static JLabel lblEstaConectado;
	public static JTextArea textAreaSQL;

	/**
	 * Create the frame.
	 */
	public FrmPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 130, 355, 120);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnConectar = new JButton("CONECTAR");
		btnConectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.CtrPrincipal.mostrarDialogo();
			}
		});
		btnConectar.setBounds(10, 11, 89, 23);
		contentPane.add(btnConectar);
		
		lblEstaConectado = new JLabel("NO CONECTADO");
		lblEstaConectado.setBounds(124, 15, 122, 14);
		contentPane.add(lblEstaConectado);
		
		textAreaSQL = new JTextArea();
		textAreaSQL.setBounds(29, 45, 355, 48);
		contentPane.add(textAreaSQL);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.CtrPrincipal.limpiarCuadroSQL();
			}
		});
		btnLimpiar.setBounds(174, 96, 89, 23);
		contentPane.add(btnLimpiar);
		
		JButton btnEjecutar = new JButton("Ejecutar");
		btnEjecutar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.CtrPrincipal.ejercuarSentencia();
			}
		});
		btnEjecutar.setBounds(269, 96, 89, 23);
		contentPane.add(btnEjecutar);
		setVisible(true);
	}
}
