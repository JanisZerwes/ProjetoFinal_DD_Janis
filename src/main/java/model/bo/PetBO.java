package model.bo;

import java.util.ArrayList;

import model.dao.PetDAO;
import model.dto.GeradorDePlanilha;
import model.vo.Pet;

public class PetBO {

	public static Pet salvar(Pet novoPet) {
		PetDAO dao = new PetDAO();
		return dao.salvar(novoPet);
	}

	public void cadastrarPetBO(PetBO petBO) {
		// TODO Auto-generated method stub

	}

	public void excluirPetBO(Pet petVO) {
		// TODO Auto-generated method stub

	}

	public void atualizarPetBO(Pet petVO) {
		// TODO Auto-generated method stub

	}

	public ArrayList<Pet> consultarPetsBO() {

		PetDAO petDAO = new PetDAO();

		ArrayList<Pet> petVO = petDAO.consultarTodosPet();

		if (petVO.isEmpty()) {
			System.out.println("\n Lista de pets está vazia.");
		}

		return petVO;
	}

	public Pet consultarPetBO(Pet petVO) {
		PetDAO petDAO = new PetDAO();
		petVO = petDAO.consultarPetPorID(petVO.getIdPet());
		return petVO;
	}
//
//	public ArrayList<Pet> consultarTodosPetController() {
//		PetDAO petDAO = new PetDAO();
//		ArrayList<Pet> petVO = petDAO.consultarTodosPet();
//		if (petVO.isEmpty()) {
//			System.out.println("\n Lista de pets está vazia.");
//		}
//
//		return petVO;
//	}

	public void gerarRelatorio(ArrayList<Pet> petsConsultados, String caminhoEscolhido) {
		GeradorDePlanilha gerador = new GeradorDePlanilha();
		gerador.gerarPlanilhaPet(petsConsultados, caminhoEscolhido);
	}

}
