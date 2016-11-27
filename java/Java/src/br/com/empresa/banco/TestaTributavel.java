package br.com.empresa.banco;
import br.com.empresa.conta.ContaCorrente;
import br.com.empresa.conta.Tributavel;

public class TestaTributavel {
	public static void main(String[] args) {
		ContaCorrente contaCorrente = new ContaCorrente();
		contaCorrente.deposita(100);
		System.out.println(contaCorrente.calculaTributos());
		
		Tributavel t = contaCorrente;
		System.out.println(t.calculaTributos());
	}
}
