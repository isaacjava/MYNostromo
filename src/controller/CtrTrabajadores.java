package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import model.Proyecto;
import model.Trabajador;

public class CtrTrabajadores {

	public static String resultadoCelda;

	public static List<Trabajador> lstTrabajador = new ArrayList<Trabajador>();

	public static int frameMode;
	public static Integer elementoSeleccionado;

	public static void inicio() throws SQLException {
		if (lstTrabajador.isEmpty()) {
			inicializaLista();

		}

		new view.FrmTrabajador();
		ctrConsTrabajador();
		rellenarTrabajador();
	}

	public static void ctrConsTrabajador() throws SQLException {

		logic.LogicTrabajador.dbConsTrabajador();

	}

	public static void rellenarTrabajador() {
		try {
			// Establecer una conexión
			Connection c = databasemanager.DBsqlServer.establecerConexion();

			// preparar el canal de comunicaciones en esa conex.
			Statement s = c.createStatement();

			// mandar la sentencia SQL y recoger los datos
			String strSQL = logic.LogicTrabajador.sqlTrabajador;
			ResultSet r = s.executeQuery(strSQL);
			ResultSetMetaData md = r.getMetaData();

			// pintar la tabla
			int totalCampos = md.getColumnCount();

			DefaultTableModel modelo = new DefaultTableModel();
			for (int i = 1; i <= totalCampos; i++) {
				modelo.addColumn(md.getColumnName(i));
			}

			String[] campo = new String[totalCampos];

			while (r.next()) {
				for (int i = 1; i <= totalCampos; i++) {
					campo[i - 1] = r.getString(i);
				}
				modelo.addRow(campo);
			}

			view.FrmTrabajador.tableTrabajador.setModel(modelo);

			// cerrar la conexion
			databasemanager.DBsqlServer.cerrarConexion(c);

		} catch (Exception e) {

		}

	}

	private static void inicializaLista() {
		lstTrabajador.add(new Trabajador("111a", "aaa", "aaa", "h"));
		lstTrabajador.add(new Trabajador("222b", "bbb", "bbb", "m"));
		lstTrabajador.add(new Trabajador("333c", "ccc", "ccc", "h"));
		lstTrabajador.add(new Trabajador("444d", "ddd", "ddd", "m"));
		lstTrabajador.add(new Trabajador("555e", "eee", "eee", "h"));
		lstTrabajador.add(new Trabajador("666f", "fff", "fff", "m"));
	}

	public static void mostrarFrmDetalles(int mode, Integer selectedIndex) {
		if (selectedIndex >= 0) {
			frameMode = mode;
			elementoSeleccionado = selectedIndex;
			new view.DiaTrabajador();
		}
	}

	public static void borrar(int selectedIndex) throws SQLException {
		if (selectedIndex >= 0) {

			logic.LogicTrabajador.dbBorrarTrabajador();
		}
	}

	public static void crear(String text1, String text2, String text3, String text4) {
		Trabajador t = new Trabajador(text1, text2, text3, text4);
		lstTrabajador.add(t);
	}

	public static void editar(String text1, String text2, String text3, String text4) {
		Trabajador t = new Trabajador(text1, text2, text3, text4);
		lstTrabajador.set(elementoSeleccionado, t);
	}

	public static void borrarTrabajador() throws SQLException {
		resultadoCelda = (String) view.FrmTrabajador.tableTrabajador.getValueAt(
				view.FrmTrabajador.tableTrabajador.getSelectedRow(),
				view.FrmTrabajador.tableTrabajador.getSelectedColumn());
		;
		logic.LogicTrabajador.dbBorrarTrabajador();

	}

	public static void editarTrabajador() throws SQLException {

		resultadoCelda = (String) view.FrmTrabajador.tableTrabajador.getValueAt(
				view.FrmTrabajador.tableTrabajador.getSelectedRow(),
				view.FrmTrabajador.tableTrabajador.getSelectedColumn());

		Trabajador t = logic.LogicTrabajador.dbEditarTrabajador(resultadoCelda);
		view.DiaTrabajador dialogTrb = new view.DiaTrabajador();
		// rellenar los campos del cialogo...
		dialogTrb.textDni.setText(t.getDni());
		dialogTrb.textNombre.setText(t.getNombre());
		dialogTrb.textApellidos.setText(t.getApellidos());
		dialogTrb.textGenero.setText(t.getGenero());
		dialogTrb.setModal(true);

	}

	public static void rellenarCuadros() {
		view.DiaTrabajador.textDni.setText(logic.LogicTrabajador.dni);
		view.DiaTrabajador.textNombre.setText(logic.LogicTrabajador.Nombre);
		view.DiaTrabajador.textApellidos.setText(logic.LogicTrabajador.Apellido);
		view.DiaTrabajador.textGenero.setText(logic.LogicTrabajador.Genero);
	}

	public static void guardarTrabajador() throws SQLException {
		
		String dniT = view.DiaTrabajador.textDni.getText();
		String nombreT = view.DiaTrabajador.textNombre.getText();
		String apellidosT = view.DiaTrabajador.textApellidos.getText();
		String generoT = view.DiaTrabajador.textGenero.getText();
		
		logic.LogicTrabajador.lgGuardarTrabajador(resultadoCelda,dniT,nombreT,apellidosT,generoT);
		
	}
	
}
