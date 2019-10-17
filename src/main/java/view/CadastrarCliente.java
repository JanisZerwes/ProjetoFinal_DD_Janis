package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class CadastrarCliente extends JPanel {
	private JTextField txtCliente;

	/**
	 * Create the panel.
	 */
	public CadastrarCliente() {
		setBorder(new LineBorder(Color.GREEN, 4));
		setLayout(null);

		JLabel lblIdCliente = new JLabel("ID Cliente");
		lblIdCliente.setBounds(33, 64, 56, 16);
		add(lblIdCliente);

		txtCliente = new JTextField();
		txtCliente.setBounds(154, 61, 116, 22);
		add(txtCliente);
		txtCliente.setColumns(10);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCadastrar.setBounds(33, 276, 97, 25);
		add(btnCadastrar);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(33, 337, 97, 25);
		add(btnVoltar);

	}

}
