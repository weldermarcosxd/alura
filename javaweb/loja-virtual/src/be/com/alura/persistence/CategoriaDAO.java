package be.com.alura.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.datasource.Connect;
import br.com.alura.model.Categoria;
import br.com.alura.model.Produto;

public class CategoriaDAO {

	Connect connect = new Connect();

	public List<Categoria> findListComProduto() throws SQLException {
		List<Categoria> categoriaList = new ArrayList<Categoria>();
		try (Connection connection = connect.getConnection()) {
			String sql = "select categoria.id as categoriaId, categoria.nome as categoriaNome, "
					+ " produto.id as produtoId, produto.nome as produtoNome, produto.descricao as produtoDescricao " + " from categoria "
					+ " left join produto on categoria.id = produto.categoria_id "
					+ " order by  categoriaNome ";

			try (PreparedStatement prepareStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
				boolean result = prepareStatement.execute();
				if (result) {
					System.out.println("Query successful");
				}
				ResultSet resultSet = prepareStatement.getResultSet();
				Categoria ultima = new Categoria();
				while (resultSet.next()) {

					if (null == ultima.getId() || !ultima.getNome().equals(resultSet.getString("categoriaNome"))) {
						Categoria categoria = new Categoria(resultSet.getInt("categoriaId"), resultSet.getString("categoriaNome"));
						ultima = categoria;
						categoriaList.add(categoria);
					}
					Produto produto = new Produto(resultSet.getInt("produtoId"), resultSet.getString("produtoNome"), resultSet.getString("produtoDescricao"));
					ultima.getProdutoList().add(produto);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			return categoriaList;
		}
	}
}
