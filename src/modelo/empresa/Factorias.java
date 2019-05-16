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
	public void contratarDemandante(Ser trabajador) {
		
	}
	/**
	 * comparar con ser y eliminar de la pila
	 * @param id
	 */
	public void eliminarTrabajador(int id){
		
	}
	/**
	 * 
	 * @param despedidos
	 * @return lista de ids de depedidos
	 */
	public ArrayList<Integer> despedirTrabajadores(int despedidos){
		return null;
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

	public void setContratarTrabajador(Ser ser) {
		this.pilaTrabajador.add(ser);

	}

}
