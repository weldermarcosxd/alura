package br.com.caelum.livraria.dao;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.caelum.livraria.modelo.Usuario;

@Named
@ViewScoped
public class UsuarioDAO implements Serializable{

	private static final long serialVersionUID = -722546784591065844L;
	
	@Inject 
	EntityManager entityManager;

	public Boolean autenticar(Usuario usuario) {
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