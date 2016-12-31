package br.com.alura.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestList {
	// main test
	public static void main(String[] args) throws SQLException {

		TestConnection testConnection = new TestConnection();

		for (int i = 0; i < 100; i++) {
			Connection connection = testConnection.getConnection();

			Statement statement = connection.createStatement();
			boolean result = statement.execute("select * from PRODUTO");
			System.out.println(result ? "Query successful" : "Error in query execution");

			ResultSet resultSet = statement.getResultSet();
			while (resultSet.next()) {
				System.out.println(resultSet.getInt("id"));
				System.out.println(resultSet.getString("nome"));
				System.out.println(resultSet.getString("descricao"));
			}
			resultSet.close();
			statement.close();
			connection.close();
		}
	}
}