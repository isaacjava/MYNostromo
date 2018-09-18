package controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import view.FrmEquipos;
import model.Cargo;
import model.Equipo;
import model.Proyecto;
import model.Trabajador;

public class CtrEquipos {

	public static List<Equipo> lstEquipo = new ArrayList<Equipo>();

	public static List<?> tablaBid[][];
	public static int frameMode;
	public static Integer elementoSeleccionado;
	public static Integer selectedIndex;
	public static List eq;
	public static List ca;
	public static void inicio() {
		if (lstEquipo.isEmpty()) {
			inicializaLista();
		}

		new view.FrmEquipos();

	}

	private static void inicializaLista() {
		// Equipo 1
		List<Trabajador> LT1 = new ArrayList<Trabajador>();
		LT1.add(controller.CtrTrabajadores.lstTrabajador.get(0));
		// LT1.add(controller.CtrTrabajadores.lstTrabajador.get(1));

		List<Cargo> LC1 = new ArrayList<Cargo>();
		LC1.add(model.Cargo.Diseñador);
		// LC1.add(model.Cargo.Programador);

		lstEquipo.add(new Equipo(LT1, LC1));

		// Equipo 2
		List<Trabajador> LT2 = new ArrayList<Trabajador>();
		LT2.add(controller.CtrTrabajadores.lstTrabajador.get(1));

		List<Cargo> LC2 = new ArrayList<Cargo>();
		LC2.add(model.Cargo.Tester);

		lstEquipo.add(new Equipo(LT2, LC2));

		// Equipo 3
		List<Trabajador> LT3 = new ArrayList<Trabajador>();
		LT3.add(controller.CtrTrabajadores.lstTrabajador.get(2));

		List<Cargo> LC3 = new ArrayList<Cargo>();
		LC3.add(model.Cargo.Programador);
		lstEquipo.add(new Equipo(LT3, LC3));

		// Equipo 4
		List<Trabajador> LT4 = new ArrayList<Trabajador>();
		LT4.add(controller.CtrTrabajadores.lstTrabajador.get(3));
		// LT4.add(controller.CtrTrabajadores.lstTrabajador.get(4));
		// LT4.add(controller.CtrTrabajadores.lstTrabajador.get(5));

		List<Cargo> LC4 = new ArrayList<Cargo>();
		LC4.add(model.Cargo.Jefe_Proyectos);
		// LC4.add(model.Cargo.Diseñador);
		// LC4.add(model.Cargo.Analista);
		lstEquipo.add(new Equipo(LT4, LC4));

	}

	public static void rellenaCombo() {
		view.FrmEquipos.comboBoxProyecto.removeAllItems();
		for (Proyecto p : controller.CtrProyectos.lstProyecto) {
			view.FrmEquipos.comboBoxProyecto.addItem(p.getNombre());
		}
	}

	/*
	 * public static void rellenaJtable() { view.FrmEquipos.table.removeAll();
	 * for (Trabajador t : controller.CtrTrabajadores.lstTrabajador) { for
	 * (Cargo c : model.Cargo.values());
	 * 
	 * }view.FrmEquipos.table.setc;
	 * 
	 * }
	 */
	public static void rellenaJtable2() {
		view.FrmEquipos.table.removeAll();
		final int FILS = lstEquipo.size();
		final int COLS = lstEquipo.size();
		List<?> tablaBid[][] = new List[FILS][COLS];
		// Rellenar la tabla...
		for (int f = 0; f < FILS; f++) {
			for (int c = 0; c < COLS; c++) {

				tablaBid[f][c] = lstEquipo.get(f).getLstTrabajador();
				lstEquipo.get(c).getLstCargo();

			}

			System.out.println("tamaño: " + lstEquipo.size());
			System.out.println(lstEquipo.get(f).getLstTrabajador());
			System.out.println(lstEquipo.get(f).getLstCargo());
			System.out.println("salto-------------");

		}

	}

	public static void tabla() {

		final int FILS = lstEquipo.size();
		final int COLS = lstEquipo.size();

		// List tablaBid[][] = new List[FILS][COLS];
		// Rellenar la tabla...
		List<?> Object[][] = new List[FILS][COLS];
		int e = 0;
		int f= 0;
		view.FrmEquipos.table.setModel(new DefaultTableModel(

				new Object[][] { { lstEquipo.get(e).getLstTrabajador(),
						lstEquipo.get(e).getLstCargo() }, },

				new String[] { "NOMBRE", "CARGO" }));
		for (int c = 0; c < COLS; c++) {
			Object[c][c]=lstEquipo.get(c).getLstTrabajador();
					lstEquipo.get(c).getLstCargo();
			System.out.println("prueba");
			FrmEquipos.scrollPane.setViewportView(FrmEquipos.table);
		}

	}
	/*public static void tabla() {

		final int FILS = lstEquipo.size();
		final int COLS = lstEquipo.size();

		// List tablaBid[][] = new List[FILS][COLS];
		// Rellenar la tabla...

		for (int c = 0; c < COLS; c++) {
			List eq= lstEquipo.get(c).getLstTrabajador();
			List ca=	lstEquipo.get(c).getLstCargo() ;

			
			System.out.println("prueba");
			FrmEquipos.scrollPane.setViewportView(FrmEquipos.table);
		}

	}*/
	
	public static void borrar(int selectedIndex) {
		if (selectedIndex >= 0) {
			// elementoSeleccionado = selectedIndex;
			System.out.println("indice metodo: " + selectedIndex);
			System.out.println("indice CONTENIDO: "
					+ lstEquipo.get(selectedIndex));
			lstEquipo.remove(selectedIndex);

		}
	}

}
