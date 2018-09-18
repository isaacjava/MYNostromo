package model;

public class Trabajador  {

	private String Dni;
	protected String Nombre;
	private String Apellidos;
	private String Genero;

	public Trabajador() {
		super();
	}

	public Trabajador(String dni, String nombre, String apellidos, String genero) {
		super();
		Dni = dni;
		Nombre = nombre;
		Apellidos = apellidos;
		Genero = genero;
	}

	public String getDni() {
		return Dni;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}

	public void setGenero(String genero) {
		Genero = genero;
	}

	public String getApellidos() {
		return Apellidos;
	}

	public String getGenero() {
		return Genero;
	}

	public void setDni(String dni) {
		Dni = dni;
	}
}