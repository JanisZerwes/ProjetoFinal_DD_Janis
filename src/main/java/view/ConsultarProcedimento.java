package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import Controller.ControllerPet;
import Controller.ControllerProcedimento;
import Controller.ControllerTipo;
import Controller.ControllerVeterinario;
import model.vo.Pet;
import model.vo.Procedimento;
import model.vo.Tipo;
import model.vo.Veterinario;

public class ConsultarProcedimento extends JPanel {
	private JTable tblProcedimento;

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
		lblVeterinrio.setBounds(277, 382, 81, 16);
		add(lblVeterinrio);

		final JComboBox cbVeterinario = new JComboBox();
		cbVeterinario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparTela();
				ControllerVeterinario consultarTodosProcedimentosPorVeterinario = new ControllerVeterinario();
				Veterinario veterinario = new Veterinario();
				veterinario.setIdVeterinario(cbVeterinario.getSelectedIndex() + 1);
				ArrayList<Procedimento> veterinarioProcedimento = consultarTodosProcedimentosPorVeterinario
						.consultarProcedimentosPorProcedimento(veterinario);
				DefaultTableModel model = (DefaultTableModel) tblProcedimento.getModel();
				for (int i = 0; i < veterinarioProcedimento.size(); i++) {
					String[] novaLinha = new String[10];
					System.out.println(veterinarioProcedimento.get(i).getIdProcedimento());
					novaLinha[0] = veterinarioProcedimento.get(i).getIdProcedimento() + "";
					novaLinha[1] = veterinarioProcedimento.get(i).getTitulo();
					novaLinha[2] = veterinarioProcedimento.get(i).getDtEntrada() + "";
					novaLinha[3] = veterinarioProcedimento.get(i).getDtSaida() + "";
					novaLinha[4] = veterinarioProcedimento.get(i).getValor() + "";
					novaLinha[5] = veterinarioProcedimento.get(i).getFormaPagamento();
					if (veterinarioProcedimento.get(i).getSituacaoPagamento()) {
						novaLinha[6] = "Pago";
					} else {
						novaLinha[6] = "Não Pago";
					}
					novaLinha[7] = veterinarioProcedimento.get(i).getTipo().getIdTipo() + "";
					novaLinha[8] = veterinarioProcedimento.get(i).getPet().getNome();
					novaLinha[9] = veterinarioProcedimento.get(i).getVeterinario().getNome() + "";
					model.addRow(novaLinha);
				}
			}
		});
		ArrayList<Veterinario> veterinariosCadastrados = new ArrayList<Veterinario>();
		ControllerVeterinario controllerVeterinario = new ControllerVeterinario();
		veterinariosCadastrados = controllerVeterinario.consultarTodosVeterinariosController();
		for (int i = 0; i < veterinariosCadastrados.size(); i++) {
			cbVeterinario.addItem(veterinariosCadastrados.get(i));
		}

		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(613, 382, 56, 16);
		add(lblTipo);

		JComboBox cbTipo = new JComboBox();
		ArrayList<Tipo> tipoCadastrado = new ArrayList<Tipo>();
		ControllerTipo controllerTipo = new ControllerTipo();
		tipoCadastrado = controllerTipo.consultarTodosTiposController();

		cbTipo.setBounds(647, 379, 131, 22);
		add(cbTipo);
		for (int i = 0; i < tipoCadastrado.size(); i++) {
			cbTipo.addItem(tipoCadastrado.get(i));
		}

		final JComboBox cbPet = new JComboBox();
		cbPet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limparTela();
				ControllerProcedimento consultarTodosProcedimentosPorPet = new ControllerProcedimento();
				Pet p = new Pet();
				p.setIdPet(cbPet.getSelectedIndex() + 1);
				ArrayList<Procedimento> procedimentoTabela = consultarTodosProcedimentosPorPet
						.consultarProcedimentosPorPet(p);

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
		ArrayList<Pet> petsCadastrados = new ArrayList<Pet>();
		ControllerPet controllerPet = new ControllerPet();
		petsCadastrados = controllerPet.consultarTodosPetController();
		for (int i = 0; i < petsCadastrados.size(); i++) {
			cbPet.addItem(petsCadastrados.get(i));
		}
		cbPet.setBounds(50, 379, 131, 22);
		add(cbPet);

		cbVeterinario.setBounds(356, 379, 129, 22);
		add(cbVeterinario);
		JButton btnNewButton = new JButton("Consultar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				limparTela();
				ControllerProcedimento consultarTodosProcedimentosPorPet = new ControllerProcedimento();
				ArrayList<Procedimento> procedimentoTabela = consultarTodosProcedimentosPorPet
						.consultarTodosProcedimentosController();
				if (cbPet != null) {
					procedimentoTabela = consultarTodosProcedimentosPorPet
							.consultarProcedimentosPorPet((Pet) cbPet.getSelectedItem());

				}

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
		btnAtualizar.setBounds(183, 282, 97, 25);
		add(btnAtualizar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(388, 282, 97, 25);
		add(btnExcluir);

		btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(587, 282, 97, 25);
		add(btnVoltar);

		JButton btnGerarRelatorio = new JButton("Gerar Relat\u00F3rio");
		btnGerarRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnGerarRelatorio.setBounds(767, 282, 131, 25);
		add(btnGerarRelatorio);

		JLabel lblPet = new JLabel("Pet:");
		lblPet.setBounds(22, 382, 56, 16);
		add(lblPet);

	}

	void limparTela() {
		tblProcedimento.setModel(new DefaultTableModel(new Object[][] { colunas }, colunas));
	}
}
