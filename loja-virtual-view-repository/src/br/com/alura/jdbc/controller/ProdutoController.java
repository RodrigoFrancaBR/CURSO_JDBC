package br.com.alura.jdbc.controller;

import java.sql.Connection;
import java.util.List;

import br.com.alura.jdbc.dao.ProdutoDAO;
import br.com.alura.jdbc.factory.ConnectionFactory;
import br.com.alura.jdbc.modelo.Produto;

public class ProdutoController {

	private ProdutoDAO produtoDAO;

	public ProdutoController() {
		Connection connection = new ConnectionFactory().recuperarConexao();
		produtoDAO = new ProdutoDAO(connection);
	}

	public void deletar(Integer id) {
		System.out.println("Deletando produto");
		produtoDAO.deletar(id);
	}

	public void salvar(Produto produto) {
		System.out.println("Salvando produto");
		produtoDAO.salvar(produto);
	}

	public List<Produto> listar() {
		System.out.println("Listando produtos");
		return produtoDAO.listar();
	}

	public void alterar(String nome, String descricao, Integer id) {
		System.out.println("Alterando produto");
		produtoDAO.alterar(nome, descricao, id);

	}
}
