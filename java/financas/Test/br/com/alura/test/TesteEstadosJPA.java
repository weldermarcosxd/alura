package br.com.alura.test;

import javax.persistence.EntityManager;

import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.persistence.jpa.JPABase;

public class TesteEstadosJPA {

  public static void main(String[] args) {

		EntityManager manager = new JPABase().getEntityManagerFactory();

		manager.getTransaction().begin();

		Conta conta = manager.find(Conta.class, 1);
		System.out.println(conta.getTitular());
		
		conta.setTitular("Outro");
		System.out.println(conta.getTitular());
		
		Conta conta2 = manager.find(Conta.class, 1);
		
		manager.getTransaction().commit();
		
		manager.getTransaction().begin();
		conta2.setTitular("José 2");
		manager.getTransaction().commit();

		manager.close();

	}
}