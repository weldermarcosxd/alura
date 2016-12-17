package br.com.alura.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDelete {
	//main test
	public static void main(String[] args) throws SQLException {
		
		TestConnection testConnection = new TestConnection();
		
		Connection connection = testConnection.getConnection();

		Statement statement = connection.createStatement();
		boolean result = statement.execute("delete from produto where id > 3");
		if(!result) {
			System.out.println("Query successful");
		}
		
		int updateCount = statement.getUpdateCount();
		System.out.println(updateCount + " linhas removidas");

		statement.close();
		connection.close();
	}
}
