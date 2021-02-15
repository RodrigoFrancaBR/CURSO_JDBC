package br.com.alura.jdbc;
import java.sql.SQLException;

public class TestaPoolDeConexao {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory cf = new ConnectionFactory();
		
		for (int i = 0; i < 20; i++) {
			cf.recuperarConexao();
			System.out.println("Conexao de número: " +i );
		}
				
	}

}
