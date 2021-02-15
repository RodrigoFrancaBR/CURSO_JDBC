import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaListagem {
	public static void main(String[] args) throws SQLException {
		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC", "root", "root");
		System.out.println("Fechando a conex�o");

		Statement stm = connection.createStatement();
		boolean result = stm.execute("SELECT * from PRODUTO");
		ResultSet resultSet = stm.getResultSet();
		System.out.println(result);
		int stmFild = 1;
		/* Enquanto existir registros pega a pr�xima linha. stmField inicia com 1 por�m ao final da instru��o incrementa +1 a vari�vel.*/
		while (resultSet.next()) {			
			int id = resultSet.getInt(stmFild++);
			System.out.println(id);
			String nome = resultSet.getString(stmFild++);
			System.out.println(nome);
			String descricao = resultSet.getString(stmFild++);
			System.out.println(descricao);
		}

		connection.close();
	}
}
