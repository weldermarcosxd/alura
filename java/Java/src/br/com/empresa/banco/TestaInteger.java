package br.com.empresa.banco;

import br.com.empresa.conta.Conta;
import br.com.empresa.conta.ContaCorrente;

public class TestaInteger {
	public static void main(String[] args) {

		Conta conta = new ContaCorrente();
		System.out.println(conta);

		String string = "Alura";
		int lenght = string.length();

		for (int i = 0; i < lenght; i++) {
			System.out.println(string.charAt(i));
		}

		String[] s = new String[2];
		s[0] = "Socorram-me, subi no ônibus em Marrocos";
		s[1] = "anotaram a data da maratona";

		for (String strings : s) {
			for (int i = strings.length() - 1; i >= 0; i--) {
				System.out.print(strings.charAt(i));
			}
		}

		System.out.println();

		for (String strings : s) {

			String[] reverso = strings.split(" ");
			for (int i = reverso.length - 1; i >= 0; i--) {
				System.out.print(reverso[i] + " ");
			}
			System.out.println();
		}

		StringBuilder sBuilder = new StringBuilder("Teste de Testar");
		System.out.println(sBuilder.reverse());

		String integ = "2133113113";

		int resultado = 0;
		while (integ.length() > 0) {
			char algarismo = integ.charAt(0);
			resultado = resultado * 10 + (algarismo - '0');
			integ = integ.substring(1);
		}
		System.out.println(resultado);
	}
}