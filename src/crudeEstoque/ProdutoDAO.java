/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudeEstoque;

/**
 *
 * @author kai
 */

//import Util.ConexaoDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author GrupoIntegrador
 */
public class ProdutoDAO {
    private Connection connection;

	public ProdutoDAO() {
		connection = Conexao.getConexao();
	}

	public void Inserir(Produto produto) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into produto(nome, codigo, qtd_estoque, und_med, valor_venda, valor_compra, qtd_estoque_min) values (?, ?, ?, ?, ?, ?, ? )");
			// Parameters start with 1
			
			
                        preparedStatement.setString(1, produto.getNome());
                        preparedStatement.setInt(2, produto.getCodigo());
                        preparedStatement.setInt(3, produto.getQtdEstoque());
                        preparedStatement.setString(4, produto.getUnidadeDmedida());
			preparedStatement.setInt(5, produto.getValorVenda());
                        preparedStatement.setInt(6, produto.getValorCompra());
                        preparedStatement.setInt(5, produto.getQtdEstoqueMin());
                        
                        
                        preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void Remover(int codigo) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from produto where codigo=?");
			// Parameters start with 1
			preparedStatement.setInt(1, codigo);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void Alterar(Produto produto) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update produto set nome=?, codigo=?, qtd_estoque=?, und_med=?, valor_venda=?, valor_compra=?, qtd_estoque_min=?"
							+ "where codigo=?");
			// Parameters start with 1
			preparedStatement.setString(1, produto.getNome());
                        preparedStatement.setInt(2, produto.getCodigo());
                        preparedStatement.setInt(3, produto.getQtdEstoque());
                        preparedStatement.setString(4, produto.getUnidadeDmedida());
			preparedStatement.setInt(5, produto.getValorVenda());
                        preparedStatement.setInt(6, produto.getValorCompra());
                        preparedStatement.setInt(5, produto.getQtdEstoqueMin());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Produto> ConsultarTodos() {
		List<Produto> produtos = new ArrayList<Produto>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from produto");
			while (rs.next()) {
				Produto produto = new Produto();
				produto.setNome(rs.getString("nome"));
                                produto.setCodigo(rs.getInt("codigo"));
                                produto.setQtdEstoque(rs.getInt("qtd_estoque"));
                                produto.setUnidadeDmedida(rs.getString("und_med"));
                                produto.setValorVenda(rs.getInt("valor_venda"));
                                produto.setValorCompra(rs.getInt("valor_compra"));
                                produto.setQtdEstoqueMin(rs.getInt("qtd_estoque_min"));
				produtos.add(produto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return produtos;
	}
	
	
	}
