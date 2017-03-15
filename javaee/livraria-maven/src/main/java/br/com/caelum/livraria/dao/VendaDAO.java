package br.com.caelum.livraria.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.caelum.livraria.modelo.Venda;

public class VendaDAO {
	
	@Inject
	EntityManager entityManager;

	public List<Venda> listaTodas() {
		TypedQuery<Venda> query = entityManager.createQuery("select v from Venda v", Venda.class);
		return query.getResultList();
	}

}
