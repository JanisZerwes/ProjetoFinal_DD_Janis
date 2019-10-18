package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class TelaPrincipal {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.GREEN);
		frame.setBounds(100, 100, 1066, 615);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnCliente = new JMenu("Cliente");
		mnCliente.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/icones/icons8-fila.png")));
		mnCliente.setForeground(Color.BLACK);
		mnCliente.setFont(new Font("Segoe UI", Font.BOLD, 20));
		menuBar.add(mnCliente);

		JMenuItem mntmCadastroCliente = new JMenuItem("Cadastrar");
		mntmCadastroCliente.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		mntmCadastroCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarCliente cadastrarC = new CadastrarCliente();
				frame.setContentPane(cadastrarC);
				frame.revalidate();
			}
		});
		mnCliente.add(mntmCadastroCliente);

		JMenuItem mntmCosultaCliente = new JMenuItem("Consultar");
		mntmCosultaCliente.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		mntmCosultaCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultarCliente consultarCliente = new ConsultarCliente();
				frame.setContentPane(consultarCliente);
				frame.revalidate();
			}
		});
		mnCliente.add(mntmCosultaCliente);

		JMenu mnVeterinrio = new JMenu("Veterin\u00E1rio");
		mnVeterinrio.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/png/icons8-m\u00E9dico-80.png")));
		mnVeterinrio.setForeground(Color.BLACK);
		mnVeterinrio.setFont(new Font("Segoe UI", Font.BOLD, 20));
		menuBar.add(mnVeterinrio);

		JMenuItem mntmCadastroVeterinario = new JMenuItem("Cadastrar");
		mntmCadastroVeterinario.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		mntmCadastroVeterinario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarVeterinario cadastrarVeterinario = new CadastrarVeterinario();
				frame.setContentPane(cadastrarVeterinario);
				frame.revalidate();
			}
		});
		mnVeterinrio.add(mntmCadastroVeterinario);

		JMenuItem mntmConsultarVeterinario = new JMenuItem("Consultar");
		mntmConsultarVeterinario.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		mntmConsultarVeterinario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultarVeterinario consultarVeterinario = new ConsultarVeterinario();
				frame.setContentPane(consultarVeterinario);
				frame.revalidate();
			}
		});
		mnVeterinrio.add(mntmConsultarVeterinario);

		JMenu mnPet = new JMenu("Pet");
		mnPet.setIcon(
				new ImageIcon(TelaPrincipal.class.getResource("/icones/icones/icons8-pegada-de-cachorro-80.png")));
		mnPet.setFont(new Font("Segoe UI", Font.BOLD, 20));
		mnPet.setForeground(Color.BLACK);
		menuBar.add(mnPet);

		JMenuItem mntmCadastroPet = new JMenuItem("Cadastrar");
		mntmCadastroPet.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		mntmCadastroPet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarPet cadastrarPet = new CadastrarPet();
				frame.setContentPane(cadastrarPet);
				frame.revalidate();
			}
		});
		mnPet.add(mntmCadastroPet);

		JMenuItem mntmConsultarPet = new JMenuItem("Consultar");
		mntmConsultarPet.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		mnPet.add(mntmConsultarPet);

		JMenu mnProcedimentos = new JMenu("Procedimentos");
		mnProcedimentos.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/png/004-calendar.png")));
		mnProcedimentos.setFont(new Font("Segoe UI", Font.BOLD, 20));
		mnProcedimentos.setForeground(Color.BLACK);
		menuBar.add(mnProcedimentos);

		JMenuItem mntmCadastroProcedimento = new JMenuItem("Cadastro");
		mntmCadastroProcedimento.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		mntmCadastroProcedimento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarProcedimento cadastrarProcedimento = new CadastrarProcedimento();
				frame.setContentPane(cadastrarProcedimento);
				frame.revalidate();

			}
		});
		mnProcedimentos.add(mntmCadastroProcedimento);

		JMenuItem mntmConsultaProcedimento = new JMenuItem("Consulta");
		mntmConsultaProcedimento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultarProcedimento consultarProcedimento = new ConsultarProcedimento();
				frame.setContentPane(consultarProcedimento);
				frame.revalidate();
			}
		});
		mntmConsultaProcedimento.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		mnProcedimentos.add(mntmConsultaProcedimento);

		JMenu mnRelatrio = new JMenu("Relat\u00F3rio");
		mnRelatrio.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/png/006-newspaper.png")));
		mnRelatrio.setFont(new Font("Segoe UI", Font.BOLD, 20));
		mnRelatrio.setForeground(Color.BLACK);
		menuBar.add(mnRelatrio);

		JMenuItem mntmGerarRelatrio = new JMenuItem("Gerar Relat\u00F3rio");
		mntmGerarRelatrio.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		mnRelatrio.add(mntmGerarRelatrio);

		JMenu mnSobre = new JMenu("Sobre");
		mnSobre.setIcon(
				new ImageIcon(TelaPrincipal.class.getResource("/icones/png/007-questions-about-abecedary.png")));
		mnSobre.setFont(new Font("Segoe UI", Font.BOLD, 20));
		mnSobre.setForeground(Color.BLACK);
		menuBar.add(mnSobre);
	}
}
