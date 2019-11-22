package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.vo.Cliente;

public class ClienteDAO implements Base<Cliente> {

	public Cliente salvar(Cliente novoCliente) {
		Connection conexao = Banco.getConnection();
		String sql = " INSERT INTO CLIENTE(NOME, SOBRENOME, ENDERECO,SEXO, CPF, TELEFONE, EMAIL) "
				+ " VALUES (?,?,?,?,?,?,?)";
		PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql, PreparedStatement.RETURN_GENERATED_KEYS);
		try {
			stmt.setString(1, novoCliente.getNome());
			stmt.setString(2, novoCliente.getSobrenome());
			stmt.setString(3, novoCliente.getEndereco());

			stmt.setString(4, novoCliente.getSexo());
			stmt.setString(5, novoCliente.getCpf());
			stmt.setString(6, novoCliente.getTelefone());
			stmt.setString(7, novoCliente.getEmail());

			stmt.execute();

			ResultSet rs = stmt.getGeneratedKeys();

			if (rs.next()) {
				int idClienteGerado = rs.getInt(1);

				novoCliente.setIdCliente(idClienteGerado);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao inserir novo endereço.");
			System.out.println("Erro: " + e.getMessage());
		}

		return novoCliente;

	}

	public boolean excluir(int id) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;

		String query = "DELETE FROM CLIENTE WHERE idcliente = " + id;
		try {
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de Exclusão do cliente.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return (resultado > 0);
	}

	public boolean alterar(Cliente entidade) {
		Connection conn = Banco.getConnection();

		int resultado = 0;
		String sql = " UPDATE CLIENTE SET NOME =?, SOBRENOME =?, ENDERECO =?,SEXO =?, CPF =?, TELEFONE=?, EMAIL=? WHERE IDCLIENTE =? ";
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql, PreparedStatement.NO_GENERATED_KEYS);
		try {
			stmt.setString(1, entidade.getNome());
			stmt.setString(2, entidade.getSobrenome());
			stmt.setString(3, entidade.getEndereco());

			stmt.setString(4, entidade.getSexo());
			stmt.setString(5, entidade.getCpf());
			stmt.setString(6, entidade.getTelefone());
			stmt.setString(7, entidade.getEmail());
			stmt.setInt(8, entidade.getIdCliente());

			stmt.execute();

		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de Atualização do Usuário.");
			System.out.println("Erro: " + e.getMessage());
		}
		return (resultado > 0);
	}

	public ArrayList<Cliente> consultarTodos() {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);

		ResultSet resultado = null;
		ArrayList<Cliente> clientesVO = new ArrayList<Cliente>();
		String query = "SELECT idcliente, nome, sobrenome, endereco, sexo, cpf, telefone, email, adimplente FROM cliente";
		try {
			resultado = stmt.executeQuery(query);

			while (resultado.next()) {
				Cliente clienteVO = new Cliente();
				clienteVO.setIdCliente(Integer.parseInt(resultado.getString(1)));
				clienteVO.setNome(resultado.getString(2));
				clienteVO.setSobrenome(resultado.getString(3));
				clienteVO.setEndereco(resultado.getString(4));
				clienteVO.setSexo(resultado.getString(5));
				clienteVO.setCpf(resultado.getString(6));
				clienteVO.setTelefone(resultado.getString(7));
				clienteVO.setEmail(resultado.getString(8));
				clienteVO.setAdimplente(resultado.getBoolean(9));

				clientesVO.add(clienteVO);
			}

		} catch (SQLException e) {
			System.out.println("Erro ao executar a Quer y de Consulta de Clientes.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return clientesVO;
	}

	public Cliente consultarClientePorID(int id) {

		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);

		ResultSet resultado = null;
		Cliente clienteVO = new Cliente();
		String query = "SELECT idcliente, nome, sobrenome, endereco, sexo, cpf, telefone, email, adimplente FROM cliente WHERE IDCLIENTE = "
				+ id;
		try {
			resultado = stmt.executeQuery(query);

			if (resultado.next()) {

				clienteVO.setIdCliente(Integer.parseInt(resultado.getString(1)));
				clienteVO.setNome(resultado.getString(2));
				clienteVO.setSobrenome(resultado.getString(3));
				clienteVO.setEndereco(resultado.getString(4));
				clienteVO.setSexo(resultado.getString(5));
				clienteVO.setCpf(resultado.getString(6));
				clienteVO.setTelefone(resultado.getString(7));
				clienteVO.setEmail(resultado.getString(8));
				clienteVO.setAdimplente(resultado.getBoolean(9));

			}

		} catch (SQLException e) {
			System.out.println("Erro ao executar a Quer y de Consulta de Clientes.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return clienteVO;
	}

	public Cliente consultarPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}