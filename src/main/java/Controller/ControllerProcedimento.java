package Controller;

import java.util.ArrayList;

import model.bo.ProcedimentoBO;
import model.vo.Procedimento;

public class ControllerProcedimento {

	public static Procedimento salva(Procedimento novoProcedimento) {
		ProcedimentoBO bo = new ProcedimentoBO();
		return bo.salvar(novoProcedimento);

	}

	public void cadastrarProcedimentoController(Procedimento procedimentoVO) {
		ProcedimentoBO procedimentoBO = new ProcedimentoBO();
		procedimentoBO.cadastrarProcedimentoBO(procedimentoVO);
	}

	public void excluirProcedimentoController(Procedimento procedimentoVO) {
		ProcedimentoBO procedimentoBO = new ProcedimentoBO();
		procedimentoBO.excluirProcedimentoBO(procedimentoVO);
	}

	public void atualizarProcedimentoController(Procedimento procedimentoVO) {
		ProcedimentoBO procedimentoBO = new ProcedimentoBO();
		procedimentoBO.atualizarProcedimentoBO(procedimentoVO);
	}

	public ArrayList<Procedimento> consultarTodosProcedimentosController() {
		ProcedimentoBO procedimentoBO = new ProcedimentoBO();
		return procedimentoBO.consultarProcedimentoBO();
	}

	public Procedimento consultarProcedimentoController(Procedimento procedimentoVO) {
		ProcedimentoBO procedimentoBO = new ProcedimentoBO();
		return procedimentoBO.consultarProcedimentosBO(procedimentoVO);
	}

	public String validarCamposSalvar(String tituloDigitado, String dataEntradaDigitada, String dataSaidaDigitada,
			String valorDigitada, String formaPagamentoDigitada, boolean situacaoPagamentoDigitada) {
		String mensagem = "";

		if (tituloDigitado.isEmpty() || tituloDigitado.trim().length() < 3) {
			mensagem += "Titulo deve possuir pelo menos 3 letras \n";
		}

		if (dataEntradaDigitada.isEmpty()) {
			mensagem += "Digite a data de entrada \n";
		}

		if (dataSaidaDigitada.isEmpty()) {
			mensagem += "Digite a data de saída";
		}

		if (valorDigitada.isEmpty()) {
			mensagem += "Digite o valor do procedimento \n";
		}
		if (formaPagamentoDigitada.isEmpty()) {
			mensagem += "Digite a forma de pagamento \n";
		}

		return mensagem;
	}
}
