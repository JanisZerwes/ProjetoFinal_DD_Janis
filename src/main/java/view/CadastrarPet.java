package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import Controller.ControllerPet;
import model.vo.Cliente;
import model.vo.Pet;

public class CadastrarPet extends JPanel {
	DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern(" yyyy-MM-dd ");

	String[] especie = new String[5];
	private JTextField txtNome;
	private JTextField txtPeso;
	private JTextField txtPorte;
	private JTextField txtRaca;
	private JTextField txtNascimento;
	private Pet novoPet;
	ControllerPet conCliente;;

	/**
	 * Create the panel.
	 */
	public CadastrarPet() {
		setBorder(new LineBorder(Color.GREEN, 4));
		setLayout(null);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(12, 31, 56, 16);
		add(lblNome);

		txtNome = new JTextField();
		txtNome.setBounds(169, 28, 116, 22);
		add(txtNome);
		txtNome.setColumns(10);

		txtPeso = new JTextField();
		txtPeso.setBounds(169, 98, 116, 22);
		add(txtPeso);
		txtPeso.setColumns(10);

		JLabel lblNewLabel = new JLabel("Peso:");
		lblNewLabel.setBounds(12, 101, 56, 16);
		add(lblNewLabel);

		JLabel lblPorte = new JLabel("Porte:");
		lblPorte.setBounds(12, 62, 56, 16);
		add(lblPorte);

		txtPorte = new JTextField();
		txtPorte.setBounds(169, 63, 116, 22);
		add(txtPorte);
		txtPorte.setColumns(10);

		JLabel lblEspecie = new JLabel("Especie:");
		lblEspecie.setBounds(326, 31, 56, 16);
		add(lblEspecie);

		especie[0] = "Cachorro";
		especie[1] = "Gato";
		especie[2] = "Passarinho";
		especie[3] = "Tartaruga";
		especie[4] = "Ramster";

		JComboBox cbEspecie = new JComboBox();
		cbEspecie = new JComboBox(especie);
		cbEspecie.setModel(
				new DefaultComboBoxModel(new String[] { "Cachorro", "Gato", "Passarinho", "Tartaruga", "Ramster" }));
		cbEspecie.setBounds(394, 28, 125, 22);
		add(cbEspecie);

		JLabel lblRaa = new JLabel("Ra\u00E7a:");
		lblRaa.setBounds(12, 142, 56, 16);
		add(lblRaa);

		txtRaca = new JTextField();
		txtRaca.setBounds(169, 139, 116, 22);
		add(txtRaca);
		txtRaca.setColumns(10);

		final JRadioButton rbFemea = new JRadioButton("F�mea");
		rbFemea.setBounds(12, 233, 127, 25);
		add(rbFemea);

		final JRadioButton rbMacho = new JRadioButton("Macho");
		rbMacho.setBounds(158, 233, 127, 25);
		add(rbMacho);

		JButton btnCadastrar = new JButton("Salvar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				ControllerPet controllerPet = new ControllerPet();

				String nomePetDigitado = txtNome.getText();
				String pesoPetDigitado = txtPeso.getText();
				String porteDigitado = txtPorte.getText();
				String racaDigitada = txtRaca.getText();
				String sexo = "";
				String dataNascimentoDigitada = txtNascimento.getText();
				if (rbMacho.isSelected()) {
					sexo = "M";
				}

				if (rbFemea.isSelected()) {
					sexo = "F";
				}
				String mensagem = controllerPet.validarCamposSalvar(nomePetDigitado, pesoPetDigitado, porteDigitado,
						racaDigitada, sexo, dataNascimentoDigitada);

				novoPet = new Pet(0, nomePetDigitado, pesoPetDigitado, porteDigitado, racaDigitada, sexo,
						dataNascimentoDigitada);

				if (mensagem.isEmpty()) {
					novoPet = new Pet(0, nomePetDigitado, pesoPetDigitado, porteDigitado, racaDigitada, sexo,
							dataNascimentoDigitada);
					novoPet = controllerPet.salva(novoPet);
				} else {
					JOptionPane.showMessageDialog(null, mensagem, "Aten��o", JOptionPane.WARNING_MESSAGE);
				}

			}

		});
		btnCadastrar.setBounds(160, 293, 125, 25);
		add(btnCadastrar);
		setLayout(null);
		setVisible(true);

		JLabel lblDataNascimento = new JLabel("Data Nascimento:");
		lblDataNascimento.setBounds(12, 185, 116, 16);
		add(lblDataNascimento);

		txtNascimento = new JTextField();
		txtNascimento.setBounds(169, 182, 116, 22);
		add(txtNascimento);
		txtNascimento.setColumns(10);

//		usuarios = conUsuario.consultarTodosUsuariosController();
//		final JComboBox<UsuarioVO> cbUsuario = new JComboBox();
//		cbUsuario.addItem(null);
//		for (UsuarioVO user: usuarios) {
//			cbUsuario.addItem(user);			
//		}

		ArrayList<Cliente> clientes = new ArrayList();
		conCliente = new ControllerPet();

		clientes = conCliente.consultarTodosClientesPetController();

		JComboBox<Cliente> cbCliente = new JComboBox();

		cbCliente.setBounds(394, 182, 125, 22);
		add(cbCliente);
		for (Cliente user : clientes) {
			cbCliente.addItem(user);
		}

		JLabel lblDono = new JLabel("Dono:");
		lblDono.setBounds(326, 185, 56, 16);
		add(lblDono);

	}
}
