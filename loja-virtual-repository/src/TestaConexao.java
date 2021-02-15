import java.sql.Connection;
import java.sql.SQLException;

public class TestaConexao {
	public static void main(String[] args) throws SQLException {
		/*
		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC", "root", "root");
		System.out.println("Fechando a conex�o");
		connection.close();
		*/
		
		ConnectionFactory criaConexao = new ConnectionFactory();
		Connection connection = criaConexao.recuperarConexao();
		System.out.println("Fechando a conex�o");
		connection.close();	
	}
}
