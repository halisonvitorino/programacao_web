package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static Connection connection = null;

	public static Connection getConnection() throws SQLException {
		if (connection == null) {
			try {
				/* Obtém o driver de conexão com o banco de dados */
				Class.forName("com.mysql.jdbc.Driver");
				
				/* Configura os parâmetros da conexão */
				String sql = "jdbc:mysql://127.0.0.1:3306/rally";
				
				/* Tenta se conectar */
				connection = DriverManager.getConnection(sql, "java", "java");
			} catch (ClassNotFoundException e) {
				throw new SQLException("CF: Driver não localizado!");
			}
		}
		
		/* Caso a conexão ocorra com sucesso, a conexão é retornada */
		return connection;
	}

	public void finalize() {
		try {
			/* Tenta finalizar conexão com banco */
			connection.close();
		} catch (SQLException e) {
			System.out.println("CF: Erro ao encerrar conexão com banco!");
		}
	}
}