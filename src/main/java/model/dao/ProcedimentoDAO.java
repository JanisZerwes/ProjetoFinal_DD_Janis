package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

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
				procedimentoVO.setFormaPagamento(resultado.getString(2));
				procedimentoVO.setSituacaoPagamento(resultado.getBoolean(2));

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
