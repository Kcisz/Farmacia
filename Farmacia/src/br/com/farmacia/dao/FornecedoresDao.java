package br.com.farmacia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.farmacia.domain.Fornecedores;
import br.com.farmacia.factory.ConexaoFactory;

public class FornecedoresDao {

	public void Salvar(Fornecedores f) throws SQLException {
		// Utilizei o StringBuilder, para não ter a necessidade de sempre ter
		// que concatenar minhas queries.
		StringBuilder sql = new StringBuilder();

		// append() = Entende que tudo que for inserido no parenteses esta sendo
		// comcatenado, sem deixa espaço
		sql.append("INSERT INTO fornecedores ");
		sql.append("(descricao)");
		sql.append("VALUES (?)");
		Connection connection = ConexaoFactory.conectar();
		// toString converte a variavel SQL para string

		PreparedStatement statement = connection.prepareStatement(sql.toString());
		statement.setString(1, f.getDescricao());

		statement.executeUpdate();

	}

	public void excluir(Fornecedores f) throws SQLException {
		// Utilizei o StringBuilder, para não ter a necessidade de sempre ter
		// que concatenar minhas queries.
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM fornecedores ");
		sql.append("WHERE idfornecedores = ?");

		Connection connection = ConexaoFactory.conectar();
		// toString converte a variavel SQL para string

		PreparedStatement statement = connection.prepareStatement(sql.toString());
		statement.setLong(1, f.getIdfornecedores());

		statement.executeUpdate();

	}

	public void editar(Fornecedores f) throws SQLException {
		// Utilizei o StringBuilder, para não ter a necessidade de sempre ter
		// que concatenar minhas queries.
		StringBuilder sql = new StringBuilder();

		// append() = Entende que tudo que for inserido no parenteses esta sendo
		// comcatenado, sem deixa espaço
		sql.append("UPDATE fornecedores ");
		sql.append("SET descricao = ? ");
		sql.append("WHERE idfornecedores = ?");
		Connection connection = ConexaoFactory.conectar();
		// toString converte a variavel SQL para string

		PreparedStatement statement = connection.prepareStatement(sql.toString());
		statement.setString(1, f.getDescricao());
		statement.setLong(2, f.getIdfornecedores());

		statement.executeUpdate();

	}

	public Fornecedores buscarPorId(Fornecedores f) throws SQLException {

		// Utilizei o StringBuilder, para não ter a necessidade de sempre ter
		// que concatenar minhas queries.
		StringBuilder sql = new StringBuilder();

		// append() = Entende que tudo que for inserido no parenteses esta sendo
		// comcatenado, sem deixa espaço
		sql.append("SELECT idfornecedores, descricao ");
		sql.append("FROM fornecedores ");
		sql.append("WHERE idfornecedores = ?");
		Connection connection = ConexaoFactory.conectar();
		// toString converte a variavel SQL para string

		PreparedStatement statement = connection.prepareStatement(sql.toString());
		statement.setLong(1, f.getIdfornecedores());

		ResultSet resultado = statement.executeQuery();

		// Fára a buscar e armazenara no meu retorno
		Fornecedores retorno = null;

		if (resultado.next()) {
			retorno = new Fornecedores();
			retorno.setIdfornecedores(resultado.getLong("idfornecedores"));
			retorno.setDescricao(resultado.getString("descricao"));
		}

		return retorno;

	}

	//busca somente descricao
	public ArrayList<Fornecedores> buscarPorDescricao( Fornecedores fornecedores) throws SQLException {
		// Utilizei o StringBuilder, para não ter a necessidade de sempre ter
		// que concatenar minhas queries.
		StringBuilder sql = new StringBuilder();
		
		// append() = Entende que tudo que for inserido no parenteses esta sendo
		// comcatenado, sem deixa espaço
		sql.append("SELECT idfornecedores, descricao, email ");
		sql.append("FROM fornecedores ");
		sql.append("WHERE descricao LIKE  ? ");//DESC OU ASC
		sql.append("ORDER BY descricao ASC");//DESC OU ASC
		Connection connection = ConexaoFactory.conectar();
		
		PreparedStatement statement = connection.prepareStatement(sql.toString());
		
		statement.setString(1,"%" + fornecedores.getDescricao() +"%");
		
		
		ResultSet resultado = statement.executeQuery();
		// Fára a buscar e armazenara no meu retorno
		

		ArrayList<Fornecedores> lista = new ArrayList<Fornecedores>();

		while (resultado.next()) {
			Fornecedores item = new Fornecedores();

			item.setIdfornecedores(resultado.getLong("idfornecedores"));
			item.setDescricao(resultado.getString("descricao"));
			item.setEmail(resultado.getString("email"));

			lista.add(item);
		}
		return lista;
		
		
		
		
	}
	
	
	
