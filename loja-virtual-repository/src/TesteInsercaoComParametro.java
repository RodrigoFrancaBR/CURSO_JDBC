import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteInsercaoComParametro {
	public static void main(String[] args) throws SQLException {

		String sql = " INSERT INTO PRODUTO (nome, descricao) VALUES (?,?) ";
		ConnectionFactory cf = new ConnectionFactory();
		Connection connection = cf.recuperarConexao();
		connection.setAutoCommit(false);

		PreparedStatement stm = null;

		try {
			stm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			adicionarParametro("Mouse1", "Mouse sem fio1", stm);
			adicionarParametro("Mouse2", "Mouse sem fio2", stm);
			
			connection.commit();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ROLLBACK EXECUTADO");
			connection.rollback();
		} finally {
			stm.close();
			connection.close();
		}

	}

	private static void adicionarParametro(String nome, String descricao, PreparedStatement stm) throws SQLException {
		
		if (nome.equals("Mouse")){
			throw new RuntimeException("Mouse não pode ser inserido");
		}
		
		int stmFild = 1;
		stm.setString(stmFild++, nome);
		stm.setString(stmFild++, descricao);
		stm.execute();

		ResultSet resultSet = stm.getGeneratedKeys();

		while (resultSet.next()) {
			int id = resultSet.getInt(1);
			System.out.println(id);
		}
	}
}
