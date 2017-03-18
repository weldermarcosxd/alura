package br.com.caelum.livraria.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.caelum.livraria.modelo.Autor;

public class AutorDAO implements Serializable{
	
	private static final long serialVersionUID = 2601427845359082395L;

	@Inject
	EntityManager entityManager;
	
	private DAO<Autor> dao;
	
	@PostConstruct
	void init(){
		this.dao = new DAO<Autor>(entityManager, Autor.class);
	}

	public Autor buscaPorId(Integer autorId) {
		return dao.buscaPorId(autorId);
	}

	public void adiciona(Autor autor) {
		dao.adiciona(autor);
	}

	public void remove(Autor autor) {
		dao.remove(autor);
	}

	public void atualiza(Autor autor) {
		dao.atualiza(autor);
	}

	public List<Autor> listaTodos() {
		return dao.listaTodos();
	}

}