package br.com.alura.jdbc;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaListagem {
	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory criaConexao = new ConnectionFactory();
		Connection connection = criaConexao.recuperarConexao();

		Statement stm = connection.createStatement();

		// result recebe true se a execu��o do statemento retornar um ResultSet
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
			Long id = resultSet.getLong(stmFild++);
			String nome = resultSet.getString(stmFild++);
			String descricao = resultSet.getString(stmFild++);
			System.out.println(id);
			System.out.println(nome);
			System.out.println(descricao);
		}		

		connection.close();
	}
}
