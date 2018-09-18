package model;

import java.util.ArrayList;
import java.util.List;

public class Equipo {

	private List<Trabajador> lstTrabajador;
	private List<Cargo> lstCargo;
	
	public Equipo() {
		super();
		lstTrabajador = new ArrayList<Trabajador>();
		lstCargo = new ArrayList<Cargo>();
	}

	public Equipo(List<Trabajador> lstTrabajador, List<Cargo> lstCargo) {
		super();
		this.lstTrabajador = lstTrabajador;
		this.lstCargo = lstCargo;
	}

	public List<Trabajador> getLstTrabajador() {
		return lstTrabajador;
	}

	public List<Cargo> getLstCargo() {
		return lstCargo;
	}

	public void setLstTrabajador(List<Trabajador> lstTrabajador) {
		this.lstTrabajador = lstTrabajador;
	}

	public void setLstCargo(List<Cargo> lstCargo) {
		this.lstCargo = lstCargo;
	}

	@Override
	public String toString() {
		return "Equipo [getLstTrabajador()=" + getLstTrabajador() + ", getLstCargo()=" + getLstCargo() + "]";
	}
	
}