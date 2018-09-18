package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Ficheros {

	public static List<String> cargarFicheroCFG() throws Exception {
		List<String> cfg = new ArrayList<String>();

		FileReader fch = new FileReader("conexion.txt");
		BufferedReader b = new BufferedReader(fch);

		for (int i = 1; i <= 5; i++) {
			cfg.add(b.readLine());
		}
		b.close();

		return cfg;
	}

}