	//busca todos elementos
	public ArrayList<Fornecedores> listar() throws SQLException {
		// Utilizei o StringBuilder, para não ter a necessidade de sempre ter
		// que concatenar minhas queries.
		StringBuilder sql = new StringBuilder();

		// append() = Entende que tudo que for inserido no parenteses esta sendo
		// comcatenado, sem deixa espaço
		sql.append("SELECT idfornecedores, descricao, telefone, email ");
		sql.append("FROM fornecedores ");
		sql.append("ORDER BY descricao ASC");//DESC OU ASC
		Connection connection = ConexaoFactory.conectar();
		// toString converte a variavel SQL para string

		PreparedStatement statement = connection.prepareStatement(sql.toString());
		ResultSet resultado = statement.executeQuery();
		// Fára a buscar e armazenara no meu retorno
		Fornecedores retorno = null;

		ArrayList<Fornecedores> lista = new ArrayList<Fornecedores>();

		while (resultado.next()) {
			Fornecedores fornecedores = new Fornecedores();

			fornecedores.setIdfornecedores(resultado.getLong("idfornecedores"));
			fornecedores.setDescricao(resultado.getString("descricao"));
			fornecedores.setEmail(resultado.getString("email"));
			fornecedores.setTelefone(resultado.getString("telefone"));
			lista.add(fornecedores);
		}
		return lista;

	}

	
//	public static void main(String[] args) {
//		Fornecedores fornecedores = new Fornecedores();
//				
//				fornecedores.setDescricao("1");
//				FornecedoresDao dao = new FornecedoresDao();
//				
//				try {
//					ArrayList<Fornecedores> lista = dao.buscarPorDescricao(fornecedores);
//		
//					for (Fornecedores fornecedores2 : lista) {
//						System.out.println("Resultado" + fornecedores2);
//					}
//		
//				} catch (SQLException e) {
//		
//					e.printStackTrace();
//				}
//				System.out.println();
//		
//			}
	
	public static void main(String[] args) {

		FornecedoresDao dao = new FornecedoresDao();

		try {
			ArrayList<Fornecedores> lista = dao.listar();

			for (Fornecedores fornecedores : lista) {
				System.out.println("Resultado" + fornecedores);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		System.out.println();

	}

	// public static void main(String[] args) {
	//
	// Fornecedores f = new Fornecedores();
	//
	// f.setIdfornecedores(5);
	// try {
	// FornecedoresDao dao = new FornecedoresDao();
	//
	// Fornecedores f1 = dao.buscarPorId(f);
	// // foi configurado o toString na classe objeto
	// System.out.println("Resultado: " + f1);
	// } catch (SQLException e) {
	// System.out.println("Erro para buscar");
	// e.printStackTrace();
	// }
	// System.out.println();
	//
	// }

	// public static void main(String[] args) {
	// try {
	// Fornecedores f1 = new Fornecedores();
	// f1.setIdfornecedores(2);
	// f1.setDescricao("Descricao 1");
	//
	// FornecedoresDao dao = new FornecedoresDao();
	//
	// dao.editar(f1);
	// System.out.println("Alterado com sucesso");
	// } catch (SQLException e) {
	// System.out.println("Erro ao remover!");
	// e.printStackTrace();
	// }
	//
	// }// fim main

	// public static void main(String[] args) throws SQLException {
	// Fornecedores f1 = new Fornecedores();
	// f1.setIdfornecedores(1);
	// FornecedoresDao dao = new FornecedoresDao();
	// dao.excluir(f1);
	// System.out.println("Removido com sucesso");
	// }// fim main

	// public static void main(String[] args) {
	// Fornecedores f1 = new Fornecedores();
	// f1.setDescricao("Descricao 1");
	// Fornecedores f2 = new Fornecedores();
	// f2.setDescricao("Descricao 2");
	// FornecedoresDao dao = new FornecedoresDao();
	// try {
	// dao.Salvar(f1);
	// dao.Salvar(f2);
	// System.out.println("Salvo com sucesso");
	// } catch (SQLException e) {
	// System.out.println("Erro ao salvar");
	// e.printStackTrace();
	// }
	//
	//
	// }//fim main
}
