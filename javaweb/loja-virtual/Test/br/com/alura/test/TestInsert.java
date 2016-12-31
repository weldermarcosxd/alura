package br.com.alura.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestInsert {
	public static void main(String[] args) throws SQLException {
		// main test
		TestConnection testConnection = new TestConnection();
		
		try (Connection connection = testConnection.getConnection()) {
			
			connection.setAutoCommit(false);

			String sql = "insert into produto (nome, descricao) values (? , ?)";

			try (PreparedStatement prepareStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

				add("TV LED", "23 polegadas", prepareStatement);
				add("BlueRay", "Full HD", prepareStatement);
				connection.commit();

			} catch (Exception e) {
				e.printStackTrace();
				connection.rollback();
				System.out.println("Rollback efetuado");
			}
		}
	}

	public static void add(String nome, String descricao, PreparedStatement prepareStatement) throws SQLException {
		prepareStatement.setString(1, nome);
		prepareStatement.setString(2, descricao);

		boolean result = prepareStatement.execute();
		if (!result) {
			System.out.println("Query successful");
		}

		ResultSet resultSet = prepareStatement.getGeneratedKeys();
		while (resultSet.next()) {
			System.out.println(resultSet.getInt("id"));
		}

		resultSet.close();
	}
}