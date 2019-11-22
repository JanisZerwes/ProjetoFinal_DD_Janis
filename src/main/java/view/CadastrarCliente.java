package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import Controller.ControllerCliente;
import model.vo.Cliente;

public class CadastrarCliente extends JPanel {
	private JTextField txtNome;
	private JTextField txtSobrenome;
	private JTextField txtCpf;
	private JTextField txtTelefone;
	private JTextField txtEmail;
	private JTextField txtEndereco;
	String[] adimplente = new String[2];
	private JComboBox cbAdimplente;
	private Cliente novoCliente;
	private JComboBox cbAdimplente_1;

	/**
	 * Create the panel.
	 */
	public CadastrarCliente() {

		setBorder(new LineBorder(Color.GREEN, 4));
		setLayout(null);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(12, 38, 38, 16);
		add(lblNome);

		txtNome = new JTextField();
		txtNome.setBounds(86, 35, 116, 22);
		add(txtNome);
		txtNome.setColumns(10);

		JLabel lblSobrenome = new JLabel("Sobrenome:");
		lblSobrenome.setBounds(12, 85, 71, 16);
		add(lblSobrenome);

		txtSobrenome = new JTextField();
		txtSobrenome.setBounds(86, 82, 116, 22);
		add(txtSobrenome);
		txtSobrenome.setColumns(10);

		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(12, 182, 33, 16);
		add(lblSexo);

		JLabel lblCpf = new JLabel("Cpf:");
		lblCpf.setBounds(12, 134, 24, 16);
		add(lblCpf);

		txtCpf = new JTextField();
		txtCpf.setBounds(86, 131, 116, 22);
		add(txtCpf);
		txtCpf.setColumns(10);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(12, 286, 55, 16);
		add(lblTelefone);

		txtTelefone = new JTextField();
		txtTelefone.setBounds(86, 283, 116, 22);
		add(txtTelefone);
		txtTelefone.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setBounds(342, 283, 116, 22);
		add(txtEmail);
		txtEmail.setColumns(10);

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(289, 286, 41, 16);
		add(lblEmail);

		JLabel lblAdimplente = new JLabel("Adimplente:");
		lblAdimplente.setBounds(342, 38, 109, 16);
		add(lblAdimplente);

		JComboBox cbAdimplente = new JComboBox();
		cbAdimplente_1 = new JComboBox(adimplente);
		cbAdimplente_1.setBounds(514, 38, 98, 22);
		cbAdimplente_1.setModel(new DefaultComboBoxModel(new String[] { "Sim", "Não" }));
		add(cbAdimplente_1);

		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setBounds(12, 231, 58, 16);
		add(lblEndereo);

		txtEndereco = new JTextField();
		txtEndereco.setBounds(86, 228, 116, 22);
		add(txtEndereco);
		txtEndereco.setColumns(10);

		final JRadioButton rbFemenino = new JRadioButton("Feminino");
		rbFemenino.setBounds(86, 178, 127, 25);
		add(rbFemenino);

		final JRadioButton rbMasculino = new JRadioButton("Masculino");
		rbMasculino.setBounds(248, 178, 127, 25);
		add(rbMasculino);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(514, 282, 98, 25);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControllerCliente controllerCliente = new ControllerCliente();

				;
				String nomeDigitado = txtNome.getText();
				String sobrenomeDigitado = txtSobrenome.getText();
				String enderecoDigitado = txtEndereco.getText();
				String sexoDigitado = "";
				String cpfDigitado = txtCpf.getText().replace("-", "").replace(".", "");
				String telefoneDigitado = txtTelefone.getText();
				String emailDigitado = txtEmail.getText();

				if (rbFemenino.isSelected()) {
					sexoDigitado = "M";
				}

				if (rbMasculino.isSelected()) {
					sexoDigitado = "F";
				}

				String mensagem = controllerCliente.validarCamposSalvar(nomeDigitado, sobrenomeDigitado,
						enderecoDigitado, sexoDigitado, cpfDigitado, telefoneDigitado, emailDigitado);
				if (mensagem.isEmpty()) {
					boolean adim;
					if (cbAdimplente_1.getSelectedIndex() == 0) {
						adim = true;
					} else {
						adim = false;
					}

					novoCliente = new Cliente(nomeDigitado, sobrenomeDigitado, enderecoDigitado, sexoDigitado,
							cpfDigitado, telefoneDigitado, emailDigitado, adim, 0);

					novoCliente = controllerCliente.salva(novoCliente);

				} else {
					JOptionPane.showMessageDialog(null, mensagem, "Atenção", JOptionPane.WARNING_MESSAGE);
				}

			}

		});
		add(btnSalvar);

	}
}
