package br.com.caelum.erp;

import br.com.caelum.erp.TipoDeProduto;


public class Produto {

	private String nome;
	private double preco;
	private TipoDeProduto tipo;

	public Produto(String nome, TipoDeProduto tipo, double preco) {
		this.nome = nome;
		this.tipo = tipo;
		this.preco = preco;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public double getPreco() {
		return preco;
	}

	public TipoDeProduto getTipo() {
		return tipo;
	}
	
	public void setPreco(double preco) {
		this.preco = preco;
	}
}
