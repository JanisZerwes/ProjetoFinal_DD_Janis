package view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

public class ConsultarCliente extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public ConsultarCliente() {
		setBorder(new LineBorder(Color.GREEN, 4));
		setLayout(null);

		table = new JTable();
		table.setBounds(12, 49, 604, 257);
		add(table);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(12, 340, 97, 25);
		add(btnConsultar);

		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(141, 340, 97, 25);
		add(btnAtualizar);

		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(274, 340, 97, 25);
		add(btnAdicionar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(410, 340, 97, 25);
		add(btnExcluir);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(519, 340, 97, 25);
		add(btnVoltar);

	}

}
