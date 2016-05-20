package metodosSQL;



import java.sql.Connection;
import java.sql.SQLException;

import metodosSQL.ConnectionFactory;

public class UsuarioDAO {
	private Connection connection;

	public UsuarioDAO() throws SQLException {
		super();
		this.connection = new ConnectionFactory().getConnectionPool();
	}
	@Override
	public void finalize() throws SQLException {
		connection.close();
	}

	public Usuario consultar(Usuario usu) throws RuntimeException, SQLException {
		String sql = "select nome, senha from usuario where nome=?";
		java.sql.PreparedStatement stmt = connection.prepareStatement(sql);
		Usuario usuario = new Usuario();
		try {
			stmt.setString(1, usu.getChaveUsuario());
			java.sql.ResultSet rs = stmt.executeQuery();
			rs.next();
			usuario.setChaveUsuario(new String(rs.getString("nome")));
			usuario.setSenhaUsuario(new String(rs.getString("senha")));
			rs.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			stmt.close();
		}
		return usuario;
	}
}
