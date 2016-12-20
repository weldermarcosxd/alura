package br.com.alura.financas.persistence.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPABase {
	
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("financas");

	public EntityManager getEntityManagerFactory() {
		return entityManagerFactory.createEntityManager();
	}
}
