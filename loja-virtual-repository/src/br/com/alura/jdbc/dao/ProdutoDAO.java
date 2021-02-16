package br.com.alura.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.jdbc.modelo.Produto;

public class ProdutoDAO {
	private Connection connection;
	private final String SELECT = "SELECT ID, NOME, DESCRICAO FROM PRODUTO";
	private final String INSERT = "INSERT INTO PRODUTO (NOME, DESCRICAO) VALUES(?,?)";

	public ProdutoDAO(Connection connection) {
		this.connection = connection;
	}

	public void salvar(Produto produto) throws SQLException {

		try (PreparedStatement pstm = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)) {
			pstm.setString(1, produto.getNome());
			pstm.setString(2, produto.getDescricao());
			pstm.execute();
			try (ResultSet rs = pstm.getGeneratedKeys()) {
				while (rs.next()) {
					produto.setId(rs.getLong(1));
				}
			}

		}
	}

	public List<Produto> listar() throws SQLException {
		Produto p;
		List<Produto> listaDeProdutos = new ArrayList<>();
		try (PreparedStatement pstm = connection.prepareStatement(SELECT, Statement.RETURN_GENERATED_KEYS)) {
			pstm.execute();
			try (ResultSet rs = pstm.getResultSet()) {
				while (rs.next()) {
					p = new Produto(rs.getInt(1), rs.getString(2), rs.getString(3));
					listaDeProdutos.add(p);
				}
			}
		}
		return listaDeProdutos;
	}

}
