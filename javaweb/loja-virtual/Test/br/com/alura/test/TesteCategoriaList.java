package br.com.alura.test;

import java.sql.SQLException;
import java.util.List;

import be.com.alura.persistence.CategoriaDAO;
import br.com.alura.model.Categoria;
import br.com.alura.model.Produto;

public class TesteCategoriaList {
	
	public static void main(String[] args) throws SQLException {
		
		CategoriaDAO categoriaDAO = new CategoriaDAO();
		List<Categoria> categotiaList = categoriaDAO.findListComProduto();
		
		for (Categoria categoria : categotiaList) {
			System.out.println(categoria.getNome());
			for(Produto produto : categoria.getProdutoList()){
				System.out.println(categoria.getNome() + " - " + produto.getNome());
			}
		}
	}
}