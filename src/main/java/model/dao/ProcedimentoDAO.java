package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import model.vo.Cliente;
import model.vo.Pet;
import model.vo.Procedimento;
import model.vo.Tipo;
import model.vo.Veterinario;

public class ProcedimentoDAO {
	DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	public Procedimento salvar(Procedimento novoProcedimento) {
		Connection conexao = Banco.getConnection();
		String sql = " INSERT INTO PROCEDIMENTO(idpet, idveterinario, titulo, dtentrada, dtSaida, valor,"
				+ "  formapagamento, situacaopagamento, idtipo) " + " VALUES (?,?,?,?,?,?,?,?,?)";

//		int idProcedimento, Pet pet, Veterinario veterinario, String titulo, LocalDate dtEntrada,
//		LocalDate dtSaida , double valor, String formaPagamento, boolean situacaoPagamento, Tipo tipo

		PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql, PreparedStatement.RETURN_GENERATED_KEYS);
		try {

			System.out.println("teste procedimento dao " + novoProcedimento.getDtEntrada());
			stmt.setInt(1, novoProcedimento.getPet().getIdPet());
			stmt.setInt(2, novoProcedimento.getVeterinario().getIdVeterinario());
			stmt.setString(3, novoProcedimento.getTitulo());
			stmt.setString(4, (novoProcedimento.getDtEntrada().toString()));
			stmt.setString(5, (novoProcedimento.getDtSaida().toString()));
			stmt.setDouble(6, novoProcedimento.getValor());
			stmt.setString(7, novoProcedimento.getFormaPagamento());
			if (novoProcedimento.getSituacaoPagamento() == true) {
				stmt.setString(8, "Pago");
			} else {
				stmt.setString(8, "Não pago");
			}

			stmt.setInt(9, novoProcedimento.getTipo().getIdTipo());
			System.out.println(novoProcedimento.getTitulo() + "Saiu da DAO");
			stmt.execute();

			ResultSet rs = stmt.getGeneratedKeys();

			if (rs.next()) {
				int idProcedimentoGerado = rs.getInt(1);

				novoProcedimento.setIdProcedimento(idProcedimentoGerado);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao inserir novo Procedimento.");
			System.out.println("Erro: " + e.getMessage());
		}

		return novoProcedimento;
	}

