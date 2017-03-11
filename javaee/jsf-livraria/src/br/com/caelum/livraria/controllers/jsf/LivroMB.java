package br.com.caelum.livraria.controllers.jsf;

@javax.faces.bean.ManagedBean
public class LivroMB {
	
	private Livro livro = new Livro();
	
	public Livro getLivro() {
		return livro;
	}
	
	public void gravar(){
		System.out.println("Gravando livro " + this.livro.getTitulo() );
	}
}
