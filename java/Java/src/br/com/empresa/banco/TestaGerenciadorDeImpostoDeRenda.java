package br.com.empresa.banco;
import br.com.empresa.conta.ContaCorrente;
import br.com.empresa.conta.GerenciadorDeImpostoDeRenda;
import br.com.empresa.conta.SeguroDeVida;


public class TestaGerenciadorDeImpostoDeRenda {
	public static void main(String[] args) {
		GerenciadorDeImpostoDeRenda gerenciador = new GerenciadorDeImpostoDeRenda();
		SeguroDeVida seguroDeVida = new SeguroDeVida();
		gerenciador.adiciona(seguroDeVida);
		
		ContaCorrente contaCorrente = new ContaCorrente();
		contaCorrente.deposita(1000);
		gerenciador.adiciona(contaCorrente);
		
		System.out.println(gerenciador.getTotal());
		System.out.printf("O saldo é :" + contaCorrente.getSaldo());
	}
}
