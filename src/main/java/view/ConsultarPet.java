package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		table.setBounds(12, 60, 636, 220);
		add(table);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(437, 328, 97, 25);
		add(btnExcluir);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(12, 328, 97, 25);
		add(btnConsultar);

		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(294, 328, 97, 25);
		add(btnAdicionar);

		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(144, 328, 97, 25);
		add(btnAtualizar);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVoltar.setBounds(546, 328, 97, 25);
		add(btnVoltar);

	}
}
