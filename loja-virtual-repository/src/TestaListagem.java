import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaListagem {
	public static void main(String[] args) throws SQLException {
		/*
		 * Connection connection = DriverManager.getConnection(
		 * "jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC",
		 * "root", "root"); System.out.println("Fechando a conexão");
		 */
		ConnectionFactory criaConexao = new ConnectionFactory();
		Connection connection = criaConexao.recuperarConexao();

		Statement stm = connection.createStatement();

		// result true se a execução do statemento retornar uma lista
		boolean result = stm.execute("SELECT * from PRODUTO");

		ResultSet resultSet = stm.getResultSet();
		System.out.println(result);
		int stmFild =0;

		/*
		 * Enquanto existir registros pega a próxima linha. stmField inicia com
		 * 1 porém ao final da instrução incrementa +1 a variável.
		 */
		while (resultSet.next()) {
			stmFild =1;
			int id = resultSet.getInt(stmFild++);
			String nome = resultSet.getString(stmFild++);
			String descricao = resultSet.getString(stmFild++);
			System.out.println(id);
			System.out.println(nome);
			System.out.println(descricao);
		}

		

		connection.close();
	}
}
