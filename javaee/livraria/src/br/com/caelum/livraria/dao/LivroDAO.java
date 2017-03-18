package br.com.caelum.livraria.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.caelum.livraria.bean.Log;
import br.com.caelum.livraria.modelo.Livro;

public class LivroDAO implements Serializable{

	private static final long serialVersionUID = 4264425744698382721L;

	@Inject
	private EntityManager entityManager;
	
	private DAO<Livro> dao;
	
	@PostConstruct
	void init(){
		this.dao = new DAO<Livro>(entityManager, Livro.class);
	}
	
	public Livro buscaPorId(Integer livroId) {
		return dao.buscaPorId(livroId);
	}

	public void remove(Livro livro) {
		dao.remove(livro);
	}

	public void atualiza(Livro livro) {
		dao.atualiza(livro);
	}

	public void adiciona(Livro livro) {
		dao.adiciona(livro);
	}

	@Log
	public List<Livro> listaTodos() {
		return dao.listaTodos();
	}

	public int quantidadeDeElementos() {
		return dao.quantidadeDeElementos();
	}

	public List<Livro> listaTodosPaginada(int inicio, int quantidade, Map<String, Object> filtros) {
		return dao.listaTodosPaginada(inicio, quantidade, filtros);
	}
}