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

import Controller.ControllerVeterinario;
import model.vo.Veterinario;

public class ConsultarVeterinario extends JPanel {
	private ArrayList<Veterinario> dadosVeterinario;

	// private JTable tblVeterinario;

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
		btnAtualizar_1.setBounds(157, 336, 97, 25);
		add(btnAtualizar_1);

		JButton btnExcluir_1 = new JButton("Excluir");
		btnExcluir_1.setBounds(570, 336, 97, 25);
		add(btnExcluir_1);

		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(449, 336, 97, 25);
		add(btnAdicionar);

	}

	private void limparTela() {
		tblVeterinario.setModel(new DefaultTableModel(new Object[][] { colunas }, colunas));
	}
}
