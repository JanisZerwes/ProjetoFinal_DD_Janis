package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Controller.ControllerCliente;
import model.vo.Cliente;

public class AtualizarClienteFrame extends JFrame {

	private JPanel contentPane;
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

	public AtualizarClienteFrame(Cliente clienteSelecionado) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 691, 414);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		ControllerCliente controladoraCliente = new ControllerCliente();

		clienteSelecionado = controladoraCliente.consultarClienteController(clienteSelecionado);
		getContentPane().setLayout(null);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(12, 38, 38, 16);
		getContentPane().add(lblNome);

		txtNome = new JTextField();
		txtNome.setBounds(86, 35, 116, 22);
		getContentPane().add(txtNome);
		txtNome.setColumns(10);
		txtNome.setText(clienteSelecionado.getNome());

		JLabel lblSobrenome = new JLabel("Sobrenome:");
		lblSobrenome.setBounds(12, 85, 71, 16);
		getContentPane().add(lblSobrenome);

		txtSobrenome = new JTextField();
		txtSobrenome.setBounds(86, 82, 116, 22);
		getContentPane().add(txtSobrenome);
		txtSobrenome.setColumns(10);
		txtSobrenome.setText(clienteSelecionado.getSobrenome());

		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(12, 182, 33, 16);
		getContentPane().add(lblSexo);

		JLabel lblCpf = new JLabel("Cpf:");
		lblCpf.setBounds(12, 134, 24, 16);
		getContentPane().add(lblCpf);

		txtCpf = new JTextField();
		txtCpf.setBounds(86, 131, 116, 22);
		getContentPane().add(txtCpf);
		txtCpf.setColumns(10);
		txtCpf.setText(clienteSelecionado.getCpf());

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(12, 286, 55, 16);
		getContentPane().add(lblTelefone);

		txtTelefone = new JTextField();
		txtTelefone.setBounds(86, 283, 116, 22);
		getContentPane().add(txtTelefone);
		txtTelefone.setColumns(10);
		txtTelefone.setText(clienteSelecionado.getTelefone());

		txtEmail = new JTextField();
		txtEmail.setBounds(342, 283, 116, 22);
		getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		txtEmail.setText(clienteSelecionado.getEmail());

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(289, 286, 41, 16);
		getContentPane().add(lblEmail);

		JLabel lblAdimplente = new JLabel("Adimplente:");
		lblAdimplente.setBounds(342, 38, 109, 16);
		getContentPane().add(lblAdimplente);

		adimplente[0] = "Sim";
		adimplente[1] = "Não";
		JComboBox cbAdimplente = new JComboBox();
		cbAdimplente_1 = new JComboBox(adimplente);
		cbAdimplente_1.setBounds(514, 38, 98, 22);
		cbAdimplente_1.setModel(new DefaultComboBoxModel(new String[] { "Sim", "Não" }));
		getContentPane().add(cbAdimplente_1);
		if (clienteSelecionado.getAdimplente()) {
			cbAdimplente_1.setSelectedIndex(0);
		} else {
			cbAdimplente_1.setSelectedIndex(1);
		}

		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setBounds(12, 231, 58, 16);
		getContentPane().add(lblEndereo);

		txtEndereco = new JTextField();
		txtEndereco.setBounds(86, 228, 116, 22);
		getContentPane().add(txtEndereco);
		txtEndereco.setColumns(10);
		txtEndereco.setText(clienteSelecionado.getEndereco());

		final JRadioButton rbFeminino = new JRadioButton("Feminino");
		rbFeminino.setBounds(86, 178, 127, 25);
		getContentPane().add(rbFeminino);

		if (clienteSelecionado.getSexo().equals("F")) {
			rbFeminino.setSelected(true);
		}

		final JRadioButton rbMasculino = new JRadioButton("Masculino");
		rbMasculino.setBounds(248, 178, 127, 25);
		getContentPane().add(rbMasculino);

		if (clienteSelecionado.getSexo().equals("M")) {
			rbMasculino.setSelected(true);
		}

		final int idSelecionado = clienteSelecionado.getIdCliente();

		JButton btnSalvar = new JButton("Atualizar");
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

				if (rbFeminino.isSelected()) {
					sexoDigitado = "M";
				}

				if (rbMasculino.isSelected()) {
					sexoDigitado = "F";
				}

				String mensagem = controllerCliente.validarCamposSalvar(nomeDigitado, sobrenomeDigitado,
						enderecoDigitado, sexoDigitado, cpfDigitado, telefoneDigitado, emailDigitado);

				if (mensagem.isEmpty()) {
					Cliente atualizarCliente;
					atualizarCliente = new Cliente(nomeDigitado, sobrenomeDigitado, enderecoDigitado, sexoDigitado,
							cpfDigitado, telefoneDigitado, emailDigitado, null, idSelecionado);
					controllerCliente.atualizarClienteController(atualizarCliente);

				} else {
					JOptionPane.showMessageDialog(null, mensagem, "Atenção", JOptionPane.WARNING_MESSAGE);
				}

			}

		});
		getContentPane().add(btnSalvar);
	}

}
