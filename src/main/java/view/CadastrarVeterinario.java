package view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class CadastrarVeterinario extends JPanel {
	private JTextField txtVeterinario;

	/**
	 * Create the panel.
	 */
	public CadastrarVeterinario() {
		setBorder(new LineBorder(Color.GREEN, 4));
		setLayout(null);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(12, 369, 97, 25);
		add(btnCadastrar);

		JLabel lblIdVeterinrio = new JLabel("ID Veterin\u00E1rio");
		lblIdVeterinrio.setBounds(24, 60, 116, 16);
		add(lblIdVeterinrio);

		txtVeterinario = new JTextField();
		txtVeterinario.setBounds(196, 57, 116, 22);
		add(txtVeterinario);
		txtVeterinario.setColumns(10);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(138, 369, 97, 25);
		add(btnVoltar);

	}

}
