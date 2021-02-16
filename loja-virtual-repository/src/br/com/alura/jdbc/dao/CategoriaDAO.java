package br.com.alura.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.jdbc.modelo.Categoria;
import br.com.alura.jdbc.modelo.Produto;

public class CategoriaDAO {
	private Connection connection;

	public CategoriaDAO(Connection connection) {
		this.connection = connection;
	}
	
	public List<Categoria> listar() throws SQLException {
		List<Categoria> categorias = new ArrayList<>();

		System.out.println("Executando a query de listar categoria");

		String sql = "SELECT ID, NOME FROM CATEGORIA";

		try(PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.execute();

			try(ResultSet rst = pstm.getResultSet()) {
				while(rst.next()) {
					Categoria categoria = 
							new Categoria(rst.getLong(1), rst.getString(2));

					categorias.add(categoria);
				}
			}
		}
		return categorias;
	}

	public List<Categoria> listarComProdutos() throws SQLException {
		System.out.println("Executando a query de listar categoria");

		Categoria ultimaCategoria = null;

		List<Categoria> listaDeCategorias = new ArrayList<Categoria>();

		final String SELECT = "select c.id, c.nome, p.id, p.nome, p.descricao from categoria c inner join produto p on c.id = p.categoria_id";

		try (PreparedStatement pstm = connection.prepareStatement(SELECT)) {

			pstm.execute();

			try (ResultSet resultSet = pstm.getResultSet()) {

				while (resultSet.next()) {

					if (ultimaCategoria == null || !ultimaCategoria.getNome().equals(resultSet.getString(2))) {
						Categoria categoria = new Categoria(resultSet.getLong(1), resultSet.getString(2));
						listaDeCategorias.add(categoria);
						ultimaCategoria = categoria;
					}

					Produto produto = new Produto(resultSet.getLong(3), resultSet.getString(4), resultSet.getString(5));
					ultimaCategoria.adicionar(produto);
				}

			}
			return listaDeCategorias;
		}
	}
}
