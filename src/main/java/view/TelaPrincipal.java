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
import javax.swing.JPanel;

public class TelaPrincipal {

	private JFrame frmClnicaVeterinria;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
					window.frmClnicaVeterinria.setVisible(true);
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
		frmClnicaVeterinria = new JFrame();
		frmClnicaVeterinria.setTitle("Clínica Veterinária");
		criarPainelVerde();

		frmClnicaVeterinria.setBounds(100, 100, 963, 678);
		frmClnicaVeterinria.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		frmClnicaVeterinria.setJMenuBar(menuBar);

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
				frmClnicaVeterinria.setContentPane(cadastrarC);
				frmClnicaVeterinria.revalidate();
			}
		});
		mnCliente.add(mntmCadastroCliente);

		JMenuItem mntmCosultaCliente = new JMenuItem("Consultar");
		mntmCosultaCliente.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		mntmCosultaCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultarCliente consultarCliente = new ConsultarCliente();
				frmClnicaVeterinria.setContentPane(consultarCliente);
				frmClnicaVeterinria.revalidate();
				consultarCliente.getBtnVoltar().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// mudar o contentPane da tela principal para verde
						criarPainelVerde();
					}

				});

			}
		});
		mnCliente.add(mntmCosultaCliente);

		JMenu mnVeterinrio = new JMenu("Veterinário");
		mnVeterinrio.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/png/icons8-m\u00E9dico-80.png")));
		mnVeterinrio.setForeground(Color.BLACK);
		mnVeterinrio.setFont(new Font("Segoe UI", Font.BOLD, 20));
		menuBar.add(mnVeterinrio);

		JMenuItem mntmCadastroVeterinario = new JMenuItem("Cadastrar");
		mntmCadastroVeterinario.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		mntmCadastroVeterinario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarVeterinario cadastrarVeterinario = new CadastrarVeterinario();
				frmClnicaVeterinria.setContentPane(cadastrarVeterinario);
				frmClnicaVeterinria.revalidate();
			}
		});
		mnVeterinrio.add(mntmCadastroVeterinario);

		JMenuItem mntmConsultarVeterinario = new JMenuItem("Consultar");
		mntmConsultarVeterinario.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		mntmConsultarVeterinario.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				ConsultarVeterinario consultarVeterinario = new ConsultarVeterinario();
				frmClnicaVeterinria.setContentPane(consultarVeterinario);
				frmClnicaVeterinria.revalidate();
				consultarVeterinario.getBtnVoltar().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// mudar o contentPane da tela principal para verde
						criarPainelVerde();
					}

				});

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
				frmClnicaVeterinria.setContentPane(cadastrarPet);
				frmClnicaVeterinria.revalidate();
			}
		});
		mnPet.add(mntmCadastroPet);

		JMenuItem mntmConsultarPet = new JMenuItem("Consultar");
		mntmConsultarPet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConsultarPet consultarPet = new ConsultarPet();
				frmClnicaVeterinria.setContentPane(consultarPet);
				frmClnicaVeterinria.revalidate();
				consultarPet.getBtnVoltar().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// mudar o contentPane da tela principal para verde
						criarPainelVerde();

					}
				});
			}
		});
		mntmConsultarPet.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		mnPet.add(mntmConsultarPet);

		JMenu mnProcedimentos = new JMenu("Procedimentos");
		mnProcedimentos.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/png/004-calendar.png")));
		mnProcedimentos.setFont(new Font("Segoe UI", Font.BOLD, 20));
		mnProcedimentos.setForeground(Color.BLACK);
		menuBar.add(mnProcedimentos);

		JMenuItem mntmCadastroProcedimento = new JMenuItem("Cadastrar");
		mntmCadastroProcedimento.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		mntmCadastroProcedimento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarProcedimento cadastrarProcedimento = new CadastrarProcedimento();
				frmClnicaVeterinria.setContentPane(cadastrarProcedimento);
				frmClnicaVeterinria.revalidate();

			}
		});
		mnProcedimentos.add(mntmCadastroProcedimento);

		JMenuItem mntmConsultaProcedimento = new JMenuItem("Consulta");
		mntmConsultaProcedimento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultarProcedimento consultarProcedimento = new ConsultarProcedimento();
				frmClnicaVeterinria.setContentPane(consultarProcedimento);
				frmClnicaVeterinria.revalidate();

				consultarProcedimento.getBtnVoltar().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// mudar o contentPane da tela principal para verde
						criarPainelVerde();
					}
				});
			}
		});
		mntmConsultaProcedimento.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		mnProcedimentos.add(mntmConsultaProcedimento);

		JMenu mnSobre = new JMenu("Sobre");
		mnSobre.setIcon(
				new ImageIcon(TelaPrincipal.class.getResource("/icones/png/007-questions-about-abecedary.png")));
		mnSobre.setFont(new Font("Segoe UI", Font.BOLD, 20));
		mnSobre.setForeground(Color.BLACK);
		menuBar.add(mnSobre);
	}

	private void criarPainelVerde() {
		frmClnicaVeterinria.setContentPane(new JPanel());
		frmClnicaVeterinria.getContentPane().setBackground(Color.GREEN);
		frmClnicaVeterinria.getContentPane().setLayout(null);
		frmClnicaVeterinria.revalidate();
	}
}
