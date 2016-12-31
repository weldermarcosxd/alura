package br.com.alura.test;

import javax.persistence.EntityManager;
import br.com.alura.financas.modelo.Movimentacao;
import br.com.alura.financas.persistence.jpa.JPABase;

public class TestaMovimentacoesConta {
	public static void main(String[] args) {

		EntityManager entityManager = new JPABase().getEntityManagerFactory();
		Movimentacao movimentacao = entityManager.find(Movimentacao.class, 2);
		
		System.out.println(movimentacao.getConta().getTitular());
	}
}