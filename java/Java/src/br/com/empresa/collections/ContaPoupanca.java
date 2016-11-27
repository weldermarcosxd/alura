package br.com.empresa.collections;

public class ContaPoupanca extends Conta implements Comparable<ContaPoupanca>{
	
	private String nomeCliente;
	
	@Override
	public void atualiza(double valor) {
		this.setSaldo(getSaldo() + valor);
	}
	
	public ContaPoupanca(int numero) {
		this.setNumero(numero);
	}
	
	public ContaPoupanca(int numero, String nomeCliente) {
		this.setNumero(numero);
		this.setNomeCliente(nomeCliente);
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	@Override
	public int compareTo(ContaPoupanca contaPoupanca) {
		return this.getNomeCliente().compareTo(contaPoupanca.getNomeCliente());
	}
}
