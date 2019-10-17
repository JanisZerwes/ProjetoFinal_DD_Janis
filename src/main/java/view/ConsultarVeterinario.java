package view;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;

public class ConsultarVeterinario extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public ConsultarVeterinario() {
		setLayout(null);

		table = new JTable();
		table.setBounds(54, 68, 583, 313);
		add(table);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(12, 432, 97, 25);
		add(btnConsultar);

		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(121, 432, 97, 25);
		add(btnAtualizar);

		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.setBounds(230, 432, 97, 25);
		add(btnNewButton);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(353, 432, 97, 25);
		add(btnExcluir);

		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(488, 432, 97, 25);
		add(btnNewButton_1);

	}

}
