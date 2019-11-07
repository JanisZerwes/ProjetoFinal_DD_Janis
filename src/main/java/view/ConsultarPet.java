package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import Controller.ControllerPet;
import model.dao.PetDAO;
import model.dto.RelatorioPet;
import model.vo.Pet;

public class ConsultarPet extends JPanel {
	private JTable tblPet;

	/**
	 * Create the panel.
	 */
	public ConsultarPet() {
		setBorder(new LineBorder(Color.GREEN, 4));
		setLayout(null);

		tblPet = new JTable();
		tblPet.setForeground(Color.GREEN);
		tblPet.setBounds(12, 60, 652, 220);
		add(tblPet);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(532, 328, 97, 25);
		add(btnExcluir);

		final JTable tblPet;
		String[] colunas = { "#", "Nome", "Porte", "Peso", "Raça", "Data Nascimento", "Especie" };

		tblPet = new JTable();
		tblPet.setModel(new DefaultTableModel(new Object[][] { colunas }, colunas));
		tblPet.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		tblPet.setBounds(12, 30, 720, 281);
		add(tblPet);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		btnConsultar.setBounds(38, 328, 97, 25);
		add(btnConsultar);

		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(351, 328, 97, 25);
		add(btnAdicionar);

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
		btnGerarXls.setBounds(532, 365, 97, 25);
		add(btnGerarXls);

	}
}
