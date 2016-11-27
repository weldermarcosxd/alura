package br.com.caelum.model.comercial;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.erp.Produto;

public class Cliente {
	private String nome;
	private String cpf;
	private List<Produto> produtos;

	public Cliente(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
		this.produtos = new ArrayList<Produto>();
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}
	
}
