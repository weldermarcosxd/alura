package be.com.alura.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import br.com.alura.datasource.Connect;
import br.com.alura.model.Produto;

public class ProdutoDAO {

	Connect connect = new Connect();

	public Produto save(Produto produto) throws SQLException {
		try (Connection connection = connect.getConnection()) {
			connection.setAutoCommit(false);
			Produto produtoInserido = new Produto();

			String sql = "insert into produto (nome, descricao) values (? , ?)";

			try (PreparedStatement prepareStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
				prepareStatement.setString(1, produto.getNome());
				prepareStatement.setString(2, produto.getDescricao());
				boolean result = prepareStatement.execute();
				if (!result) {
					System.out.println("Query successful");
				}
				ResultSet resultSet = prepareStatement.getGeneratedKeys();
				while (resultSet.next()) {
					produtoInserido.setId(resultSet.getInt("id"));
				}
				resultSet.close();
				connection.commit();
			} catch (Exception e) {
				e.printStackTrace();
				connection.rollback();
				System.out.println("Rollback efetuado");
			}
			return findByid(produtoInserido);
		}
	}

	public List<Produto> findList() throws SQLException {
		
		List<Produto> produtoList = new ArrayList<Produto>();
		
		try (Connection connection = connect.getConnection()) {

			String sql = "select * from produto";

			try (PreparedStatement prepareStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
				boolean result = prepareStatement.execute();
				if (result) {
					System.out.println("Query successful");
				}
				ResultSet resultSet = prepareStatement.getResultSet();
				while (resultSet.next()) {
					Produto produto = new Produto(
							resultSet.getInt("id"),
							resultSet.getString("nome"),
							resultSet.getString("descricao")
					);
					produtoList.add(produto);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return produtoList;
		}
	}

	public Produto findByid(Produto produto) throws SQLException {
		try (Connection connection = connect.getConnection()) {

			String sql = "select * from produto where id = ? ";

			try (PreparedStatement prepareStatement = connection.prepareStatement(sql)) {
				prepareStatement.setInt(1, produto.getId());
				boolean result = prepareStatement.execute();
				if (result) {
					System.out.println("Query successful");
				}
				ResultSet resultSet = prepareStatement.getResultSet();
				while (resultSet.next()) {
					produto.setNome(resultSet.getString("Nome"));
					produto.setDescricao(resultSet.getString("Descricao"));
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Rollback efetuado");
			}
		}
		return produto;
	}

	public Produto update(Produto produto) {
		return new Produto();
	}

	public void delete(Produto produto) {
	}
}
