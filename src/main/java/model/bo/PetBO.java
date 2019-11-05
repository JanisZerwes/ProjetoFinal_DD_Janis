package model.bo;

import java.util.ArrayList;

import model.dao.PetDAO;
import model.vo.Pet;

public class PetBO {

	public static PetDAO dao = new PetDAO();

	public static Pet salvar(Pet novoPet) {
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
		// TODO Auto-generated method stub
		return null;
	}

	public Pet consultarPetBO(Pet petVO) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Pet> consultarTodosPetController() {
		PetDAO petDAO = new PetDAO();
		ArrayList<Pet> petVO = petDAO.consultarTodosPet();
		if (petVO.isEmpty()) {
			System.out.println("\n Lista de pets está vazia.");
		}

		return petVO;
	}

}
