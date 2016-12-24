package br.com.alura.financas.persistence.dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.alura.financas.modelo.Conta;

public class ContaDAO {

	public Conta findById(EntityManager entityManager, int id){
		
		TypedQuery<Conta> query = entityManager.createNamedQuery("findById", Conta.class);
		query.setParameter("id", id);
		
		Conta conta = query.getSingleResult();
		
		if(null != conta){
			return conta;
		}else{
			return null;
		}
	}
	
}
