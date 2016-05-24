package metodosSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.annotation.Resource.AuthenticationType;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionFactory {

	/*
	 * Conexão direta com o Banco de Dados MySql
	 */
	public Connection getConnection() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (InstantiationException e) {
			throw new SQLException(e);
		} catch (IllegalAccessException e) {
			throw new SQLException(e);
		} catch (ClassNotFoundException e) {
			throw new SQLException(e);
		}
		return DriverManager.getConnection("jdbc:mysql://localhost/rally","root","java");

	}

	/*
	 * Conexão com o Banco de Dados MySql via Pool implementado pelo Tomcat.
	 */
	@Resource(name = "jdbc/PoolMydb", type = javax.sql.DataSource.class,  
			authenticationType = AuthenticationType.CONTAINER)
	private DataSource dataSource;
	public Connection getConnectionPool() throws SQLException {
		try {
			dataSource = (DataSource) new InitialContext().lookup("java:/comp/env/jdbc/PoolMydb");
			return dataSource.getConnection();
		} catch (NamingException e) {
			throw new SQLException(e);
		}
	}
}