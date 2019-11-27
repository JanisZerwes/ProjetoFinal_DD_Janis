package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import Controller.ControllerProcedimento;
import model.vo.Procedimento;

public class ConsultarProcedimento extends JPanel {
	private JTable tblProcedimento;

	/**
	 * Create the panel.
	 */

	private String[] colunas = { "#", "Titulo", "Dt Entrada", "Dt Saída", "Valor", "Forma Pagamento",
			"Situação Pagamento", "Tipo", "Pet", "Veterinario" };

	public ConsultarProcedimento() {
		setBorder(new LineBorder(Color.GREEN, 4));
		setLayout(null);

		tblProcedimento = new JTable();
		tblProcedimento.setModel(new DefaultTableModel(new Object[][] { colunas }, colunas));
		tblProcedimento.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		tblProcedimento.setBounds(12, 79, 886, 246);
		add(tblProcedimento);

		JButton btnNewButton = new JButton("Consultar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limparTela();
				ControllerProcedimento consultarTodosProcedimentosController = new ControllerProcedimento();
				ArrayList<Procedimento> procedimentoTabela = consultarTodosProcedimentosController
						.consultarTodosProcedimentosController();

				DefaultTableModel model = (DefaultTableModel) tblProcedimento.getModel();
				for (int i = 0; i < procedimentoTabela.size(); i++) {
					String[] novaLinha = new String[10];
					System.out.println(procedimentoTabela.get(i).getIdProcedimento());
					novaLinha[0] = procedimentoTabela.get(i).getIdProcedimento() + "";
					novaLinha[1] = procedimentoTabela.get(i).getTitulo();
					novaLinha[2] = procedimentoTabela.get(i).getDtEntrada() + "";
					novaLinha[3] = procedimentoTabela.get(i).getDtSaida() + "";
					novaLinha[4] = procedimentoTabela.get(i).getValor() + "";
					novaLinha[5] = procedimentoTabela.get(i).getFormaPagamento();
					if (procedimentoTabela.get(i).getSituacaoPagamento()) {
						novaLinha[6] = "Pago";
					} else {
						novaLinha[6] = "Não Pago";
					}
					novaLinha[7] = procedimentoTabela.get(i).getTipo().getIdTipo() + "";
					novaLinha[8] = procedimentoTabela.get(i).getPet().getIdPet() + "";
					novaLinha[9] = procedimentoTabela.get(i).getVeterinario().getIdVeterinario() + "";
					model.addRow(novaLinha);
				}
			}
		});
		btnNewButton.setBounds(26, 393, 97, 25);
		add(btnNewButton);

		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(210, 393, 97, 25);
		add(btnAtualizar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(391, 393, 97, 25);
		add(btnExcluir);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(566, 393, 97, 25);
		add(btnVoltar);

		JButton btnGerarRelatorio = new JButton("Gerar Relat\u00F3rio");
		btnGerarRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnGerarRelatorio.setBounds(740, 393, 131, 25);
		add(btnGerarRelatorio);

	}

	void limparTela() {
		tblProcedimento.setModel(new DefaultTableModel(new Object[][] { colunas }, colunas));
	}

}
