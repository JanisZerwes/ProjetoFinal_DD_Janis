package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.vo.Tipo;

public class TipoDAO {

	public ArrayList<Tipo> consultarTodos() {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);

		ResultSet resultado = null;
		ArrayList<Tipo> tiposVO = new ArrayList<Tipo>();
		String query = "SELECT idcliente, descricao FROM tipo";
		try {
			resultado = stmt.executeQuery(query);

			while (resultado.next()) {
				Tipo tipoVO = new Tipo();
				tipoVO.setIdTipo(Integer.parseInt(resultado.getString(1)));
				tipoVO.setDescricao(resultado.getString(2));

				tiposVO.add(tipoVO);
			}

		} catch (SQLException e) {
			System.out.println("Erro ao executar a Quer y de Consulta de Tipos.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return tiposVO;
	}

}
