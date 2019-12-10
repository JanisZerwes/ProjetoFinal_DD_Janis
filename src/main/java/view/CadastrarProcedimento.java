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

import com.github.lgooddatepicker.components.DatePicker;

import Controller.ControllerProcedimento;
import model.dao.PetDAO;
import model.dao.VeterinarioDAO;
import model.vo.Pet;
import model.vo.Procedimento;
import model.vo.Tipo;
import model.vo.Veterinario;

public class CadastrarProcedimento extends JPanel {

	DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	private JTextField txtTitulo;
	private JTextField txtDtEntrada;
	private DatePicker dataEntrada;
	private DatePicker dataSaida;

	private JTextField txtDtSaida;
	private JTextField txtValor;
	private JTextField txtFormaPagamento;
	private Procedimento novoProcedimento;
	String[] tipo = new String[4];
	JComboBox<Pet> cbPet;
	private JComboBox cbTipoPagamento;
	private JComboBox<Tipo> cbTipoProcedimento;
	private JComboBox<Veterinario> cbVeterinario;
	JRadioButton rbNao;
	JRadioButton rbSim;

	/**
	 * Create the panel..
	 */

	public CadastrarProcedimento() {
		initialize();
	}

	public void initialize() {

		setBorder(new LineBorder(Color.GREEN, 4));
		setLayout(null);

		JLabel lblTtulo = new JLabel("T\u00EDtulo:");
		lblTtulo.setBounds(12, 37, 56, 16);
		add(lblTtulo);

		txtTitulo = new JTextField();
		txtTitulo.setBounds(160, 34, 116, 22);
		add(txtTitulo);
		txtTitulo.setColumns(10);

		JLabel lblDataEntrada = new JLabel("Data Entrada:");
		lblDataEntrada.setBounds(12, 92, 91, 16);

		add(lblDataEntrada);

		// txtDtEntrada = new JTextField();
		// txtDtEntrada.setBounds(160, 89, 116, 22);

		dataEntrada = new DatePicker();
		dataEntrada.setBounds(160, 89, 300, 30);
		add(dataEntrada);

		// add(txtDtEntrada);
		// txtDtEntrada.setColumns(10);

		JLabel lblDataSada = new JLabel("Data Sa\u00EDda:");
		lblDataSada.setBounds(12, 157, 91, 16);
		add(lblDataSada);

//		txtDtSaida = new JTextField();
//		txtDtSaida.setBounds(160, 151, 116, 22);
//		add(txtDtSaida);
//		txtDtSaida.setColumns(10);

		dataSaida = new DatePicker();
		dataSaida.setBounds(160, 151, 300, 30);
		add(dataSaida);

		JLabel lblValor = new JLabel("Valor:");
		lblValor.setBounds(12, 222, 56, 16);
		add(lblValor);

		txtValor = new JTextField();
		txtValor.setBounds(160, 219, 116, 22);
		add(txtValor);
		txtValor.setColumns(10);

		JLabel lblFormaPagamento = new JLabel("Forma Pagamento:");
		lblFormaPagamento.setBounds(12, 281, 116, 16);
		add(lblFormaPagamento);

		txtFormaPagamento = new JTextField();
		txtFormaPagamento.setBounds(160, 275, 116, 22);
		add(txtFormaPagamento);
		txtFormaPagamento.setColumns(10);

		JLabel lblSituaoPagamento = new JLabel("Situa\u00E7\u00E3o Pagamento:");
		lblSituaoPagamento.setBounds(12, 336, 136, 16);
		add(lblSituaoPagamento);

		cbTipoPagamento = new JComboBox(tipo);
		cbTipoPagamento.setBounds(605, 51, 129, 22);
		cbTipoPagamento.setModel(new DefaultComboBoxModel(
				new String[] { "Cartão à Vista", "Cartão Parcelado", "Dinheiro à Vista", "Dinheiro Parcelado" }));
		add(cbTipoPagamento);
		cbTipoPagamento.setSelectedIndex(-1);
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(537, 54, 56, 16);
		add(lblTipo);

		rbSim = new JRadioButton("Sim");
		rbSim.setBounds(149, 332, 127, 25);
		add(rbSim);

		rbNao = new JRadioButton("Não");
		rbNao.setBounds(147, 362, 127, 25);
		add(rbNao);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				ControllerProcedimento controllerProcedimento = new ControllerProcedimento();

				String tituloDigitado = txtTitulo.getText();
				String dataEntradaDigitada = dataEntrada.getText();
				String dataSaidaDigitada = dataSaida.getText();
				String valorDigitada = txtValor.getText();
				String formaPagamentoDigitada = (String) cbTipoPagamento.getSelectedItem();
				boolean situacaoPagamentoSelecionada = false;
				if (rbNao.isSelected()) {
					situacaoPagamentoSelecionada = false;
				}

				if (rbSim.isSelected()) {
					situacaoPagamentoSelecionada = true;
				}
				String mensagem = controllerProcedimento.validarCamposSalvar(tituloDigitado, dataEntradaDigitada,
						dataSaidaDigitada, valorDigitada, formaPagamentoDigitada, situacaoPagamentoSelecionada);
//				int idProcedimento, Pet pet, Veterinario veterinario, String titulo, LocalDate dtEntrada,
//				LocalDate dtSaida, double valor, String formaPagamento, boolean situacaoPagamento, Tipo tipo
				Pet petSelecionado = (Pet) cbPet.getSelectedItem();
				Veterinario veterinarioSelecionado = (Veterinario) cbVeterinario.getSelectedItem();
				Tipo tipoSelecionado = (Tipo) cbTipoProcedimento.getSelectedItem();
				if (mensagem.isEmpty()) {
					novoProcedimento = new Procedimento(0, petSelecionado, veterinarioSelecionado, tituloDigitado,
							dataEntrada.getDate(), dataSaida.getDate(), Double.valueOf(valorDigitada),
							formaPagamentoDigitada, situacaoPagamentoSelecionada, tipoSelecionado);
					novoProcedimento = controllerProcedimento.salva(novoProcedimento);

					if (novoProcedimento.getIdProcedimento() != 0) {
						JOptionPane.showMessageDialog(null, "Procedimento salva com sucesso.");
					}
				} else {
					JOptionPane.showMessageDialog(null, mensagem, "Atenção", JOptionPane.WARNING_MESSAGE);

				}
			}
		});
		btnSalvar.setBounds(147, 429, 129, 25);
		add(btnSalvar);

		cbPet = new JComboBox();
		cbPet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		cbPet.setBounds(605, 132, 129, 22);
		add(cbPet);

		PetDAO petDao = new PetDAO();
		ArrayList<Pet> pets = petDao.consultarTodosPet();
		for (Pet pet : pets) {
			cbPet.addItem(pet);
		}
		cbPet.setSelectedIndex(-1);
		JLabel lblPet = new JLabel("Pet:");
		lblPet.setBounds(537, 135, 56, 16);
		add(lblPet);
		cbTipoProcedimento = new JComboBox();
		cbTipoProcedimento.setBounds(605, 199, 129, 22);
		Tipo t1 = new Tipo(1, "Cirurgia");
		Tipo t2 = new Tipo(2, "Tosa");
		Tipo t3 = new Tipo(3, "Castração");
		Tipo t4 = new Tipo(4, "Consulta Periódica");
		cbTipoProcedimento.addItem(t1);
		cbTipoProcedimento.addItem(t2);
		cbTipoProcedimento.addItem(t3);
		cbTipoProcedimento.addItem(t4);
		add(cbTipoProcedimento);
		cbTipoProcedimento.setSelectedIndex(-1);
		JLabel lblTipo_1 = new JLabel("Tipo:");
		lblTipo_1.setBounds(537, 202, 56, 16);
		add(lblTipo_1);

		JLabel lblVeterinrio = new JLabel("Veterin\u00E1rio:");
		lblVeterinrio.setBounds(514, 281, 79, 16);
		add(lblVeterinrio);

		cbVeterinario = new JComboBox();
		cbVeterinario.setBounds(605, 278, 129, 22);
		add(cbVeterinario);

		VeterinarioDAO veterinarioDAO = new VeterinarioDAO();

		ArrayList<Veterinario> veterinarios = veterinarioDAO.consultarTodos();
		for (Veterinario veterinario : veterinarios) {
			cbVeterinario.addItem(veterinario);

		}
		cbVeterinario.setSelectedIndex(-1);
	}
}
