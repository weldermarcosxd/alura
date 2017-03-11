package br.com.caelum.livraria.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.caelum.livraria.modelo.Usuario;

public class UsuarioDAO {

	public Boolean autenticar(Usuario usuario) {
		EntityManager entityManager = new JPAUtil().getEntityManager();
		TypedQuery<Usuario> query = entityManager.createQuery(
				  " select u from Usuario u"
							+ " where u.email = :email and senha = :senha", Usuario.class);
		query.setParameter("email", usuario.getEmail());
		query.setParameter("senha", usuario.getSenha());
		
		Usuario result;
		
		try {
			result = query.getSingleResult();
		} catch (NoResultException e) {
			result = null;
		}
		
		entityManager.close();
		
		return result != null;
	}

}