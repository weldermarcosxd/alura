package br.com.alura.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.persistence.jpa.JPABase;

public class TestaMovimentacoesConta {
	public static void main(String[] args) {
		
		EntityManager entityManager = new JPABase().getEntityManagerFactory();
		TypedQuery<Conta> query = entityManager.createQuery(
				" select distinct conta from Conta conta join fetch conta.movimentacoes"
			  , Conta.class);
		
		Conta conta = new Conta();
		conta.setId(1);
		
		List<Conta> resultList = query.getResultList();
		
		for (Conta contas : resultList) {
			System.out.println(contas.getMovimentacoes().size());
		}
	}
}
