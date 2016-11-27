package br.com.caelum.erp;

public class Encargo {

	private String tipo;
	private double aliquota;
	
	public Encargo(String tipo, double aliquota) {
		this.tipo = tipo;
		this.aliquota = aliquota;
	}

	public String getTipo() {
		return tipo;
	}

	public double getAliquota() {
		return aliquota;
	}
}
