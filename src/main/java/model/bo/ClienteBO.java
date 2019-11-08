package model.bo;

import java.util.ArrayList;

import model.dao.ClienteDAO;
import model.vo.Cliente;

public class ClienteBO {

	private static ClienteDAO dao = new ClienteDAO();

	public static Cliente salvar(Cliente novoCliente) {
		return dao.salvar(novoCliente);

	}

//	public void atualizarClienteBO(ClienteBO clienteBO) {
//		ClienteDAO clienteDAO = new ClienteDAO();
//		if (clienteDAO.existeRegistroPorIdCliente(clienteBO.get())) {
//			boolean alterou = usuarioDAO.alterar(usuarioVO);
//			if (alterou) {
//				System.out.println("\nUsuário atualizado com Sucesso.");
//			} else {
//				System.out.println("\nNão foi possível atualizar o Usuário.");
//			}
//		} else {
//			System.out.println("\nUsuário ainda não foi cadastrado.");
//		}
//
//	}

	public Cliente consultarClienteBO(Cliente clienteVO) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Cliente> consultarClientesBO() {

		ClienteDAO clienteDAO = new ClienteDAO();
		ArrayList<Cliente> clientesVO = clienteDAO.consultarTodos();
		if (clientesVO.isEmpty()) {
			System.out.println("\n Lista de clientes est� vazia.");
		}
		return clientesVO;
	}

	public void excluirClienteBO(Cliente clienteVO) {
		// TODO Auto-generated method stub

	}

	public void cadastrarClienteBO(Cliente clienteVO) {
		// TODO Auto-generated method stub

	}

	public void atualizarClienteBO(Cliente clienteVO) {
		// TODO Auto-generated method stub

	}

	public ArrayList<Cliente> consultarTodosClientesPetController() {
		ClienteDAO clienteDAO = new ClienteDAO();
		ArrayList<Cliente> clientesVO = clienteDAO.consultarTodos();
		if (clientesVO.isEmpty()) {
			System.out.println("\nLista de clientes est� vazia.");
		}
		return clientesVO;
	}

}
