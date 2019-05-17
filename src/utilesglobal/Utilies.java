package utilesglobal;

import java.util.Random;

public class Utilies {
	
	public static int obtenerAleatorio(int max) {
	return new Random().nextInt(max)+1;
	}
	public static int obtenerAleatorio(int min,int max) {
		return (int) (Math.random()*max+min);
	}
	
	public static String obtenerNombre() {
		String[] personas = { "Antonio", "Paco", "Pepe", "Monica", "Laura", "Marta", "Manolo", "Maria", "Pedro",
				"Jesus", "Fran", "Ana", "Raul", "Victoria", "SerRaro", "Alien", "Depredador", "Pitufino", "Rufino",
		"Teresa" };
		return personas[obtenerAleatorio(0,personas.length-1)];
	}
}
