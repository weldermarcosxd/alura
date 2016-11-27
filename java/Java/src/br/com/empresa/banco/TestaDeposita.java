package br.com.empresa.banco;
import br.com.empresa.conta.Conta;
import br.com.empresa.conta.ContaCorrente;
import br.com.empresa.conta.ValorInvalidoException;

public class TestaDeposita {
	public static void main(String[] args) {
		Conta conta = new ContaCorrente();
		try {
			conta.deposita(-1000);
		} catch (ValorInvalidoException e) {
			System.out.println("Valor Inválido: " + e.getMessage());
		}
	}
}
