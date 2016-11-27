package br.com.caelum.erp;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.erp.exceptions.ProdutoForaDeEstoqueException;

public class Estoque {
	private List<Produto> disponiveis;
	private List<Produto> reservados;
	
	public Estoque() {
		this.disponiveis = new ArrayList<Produto>();
		this.reservados = new ArrayList<Produto>();
	}
	
	public List<Produto> getDisponiveis() {
		return disponiveis;
	}
	
	public List<Produto> getReservados() {
		return reservados;
	}
	
	public void reserva(Produto produto) {
		if(disponiveis.contains(produto)) {
			disponiveis.remove(produto);
			reservados.add(produto);
		} else {
			throw new ProdutoForaDeEstoqueException(produto);
		}
	}
}
