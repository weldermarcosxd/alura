package br.com.alura.datasource;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.hsqldb.jdbc.JDBCPool;

public class Connect {
	//main test
	private DataSource dataSource;
	
	public Connect(){
		JDBCPool jdbcPool = new JDBCPool();
		jdbcPool.setUrl("jdbc:hsqldb:hsql://localhost/loja-virtual");
		jdbcPool.setUser("SA");
		jdbcPool.setPassword("");
		this.dataSource = jdbcPool;
	}
	
	public Connection getConnection() throws SQLException {
		Connection connection = dataSource.getConnection();
		System.out.println("Connections successfully open");
		return connection;
	}
}