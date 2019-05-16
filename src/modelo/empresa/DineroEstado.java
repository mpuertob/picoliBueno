package modelo.empresa;

public class DineroEstado {
	private double dineroTotal;

	public DineroEstado(double dineroTotal) {
		super();
		this.dineroTotal = dineroTotal;
	}

	/**
	 * 
	 * @param seres
	 * @param sueldo
	 * @return el dinero reparte
	 */
	public double calcularSueldo(int seres, double sueldo) {

		return sueldo;
	}

	public double calcularPorcentajeJubilados(double dineroNecesario) {
		return ((this.dineroTotal * 100) / dineroNecesario) / 100;
	}

	public double getDineroTotal() {
		return dineroTotal;
	}

	public void setDineroTotal(double dineroTotal) {
		this.dineroTotal = dineroTotal;
	}
}
