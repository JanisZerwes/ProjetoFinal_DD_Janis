package model.bo;

import java.util.ArrayList;

import model.dao.ProcedimentoDAO;
import model.dao.VeterinarioDAO;
import model.vo.Procedimento;
import model.vo.Veterinario;

public class VeterinarioBO {

	private static VeterinarioDAO dao = new VeterinarioDAO();

	public static Veterinario salvar(Veterinario novoVeterinario) {

		return dao.salvar(novoVeterinario);
	}

	public void cadastrarVeterinarioBO(VeterinarioBO veterinarioBO) {
		// TODO Auto-generated method stub

	}

	public boolean excluirVeterinarioBO(Veterinario veterinarioVO) {
		VeterinarioDAO veterinarioDAO = new VeterinarioDAO();
		return veterinarioDAO.excluir(veterinarioVO.getIdVeterinario());
	}

	public void atualizarVeterinarioBO(Veterinario veterinarioVO) {
		VeterinarioDAO veterinarioDAO = new VeterinarioDAO();
		veterinarioDAO.alterar(veterinarioVO);

	}

	public ArrayList<Veterinario> consultarVeterinariosBO() {
		VeterinarioDAO veterinarioDAO = new VeterinarioDAO();
		ArrayList<Veterinario> veterinariosVO = veterinarioDAO.consultarTodos();
		if (veterinariosVO.isEmpty()) {
			System.out.println("\n Lista de clientes está vazia.");
		}
		return veterinariosVO;
	}

	public ArrayList<Procedimento> consultarProcedimentosPorPet(Veterinario veterinario) {
		ProcedimentoDAO procedimentoDAO = new ProcedimentoDAO();
		ArrayList<Procedimento> procedimentosVO = procedimentoDAO
				.consultarProcedimentosPorVeterinario(veterinario.getIdVeterinario());

		if (procedimentosVO.isEmpty()) {
			System.out.println("\nLista de procedimentoVO está vazia.");
		}
		return procedimentosVO;
	}

}
