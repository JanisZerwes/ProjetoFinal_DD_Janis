package Controller;

import java.util.ArrayList;

import model.bo.VeterinarioBO;
import model.vo.Procedimento;
import model.vo.Veterinario;

public class ControllerVeterinario {
	public String validarCamposSalvar(String nomeDigitado, String sobrenomeDigitado, String enderecoDigitado,
			String sexoDigitado, String cpfDigitado, String telefoneDigitado, String emailDigitado,
			String certificadoDigitado, String crmvDigitado) {
		String mensagem = "";

		if (nomeDigitado.isEmpty() || nomeDigitado.trim().length() < 3) {
			mensagem += "Nome deve possuir pelo menos 3 letras \n";
		}

		if (sobrenomeDigitado.isEmpty() || sobrenomeDigitado.trim().length() < 3) {
			mensagem += "Sobrenome deve possuir pelo menos 3 letras \n";
		}
		if (enderecoDigitado == null) {
			mensagem += "Digite o Endereço Completo";
		}
		if (sexoDigitado.isEmpty() || sexoDigitado.trim().length() < 1) {
			mensagem += "Escolha o Sexo \n";
		}
		if (cpfDigitado.isEmpty() || cpfDigitado.trim().length() != 11) {
			mensagem += "CPF deve possuir 11 exatamente dÃ­gitos \n";
		}
		if (telefoneDigitado.isEmpty() || telefoneDigitado.trim().length() < 9) {
			mensagem += "Telefone deve possuir pelo menos 9 números \n";
		}
		if (emailDigitado.isEmpty() || !emailDigitado.contains("@") || emailDigitado.trim().length() < 5) {
			mensagem += "Digite um email válido \n";
		}
		if (certificadoDigitado.isEmpty()) {
			mensagem += "Digite o Certificado";
		}
		if (crmvDigitado.isEmpty()) {
			mensagem += "Digite o Crmv";
		}

		return mensagem;

	}

	public Veterinario salva(Veterinario novoVeterinario) {
		return VeterinarioBO.salvar(novoVeterinario);

	}

	public void cadastrarVeterinarioController(Veterinario veterinarioVO) {
		VeterinarioBO veterinarioBO = new VeterinarioBO();
		veterinarioBO.cadastrarVeterinarioBO(veterinarioBO);
	}

	public void excluirVeterinarioController(Veterinario veterinarioVO) {
		VeterinarioBO veterinarioBO = new VeterinarioBO();
		veterinarioBO.excluirVeterinarioBO(veterinarioVO);
	}

	public void atualizarVeterinarioController(Veterinario veterinarioVO) {
		VeterinarioBO veterinarioBO = new VeterinarioBO();
		veterinarioBO.atualizarVeterinarioBO(veterinarioVO);
	}

	public ArrayList<Veterinario> consultarTodosVeterinariosController() {
		VeterinarioBO veterinarioBO = new VeterinarioBO();
		return veterinarioBO.consultarVeterinariosBO();
	}

	public Veterinario consultarVeterinarioController(Veterinario veterinarioVO) {
		VeterinarioBO veterinarioBO = new VeterinarioBO();
		return veterinarioVO.consultarVeterinarioBO(veterinarioVO);
	}

	public ArrayList<Procedimento> consultarProcedimentosPorProcedimento(Veterinario veterinario) {
		VeterinarioBO veterinarioBO = new VeterinarioBO();
		return veterinarioBO.consultarProcedimentosPorPet(veterinario);
	}
}
