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
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import Controller.ControllerProcedimento;
import model.vo.Procedimento;

public class CadastrarProcedimento extends JPanel {
	private JTextField txtTitulo;
	private JTextField txtDtEntrada;
	private JTextField txtDtSaida;
	private JTextField txtValor;
	private JTextField txtFormaPagamento;
	private JTextField txtSituacaoPagamento;
	private Procedimento novoProcedimento;
	String[] tipo = new String[4];

	/**
	 * Create the panel.
	 */
	public CadastrarProcedimento() {
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

		txtDtEntrada = new JTextField();
		txtDtEntrada.setBounds(160, 89, 116, 22);
		add(txtDtEntrada);
		txtDtEntrada.setColumns(10);

		JLabel lblDataSada = new JLabel("Data Sa\u00EDda:");
		lblDataSada.setBounds(12, 157, 91, 16);
		add(lblDataSada);

		txtDtSaida = new JTextField();
		txtDtSaida.setBounds(160, 151, 116, 22);
		add(txtDtSaida);
		txtDtSaida.setColumns(10);

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

		txtSituacaoPagamento = new JTextField();
		txtSituacaoPagamento.setBounds(160, 333, 116, 22);
		add(txtSituacaoPagamento);
		txtSituacaoPagamento.setColumns(10);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ControllerProcedimento controllerProcedimento = new ControllerProcedimento();

				String tituloDigitado = txtTitulo.getText();
				String dataEntradaDigitada = txtDtEntrada.getText();
				String dataSaidaDigitada = txtDtSaida.getText();
				String valorDigitada = txtValor.getText();
				String formaPagamentoDigitada = txtFormaPagamento.getText();
				String situacaoPagamentoDigitada = txtSituacaoPagamento.getText();

				String mensagem = controllerProcedimento.validarCamposSalvar(tituloDigitado, dataEntradaDigitada,
						dataSaidaDigitada, valorDigitada, formaPagamentoDigitada, situacaoPagamentoDigitada);
				novoProcedimento = new Procedimento(0, tituloDigitado, dataEntradaDigitada, dataSaidaDigitada,
						valorDigitada, formaPagamentoDigitada, situacaoPagamentoDigitada);
				System.out.println(tituloDigitado + "Saiu do Cadastrar");
				if (mensagem.isEmpty()) {
					novoProcedimento = new Procedimento(0, tituloDigitado, dataEntradaDigitada, dataSaidaDigitada,
							valorDigitada, formaPagamentoDigitada, situacaoPagamentoDigitada);
					novoProcedimento = controllerProcedimento.salva(novoProcedimento);
				} else {
					JOptionPane.showMessageDialog(null, mensagem, "Atenção", JOptionPane.WARNING_MESSAGE);

				}
			}
		});
		btnSalvar.setBounds(458, 406, 129, 25);
		add(btnSalvar);

		tipo[0] = "Cartão à Vista";
		tipo[1] = "Cartão Parcelado";
		tipo[2] = "Dinheiro à Vista";
		tipo[3] = "Dinheiro Parcelado";
		JComboBox cbTipo = new JComboBox();

		cbTipo = new JComboBox(tipo);
		cbTipo.setBounds(458, 51, 129, 22);
		cbTipo.setModel(new DefaultComboBoxModel(
				new String[] { "Cartão à Vista", "Cartão Parcelado", "Dinheiro à Vista", "Dinheiro Parcelado" }));
		add(cbTipo);

		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(367, 54, 56, 16);
		add(lblTipo);

	}
}
