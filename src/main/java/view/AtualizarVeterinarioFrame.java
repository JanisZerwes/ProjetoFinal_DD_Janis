package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Controller.ControllerVeterinario;
import model.vo.Veterinario;

public class AtualizarVeterinarioFrame extends JFrame {

	private JPanel contentPane;
	private Veterinario novoVeterinario;
	private JTextField txtNome;
	private JTextField txtSobrenome;
	private JTextField txtEndereco;
	private JTextField txtSexo;
	private JTextField txtCpf;
	private JLabel lblTelefone;
	private JTextField txtTelefone;
	private JLabel lblEmail;
	private JTextField txtEmail;
	private JLabel lblCertificado;
	private JTextField txtCertificado;
	private JLabel lblCrmv;
	private JTextField txtCrmv;

	public AtualizarVeterinarioFrame(Veterinario veterinarioSelecionado) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 711, 544);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		ControllerVeterinario controladoraVeterinario = new ControllerVeterinario();

		veterinarioSelecionado = controladoraVeterinario.consultarVeterinarioController(veterinarioSelecionado);
		getContentPane().setLayout(null);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(12, 39, 56, 16);
		add(lblNome);

		txtNome = new JTextField();
		txtNome.setBounds(107, 36, 116, 22);
		add(txtNome);
		txtNome.setColumns(10);

		JLabel lblSobrenome = new JLabel("Sobrenome:");
		lblSobrenome.setBounds(12, 83, 83, 16);
		add(lblSobrenome);

		txtSobrenome = new JTextField();
		txtSobrenome.setBounds(107, 80, 116, 22);
		add(txtSobrenome);
		txtSobrenome.setColumns(10);

		txtEndereco = new JTextField();
		txtEndereco.setBounds(107, 132, 116, 22);
		add(txtEndereco);
		txtEndereco.setColumns(10);

		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setBounds(12, 135, 83, 16);
		add(lblEndereo);

		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(12, 182, 56, 16);
		add(lblSexo);

		JLabel lblNewLabel = new JLabel("Cpf:");
		lblNewLabel.setBounds(12, 229, 56, 16);
		add(lblNewLabel);

		txtCpf = new JTextField();
		txtCpf.setBounds(107, 226, 116, 22);
		add(txtCpf);
		txtCpf.setColumns(10);

		lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(12, 276, 56, 16);
		add(lblTelefone);

		txtTelefone = new JTextField();
		txtTelefone.setBounds(107, 273, 116, 22);
		add(txtTelefone);
		txtTelefone.setColumns(10);

		lblEmail = new JLabel("Email:");
		lblEmail.setBounds(12, 325, 56, 16);
		add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setBounds(107, 322, 116, 22);
		add(txtEmail);
		txtEmail.setColumns(10);

		lblCertificado = new JLabel("Certificados:");
		lblCertificado.setBounds(12, 379, 83, 16);
		add(lblCertificado);

		txtCertificado = new JTextField();
		txtCertificado.setBounds(107, 376, 116, 22);
		add(txtCertificado);
		txtCertificado.setColumns(10);

		lblCrmv = new JLabel("Crmv:");
		lblCrmv.setBounds(12, 425, 56, 16);
		add(lblCrmv);

		txtCrmv = new JTextField();
		txtCrmv.setBounds(107, 422, 116, 22);
		add(txtCrmv);
		txtCrmv.setColumns(10);

		final JRadioButton rbtnFeminino = new JRadioButton("Feminino");
		rbtnFeminino.setBounds(107, 178, 127, 25);
		add(rbtnFeminino);

		final JRadioButton rbtnMasculino = new JRadioButton("Masculino");
		rbtnMasculino.setBounds(243, 178, 127, 25);
		add(rbtnMasculino);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ControllerVeterinario controllerVeterinario = new ControllerVeterinario();

				String nomeDigitado = txtNome.getText();
				String sobrenomeDigitado = txtSobrenome.getText();
				String enderecoDigitado = txtEndereco.getText();
				String sexoDigitado = "";
				String cpfDigitado = txtCpf.getText().replace("-", "").replace(".", "");
				String telefoneDigitado = txtTelefone.getText();
				String emailDigitado = txtEmail.getText();
				String certificadoDigitado = txtCertificado.getText();
				String crmvDigitado = txtCrmv.getText();

				novoVeterinario = new Veterinario(0, nomeDigitado, sobrenomeDigitado, enderecoDigitado, sexoDigitado,
						cpfDigitado, telefoneDigitado, emailDigitado, certificadoDigitado, crmvDigitado);

				String mensagem = controllerVeterinario.validarCamposSalvar(nomeDigitado, sobrenomeDigitado,
						enderecoDigitado, sexoDigitado, cpfDigitado, telefoneDigitado, emailDigitado,
						certificadoDigitado, crmvDigitado);

				if (mensagem.isEmpty()) {

					novoVeterinario.setIdVeterinario(0);
					novoVeterinario.setNome(nomeDigitado);
					novoVeterinario.setSobrenome(sobrenomeDigitado);
					novoVeterinario.setEndereco(enderecoDigitado);
					novoVeterinario.setSexo(sexoDigitado);
					novoVeterinario.setCpf(cpfDigitado);
					novoVeterinario.setTelefone(telefoneDigitado);
					novoVeterinario.setEmail(emailDigitado);
					novoVeterinario.setCertificado(certificadoDigitado);
					novoVeterinario.setCrmv(crmvDigitado);
					novoVeterinario = controllerVeterinario.salva(novoVeterinario);

				} else {
					JOptionPane.showMessageDialog(null, mensagem, "Atenção", JOptionPane.WARNING_MESSAGE);
				}

			}
		});

		btnSalvar.setBounds(357, 421, 97, 25);
		add(btnSalvar);

	}

}
