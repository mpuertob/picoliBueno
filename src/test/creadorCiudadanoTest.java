package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;

import control.Poblacion;
import modelo.poblacion.Ser;

class creadorCiudadanoTest {
	Ser seres = new Ser(0);
	Poblacion poblacion = new Poblacion(0, 0, 0);
	ArrayList<Ser> menores;
	
	@Test
	void test() {
		boolean comprobador=false;
		if(seres.getEdad()==0 && seres.getAhorro()==0) {
			comprobador=true;
		} else comprobador =false;
		assertTrue(comprobador);
	}
	
}
