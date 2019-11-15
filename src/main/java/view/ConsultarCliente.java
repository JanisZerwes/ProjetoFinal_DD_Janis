package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import Controller.ControllerCliente;
import model.vo.Cliente;

public class ConsultarCliente extends JPanel {
	private ArrayList<Cliente> dadosNovoCliente;

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

		btnConsultar.setBounds(12, 340, 97, 25);
		add(btnConsultar);

		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object idSelecionado = tblClientes.getModel().getValueAt(tblClientes.getSelectedRow(), 0);

				Cliente clienteSelecionado = new Cliente();
				clienteSelecionado.setIdCliente(Integer.valueOf((String) idSelecionado));

				AtualizarCliente atualizarCliente = new AtualizarCliente();
				frame.setContentPane(atualizarCliente);
				frame.revalidate();

			}
		});
		btnAtualizar.setBounds(141, 340, 97, 25);
		add(btnAtualizar);

		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(302, 340, 97, 25);
		add(btnAdicionar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(468, 340, 97, 25);
		add(btnExcluir);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(603, 340, 97, 25);
		add(btnVoltar);

	}
}
