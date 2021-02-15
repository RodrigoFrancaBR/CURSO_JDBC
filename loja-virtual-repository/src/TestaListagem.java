import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaListagem {
	public static void main(String[] args) throws SQLException {
		/*
		 * Connection connection = DriverManager.getConnection(
		 * "jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC",
		 * "root", "root"); System.out.println("Fechando a conex�o");
		 */
		ConnectionFactory criaConexao = new ConnectionFactory();
		Connection connection = criaConexao.recuperarConexao();

		Statement stm = connection.createStatement();

		// result true se a execu��o do statemento retornar uma lista
		boolean result = stm.execute("SELECT * from PRODUTO");

		ResultSet resultSet = stm.getResultSet();
		System.out.println(result);
		int stmFild =0;

		/*
		 * Enquanto existir registros pega a pr�xima linha. stmField inicia com
		 * 1 por�m ao final da instru��o incrementa +1 a vari�vel.
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
