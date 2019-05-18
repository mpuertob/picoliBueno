package modelo.empresa;

import java.util.ArrayList;
import java.util.Stack;

import modelo.poblacion.EstadoSer;
import modelo.poblacion.Ser;

public class Factorias {

	private int produccionEmpleado = 1000;

	private Stack<Ser> pilaTrabajador;

	public Factorias() {
		super();
		this.pilaTrabajador = new Stack<Ser>();
	}
	/**
	 * añade trabajador a la pila
	 * @param trabajador
	 */
	public void contratarDemandante(Ser demandante) {
		this.pilaTrabajador.add(demandante);
	}
	/**
	 * comparar con ser y eliminar de la pila
	 * @param id
	 */
	public void eliminarTrabajador(int id){
		for (Ser ser : pilaTrabajador) {
			if (ser.getId()==id) {
				pilaTrabajador.remove(ser);
			}
		}
	}
	/**
	 * 
	 * @param despedidos
	 * @return lista de ids de depedidos
	 */
	public ArrayList<Integer> despedirTrabajadores(int despedidos){
		ArrayList<Integer>ListaDespidos = new ArrayList<Integer>();
		for (int i = 0; i < despedidos; i++) {
			if (this.pilaTrabajador.empty()==false) {
				ListaDespidos.add(this.pilaTrabajador.pop().getId());
			}
		}
		return ListaDespidos;
	}

	public int comprobarProduccion() {
		return pilaTrabajador.size() * this.produccionEmpleado;
	}

	public int puestosLibres() {
		return 1000 - this.pilaTrabajador.size();
	}

	public int getProduccion() {
		return produccionEmpleado;
	}

	public Stack<Ser> getPilaTrabajador() {
		return pilaTrabajador;
	}

	public void setPilaTrabajador(Stack<Ser> pilaTrabajador) {
		this.pilaTrabajador = pilaTrabajador;
	}

}
