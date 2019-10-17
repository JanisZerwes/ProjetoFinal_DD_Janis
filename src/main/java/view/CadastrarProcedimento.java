package view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class CadastrarProcedimento extends JPanel {
	private JTextField txtIdProcedimento;

	/**
	 * Create the panel.
	 */
	public CadastrarProcedimento() {
		setBorder(new LineBorder(Color.GREEN, 4));
		setLayout(null);

		JLabel lblIdProcedimento = new JLabel("ID Procedimento");
		lblIdProcedimento.setBounds(31, 52, 109, 16);
		add(lblIdProcedimento);

		txtIdProcedimento = new JTextField();
		txtIdProcedimento.setBounds(273, 49, 116, 22);
		add(txtIdProcedimento);
		txtIdProcedimento.setColumns(10);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(12, 324, 97, 25);
		add(btnCadastrar);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(12, 362, 97, 25);
		add(btnVoltar);

	}
}
