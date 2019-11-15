package Controller;

import java.util.ArrayList;

import model.bo.ClienteBO;
import model.vo.Cliente;

public class ControllerCliente {

	public String validarCamposSalvar(String nomeDigitado, String sobrenomeDigitado, String enderecoDigitado,
			String sexoDigitado, String cpfDigitado, String telefoneDigitado, String emailDigitado) {
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
		return mensagem;

	}

	public static Cliente salva(Cliente novoCliente) {
		return ClienteBO.salvar(novoCliente);

	}

	public void cadastrarClienteController(Cliente clienteVO) {
		ClienteBO clienteBO = new ClienteBO();
		clienteBO.cadastrarClienteBO(clienteVO);
	}

	public void excluirClienteController(Cliente clienteVO) {
		ClienteBO clienteBO = new ClienteBO();
		clienteBO.excluirClienteBO(clienteVO);
	}

	public void atualizarClienteController(Cliente clienteVO) {
		ClienteBO clienteBO = new ClienteBO();
		clienteBO.atualizarClienteBO(clienteVO);
	}

	public ArrayList<Cliente> consultarTodosClientesController() {
		ClienteBO clienteBO = new ClienteBO();
		return clienteBO.consultarClientesBO();
	}

	public Cliente consultarClienteController(Cliente clienteVO) {
		ClienteBO clienteBO = new ClienteBO();
		return clienteBO.consultarClienteBO(clienteVO);
	}

}
