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
		public Usuario cadastraUser(String usuario, String senha, String email, String datanasci, String telefone){
			String sql = "INSERT INTO USUARIO (NOME, SENHA, EMAIL, TELEFONE, data_nascimento)  VALUES('" + usuario + "', '"+ senha +"', '"+ email +"', '"+ telefone +"', '"+ datanasci +"');";

			try {
				List<Usuario> usuarios = new ArrayList<Usuario>();
				PreparedStatement stmt = this.con.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();

				while (rs.next()) {
					Usuario usu = new Usuario();
					
					usu.setNome(rs.getString("nome"));
					usu.setSenha(rs.getString("senha"));
					usu.setSenha(rs.getString("email"));
					usu.setSenha(rs.getString("telefone"));
					usu.setSenha(rs.getString("data_nascimento"));
					usuarios.add(usu);

					return usu;
				}
				rs.close();
				stmt.close();

			} catch (SQLException e) {
				System.out.println("Usuário \"" + usuario + "\" não Cadastrado!");
				throw new RuntimeException(e);
			}

			return null;
		}	
		
}
