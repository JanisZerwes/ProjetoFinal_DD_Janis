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
		table.setBounds(35, 87, 526, 207);
		add(table);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(12, 340, 97, 25);
		add(btnConsultar);

		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(141, 340, 97, 25);
		add(btnAtualizar);

		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(266, 340, 97, 25);
		add(btnAdicionar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(375, 340, 97, 25);
		add(btnExcluir);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(492, 340, 97, 25);
		add(btnVoltar);

	}

}
