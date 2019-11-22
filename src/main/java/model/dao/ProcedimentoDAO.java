package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import model.vo.Cliente;
import model.vo.Procedimento;

public class ProcedimentoDAO {
	DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	public ArrayList<Procedimento> consultarTodosProcedimentos() {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<Procedimento> procedimentosVO = new ArrayList<Procedimento>();

		String query = "SELECT idProcedimento, titulo, dtEntrada, dtSaida, valor, formaPagamento, situacaoPagamento FROM Procedimento";
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
				procedimentoVO.setSituacaoPagamento(resultado.getBoolean(7));

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

}
