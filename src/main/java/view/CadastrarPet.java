package view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class CadastrarPet extends JPanel {
	private JTextField idPet;
	private JTextField dtEntrada;
	private JTextField dtSaida;

	/**
	 * Create the panel.
	 */
	public CadastrarPet() {
		setBorder(new LineBorder(Color.GREEN, 4));
		setLayout(null);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(12, 263, 97, 25);
		add(btnCadastrar);

		JLabel lblIdPet = new JLabel("ID Pet");
		lblIdPet.setBounds(12, 60, 56, 16);
		add(lblIdPet);

		idPet = new JTextField();
		idPet.setBounds(169, 57, 116, 22);
		add(idPet);
		idPet.setColumns(10);

		JLabel lblDataEntrada = new JLabel("Data Entrada");
		lblDataEntrada.setBounds(12, 110, 88, 16);
		add(lblDataEntrada);

		dtEntrada = new JTextField();
		dtEntrada.setBounds(169, 107, 116, 22);
		add(dtEntrada);
		dtEntrada.setColumns(10);

		JLabel lblDataSada = new JLabel("Data Sa\u00EDda");
		lblDataSada.setBounds(12, 150, 88, 16);
		add(lblDataSada);

		dtSaida = new JTextField();
		dtSaida.setBounds(169, 147, 116, 22);
		add(dtSaida);
		dtSaida.setColumns(10);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(12, 326, 97, 25);
		add(btnVoltar);

	}
}
