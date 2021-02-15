import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteInsercaoComParametro {
	public static void main(String[] args) throws SQLException {

		String sql = " INSERT INTO PRODUTO (nome, descricao) VALUES (?,?) ";
		ConnectionFactory cf = new ConnectionFactory();

		try (Connection connection = cf.recuperarConexao()) {
			connection.setAutoCommit(false);

// toda classe que herda de AutoCloseable pode se fazer uso do try with resource, para não precisar explicitar o fechamento da conexao;
			try (PreparedStatement stm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

				adicionarParametro("Mouse1", "Mouse sem fio1", stm);
				adicionarParametro("Mouse2", "Mouse sem fio2", stm);

				connection.commit();

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("ROLLBACK EXECUTADO");
				connection.rollback();
			}
		}
	}

	private static void adicionarParametro(String nome, String descricao, PreparedStatement stm) throws SQLException {

		if (nome.equals("Mouse")) {
			throw new RuntimeException("Mouse não pode ser inserido");
		}

		int stmFild = 1;
		stm.setString(stmFild++, nome);
		stm.setString(stmFild++, descricao);
		stm.execute();

		try (ResultSet resultSet = stm.getGeneratedKeys();) {
			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				System.out.println(id);
			}

		}

	}
}
