package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import Controller.ControllerVeterinario;
import model.dao.VeterinarioDAO;
import model.vo.Veterinario;

public class ConsultarVeterinario extends JPanel {
	private ArrayList<Veterinario> dadosVeterinario;

	// private JTable tblVeterinario;

	private JButton btnVoltar;

	public JButton getBtnVoltar() {
		return btnVoltar;
	}

	private JButton btnAtualizar;

	public JButton getBtnAtualizar() {
		return btnAtualizar;
	}

	/**
	 * Create the panel.
	 */
	final JTable tblVeterinario;
	String[] colunas = { "#", "Nome", "Sobrenome", "Endereço", "Sexo", "CPF", "Telefone", "Email", "Certificado ",
			"crmv" };

	public ConsultarVeterinario() {
		setBorder(new LineBorder(Color.GREEN, 4));
		setLayout(null);

		tblVeterinario = new JTable();
		tblVeterinario.setModel(new DefaultTableModel(new Object[][] { colunas }, colunas));
		tblVeterinario.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		// frame.getContentPane().add(tblClientes, "cell 1 5 6 1,grow");
		tblVeterinario.setBounds(12, 26, 717, 259);
		add(tblVeterinario);

//
//		tblVeterinario = new JTable();
//		tblVeterinario.setModel(new DefaultTableModel(new Object[][] { colunas }, colunas));
//		tblVeterinario.setBorder(BorderFactory.createLineBorder(Color.GRAY));
//		tblVeterinario.setBounds(12, 30, 720, 281);
//		add(tblVeterinario);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limparTela();
				ControllerVeterinario controllerVeterinarioConsultar = new ControllerVeterinario();
				ArrayList<Veterinario> veterinarioTabela = controllerVeterinarioConsultar
						.consultarTodosVeterinariosController();
				DefaultTableModel model = (DefaultTableModel) tblVeterinario.getModel();

				for (int i = 0; i < veterinarioTabela.size(); i++) {
					String[] novaLinha = new String[10];

					novaLinha[0] = veterinarioTabela.get(i).getIdVeterinario() + "";
					novaLinha[1] = veterinarioTabela.get(i).getNome();
					novaLinha[2] = veterinarioTabela.get(i).getSobrenome();
					novaLinha[3] = veterinarioTabela.get(i).getEndereco();
					novaLinha[4] = veterinarioTabela.get(i).getSexo();
					novaLinha[5] = veterinarioTabela.get(i).getCpf();
					novaLinha[6] = veterinarioTabela.get(i).getTelefone();
					novaLinha[7] = veterinarioTabela.get(i).getEmail();
					novaLinha[8] = veterinarioTabela.get(i).getCertificado();
					novaLinha[9] = veterinarioTabela.get(i).getCrmv();
					model.addRow(novaLinha);
				}

			}

		});

		btnConsultar.setBounds(12, 336, 97, 25);
		add(btnConsultar);

		JButton btnAtualizar_1 = new JButton("Atualizar");
		btnAtualizar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Veterinario veterinarioSelecionado = new Veterinario();

				try {
					Object idSelecionado = tblVeterinario.getModel().getValueAt(tblVeterinario.getSelectedRow(), 0);
					veterinarioSelecionado.setIdVeterinario(Integer.valueOf((String) idSelecionado));
					AtualizarVeterinarioFrame atualizarVeterinario = new AtualizarVeterinarioFrame(
							veterinarioSelecionado);
					atualizarVeterinario.setVisible(true);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Selecione uma linha");
					System.out.println(e2.getMessage());
				}

			}

		});
		btnAtualizar_1.setBounds(157, 336, 97, 25);

		add(btnAtualizar_1);

		JButton btnExcluir_1 = new JButton("Excluir");
		btnExcluir_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Veterinario veterinarioSelecionado = new Veterinario();

				try {
					Object idSelecionado = tblVeterinario.getModel().getValueAt(tblVeterinario.getSelectedRow(), 0);
					veterinarioSelecionado.setIdVeterinario(Integer.valueOf((String) idSelecionado));
					ControllerVeterinario controllerVeterinario = new ControllerVeterinario();
					boolean excluiu = controllerVeterinario.excluirVeterinarioController(veterinarioSelecionado);

					if (excluiu) {
						JOptionPane.showMessageDialog(null, "Veterinário excluído com sucesso");
					} else {
						JOptionPane.showMessageDialog(null, "Impossível excluir, veterinário com animais cadastrados");
					}

				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Selecione uma linha");
					System.out.println(e2.getMessage());
				}

			}

		});
		btnExcluir_1.setBounds(304, 336, 97, 25);

		add(btnExcluir_1);

		btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(461, 336, 97, 25);
		add(btnVoltar);

		JButton btnGerarRelatrio = new JButton("Gerar Relat\u00F3rio");
		btnGerarRelatrio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser();
				jfc.setDialogTitle("Salvar relatório como...");
				int resultado = jfc.showSaveDialog(null);
				if (resultado == JFileChooser.APPROVE_OPTION) {
					String caminhoEscolhido = jfc.getSelectedFile().getAbsolutePath();

					ControllerVeterinario controllerVeterinario = new ControllerVeterinario();
					ArrayList<Veterinario> veterinariosConsultadis = controllerVeterinario
							.consultarTodosVeterinariosController();

					VeterinarioDAO dao = new VeterinarioDAO();
//
					ArrayList<Veterinario> veterinariosCompleto = dao.consultarRelatorioVeterinario();
//					// controllerPet.gerarRelatorio(petsConsultados, caminhoEscolhido);
//
					controllerVeterinario.gerarRelatorioCompleto(veterinariosCompleto, caminhoEscolhido);
				}

			}
		});
		btnGerarRelatrio.setBounds(610, 336, 119, 25);
		add(btnGerarRelatrio);

	}

	private void limparTela() {
		tblVeterinario.setModel(new DefaultTableModel(new Object[][] { colunas }, colunas));
	}
}
