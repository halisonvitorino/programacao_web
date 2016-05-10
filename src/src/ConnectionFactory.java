package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static Connection connection = null;

	public static Connection getConnection() throws SQLException {
		if (connection == null) {
			try {
				/* Obt�m o driver de conex�o com o banco de dados */
				Class.forName("com.mysql.jdbc.Driver");
				
				/* Configura os par�metros da conex�o */
				String sql = "jdbc:mysql://127.0.0.1:3306/rally";
				
				/* Tenta se conectar */
				connection = DriverManager.getConnection(sql, "java", "java");
			} catch (ClassNotFoundException e) {
				throw new SQLException("CF: Driver n�o localizado!");
			}
		}
		
		/* Caso a conex�o ocorra com sucesso, a conex�o � retornada */
		return connection;
	}

	public void finalize() {
		try {
			/* Tenta finalizar conex�o com banco */
			connection.close();
		} catch (SQLException e) {
			System.out.println("CF: Erro ao encerrar conex�o com banco!");
		}
	}
}