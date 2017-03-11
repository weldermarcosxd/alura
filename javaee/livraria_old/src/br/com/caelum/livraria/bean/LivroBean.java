package br.com.caelum.livraria.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import br.com.caelum.livraria.dao.DAO;
import br.com.caelum.livraria.modelo.Autor;
import br.com.caelum.livraria.modelo.Livro;
import br.com.caelum.livraria.util.RedirectView;

@ManagedBean
@ViewScoped
public class LivroBean {

	private Integer autorId;
	private Livro livro;

	public Livro getLivro() {
		return livro;
	}

	public LivroBean() {
		this.livro = new Livro();
	}

	public java.util.List<Autor> getAutores() {
		return new DAO<Autor>(Autor.class).listaTodos();
	}

	public void gravar() {
		System.out.println("Gravando livro " + this.livro.getTitulo());

		if (livro.getAutores().isEmpty()) {
			FacesContext.getCurrentInstance().addMessage("auotr", new FacesMessage("É necessário informar um autor"));
			return;
		}

		 if (this.livro.getId() == null) {
		        new DAO<Livro>(Livro.class).adiciona(this.livro);        
		    } else {
		        new DAO<Livro>(Livro.class).atualiza(this.livro);
		    }
		
		 this.livro = new Livro();
	}
	
	public void remover(Livro livro) {
	    System.out.println("Removendo livro " + livro.getTitulo());
	    new DAO<Livro>(Livro.class).remove(livro);
	}
	
	public void carregar(Livro livro) {
	    System.out.println("Carregando livro " + livro.getTitulo());
	    this.livro = livro;
	}
	
	public void removerAutorDoLivro(Autor autor) {
		this.livro.removeAutor(autor);
	}
	
	public void comecaComDigitoUm(FacesContext fc, UIComponent component, Object value) throws ValidatorException {

	    String valor = value.toString();
	    if (!valor.startsWith("1")) {
	        throw new ValidatorException(new FacesMessage("Deveria começar com 1"));
	    }
	}

	public List<Autor> getAutoresDoLivro() {
		return this.livro.getAutores();
	}

	public Integer getAutorId() {
		return autorId;
	}

	public void setAutorId(Integer autorId) {
		this.autorId = autorId;
	}

	public List<Livro> getLivros() {
		return new DAO<Livro>(Livro.class).listaTodos();
	}

	public void gravaAutor() {
		Autor autor = new DAO<Autor>(Autor.class).buscaPorId(autorId);
		this.livro.adicionaAutor(autor);
	}
	
	public RedirectView formAutor() {
        System.out.println("Chamanda o formulario do Autor");
        return new RedirectView("autor");
    }
}
