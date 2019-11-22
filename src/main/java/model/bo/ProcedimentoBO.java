package model.bo;

import java.util.ArrayList;

import model.dao.ProcedimentoDAO;
import model.vo.Procedimento;

public class ProcedimentoBO {

	public void cadastrarProcedimentoBO(Procedimento procedimentoVO) {
		// TODO Auto-generated method stub

	}

	public void excluirProcedimentoBO(Procedimento procedimentoVO) {
		// TODO Auto-generated method stub

	}

	public void atualizarProcedimentoBO(Procedimento procedimentoVO) {
		// TODO Auto-generated method stub

	}

	public ArrayList<Procedimento> consultarProcedimentoBO() {
		ProcedimentoDAO procedimentoDAO = new ProcedimentoDAO();

		ArrayList<Procedimento> procedimentoVO = procedimentoDAO.consultarTodosProcedimentos();

		if (procedimentoVO.isEmpty()) {
			System.out.println("\n Lista de procedimentos está vazia.");
		}

		return procedimentoVO;
	}

	public Procedimento consultarProcedimentosBO(Procedimento procedimentoVO) {
		ProcedimentoDAO procedimentoDAO = new ProcedimentoDAO();
		procedimentoVO = procedimentoDAO.consultarProcedimentoPorID(procedimentoVO.getIdProcedimento());
		return procedimentoVO;
	}

}
