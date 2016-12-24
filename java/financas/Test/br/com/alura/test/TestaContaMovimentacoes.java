package br.com.alura.test;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.persistence.jpa.JPABase;

public class TestaContaMovimentacoes {
	public static void main(String[] args) {
		
		EntityManager entityManager = new JPABase().getEntityManagerFactory();
		TypedQuery<Conta> query = entityManager.createQuery("from Conta conta join fetch conta.movimentacoes where conta = :conta", Conta.class);
		
		query.setParameter("conta", entityManager.find(Conta.class, 1));
		Conta conta = query.getSingleResult();
		entityManager.close();
		
		System.out.println(conta.getMovimentacoes().size());
	}
}
