package Controller;

import java.util.ArrayList;

import model.bo.PetBO;
import model.bo.ProcedimentoBO;
import model.dto.RelatorioProcedimento;
import model.dto.SeletorProcedimento;
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

	public boolean excluirProcedimentoController(Procedimento procedimentoVO) {
		ProcedimentoBO procedimentoBO = new ProcedimentoBO();
		return procedimentoBO.excluirProcedimentoBO(procedimentoVO);
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

	public ArrayList<Procedimento> consultarProcedimentosComFiltro(SeletorProcedimento seletor) {
		PetBO petBO = new PetBO();
		return petBO.consultarProcedimentosPorPet(seletor);
	}

	public String validarCamposSalvar(String tituloDigitado, String dataEntradaDigitada, String dataSaidaDigitada,
			String valorDigitada, String formaPagamentoDigitada, String situacaoPagamentoDigitada) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<RelatorioProcedimento> consultarRelatorioProcedimento() {
		// TODO Auto-generated method stub
		return null;
	}

	public void gerarRelatorioCompleto(ArrayList<RelatorioProcedimento> procedimentosCompleto,
			String caminhoEscolhido) {
		// TODO Auto-generated method stub

	}
}
