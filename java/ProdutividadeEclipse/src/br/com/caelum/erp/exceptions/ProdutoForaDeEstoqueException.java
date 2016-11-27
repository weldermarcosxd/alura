package br.com.caelum.erp.exceptions;

import br.com.caelum.erp.Produto;

public class ProdutoForaDeEstoqueException extends RuntimeException {

	private static final long serialVersionUID = -6200914212377863370L;

	public ProdutoForaDeEstoqueException(Produto produto) {
		super("Não há estoque de: " + produto.getNome());
	}

}
