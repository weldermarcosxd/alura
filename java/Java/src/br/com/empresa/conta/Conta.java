package br.com.empresa.conta;

public abstract class Conta {
	private double saldo;
	private int numero;
	private String nome;

	public void saca(double valor) {
		this.saldo -= valor;
	}

	public void deposita(double valor) throws ValorInvalidoException {
		if (valor < 0) {
			throw new ValorInvalidoException();
		} else {
			this.saldo += valor;
		}
	}

	public abstract void atualiza(double valor);

	public double getSaldo() {
		return saldo;
	}

	@Override
	public String toString() {
		return "Conta com valor: " + this.getSaldo();
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Conta){
			return ((Conta) obj).getNumero() == this.getNumero() && ((Conta) obj).getNome().equals(this.getNome());
		}else{
			return false;
		}
	}

	public void setSaldo(double valor) {
		this.saldo = valor;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
