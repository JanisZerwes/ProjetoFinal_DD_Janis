package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

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

import com.github.lgooddatepicker.components.DatePicker;

import Controller.ControllerProcedimento;
import model.dao.PetDAO;
import model.dao.VeterinarioDAO;
import model.vo.Pet;
import model.vo.Procedimento;
import model.vo.Tipo;
import model.vo.Veterinario;

public class AtualizarProcedimentoFrame extends JFrame {
	DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	private DatePicker dataEntrada;
	private DatePicker dataSaida;
	private JPanel contentPane;
	private JTextField txtTitulo;
	private JTextField txtDtEntrada;
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

	public AtualizarProcedimentoFrame(Procedimento procedimentoSelecionado) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 867, 570);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		ControllerProcedimento controllerProcedimento = new ControllerProcedimento();

		procedimentoSelecionado = controllerProcedimento.consultarProcedimentoController(procedimentoSelecionado);
		getContentPane().setLayout(null);
		contentPane.setLayout(null);

		JLabel lblTtulo = new JLabel("T\u00EDtulo:");
		lblTtulo.setBounds(12, 37, 56, 16);
		getContentPane().add(lblTtulo);

		txtTitulo = new JTextField();
		txtTitulo.setBounds(158, 34, 116, 22);
		getContentPane().add(txtTitulo);
		txtTitulo.setColumns(10);
		txtTitulo.setText(procedimentoSelecionado.getTitulo());

		JLabel lblDataEntrada = new JLabel("Data Entrada:");
		lblDataEntrada.setBounds(12, 92, 91, 16);
		getContentPane().add(lblDataEntrada);

		dataEntrada = new DatePicker();
		dataEntrada.setBounds(160, 89, 300, 30);
		getContentPane().add(dataEntrada);
		dataEntrada.setText(String.valueOf(procedimentoSelecionado.getDtEntrada()));

		dataSaida = new DatePicker();
		dataSaida.setBounds(160, 151, 300, 30);
		getContentPane().add(dataSaida);
		dataSaida.setText(String.valueOf(procedimentoSelecionado.getDtSaida()));

		JLabel lblDataSada = new JLabel("Data Sa\u00EDda:");
		lblDataSada.setBounds(12, 157, 91, 16);
		getContentPane().add(lblDataSada);

		txtDtSaida = new JTextField();
		txtDtSaida.setBounds(212, 154, 116, 22);
		getContentPane().add(txtDtSaida);
		txtDtSaida.setColumns(10);
		txtDtSaida.setText(String.valueOf(procedimentoSelecionado.getDtSaida()));

		JLabel lblValor = new JLabel("Valor:");
		lblValor.setBounds(12, 222, 56, 16);
		getContentPane().add(lblValor);

		txtValor = new JTextField();
		txtValor.setBounds(212, 219, 116, 22);
		getContentPane().add(txtValor);
		txtValor.setColumns(10);
		txtValor.setText(procedimentoSelecionado.getValor() + "");

		JLabel lblFormaPagamento = new JLabel("Forma Pagamento:");
		lblFormaPagamento.setBounds(12, 281, 116, 16);
		getContentPane().add(lblFormaPagamento);

		txtFormaPagamento = new JTextField();
		txtFormaPagamento.setBounds(212, 278, 116, 22);
		getContentPane().add(txtFormaPagamento);
		txtFormaPagamento.setColumns(10);
		txtFormaPagamento.setText(procedimentoSelecionado.getFormaPagamento());

		JLabel lblSituaoPagamento = new JLabel("Situa\u00E7\u00E3o Pagamento:");
		lblSituaoPagamento.setBounds(12, 336, 136, 16);
		getContentPane().add(lblSituaoPagamento);

		cbTipoPagamento = new JComboBox(tipo);
		cbTipoPagamento.setBounds(646, 34, 129, 22);
		cbTipoPagamento.setModel(new DefaultComboBoxModel(
				new String[] { "Cartão à Vista", "Cartão Parcelado", "Dinheiro à Vista", "Dinheiro Parcelado" }));
		getContentPane().add(cbTipoPagamento);
		cbTipoPagamento.setSelectedIndex(-1);
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(557, 37, 56, 16);
		getContentPane().add(lblTipo);

//		cbTipoPagamento.setSelectedIndex(0);

		rbSim = new JRadioButton("Sim");
		rbSim.setBounds(147, 332, 127, 25);
		getContentPane().add(rbSim);

		rbNao = new JRadioButton("Não");
		rbNao.setBounds(147, 362, 127, 25);
		getContentPane().add(rbNao);

		if (procedimentoSelecionado.getSituacaoPagamento()) {
			rbSim.setSelected(true);
			rbNao.setSelected(false);
		} else {
			rbSim.setSelected(false);
			rbNao.setSelected(true);
		}

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ControllerProcedimento controllerProcedimento = new ControllerProcedimento();

				String tituloDigitado = txtTitulo.getText();
				String dataEntradaDigitada = txtDtEntrada.getText();
				String dataSaidaDigitada = txtDtSaida.getText();
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
							LocalDate.parse(dataEntradaDigitada, dataFormatter),
							LocalDate.parse(dataSaidaDigitada, dataFormatter), Double.valueOf(valorDigitada),
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
		btnSalvar.setBounds(646, 362, 129, 25);
		getContentPane().add(btnSalvar);
		cbPet = new JComboBox();
		cbPet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		cbPet.setBounds(646, 89, 129, 22);
		getContentPane().add(cbPet);

		PetDAO petDao = new PetDAO();
		ArrayList<Pet> pets = petDao.consultarTodosPet();
		for (Pet pet : pets) {
			cbPet.addItem(pet);
		}
		cbPet.setSelectedIndex(-1);
		JLabel lblPet = new JLabel("Pet:");
		lblPet.setBounds(557, 92, 56, 16);
		getContentPane().add(lblPet);
		cbTipoProcedimento = new JComboBox();
		cbTipoProcedimento.setBounds(646, 154, 129, 22);
		Tipo t1 = new Tipo(1, "Cirurgia");
		Tipo t2 = new Tipo(2, "Tosa");
		Tipo t3 = new Tipo(3, "Castração");
		Tipo t4 = new Tipo(4, "Consulta Periódica");
		cbTipoProcedimento.addItem(t1);
		cbTipoProcedimento.addItem(t2);
		cbTipoProcedimento.addItem(t3);
		cbTipoProcedimento.addItem(t4);
		getContentPane().add(cbTipoProcedimento);
		cbTipoProcedimento.setSelectedIndex(-1);
		JLabel lblTipo_1 = new JLabel("Tipo:");
		lblTipo_1.setBounds(557, 157, 56, 16);
		getContentPane().add(lblTipo_1);

		cbVeterinario = new JComboBox();
		cbVeterinario.setBounds(646, 219, 129, 22);
		getContentPane().add(cbVeterinario);

		JLabel lblVeterinrio = new JLabel("Veterin\u00E1rio:");
		lblVeterinrio.setBounds(546, 222, 79, 16);
		getContentPane().add(lblVeterinrio);

		VeterinarioDAO veterinarioDAO = new VeterinarioDAO();

		ArrayList<Veterinario> veterinarios = veterinarioDAO.consultarTodos();
		for (Veterinario veterinario : veterinarios) {
			cbVeterinario.addItem(veterinario);

		}
		cbVeterinario.setSelectedIndex(-1);

	}

}
