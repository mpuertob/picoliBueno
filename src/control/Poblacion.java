package control;

import java.util.ArrayList;
import java.util.Iterator;

import modelo.empresa.DineroEstado;
import modelo.poblacion.EstadoSer;
import modelo.poblacion.Ser;
import utilesglobal.Utilies;

public class Poblacion {

	private ArrayList<Ser> poblacion = new ArrayList<Ser>();
	private int id = 0;
	private int jubilados = 0;
	private int trabajadores = 0;
	private int menores = 0;
	private int fallecidos = 0;

	public Poblacion(int menoresInicial, int trabajadoresIncial, int jubiladosInicial) {

		for (int i = 0; i < menoresInicial; i++) {
			poblacion.add(new Ser(Utilies.obtenerAleatorio(0, 17), this.id, EstadoSer.menor));
			this.id++;
		}
		for (int i = 0; i < trabajadoresIncial; i++) {
			poblacion.add(new Ser(Utilies.obtenerAleatorio(18, 65), this.id, EstadoSer.trabajador));
			this.id++;
		}
		for (int i = 0; i < jubiladosInicial; i++) {
			poblacion.add(new Ser(65, this.id, EstadoSer.jubilado));
			this.id++;
		}
	}

	/**
	 * 
	 * @param tipo
	 * @return lista con el mismo tipo que la entrada
	 */
	public ArrayList<Ser> obtenerSer(EstadoSer tipo) {

		return poblacion;

	}

	/**
	 * Elimina muertos y pilla ahorros
	 * 
	 * @param DineroEstado
	 * @return listaid de trabajadores muertos para elimnarlos de la sede
	 */
	public ArrayList<Integer> eliminarMuertos(DineroEstado capital) {
		ArrayList<Integer>muertos = new ArrayList<Integer>();
		for (Iterator iterator = this.poblacion.iterator(); iterator.hasNext();) {
			Ser ser = (Ser) iterator.next();
			if (ser.isPalmado()) {
				capital.setDineroTotal(ser.getAhorro());
				if (ser.getTipoEstado()==EstadoSer.trabajador) 
					this.fallecidos++;
					muertos.add(ser.getId());
					iterator.remove();
				}
				
			}return muertos;

	}

	/**
	 * @return lista de los nuevos jubilados para eliminarlos de la sede
	 */
	public ArrayList<Integer> actualizarPoblacion() {
		ArrayList<Integer>poblacionR = new ArrayList<Integer>();
		for (Ser ser : poblacion) {
			if (ser.getEdad()==18 && ser.getTipoEstado()==EstadoSer.menor) {
				ser.setTipoEstado(EstadoSer.desempleado);
				this.trabajadores++;
				poblacionR.add(ser.getId());
			}if (ser.getEdad()==65 && ser.getTipoEstado()==EstadoSer.desempleado || ser.getTipoEstado()==EstadoSer.trabajador) {
				ser.setTipoEstado(EstadoSer.desempleado);
				this.jubilados++;
				poblacionR.add(ser.getId());
			}
		}
		return poblacionR;

	}

	/**
	 * Metodo que me dice cuanto puede pagarle y le paga
	 * 
	 * @param capital
	 */
	public void pagarMenores(DineroEstado capital) {

	}

	public void pagarDemandantes(DineroEstado capital) {

	}

	public void pagarTrabajadores(DineroEstado capital) {

	}

	public void pagarJubilados(DineroEstado capital) {

	}

	/**
	 * @param tipo
	 * @return cantidad de sere de ese tipo
	 */
	public int numeroTipoSeres(EstadoSer tipo) {
		int resultado = 0;
		for (Ser ser : poblacion) {
			if (ser.getTipoEstado() == tipo) {
				resultado++;
			}
		}
		return resultado;

	}

	/**
	 * envejece a la poblacion 1 año
	 */
	public void envejecerPoblacion() {

	}

	/**
	 * 
	 * @param nacimiento
	 */
	public void generarMenor(int nacimiento) {

	}

	/**
	 * actualizar la lista de demandantes
	 * 
	 * @param genteDespedida(de la sede)
	 */
	public void despedirTrabajador(ArrayList<Integer> genteDespedida) {

	}

	public ArrayList<Ser> getPoblacion() {
		return poblacion;
	}

	public int getJubilados() {
		return jubilados;
	}

	public int getTrabajadores() {
		return trabajadores;
	}

	public int getMenores() {
		return menores;
	}

	public int getFallecidos() {
		return fallecidos;
	}
}
