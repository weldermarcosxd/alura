package br.com.caelum.livraria.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.caelum.livraria.modelo.Livro;

public class DAO<T> implements Serializable{

	private static final long serialVersionUID = -401308362075661784L;
	
	private final Class<T> classe;
	private EntityManager entityManager;

	public DAO(EntityManager entityManager, Class<T> classe) {
		this.entityManager = entityManager;
		this.classe = classe;
	}

	public void adiciona(T t) {
		
		// abre transacao
		entityManager.getTransaction().begin();

		// persiste o objeto
		entityManager.persist(t);

		// commita a transacao
		entityManager.getTransaction().commit();

	}

	public void remove(T t) {
		entityManager.getTransaction().begin();

		entityManager.remove(entityManager.merge(t));

		entityManager.getTransaction().commit();
	}

	public void atualiza(T t) {
		entityManager.getTransaction().begin();

		entityManager.merge(t);

		entityManager.getTransaction().commit();
	}

	public List<T> listaTodos() {
		CriteriaQuery<T> query = entityManager.getCriteriaBuilder().createQuery(classe);
		query.select(query.from(classe));

		List<T> lista = entityManager.createQuery(query).getResultList();

		return lista;
	}

	public T buscaPorId(Integer id) {
		T instancia = entityManager.find(classe, id);
		return instancia;
	}

	public int contaTodos() {
		long result = (Long) entityManager.createQuery("select count(n) from livro n").getSingleResult();

		return (int) result;
	}

	public List<T> listaTodosPaginada(int firstResult, int maxResults, String coluna, String valor) {
		CriteriaQuery<T> query = entityManager.getCriteriaBuilder().createQuery(classe);
		Root<T> root = query.from(classe);

		if (valor != null)
			query = query.where(entityManager.getCriteriaBuilder().like(root.<String>get(coluna), valor + "%"));

		List<T> lista = entityManager.createQuery(query).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();

		return lista;
	}

	public int quantidadeDeElementos() {
		EntityManager em = new JPAUtil().getEntityManager();
		long result = (Long) em.createQuery("select count(n) from " + classe.getSimpleName() + " n").getSingleResult();

		return (int) result;
	}

	@SuppressWarnings("unchecked")
	public List<Livro> listaTodosPaginada(int firstResult, int maxResults, Map<String, Object> filtros) {
		CriteriaQuery<T> query = entityManager.getCriteriaBuilder().createQuery(classe);
		Root<T> root = query.from(classe);

		for (Map.Entry<String, Object> filtro : filtros.entrySet()) {
			if (filtro.getValue() != null) {
				if(filtro.getKey().equals("preco")){
					query = query.where(
							entityManager.getCriteriaBuilder().lessThan(root.<String>get(filtro.getKey()), filtro.getValue().toString()));
				}else if(filtro.getKey().equals("dataLancamento")){
				}else{
					query = query.where(
							entityManager.getCriteriaBuilder().like(root.<String>get(filtro.getKey()), filtro.getValue() + "%"));
				}
			}
		}

		List<T> lista = entityManager.createQuery(query).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();

		return (List<Livro>) lista;
	}
}
