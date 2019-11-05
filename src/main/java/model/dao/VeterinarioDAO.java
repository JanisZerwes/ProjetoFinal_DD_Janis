package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.vo.Veterinario;

public class VeterinarioDAO {

	public Veterinario salvar(Veterinario novoVeterinario) {
		Connection conexao = Banco.getConnection();
		String sql = " INSERT INTO VETERINARIO(NOME, SOBRENOME, ENDERECO,SEXO, CPF, TELEFONE, EMAIL, CERTIFICADO, CRMV) "
				+ " VALUES (?,?,?,?,?,?,?,?,?)";
		PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql, PreparedStatement.RETURN_GENERATED_KEYS);
		try {

			stmt.setString(1, novoVeterinario.getNome());
			stmt.setString(2, novoVeterinario.getSobrenome());
			stmt.setString(3, novoVeterinario.getEndereco());
			stmt.setString(4, novoVeterinario.getSexo());
			stmt.setString(5, novoVeterinario.getCpf());
			stmt.setString(6, novoVeterinario.getTelefone());
			stmt.setString(7, novoVeterinario.getEmail());
			stmt.setString(8, novoVeterinario.getCertificado());
			stmt.setString(9, novoVeterinario.getCrmv());
			stmt.execute();

			ResultSet rs = stmt.getGeneratedKeys();

			if (rs.next()) {
				int idVeterinarioGerado = rs.getInt(1);

				novoVeterinario.setIdVeterinario(idVeterinarioGerado);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao inserir novo endere�o.");
			System.out.println("Erro: " + e.getMessage());
		}

		return novoVeterinario;

	}

	public ArrayList<Veterinario> consultarTodos() {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<Veterinario> veterinariosVO = new ArrayList<Veterinario>();
		String query = "SELECT idVeterinario, nome, sobrenome, endereco, sexo, cpf, telefone, email, certificado, crmv FROM veterinario";
		try {

			resultado = stmt.executeQuery(query);
			while (resultado.next()) {
				Veterinario veterinarioVO = new Veterinario();
				veterinarioVO.setIdVeterinario(Integer.parseInt(resultado.getString(1)));
				veterinarioVO.setNome(resultado.getString(2));
				veterinarioVO.setSobrenome(resultado.getString(3));
				veterinarioVO.setEndereco(resultado.getString(4));
				veterinarioVO.setSexo(resultado.getString(5));
				veterinarioVO.setCpf(resultado.getString(6));
				veterinarioVO.setTelefone(resultado.getString(7));
				veterinarioVO.setEmail(resultado.getString(8));
				veterinarioVO.setCertificado(resultado.getString(9));
				veterinarioVO.setCrmv(resultado.getString(10));
				veterinariosVO.add(veterinarioVO);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de Consulta de Veterinarios.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return veterinariosVO;
	}

}
