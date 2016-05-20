package metodosSQL;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CarrosDAO {
	private Connection connection;

	public CarrosDAO() throws SQLException {
		super();
		this.connection = new ConnectionFactory().getConnectionPool();
//		Properties properties = new Properties();
//		properties.put("user", "root");
//		properties.put("password", "root");
//		this.connection.setClientInfo(properties);
	}
	@Override
	public void finalize() throws SQLException {
//		Properties properties = new Properties();
//		properties.put("user", "");
//		properties.put("password", "");
//		this.connection.setClientInfo(properties);
		connection.close();
	}

	public void incluir(Carros car) throws RuntimeException, SQLException {
		String sql = "insert into Carros (idCarros , nomeCarros , placaCarros) values (?,?,?)";
		java.sql.PreparedStatement stmt = connection.prepareStatement(sql);
		try {
			stmt.setInt(1, (int) car.getIdCarros());
			stmt.setString(2, car.getNomeCarros());
			stmt.setString(3, car.getPlacaCarros());
			stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			stmt.close();
		}
	}

	public void alterar(Carros car) throws RuntimeException, SQLException {
		String sql = "update Carros set nomeCarros=? , placaCarros=? where idCarros=?";
		java.sql.PreparedStatement stmt = connection.prepareStatement(sql);
		try {
			stmt.setString(1, car.getNomeCarros());
			stmt.setString(2, car.getPlacaCarros());
			stmt.setInt(3, (int) car.getIdCarros());
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			stmt.close();
		}
	}

	public void excluir(Carros car) throws RuntimeException, SQLException {
		java.sql.PreparedStatement stmt = connection
				.prepareStatement("delete from Carros where idCarros = ?");
		try {
			stmt.setInt(1, (int) car.getIdCarros());
			stmt.execute();
//			System.out.println(stmt.getUpdateCount() + " registros deletados.");
//			SQLWarning warning = stmt.getWarnings();
//			while (warning != null) {
//				String message = warning.getMessage();
//				System.out.println(message);
//				String sqlState = warning.getSQLState();
//				System.out.println(sqlState);
//				int errorCode = warning.getErrorCode();
//				System.out.println(errorCode);
//				warning = warning.getNextWarning();
//			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			stmt.close();
		}
	}

	public void consultar(Carros car) throws RuntimeException, SQLException {
		String sql = "select idCarros, nomeCarros, placaCarros from Carros where idCarros=?";
		java.sql.PreparedStatement stmt = connection.prepareStatement(sql);
		try {
			stmt.setInt(1, (int) car.getIdCarros());
			java.sql.ResultSet rs = stmt.executeQuery();
			rs.next();
			car.setIdCarros((Integer) rs.getInt("idCarros"));
			car.setNomeCarros(rs.getString("nomeCarros"));
			car.setPlacaCarros(rs.getString("placaCarros"));
			rs.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			stmt.close();
		}
	}

	public void listar(List<Carros> lista) throws RuntimeException, SQLException {
		String sql = "select idCarros, nomeCarros, placaCarros from Carros";
		java.sql.PreparedStatement stmt = connection.prepareStatement(sql);
		try {
			java.sql.ResultSet rs = stmt.executeQuery();
			Carros mun;
			while (rs.next()) {
				mun = new Carros();
				mun.setIdCarros((Integer) rs.getInt("idCarros"));
				mun.setNomeCarros(rs.getString("nomeCarros"));
				mun.setPlacaCarros(rs.getString("placaCarros"));
				lista.add(mun);
			}
			rs.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			stmt.close();
		}
	}
}