package br.com.alura.test;

import java.sql.SQLException;
import java.util.List;

import be.com.alura.persistence.ProdutoDAO;
import br.com.alura.model.Produto;

public class TestProdutoList {
	public static void main(String[] args) throws SQLException {
		ProdutoDAO produtoDAO = new ProdutoDAO();

		List<Produto> produtoList = produtoDAO.findList();
		for (Produto produto : produtoList) {
			System.out.println(produto);
		}
	}
}
