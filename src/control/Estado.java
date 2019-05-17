package control;

import modelo.empresa.DineroEstado;
import modelo.poblacion.EstadoSer;
import modelo.vista.DatosEstadoGlobal;
import modelo.vista.DatosEstadoLocal;
import modelo.vista.DatosPoblacion;

public class Estado {

	private Poblacion poblacion;
	private DineroEstado dinero;
	private Sede sede;

	private double demanda = 100000;

	public Estado() {
		super();
		this.poblacion = new Poblacion(50, 100, 30);
		this.sede = new Sede();
		this.dinero = new DineroEstado(100000);
	}

	public void pasarPeriodo() {
	}

	public double incrementarDemanda() {
		float porcentaje = (float) (this.demanda * 0.1);
		return demanda += porcentaje;
	}

	public double disminuirDemanda() {
		float porcentaje = (float) (this.demanda * 0.1);
		return demanda -= porcentaje;
	}

	public DatosPoblacion getDatosPoblacion() {
		return new DatosPoblacion(this.poblacion.getPoblacion().size(), this.poblacion.numeroTipoSeres(EstadoSer.menor),
				this.sede.numTrabajadores(), this.poblacion.numeroTipoSeres(EstadoSer.jubilado),
				this.poblacion.getMenores(), this.poblacion.getFallecidos(), this.poblacion.getJubilados(), this.poblacion.getTrabajadores());
	}

	public DatosEstadoGlobal getDatosEstadoGlobales() {
		return new DatosEstadoGlobal(this.demanda, this.sede.produccionTotal(), this.dinero.getDineroTotal(), 0);
	}

	public DatosEstadoLocal getDatosEstadoLocal() {
		return new DatosEstadoLocal(0, 0, 0, 0, 0, 0);
	}
}
