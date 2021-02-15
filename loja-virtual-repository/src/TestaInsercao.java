import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao {
	public static void main(String[] args) throws SQLException {
		int stmFild =1;
		ConnectionFactory cf = new ConnectionFactory();
		Connection connection = cf.recuperarConexao();
		Statement statement = connection.createStatement();
		
		
		statement.execute("INSERT INTO PRODUTO (nome, descricao) VALUES ('Mouse', 'Mouse sem fio')",
				Statement.RETURN_GENERATED_KEYS);
		
		ResultSet resultSet = statement.getGeneratedKeys();
		
		while (resultSet.next()) {			
			int id = resultSet.getInt(stmFild++);
			System.out.println(id);			
		}
	}

}
