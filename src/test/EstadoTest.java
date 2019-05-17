package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import control.Estado;
import control.Poblacion;
import modelo.poblacion.Ser;

class EstadoTest {
	Estado estado = new Estado();
	Poblacion poblacion;

	@Test
	void testFallecimiento() {
		Ser ser = new Ser(0);
		if (ser.getEdad()>=ser.getEsperanzaVida()) {
			assertEquals(true, ser.isPalmado());
		} else {
			assertEquals(false, ser.isPalmado());
		}
	}

}
