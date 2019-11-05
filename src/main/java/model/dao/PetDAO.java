package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import model.vo.Pet;

public class PetDAO {

	DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern(" aaaa-MM-dd ");

	public Pet salvar(Pet novoPet) {
		Connection conexao = Banco.getConnection();
		String sql = " INSERT INTO PET(NOME, PESO, PORTE, RACA, SEXO, DTNASCIMENTO) " + " VALUES (?,?,?,?,?,?)";
		PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql, PreparedStatement.RETURN_GENERATED_KEYS);
		try {
			stmt.setString(1, novoPet.getNome());
			stmt.setDouble(2, novoPet.getPeso());
			stmt.setString(3, novoPet.getPorte());
			stmt.setString(4, novoPet.getRaca());
			stmt.setString(5, novoPet.getSexo());
			stmt.setDate(6, Date.valueOf(novoPet.getDtNascimento()));

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
		String query = "SELECT idPet, nome, porte, peso, raca, dtnascimento, sexo FROM Pet";
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

}
