package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import model.dto.RelatorioPet;
import model.vo.Pet;

public class PetDAO {

	DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	public Pet salvar(Pet novoPet) {
		Connection conexao = Banco.getConnection();
		String sql = " INSERT INTO PET(NOME, PESO, PORTE, RACA, SEXO, ESPECIE, DTNASCIMENTO, IDCLIENTE) "
				+ " VALUES (?,?,?,?,?,?,?,?)";
		PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql, PreparedStatement.RETURN_GENERATED_KEYS);
		try {
			stmt.setString(1, novoPet.getNome());
			stmt.setDouble(2, novoPet.getPeso());
			stmt.setString(3, novoPet.getPorte());
			stmt.setString(4, novoPet.getRaca());
			stmt.setString(5, novoPet.getSexo());
			stmt.setString(6, novoPet.getEspecie());
			System.out.println(novoPet.getDtNascimento() + "impressao PetDao");
			stmt.setString(7, (novoPet.getDtNascimento().toString()));
			stmt.setInt(8, novoPet.getCliente().getIdCliente());

			stmt.execute();

			ResultSet rs = stmt.getGeneratedKeys();

			if (rs.next()) {
				int idPetGerado = rs.getInt(1);

				novoPet.setIdPet(idPetGerado);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao inserir novo Pet.");
			System.out.println("Erro: " + e.getMessage());
		}

		return novoPet;
	}

	public ArrayList<Pet> consultarTodosPet() {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<Pet> petsVO = new ArrayList<Pet>();

		String query = "SELECT idPet, nome, porte, peso, raca, dtnascimento, sexo, especie FROM Pet";
		try {

			resultado = stmt.executeQuery(query);
			while (resultado.next()) {
				Pet petVO = new Pet();

				petVO.setIdPet(Integer.parseInt(resultado.getString(1)));
				petVO.setNome(resultado.getString(2));
				petVO.setPorte(resultado.getString(3));
				petVO.setPeso(resultado.getDouble(4));
				petVO.setRaca(resultado.getString(5));
				petVO.setDtNascimento(LocalDate.parse(resultado.getString(6), dataFormatter));
				petVO.setSexo(resultado.getString(7));
				petVO.setEspecie(resultado.getString(8));

				petsVO.add(petVO);

			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de Consulta de Pets.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return petsVO;
	}

	public ArrayList<RelatorioPet> consultarRelatorioPet() {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<RelatorioPet> relatorio = new ArrayList<RelatorioPet>();

		String query = "SELECT c.idcliente, c.nome, c.sobrenome, c.endereco, c.sexo, c.telefone, c.email, "
				+ " count(p.idpet) as QTD_ANIMAIS from cliente as c inner join pet as p on p.idcliente = c.idcliente;";
		try {

			resultado = stmt.executeQuery(query);
			while (resultado.next()) {
				RelatorioPet relatorioPet = new RelatorioPet();

				relatorioPet.setIdPet(Integer.parseInt(resultado.getString(1)));
				relatorioPet.setNome(resultado.getString(2));
				relatorioPet.setPorte(resultado.getString(3));
				relatorioPet.setPeso(resultado.getDouble(4));
				relatorioPet.setRaca(resultado.getString(5));
				relatorioPet.setEspecie(resultado.getString(6));
				relatorioPet.setDtNascimento(LocalDate.parse(resultado.getString(7), dataFormatter));
				relatorioPet.setSexo(resultado.getString(8));
				relatorioPet.setCliente(resultado.getString(9));
				relatorioPet.setContagemProcedimentos(resultado.getInt(10));
				relatorioPet.setValorTotalProcedimentos(resultado.getDouble(11));

				relatorio.add(relatorioPet);

			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de Consulta de Pets.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return relatorio;
	}

	public Pet consultarPetPorID(int id) {

		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);

		ResultSet resultado = null;
		Pet petVO = new Pet();
		String query = "SELECT idPet, nome, dtnascimento, peso, porte, especie, raca, sexo FROM pet WHERE IDCLIENTE = "
				+ id;
		try {
			resultado = stmt.executeQuery(query);

			if (resultado.next()) {

				petVO.setIdPet(Integer.parseInt(resultado.getString(1)));
				petVO.setNome(resultado.getString(2));
				petVO.setDtNascimento(LocalDate.parse(resultado.getString(3), dataFormatter));
				petVO.setPeso(resultado.getDouble(4));
				petVO.setPorte(resultado.getString(5));
				petVO.setEspecie(resultado.getString(6));
				petVO.setRaca(resultado.getString(7));
				petVO.setSexo(resultado.getString(8));

			}

		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de Atualização de Pets.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return petVO;
	}

	public boolean excluir(int idPet) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;

		String query = "DELETE FROM PET WHERE idpet = " + idPet;
		try {
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de ExclusÃ£o do Pet.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return (resultado > 0);
	}

	public boolean alterar(Pet entidade) {
		Connection conexao = Banco.getConnection();
		int resultado = 0;
		String sql = " UPDATE PET SET NOME =?, PESO =?, PORTE =?, RACA =?, SEXO =?, ESPECIE =?, DTNASCIMENTO =?, IDCLIENTE =? ";

		PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql, PreparedStatement.RETURN_GENERATED_KEYS);
		try {
			stmt.setString(1, entidade.getNome());
			stmt.setDouble(2, entidade.getPeso());
			stmt.setString(3, entidade.getPorte());
			stmt.setString(4, entidade.getRaca());
			stmt.setString(5, entidade.getSexo());
			stmt.setString(6, entidade.getEspecie());
			System.out.println(entidade.getDtNascimento() + "impressao PetDao");
			stmt.setString(7, (entidade.getDtNascimento().toString()));
			stmt.setInt(8, entidade.getCliente().getIdCliente());

			stmt.execute();

		} catch (SQLException e) {
			System.out.println("Erro ao inserir novo Pet.");
			System.out.println("Erro: " + e.getMessage());
		}

		return (resultado > 0);

	}
}
