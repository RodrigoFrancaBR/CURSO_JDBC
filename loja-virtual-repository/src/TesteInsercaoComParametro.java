import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteInsercaoComParametro {
	public static void main(String[] args) throws SQLException {
		int stmFild = 1;
		String nome = "Mouse";
		String descricao = "Mouse sem fio";
		String sql = " INSERT INTO PRODUTO (nome, descricao) VALUES (?,?) ";

		ConnectionFactory cf = new ConnectionFactory();
		Connection connection = cf.recuperarConexao();
		PreparedStatement stm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		stm.setString(stmFild++, nome);
		stm.setString(stmFild++, descricao);

		System.out.println(sql);
		stm.execute();
		
		ResultSet resultSet = stm.getGeneratedKeys();

		while (resultSet.next()) {
			int id = resultSet.getInt(1);
			System.out.println(id);
		}
	}
}
