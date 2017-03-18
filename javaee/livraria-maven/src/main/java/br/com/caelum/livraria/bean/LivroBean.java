package br.com.caelum.livraria.bean;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.livraria.dao.AutorDAO;
import br.com.caelum.livraria.dao.LivroDAO;
import br.com.caelum.livraria.modelo.Autor;
import br.com.caelum.livraria.modelo.Livro;
import br.com.caelum.livraria.modelo.LivroDataModel;

@Named
@ViewScoped
public class LivroBean  implements Serializable{
	
	private static final long serialVersionUID = 8569974364471646660L;

	@Inject
	private LivroDAO livroDAO;
	
	@Inject AutorDAO autorDAO;
	
	private Livro livro = new Livro();
	private Integer autorId;
	private Integer livroId;
	private LivroDataModel livroDataModel = new LivroDataModel();
	private List<Livro> livros;
	private List<String> generos = Arrays.asList("Romance", "Drama", "Ação");

	public Integer getLivroId() {
		return livroId;
	}

	public void setLivroId(Integer livroId) {
		this.livroId = livroId;
	}

	public void setAutorId(Integer autorId) {
		this.autorId = autorId;
	}

	public Integer getAutorId() {
		return autorId;
	}

	public Livro getLivro() {
		return livro;
	}
	
	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public List<Livro> getLivros() {

		if (this.livros == null) {
			this.livros = livroDAO.listaTodos();
		}

		return this.livros;
	}
	
	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	public List<Autor> getAutores() {
		return autorDAO.listaTodos();
	}

	public List<Autor> getAutoresDoLivro() {
		return this.livro.getAutores();
	}

	public void gravarAutor() {
		Autor autor = autorDAO.buscaPorId(this.autorId);
		this.livro.adicionaAutor(autor);
		System.out.println("Escrito por: " + autor.getNome());
	}

	@Transacional
	public void gravar() {
		System.out.println("Gravando livro " + this.livro.getTitulo());

		if (livro.getAutores().isEmpty()) {
			FacesContext.getCurrentInstance().addMessage("autor",
					new FacesMessage("Livro deve ter pelo menos um Autor."));
			return;
		}

		if (this.livro.getId() == null) {
			livroDAO.adiciona(this.livro);
			this.livros = livroDAO.listaTodos();
		} else {
			livroDAO.atualiza(this.livro);
		}

		this.livro = new Livro();
	}

	public void carregar(Livro livro) {
	    System.out.println("Carregando livro");
	    this.livro = livroDAO.buscaPorId(livro.getId());
	}

	@Transacional
	public void remover(Livro livro) {
		System.out.println("Removendo livro " + livro.getTitulo());
		livroDAO.remove(livro);
	}

	@Transacional
	public void removerAutorDoLivro(Autor autor) {
		this.livro.removeAutor(autor);
	}

	public String formAutor() {
		System.out.println("Chamanda do formulário do Autor.");
		return "autor?faces-redirect=true";
	}

	public void setGeneros(List<String> generos) {
		this.generos = generos;
	}

	public void comecaComDigitoUm(FacesContext fc, UIComponent component, Object value) throws ValidatorException {

		String valor = value.toString();
		if (!valor.startsWith("1")) {
			throw new ValidatorException(new FacesMessage("ISBN deveria começar com 1"));
		}

	}

	public void carregaPelaId() {
		this.livro = livroDAO.buscaPorId(this.livroId);
	}
	
	public boolean precoEhMenor(Object valorColuna, Object filtroDigitado, Locale locale) { //java.util.Locale
		//tirando espaços do filtro
        String textoDigitado = (filtroDigitado == null) ? null : filtroDigitado.toString().trim();

        System.out.println("Filtrando pelo " + textoDigitado + ", Valor do elemento: " + valorColuna);

        // o filtro é nulo ou vazio?
        if (textoDigitado == null || textoDigitado.equals("")) {
            return true;
        }

        // elemento da tabela é nulo?
        if (valorColuna == null) {
            return false;
        }

        try {
            // fazendo o parsing do filtro para converter para Double
            Double precoDigitado = Double.valueOf(textoDigitado);
            Double precoColuna = (Double) valorColuna;

            // comparando os valores, compareTo devolve um valor negativo se o value é menor do que o filtro
            return precoColuna.compareTo(precoDigitado) < 0;

        } catch (NumberFormatException e) {

            // usuario nao digitou um numero
            return false;
        }
	}

	public LivroDataModel getLivroDataModel() {
		return livroDataModel;
	}

	public void setLivroDataModel(LivroDataModel livroDataModel) {
		this.livroDataModel = livroDataModel;
	}
	
	public List<String> getGeneros() {
	    return generos;
	}

}