package br.com.alura.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.jdbc.modelo.Categoria;

public class CategoriaDAO {
	private Connection connection;
		
	public CategoriaDAO(Connection connection) {
		this.connection = connection;
	}

	public List<Categoria> listar() throws SQLException {
		final String SELECT = "SELECT ID, NOME FROM CATEGORIA";
		List<Categoria> listaDeCategorias = new ArrayList<Categoria>();
		int stmFild = 0;
		try (PreparedStatement pstm = connection.prepareStatement(SELECT)) {
			pstm.execute();
			try (ResultSet resultSet = pstm.getResultSet()) {
				while (resultSet.next()) {
					stmFild = 1;
					long id = resultSet.getLong(stmFild++);
					String nome = resultSet.getString(stmFild++);
					listaDeCategorias.add(new Categoria(id, nome));

				}
			} catch (Exception e) {
				
			}

		} catch (Exception e) {
		
		}
		return listaDeCategorias;

	}
}
