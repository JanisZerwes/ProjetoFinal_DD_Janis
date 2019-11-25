package Controller;

import java.util.ArrayList;

import model.bo.ClienteBO;
import model.bo.PetBO;
import model.dao.PetDAO;
import model.dto.GeradorDePlanilha;
import model.dto.RelatorioPet;
import model.vo.Cliente;
import model.vo.Pet;

public class ControllerPet {

	public Pet salva(Pet novoPet) {
		return PetBO.salvar(novoPet);

	}

	public void cadastrarPetController(Pet petVO) {
		PetBO petBO = new PetBO();
		petBO.cadastrarPetBO(petBO);
	}

	public boolean excluirPetController(Pet petVO) {
		PetBO petBO = new PetBO();
		return petBO.excluirPetBO(petVO);
	}

	public void atualizarPetController(Pet petVO) {
		PetBO petBO = new PetBO();
		petBO.atualizarPetBO(petVO);
	}

//	public ArrayList<P> consultarTodosPetsController() {
//		PetBO petBO = new PetBO();
//		return petBO.consultarPetsBO();
//	}

	public ArrayList<Cliente> consultarTodosClientesPetController() {
		ClienteBO clienteBO = new ClienteBO();
		return clienteBO.consultarTodosClientesPetController();

	}

	public Pet consultarPetController(Pet petVO) {
		PetBO petBO = new PetBO();
		return petBO.consultarPetBO(petVO);
	}

	public String validarCamposSalvar(String nomePetDigitado, String pesoPetDigitado, String porteDigitado,
			String racaDigitada, String sexo, String dataNascimentoDigitada) {
		String mensagem = "";

		if (nomePetDigitado.isEmpty() || nomePetDigitado.trim().length() < 3) {
			mensagem += "Nome deve possuir pelo menos 3 letras \n";
		}

		if (pesoPetDigitado.isEmpty()) {
			mensagem += "Preencha o peso \n";
		}
		if (porteDigitado.isEmpty()) {
			mensagem += "Digite o porte";
		}
		if (racaDigitada.isEmpty() || racaDigitada.trim().length() < 1) {
			mensagem += "Digite a Raça \n";
		}
		if (sexo.isEmpty() || sexo.trim().length() < 1) {
			mensagem += "Escolha o sexo \n";
		}

		if (dataNascimentoDigitada.isEmpty()) {
			mensagem += "Digite a data de nascimento \n";
		}

		return mensagem;
	}

	public ArrayList<Pet> consultarTodosPetController() {

		PetBO petBO = new PetBO();
		return petBO.consultarPetsBO();
	}

	public void gerarRelatorio(ArrayList<Pet> petsConsultados, String caminhoEscolhido) {
		PetBO petBO = new PetBO();
		petBO.gerarRelatorio(petsConsultados, caminhoEscolhido);
	}

	public void gerarRelatorioCompleto(ArrayList<RelatorioPet> petsConsultados, String caminhoEscolhido) {
		PetDAO petDAO = new PetDAO();
		GeradorDePlanilha gerador = new GeradorDePlanilha();
		gerador.gerarPlanilhaPetCompleta(petsConsultados, caminhoEscolhido);
	}
}
