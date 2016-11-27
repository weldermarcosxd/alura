package br.com.empresa.conta;

public class ContaPoupanca extends Conta{
	
	ContaPoupanca contaPoupanca = new ContaPoupanca();

	@Override
	public void atualiza(double valor) {
		this.setSaldo(getSaldo() + valor);
	}

}
