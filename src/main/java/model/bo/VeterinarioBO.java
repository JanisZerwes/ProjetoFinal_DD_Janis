package model.bo;

import java.util.ArrayList;

import model.dao.VeterinarioDAO;
import model.vo.Veterinario;

public class VeterinarioBO {

	private static VeterinarioDAO dao = new VeterinarioDAO();

	public static Veterinario salvar(Veterinario novoVeterinario) {

		return dao.salvar(novoVeterinario);
	}

	public void cadastrarVeterinarioBO(VeterinarioBO veterinarioBO) {
		// TODO Auto-generated method stub

	}

	public void excluirVeterinarioBO(Veterinario veterinarioVO) {
		// TODO Auto-generated method stub

	}

	public void atualizarVeterinarioBO(Veterinario veterinarioVO) {
		// TODO Auto-generated method stub

	}

	public ArrayList<Veterinario> consultarVeterinariosBO() {
		VeterinarioDAO veterinarioDAO = new VeterinarioDAO();
		ArrayList<Veterinario> veterinariosVO = veterinarioDAO.consultarTodos();
		if (veterinariosVO.isEmpty()) {
			System.out.println("\n Lista de clientes está vazia.");
		}
		return veterinariosVO;
	}

}
