package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class ConsultarProcedimento extends JPanel {
	private JTable tblProcedimento;

	/**
	 * Create the panel.
	 */

	private String[] colunas = { "#", "Titulo", "Dt Entrada", "Dt Saída", "Valor", "Forma Pagamento",
			"Situação Pagamento" };

	public ConsultarProcedimento() {
		setBorder(new LineBorder(Color.GREEN, 4));
		setLayout(null);

		tblProcedimento = new JTable();
		tblProcedimento.setModel(new DefaultTableModel(new Object[][] { colunas }, colunas));
		tblProcedimento.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		tblProcedimento.setBounds(12, 79, 886, 246);
		add(tblProcedimento);

		JButton btnNewButton = new JButton("Consultar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(26, 393, 97, 25);
		add(btnNewButton);

		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(210, 393, 97, 25);
		add(btnAtualizar);

		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(433, 393, 97, 25);
		add(btnAdicionar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(659, 393, 97, 25);
		add(btnExcluir);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(782, 393, 97, 25);
		add(btnVoltar);

	}

}
