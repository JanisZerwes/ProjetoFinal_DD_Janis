package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

public class ConsultarProcedimento extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public ConsultarProcedimento() {
		setBorder(new LineBorder(Color.GREEN, 4));
		setLayout(null);

		table = new JTable();
		table.setBounds(12, 79, 656, 253);
		add(table);

		JButton btnNewButton = new JButton("Consultar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(26, 393, 97, 25);
		add(btnNewButton);

		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(149, 393, 97, 25);
		add(btnAtualizar);

		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(299, 393, 97, 25);
		add(btnAdicionar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(446, 393, 97, 25);
		add(btnExcluir);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(571, 393, 97, 25);
		add(btnVoltar);

	}

}
