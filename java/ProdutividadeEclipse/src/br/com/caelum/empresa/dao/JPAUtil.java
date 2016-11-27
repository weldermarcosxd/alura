package br.com.caelum.empresa.dao;

import javax.persistence.EntityManager;

public class JPAUtil {

	EntityManager em;
	
	EntityManager getEntityManager(){
		return em;
	}
	
	
}
