package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import Controller.ControllerPet;
import model.dao.PetDAO;
import model.dto.RelatorioPet;
import model.vo.Pet;

public class ConsultarPet extends JPanel {
	// private JTable tblPet;

	/**
	 * Create the panel.
	 */
	final JTable tblPet;
	String[] colunas = { "#", "Nome", "Porte", "Peso", "Raça", "Data Nascimento", "Especie" };

	public ConsultarPet() {
		setBorder(new LineBorder(Color.GREEN, 4));
		setLayout(null);

		tblPet = new JTable();
		tblPet.setForeground(Color.BLACK);
		tblPet.setBounds(12, 60, 720, 220);
		add(tblPet);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Pet petSelecionado = new Pet();

				try {
					Object idSelecionado = tblPet.getModel().getValueAt(tblPet.getSelectedRow(), 0);
					petSelecionado.setIdPet(Integer.valueOf((String) idSelecionado));
					ControllerPet controllerPet = new ControllerPet();
					boolean excluiu = controllerPet.excluirPetController(petSelecionado);

					if (excluiu) {
						JOptionPane.showMessageDialog(null, "Pet excluído com sucesso");
					}

				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Selecione uma linha");
					System.out.println(e2.getMessage());
				}
			}
		});
		btnExcluir.setBounds(334, 328, 97, 25);
		add(btnExcluir);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				limparTela();
				ControllerPet controllerPetConsultar = new ControllerPet();
				ArrayList<Pet> petTabela = controllerPetConsultar.consultarTodosPetController();

				DefaultTableModel model = (DefaultTableModel) tblPet.getModel();

				for (int i = 0; i < petTabela.size(); i++) {
					String[] novaLinha = new String[10];
					novaLinha[0] = petTabela.get(i).getIdPet() + "";
					novaLinha[1] = petTabela.get(i).getNome();
					novaLinha[2] = petTabela.get(i).getPorte();
					novaLinha[3] = petTabela.get(i).getPeso() + "";
					novaLinha[4] = petTabela.get(i).getRaca();
					novaLinha[5] = petTabela.get(i).getDtNascimento() + "";
					novaLinha[6] = petTabela.get(i).getEspecie();
					model.addRow(novaLinha);
				}
			}
		});
		btnConsultar.setBounds(22, 328, 97, 25);
		add(btnConsultar);

		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(188, 328, 97, 25);
		add(btnAtualizar);

		JButton btnGerarXls = new JButton("Gerar XLS");
		btnGerarXls.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser jfc = new JFileChooser();
				jfc.setDialogTitle("Salvar relatório como...");

				int resultado = jfc.showSaveDialog(null);
				if (resultado == JFileChooser.APPROVE_OPTION) {
					String caminhoEscolhido = jfc.getSelectedFile().getAbsolutePath();

					ControllerPet controllerPet = new ControllerPet();
					ArrayList<Pet> petsConsultados = controllerPet.consultarTodosPetController();

					PetDAO dao = new PetDAO();

					ArrayList<RelatorioPet> petsCompleto = dao.consultarRelatorioPet();

					// controllerPet.gerarRelatorio(petsConsultados, caminhoEscolhido);

					controllerPet.gerarRelatorioCompleto(petsCompleto, caminhoEscolhido);

				}
			}
		});
		btnGerarXls.setBounds(635, 328, 97, 25);
		add(btnGerarXls);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(499, 328, 97, 25);
		add(btnVoltar);

	}

	private void limparTela() {
		tblPet.setModel(new DefaultTableModel(new Object[][] { colunas }, colunas));

	}
}
