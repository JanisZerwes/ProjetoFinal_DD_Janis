package view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

public class ConsultarPet extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public ConsultarPet() {
		setBorder(new LineBorder(Color.GREEN, 4));
		setLayout(null);

		table = new JTable();
		table.setForeground(Color.GREEN);
		table.setBounds(35, 60, 634, 246);
		add(table);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(453, 328, 97, 25);
		add(btnExcluir);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(30, 328, 97, 25);
		add(btnConsultar);

		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(310, 328, 97, 25);
		add(btnAdicionar);

		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(165, 328, 97, 25);
		add(btnAtualizar);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(572, 328, 97, 25);
		add(btnVoltar);

	}
}
