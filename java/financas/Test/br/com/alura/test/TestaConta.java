package br.com.alura.test;

import javax.persistence.EntityManager;

import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.persistence.jpa.JPABase;

public class TestaConta {

	public static void main(String[] args) {
		
		 double inicio = System.currentTimeMillis();
		
		EntityManager entityManager = new JPABase().getEntityManagerFactory();

		String titular = "João da Silva";
		String numero = "00066656";
		String banco = "Banco Itaú";
		String agencia = "Formiga";
		
		Conta conta = new Conta(titular, numero, banco, agencia);
		
		entityManager.getTransaction().begin();
		entityManager.persist(conta);
		entityManager.getTransaction().commit();
		entityManager.close();
		
		double fim = System.currentTimeMillis();
        System.out.println("Executado em: " + (fim - inicio)/1000 + "s");
	}
}
