package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;

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

import Controller.ControllerPet;
import model.vo.Pet;

public class AtualizarPetFrame extends JFrame {

	private JPanel contentPane;
	DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern(" yyyy-MM-dd ");

	String[] especie = new String[5];
	private JTextField txtNome;
	private JTextField txtPeso;
	private JTextField txtPorte;
	private JTextField txtRaca;
	private JTextField txtNascimento;
	private Pet novoPet;
	ControllerPet conCliente;;

	public AtualizarPetFrame(Pet petSelecionado) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 745, 489);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		ControllerPet controladoraPet = new ControllerPet();

		petSelecionado = controladoraPet.consultarPetController(petSelecionado);
		getContentPane().setLayout(null);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(12, 31, 56, 16);
		getContentPane().add(lblNome);

		txtNome = new JTextField();
		txtNome.setBounds(169, 28, 116, 22);
		getContentPane().add(txtNome);
		txtNome.setColumns(10);
		txtNome.setText(petSelecionado.getNome());

		txtPeso = new JTextField();
		txtPeso.setBounds(169, 98, 116, 22);
		getContentPane().add(txtPeso);
		txtPeso.setColumns(10);
		txtPeso.setText(String.valueOf(petSelecionado.getPeso()));

		JLabel lblNewLabel = new JLabel("Peso:");
		lblNewLabel.setBounds(12, 101, 56, 16);
		getContentPane().add(lblNewLabel);

		JLabel lblPorte = new JLabel("Porte:");
		lblPorte.setBounds(12, 62, 56, 16);
		getContentPane().add(lblPorte);

		txtPorte = new JTextField();
		txtPorte.setBounds(169, 63, 116, 22);
		getContentPane().add(txtPorte);
		txtPorte.setColumns(10);
		txtPorte.setText(petSelecionado.getPorte());

		JLabel lblEspecie = new JLabel("Especie:");
		lblEspecie.setBounds(326, 31, 56, 16);
		getContentPane().add(lblEspecie);

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
		getContentPane().add(cbEspecie);
		if (petSelecionado.getEspecie()) {
			cbEspecie.setSelectedIndex(0);
		} else {
			cbEspecie.setSelectedIndex(1);
		}
		cbEspecie.setSelectedIndex(-1);

		JLabel lblRaa = new JLabel("Ra\u00E7a:");
		lblRaa.setBounds(12, 142, 56, 16);
		getContentPane().add(lblRaa);

		txtRaca = new JTextField();
		txtRaca.setBounds(169, 139, 116, 22);
		getContentPane().add(txtRaca);
		txtRaca.setColumns(10);
		txtRaca.setText(petSelecionado.getRaca());

		final JRadioButton rbFemea = new JRadioButton("Fêmea");
		rbFemea.setBounds(12, 233, 127, 25);
		getContentPane().add(rbFemea);

		final JRadioButton rbMacho = new JRadioButton("Macho");
		rbMacho.setBounds(158, 233, 127, 25);
		getContentPane().add(rbMacho);

		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
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

				if (mensagem.isEmpty()) {
					Pet atualizarPet;
					atualizarPet = new Pet(nomePetDigitado, pesoPetDigitado, porteDigitado, racaDigitada, sexo,
							dataNascimentoDigitada);

					controllerPet.atualizarPetController(atualizarPet);
					if (atualizarPet.getIdPet() != 0) {
						JOptionPane.showMessageDialog(null, "Pet atualizado com Sucesso.");
					}
				} else {
					JOptionPane.showMessageDialog(null, mensagem, "Atenção", JOptionPane.WARNING_MESSAGE);
				}
			}

		});
		getContentPane().add(btnAtualizar);

	}
}