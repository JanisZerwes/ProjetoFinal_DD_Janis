package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import Controller.ControllerPet;
import Controller.ControllerProcedimento;
import Controller.ControllerTipo;
import Controller.ControllerVeterinario;
import model.dao.ProcedimentoDAO;
import model.dto.RelatorioProcedimento;
import model.dto.SeletorProcedimento;
import model.vo.Pet;
import model.vo.Procedimento;
import model.vo.Tipo;
import model.vo.Veterinario;

public class ConsultarProcedimento extends JPanel {
	private JTable tblProcedimento;
	private JComboBox cbTipo;
	private JComboBox cbSituacao;

	/**
	 * Create the panel.
	 */

	private String[] colunas = { "#", "Titulo", "Dt Entrada", "Dt Saída", "Valor", "Forma Pagamento",
			"Situação Pagamento", "Tipo", "Pet", "Veterinario" };

	private JButton btnVoltar;

	public JButton getBtnVoltar() {
		return btnVoltar;
	}

	public ConsultarProcedimento() {
		setBorder(new LineBorder(Color.GREEN, 4));
		setLayout(null);

		tblProcedimento = new JTable();
		tblProcedimento.setModel(new DefaultTableModel(new Object[][] { colunas }, colunas));
		tblProcedimento.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		tblProcedimento.setBounds(12, 13, 886, 246);
		add(tblProcedimento);

		JLabel lblVeterinrio = new JLabel("Veterinário:");
		lblVeterinrio.setBounds(207, 382, 81, 16);
		add(lblVeterinrio);

		final JComboBox cbVeterinario = new JComboBox();

		ArrayList<Veterinario> veterinariosCadastrados = new ArrayList<Veterinario>();
		ControllerVeterinario controllerVeterinario = new ControllerVeterinario();
		veterinariosCadastrados = controllerVeterinario.consultarTodosVeterinariosController();
		for (int i = 0; i < veterinariosCadastrados.size(); i++) {
			cbVeterinario.addItem(veterinariosCadastrados.get(i));
		}

		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(440, 382, 56, 16);
		add(lblTipo);

		cbTipo = new JComboBox();
		ArrayList<Tipo> tipoCadastrado = new ArrayList<Tipo>();
		ControllerTipo controllerTipo = new ControllerTipo();
		tipoCadastrado = controllerTipo.consultarTodosTiposController();
		cbTipo.setBounds(484, 379, 131, 22);
		add(cbTipo);
		for (int i = 0; i < tipoCadastrado.size(); i++) {
			cbTipo.addItem(tipoCadastrado.get(i));
		}

		final JComboBox cbPet = new JComboBox();

		ArrayList<Pet> petsCadastrados = new ArrayList<Pet>();
		ControllerPet controllerPet = new ControllerPet();
		petsCadastrados = controllerPet.consultarTodosPetController();
		cbPet.addItem(null);
		for (int i = 0; i < petsCadastrados.size(); i++) {
			cbPet.addItem(petsCadastrados.get(i));
		}
		cbPet.setBounds(50, 379, 129, 22);
		add(cbPet);

		cbVeterinario.setBounds(288, 379, 129, 22);
		add(cbVeterinario);
		cbVeterinario.setSelectedIndex(-1);

		JButton btnNewButton = new JButton("Consultar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				limparTela();
				Pet petSelecionado = (Pet) cbPet.getSelectedItem();
				Veterinario veterinarioSelecionado = (Veterinario) cbVeterinario.getSelectedItem();
				Tipo tipoSelecionado = (Tipo) cbTipo.getSelectedItem();
				String situacaoSelecionada = (String) cbSituacao.getSelectedItem();

				SeletorProcedimento seletor = new SeletorProcedimento();
				seletor.setPet(petSelecionado);
				seletor.setVeterinario(veterinarioSelecionado);
				seletor.setTipo(tipoSelecionado);
				seletor.setSituacaoPagamento(situacaoSelecionada);

				ControllerProcedimento consultarProcedimentos = new ControllerProcedimento();
				ArrayList<Procedimento> procedimentoTabela = consultarProcedimentos
						.consultarProcedimentosComFiltro(seletor);

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
					novaLinha[8] = procedimentoTabela.get(i).getPet().getNome();
					novaLinha[9] = procedimentoTabela.get(i).getVeterinario().getNome() + "";
					model.addRow(novaLinha);
				}
			}
		});
		btnNewButton.setBounds(22, 282, 97, 25);
		add(btnNewButton);

		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Procedimento procedimentoSelecionado = new Procedimento();

				try {
					Object idSelecionado = tblProcedimento.getModel().getValueAt(tblProcedimento.getSelectedRow(), 0);
					procedimentoSelecionado.setIdProcedimento(Integer.valueOf((String) idSelecionado));
					AtualizarProcedimentoFrame atualizarProcedimento = new AtualizarProcedimentoFrame(
							procedimentoSelecionado);
					atualizarProcedimento.setVisible(true);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Selecione uma linha");
					System.out.println(e2.getMessage());
				}
			}
		});
		btnAtualizar.setBounds(183, 282, 97, 25);
		add(btnAtualizar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Procedimento procedimentoSelecionado = new Procedimento();

				try {
					Object idSelecionado = tblProcedimento.getModel().getValueAt(tblProcedimento.getSelectedRow(), 0);
					procedimentoSelecionado.setIdProcedimento(Integer.valueOf((String) idSelecionado));
					ControllerProcedimento controladoraProcedimento = new ControllerProcedimento();
					boolean excluiu = controladoraProcedimento.excluirProcedimentoController(procedimentoSelecionado);

					if (excluiu) {
						JOptionPane.showMessageDialog(null, "Procedimento excluído com sucesso");
					} else {
						JOptionPane.showMessageDialog(null, "Impossível excluir, Procedimento com animais cadastrados");
					}

				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Selecione uma linha");
					System.out.println(e2.getMessage());
				}

			}

		});
		btnExcluir.setBounds(388, 282, 97, 25);

		add(btnExcluir);

		btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(587, 282, 97, 25);
		add(btnVoltar);

		JButton btnGerarRelatorio = new JButton("Gerar Relat\u00F3rio");
		btnGerarRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser();
				jfc.setDialogTitle("Salvar relatório como...");
				int resultado = jfc.showSaveDialog(null);
				if (resultado == JFileChooser.APPROVE_OPTION) {
					String caminhoEscolhido = jfc.getSelectedFile().getAbsolutePath();

					ControllerProcedimento controllerProcedimento = new ControllerProcedimento();
					ArrayList<Procedimento> procedimentosConsultados = controllerProcedimento
							.consultarTodosProcedimentosController();

					ProcedimentoDAO dao = new ProcedimentoDAO();
//
					ArrayList<RelatorioProcedimento> procedimentosCompleto = dao.consultarRelatorioProcedimento();
//
//					// controllerPet.gerarRelatorio(petsConsultados, caminhoEscolhido);
//
					controllerProcedimento.gerarRelatorioCompleto(procedimentosCompleto, caminhoEscolhido);
				}

			}
		});
		btnGerarRelatorio.setBounds(767, 282, 131, 25);
		add(btnGerarRelatorio);

		JLabel lblPet = new JLabel("Pet:");
		lblPet.setBounds(22, 382, 56, 16);
		add(lblPet);

		cbSituacao = new JComboBox();
		cbSituacao.setBounds(776, 379, 107, 22);
		add(cbSituacao);

		JLabel lblSitPagamento = new JLabel("Sit. Pagamento:");
		lblSitPagamento.setBounds(643, 382, 92, 16);
		add(lblSitPagamento);

		JButton btnLimpar = new JButton("Limpar Combos");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cbPet.setSelectedIndex(-1);
				cbVeterinario.setSelectedIndex(-1);
				cbTipo.setSelectedIndex(-1);
				cbSituacao.setSelectedIndex(-1);

			}
		});
		btnLimpar.setBounds(50, 441, 129, 25);
		add(btnLimpar);
		limparTela();
	}

	void limparTela() {
		tblProcedimento.setModel(new DefaultTableModel(new Object[][] { colunas }, colunas));
	}
}
