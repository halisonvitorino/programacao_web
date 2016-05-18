package autentica;

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
		String sql = "SELECT * FROM usuario WHERE nome='" + usuario + "';";

		try {
			List<Usuario> usuarios = new ArrayList<Usuario>();
			PreparedStatement stmt = this.con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Usuario usu = new Usuario();
				
				usu.setNome(rs.getString("nome"));
				usu.setSenha(rs.getString("senha"));
				
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
	
	//Cadastro usuario
		public Usuario cadastraUser(String nome, String senha, String email, String datanasci, String telefone) throws RuntimeException, SQLException {
			Usuario usu;
			String sqli = "INSERT INTO USUARIO (NOME, SENHA, EMAIL, TELEFONE, data_nascimento) VALUES (?,?,?,?,?)";
			PreparedStatement stmt = this.con.prepareStatement(sqli);
			try {
				stmt.setString(1, nome);
				stmt.setString(2, senha);
				stmt.setString(3, email);
				stmt.setString(4, telefone);
				stmt.setString(5, datanasci);
				ResultSet rs = stmt.executeQuery();
			}catch (SQLException e){
				throw new RuntimeException(e);
			} finally {
				stmt.close();
			}
			return null;
		}
		
}
