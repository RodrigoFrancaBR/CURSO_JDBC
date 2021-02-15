import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaRemocao {

	public static void main(String[] args) throws SQLException {		
		ConnectionFactory cf = new ConnectionFactory();
		Connection connection = cf.recuperarConexao();
		Statement stm = connection.createStatement();
		stm.execute("DELETE FROM PRODUTO WHERE ID > 1");
		int updateCount = stm.getUpdateCount();
		
		System.out.println("Linhas Removidas: " + updateCount);
		
	}

}
