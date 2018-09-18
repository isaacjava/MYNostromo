package logic;

import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;

import model.Trabajador;

public class LogicTrabajador {

	public static String sqlTrabajador;
	public static CachedRowSet consultaTrabajador;

	public static String sqlBorrarTrabajador;
	public static CachedRowSet borrarTrabajador;

	public static String sqlEditarTrabajador;

	public static String dni;
	public static String Nombre;
	public static String Apellido;
	public static String Genero;
	
	private static Trabajador t;

	public static void dbConsTrabajador() throws SQLException {
		sqlTrabajador = "Select  * from IP_Trabajador";

		consultaTrabajador = logic.LogicPrincipal.consultaGenerica(sqlTrabajador);

	}

	public static void dbBorrarTrabajador() throws SQLException {
		sqlBorrarTrabajador = "delete from IP_Trabajador where ID_Trabajador="
				+ controller.CtrTrabajadores.resultadoCelda;
		databasemanager.DBsqlServer.executeDML(sqlBorrarTrabajador);

	}

	public static Trabajador dbEditarTrabajador(String coord) throws SQLException {

		String strSQL = "SELECT * FROM IP_Trabajador WHERE ID_Trabajador=" + coord;
		CachedRowSet resultado = logic.LogicPrincipal.consultaGenerica(strSQL);
		resultado.next();
		t = new Trabajador();
		t.setDni(resultado.getString("DNI"));
		t.setNombre(resultado.getString("Nombre"));
		t.setApellidos(resultado.getString("Apellidos"));
		t.setGenero(resultado.getString("Genero"));
		return t;
	}

	public static void lgGuardarTrabajador(String coord,String dni,String nombre,String apellidos,String genero) throws SQLException {
		
		String strSQL = "update  IP_Trabajador set DNI="+dni +",Nombre="+nombre
		+",Apellidos="+apellidos+",Genero="+genero+" WHERE ID_Trabajador=" + coord;
		System.out.println(strSQL);
		databasemanager.DBsqlServer.executeDML(strSQL);
	}

}
