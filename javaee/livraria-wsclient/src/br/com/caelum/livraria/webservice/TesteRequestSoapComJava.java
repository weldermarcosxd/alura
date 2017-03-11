package br.com.caelum.livraria.webservice;

import java.rmi.RemoteException;

public class TesteRequestSoapComJava {

	public static void main(String[] args) throws RemoteException {
		LivrariaWS client = new LivrariaWSProxy();
		Livro[] livros = client.getLivrosPeloNome("Teste");
		
		for (Livro livro : livros) {
		    System.out.println(livro.getTitulo());
		    System.out.println(livro.getAutor().getNome());
		}
	}
}
