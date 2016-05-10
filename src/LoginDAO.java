package ucb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoginDAO {
	private Connection con;

	public LoginDAO() throws SQLException {
		this.con = ConnectionFactory.getConnection();
	}

	// Pesquisar usuario
	public Usuario validaLogin(String usuario) {
		String sql = "SELECT * FROM rally_usuarios WHERE usuario='" + usuario + "';";

		try {
			List<Usuario> usuarios = new ArrayList<Usuario>();
			PreparedStatement stmt = this.con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Usuario usu = new Usuario();
				usu.setId(rs.getLong("id"));
				usu.setUsuario(rs.getString("usuario"));
				usu.setSenha(rs.getString("senha"));
				usu.setPerfil(rs.getString("perfil"));

				usuarios.add(usu);

				return usu;
			}
			rs.close();
			stmt.close();

		} catch (SQLException e) {
			System.out.println("Usuário \"" + usuario + "\" não encontrado!");
			throw new RuntimeException(e);
		}

		return null;
	}

}