	public ArrayList<Procedimento> consultarTodosProcedimentos() {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<Procedimento> procedimentosVO = new ArrayList<Procedimento>();

		String query = "SELECT idProcedimento, titulo, dtEntrada, dtSaida, valor, formaPagamento, situacaoPagamento, idtipo, idpet, idveterinario FROM Procedimento";

		try {

			resultado = stmt.executeQuery(query);
			while (resultado.next()) {
				Procedimento procedimentoVO = new Procedimento();

				procedimentoVO.setIdProcedimento(Integer.parseInt(resultado.getString(1)));
				procedimentoVO.setTitulo(resultado.getString(2));
				procedimentoVO.setDtEntrada(LocalDate.parse(resultado.getString(3), dataFormatter));
				procedimentoVO.setDtSaida(LocalDate.parse(resultado.getString(4), dataFormatter));
				procedimentoVO.setValor(resultado.getDouble(5));
				procedimentoVO.setFormaPagamento(resultado.getString(6));
				if (resultado.getString(7).equals("Pago")) {
					procedimentoVO.setSituacaoPagamento(true);
				} else {
					procedimentoVO.setSituacaoPagamento(false);
				}

				Tipo tipo = new Tipo(resultado.getInt(8), "");
				procedimentoVO.setTipo(tipo);

				PetDAO petDAO = new PetDAO();
				Pet pet = petDAO.consultarPetPorID(resultado.getInt(9));
				procedimentoVO.setPet(pet);

				VeterinarioDAO vetDAO = new VeterinarioDAO();
				Veterinario vet = vetDAO.consultarVeterinarioPorID(resultado.getInt(10));
				procedimentoVO.setVeterinario(vet);

//				Veterinario veterinario = new Veterinario();
//				veterinario.setIdVeterinario(resultado.getInt(10));
//				procedimentoVO.setVeterinario(veterinario);

				procedimentosVO.add(procedimentoVO);

			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de Consulta de procedimentos.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return procedimentosVO;
	}

	public Procedimento consultarProcedimentoPorID(int idProcedimento) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);

		ResultSet resultado = null;
		Procedimento procedimentoVO = new Procedimento();
		String query = "SELECT idveterinario, titulo, descricao, valor, dtentrada, dtsaida, formapagamento, situacaopagamento FROM procedimento WHERE IDPROCEDIMENTO = "
				+ idProcedimento;
		try {
			resultado = stmt.executeQuery(query);

			if (resultado.next()) {

				procedimentoVO.setIdProcedimento(Integer.parseInt(resultado.getString(1)));
				procedimentoVO.setTitulo(resultado.getString(2));
				procedimentoVO.setDtEntrada(LocalDate.parse(resultado.getString(3), dataFormatter));
				procedimentoVO.setDtSaida(LocalDate.parse(resultado.getString(4), dataFormatter));
				procedimentoVO.setValor(resultado.getDouble(5));
				procedimentoVO.setFormaPagamento(resultado.getString(6));
				procedimentoVO.setSituacaoPagamento(resultado.getBoolean(7));

			}

		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de Atualização de Procedimentos.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return procedimentoVO;
	}

	public Cliente consultarPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Procedimento> consultarProcedimentosPorPet(int idPet) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<Procedimento> procedimentosVO = new ArrayList<Procedimento>();

		String query = "SELECT idProcedimento, titulo, dtEntrada, dtSaida, valor, formaPagamento, situacaoPagamento, idtipo, idpet, idveterinario FROM Procedimento where idpet = "
				+ idPet;

		try {

			resultado = stmt.executeQuery(query);
			while (resultado.next()) {
				Procedimento procedimentoVO = new Procedimento();

				procedimentoVO.setIdProcedimento(Integer.parseInt(resultado.getString(1)));
				procedimentoVO.setTitulo(resultado.getString(2));
				procedimentoVO.setDtEntrada(LocalDate.parse(resultado.getString(3), dataFormatter));
				procedimentoVO.setDtSaida(LocalDate.parse(resultado.getString(4), dataFormatter));
				procedimentoVO.setValor(resultado.getDouble(5));
				procedimentoVO.setFormaPagamento(resultado.getString(6));
				if (resultado.getString(7).equals("Pago")) {
					procedimentoVO.setSituacaoPagamento(true);
				} else {
					procedimentoVO.setSituacaoPagamento(false);
				}

				Tipo tipo = new Tipo(resultado.getInt(8), "");
				procedimentoVO.setTipo(tipo);

				PetDAO petDAO = new PetDAO();
				Pet pet = petDAO.consultarPetPorID(resultado.getInt(9));
				procedimentoVO.setPet(pet);

				VeterinarioDAO vetDAO = new VeterinarioDAO();
				Veterinario vet = vetDAO.consultarVeterinarioPorID(resultado.getInt(10));
				procedimentoVO.setVeterinario(vet);

//				Veterinario veterinario = new Veterinario();
//				veterinario.setIdVeterinario(resultado.getInt(10));
//				procedimentoVO.setVeterinario(veterinario);

				procedimentosVO.add(procedimentoVO);

			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de Consulta de procedimentos.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return procedimentosVO;
	}

	public ArrayList<Procedimento> consultarProcedimentosPorVeterinario(int idVeterinario) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<Procedimento> procedimentosVO = new ArrayList<Procedimento>();

		String query = "SELECT idProcedimento, titulo, dtEntrada, dtSaida, valor, formaPagamento, situacaoPagamento, idtipo, idpet, idveterinario FROM Procedimento where idveterinario = "
				+ idVeterinario;

		try {

			resultado = stmt.executeQuery(query);
			while (resultado.next()) {
				Procedimento procedimentoVO = new Procedimento();

				procedimentoVO.setIdProcedimento(Integer.parseInt(resultado.getString(1)));
				procedimentoVO.setTitulo(resultado.getString(2));
				procedimentoVO.setDtEntrada(LocalDate.parse(resultado.getString(3), dataFormatter));
				procedimentoVO.setDtSaida(LocalDate.parse(resultado.getString(4), dataFormatter));
				procedimentoVO.setValor(resultado.getDouble(5));
				procedimentoVO.setFormaPagamento(resultado.getString(6));
				if (resultado.getString(7).equals("Pago")) {
					procedimentoVO.setSituacaoPagamento(true);
				} else {
					procedimentoVO.setSituacaoPagamento(false);
				}

				Tipo tipo = new Tipo(resultado.getInt(8), "");
				procedimentoVO.setTipo(tipo);

				PetDAO petDAO = new PetDAO();
				Pet pet = petDAO.consultarPetPorID(resultado.getInt(9));
				procedimentoVO.setPet(pet);

				VeterinarioDAO vetDAO = new VeterinarioDAO();
				Veterinario vet = vetDAO.consultarVeterinarioPorID(resultado.getInt(10));
				procedimentoVO.setVeterinario(vet);

//				Veterinario veterinario = new Veterinario();
//				veterinario.setIdVeterinario(resultado.getInt(10));
//				procedimentoVO.setVeterinario(veterinario);

				procedimentosVO.add(procedimentoVO);

			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de Consulta de procedimentos.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return procedimentosVO;
	}

}
