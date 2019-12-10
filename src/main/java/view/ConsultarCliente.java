package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import Controller.ControllerCliente;
import model.dao.ClienteDAO;
import model.dto.RelatorioCliente;
import model.vo.Cliente;

public class ConsultarCliente extends JPanel {
	private ArrayList<Cliente> dadosNovoCliente;

	private JButton btnVoltar;

	public JButton getBtnVoltar() {
		return btnVoltar;
	}

	private Cliente novoCliente = null;
	Locale ptBr = new Locale("pt", "BR");
	NumberFormat formato = NumberFormat.getCurrencyInstance(ptBr);

	private JTable tblClientes;
	private String[] colunas = { "#", "Nome", "Sobrenome", "Endereço", "Sexo", "CPF", "Telefone", "Email",
			"Adimplente" };

	public ConsultarCliente() {
		setBorder(new LineBorder(Color.GREEN, 4));
		setLayout(null);

		tblClientes = new JTable();
		tblClientes.setModel(new DefaultTableModel(new Object[][] { colunas }, colunas));
		tblClientes.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		// frame.getContentPane().add(tblClientes, "cell 1 5 6 1,grow");
		tblClientes.setBounds(12, 26, 717, 259);
		add(tblClientes);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				limparTela();
				ControllerCliente controllerClienteConsultar = new ControllerCliente();
				ArrayList<Cliente> clienteTabela = controllerClienteConsultar.consultarTodosClientesController();

				DefaultTableModel model = (DefaultTableModel) tblClientes.getModel();
				for (int i = 0; i < clienteTabela.size(); i++) {
					String[] novaLinha = new String[9];

					System.out.println(clienteTabela.get(i).getIdCliente());
					novaLinha[0] = clienteTabela.get(i).getIdCliente() + "";
					novaLinha[1] = clienteTabela.get(i).getNome();
					novaLinha[2] = clienteTabela.get(i).getSobrenome();
					novaLinha[3] = clienteTabela.get(i).getEndereco();
					novaLinha[4] = clienteTabela.get(i).getSexo();
					novaLinha[5] = clienteTabela.get(i).getCpf();
					novaLinha[6] = clienteTabela.get(i).getTelefone();
					novaLinha[7] = clienteTabela.get(i).getEmail();
					novaLinha[8] = clienteTabela.get(i).getAdimplente() ? "Sim" : "Não";

					model.addRow(novaLinha);
				}

			}
		});

		btnConsultar.setBounds(32, 340, 97, 25);
		add(btnConsultar);

		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Cliente clienteSelecionado = new Cliente();

				try {
					Object idSelecionado = tblClientes.getModel().getValueAt(tblClientes.getSelectedRow(), 0);
					clienteSelecionado.setIdCliente(Integer.valueOf((String) idSelecionado));
					AtualizarClienteFrame atualizarCliente = new AtualizarClienteFrame(clienteSelecionado);
					atualizarCliente.setVisible(true);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Selecione uma linha");
					System.out.println(e2.getMessage());
				}

			}
		});
		btnAtualizar.setBounds(162, 340, 97, 25);
		add(btnAtualizar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Cliente clienteSelecionado = new Cliente();

				try {
					Object idSelecionado = tblClientes.getModel().getValueAt(tblClientes.getSelectedRow(), 0);
					clienteSelecionado.setIdCliente(Integer.valueOf((String) idSelecionado));
					ControllerCliente controladoraCliente = new ControllerCliente();
					boolean excluiu = controladoraCliente.excluirClienteController(clienteSelecionado);

					if (excluiu) {
						JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso");
					} else {
						JOptionPane.showMessageDialog(null, "Impossível excluir, clientes com animais cadastrados");
					}

				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Selecione uma linha");
					System.out.println(e2.getMessage());
				}

			}
		});
		btnExcluir.setBounds(315, 340, 97, 25);
		add(btnExcluir);

		btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(480, 340, 97, 25);
		add(btnVoltar);

		JButton btnGerarRelatorio = new JButton("Gerar Relatório");
		btnGerarRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser jfc = new JFileChooser();
				jfc.setDialogTitle("Salvar relatório como...");
				int resultado = jfc.showSaveDialog(null);
				if (resultado == JFileChooser.APPROVE_OPTION) {
					String caminhoEscolhido = jfc.getSelectedFile().getAbsolutePath();

					ControllerCliente controllerCliente = new ControllerCliente();
					ArrayList<Cliente> clientesConsultados = controllerCliente.consultarTodosClientesController();

					ClienteDAO dao = new ClienteDAO();
//
					ArrayList<RelatorioCliente> clientesCompleto = dao.consultarRelatorioCliente();
//
//					// controllerPet.gerarRelatorio(petsConsultados, caminhoEscolhido);
//
					controllerCliente.gerarRelatorioCompleto(clientesCompleto, caminhoEscolhido);
				}
			}
		});
		btnGerarRelatorio.setBounds(610, 340, 119, 25);
		add(btnGerarRelatorio);

	}

	private void limparTela() {
		tblClientes.setModel(new DefaultTableModel(new Object[][] { colunas }, colunas));
	}
}
