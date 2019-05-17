package control;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

import modelo.empresa.DineroEstado;
import modelo.empresa.Factorias;
import modelo.poblacion.EstadoSer;
import modelo.poblacion.Ser;

public class Sede {
	private ArrayList<Factorias> factorias;

	public Sede() {
		super();
		this.factorias = new ArrayList<>();
	}

	public boolean crearFactoria() {
		return this.factorias.add(new Factorias());
	}

	public void eliminarEmpresasEmpty() {
		for (Iterator<Factorias> iterator = factorias.iterator(); iterator.hasNext();) {
			Factorias factoria = (Factorias) iterator.next();
			if (factoria.getPilaTrabajador().isEmpty()) {
				iterator.remove();
			}
		}
	}

	public int produccionTotal() {
		int produccion = 0;
		for (Factorias factoria : factorias) {
			factoria.comprobarProduccion();
		}
		return produccion;
	}

	public void contratarDesempleados(ArrayList<Ser> desempleados) {
		// falta crear factoria si no hay vacantes suficientes para los trabajadores
		for (Iterator<Ser> iterator = desempleados.iterator(); iterator.hasNext();) {
			Ser ser = (Ser) iterator.next();
			for (Iterator<Factorias> iterator2 = this.factorias.iterator(); iterator2.hasNext();) {
				Factorias factoria = (Factorias) iterator2.next();
				if (factoria.puestosLibres() > 0) {
					factoria.setContratarTrabajador(ser);
					break;
				}
			}
		}
	}

	public int puestosVacantes() {
		int libres = 0;
		for (Factorias factoria : this.factorias) {
			libres += factoria.puestosLibres();
		}
		return libres;
	}

	public void eliminarTrabajadoresDead(ArrayList<Integer> id) {
		for (Iterator<Factorias> iterator = factorias.iterator(); iterator.hasNext();) {
			Factorias factoria = (Factorias) iterator.next();
			for (Iterator<Ser> iterator2 = factoria.getPilaTrabajador().iterator(); iterator2.hasNext();) {
				Ser ser = (Ser) iterator2.next();
				if (factorias.contains(ser.getId())) {
					iterator2.remove();
				}
			}
		}
	}

	public int numTrabajadores() {
		int contador = 0;
		for (Factorias factoria : factorias) {
			contador = contador + factoria.getPilaTrabajador().size();
		}
		return contador;
	}

	/**
	 * si la factoria tiene 0 trabajadores se cierra
	 * 
	 */
	public void gestionarCierreFactorias() {

//		int ocupacionMaxima = 1000;
//		for (Iterator<Factorias> iterator = factorias.iterator(); iterator.hasNext();) {
//			Factorias empresa = (Factorias) iterator.next();
//			int numTrabajadores = empresa.getPilaTrabajador().size();
//			float porcentajeOcupado = (numTrabajadores * 100) / ocupacionMaxima;
//			if (porcentajeOcupado <= 0.3) {
//				despedirTrabajadores(demandantes, empresa);
//				factorias.remove(empresa);
//			}
//
//		}

	}

	public void despedirTrabajadores(ArrayDeque<Ser> demandantes, Factorias empresa) {
		Ser trabajador = empresa.getPilaTrabajador().pop();
		demandantes.offer(trabajador);
	}

	public ArrayList<Factorias> getFactorias() {
		return factorias;
	}
}