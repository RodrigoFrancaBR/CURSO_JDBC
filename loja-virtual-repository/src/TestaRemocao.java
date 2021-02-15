import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestaRemocao {

	public static void main(String[] args) throws SQLException {		
		String sql = "DELETE FROM PRODUTO WHERE ID > ?";
		ConnectionFactory cf = new ConnectionFactory();
		Connection connection = cf.recuperarConexao();
		PreparedStatement stm = connection.prepareStatement(sql);
		stm.setInt(1, 1);
		stm.execute();
		
		int updateCount = stm.getUpdateCount();
		
		System.out.println("Linhas Removidas: " + updateCount);
		
	}

}
