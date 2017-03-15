package br.com.caelum.livraria.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.livraria.dao.AutorDAO;
import br.com.caelum.livraria.modelo.Autor;

@Named
@ViewScoped
public class AutorBean implements Serializable{
	
	private static final long serialVersionUID = 8569974364471646660L;

	private Integer autorId;

	private Autor autor = new Autor();
	
	@Inject
	private AutorDAO autorDao;

	public Autor getAutor() {
		return autor;
	}
	
	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public List<Autor> getAutores() {
		return autorDao.listaTodos();
	}
	
	public Integer getAutorId() {
	    return autorId;
	}

	public void setAutorId(Integer autorId) {
	    this.autorId = autorId;
	}

	public void carregarAutorPelaId() {
	    this.autor = autorDao.buscaPorId(autorId);
	}

	@Transacional
	public String gravar() {
		System.out.println("Gravando autor " + this.autor.getNome());

		if (this.autor.getId() == null) {
			autorDao.adiciona(this.autor);
		} else {
			autorDao.atualiza(this.autor);
		}

		this.autor = new Autor();

		return "livro?faces-redirect=true";
	}

	public void carregar(Autor autor) {
		System.out.println("Carregando autor");
		this.autor = autor;
	}

	@Transacional
	public void remover(Autor autor) {
		System.out.println("Removendo autor");
		autorDao.remove(autor);
	}

}
