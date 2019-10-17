package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GREEN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setToolTipText("");
		menuBar.setBounds(0, 0, 770, 26);
		contentPane.add(menuBar);

		JMenu mnNewMenu = new JMenu("Cliente");
		mnNewMenu.setForeground(Color.BLACK);
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 20));
		menuBar.add(mnNewMenu);

		JMenuItem mntmCadastrar = new JMenuItem("Cadastrar");
		mntmCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane = new CadastrarCliente();
				setContentPane(contentPane);
				revalidate();
			}
		});
		mnNewMenu.add(mntmCadastrar);

		JMenuItem mntmConsultar_1 = new JMenuItem("Consultar");
		mntmConsultar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane = new ConsultarCliente();
				setContentPane(contentPane);
				revalidate();
			}
		});
		mnNewMenu.add(mntmConsultar_1);

		JMenu mnVeterinrio = new JMenu("Veterin\u00E1rio");
		mnVeterinrio.setBackground(Color.GREEN);
		mnVeterinrio.setForeground(Color.BLACK);
		mnVeterinrio.setFont(new Font("Segoe UI", Font.BOLD, 20));
		menuBar.add(mnVeterinrio);

		JMenuItem mntmCadastrar_1 = new JMenuItem("Cadastrar");
		mnVeterinrio.add(mntmCadastrar_1);

		JMenuItem mntmConsultar_2 = new JMenuItem("Consultar");
		mnVeterinrio.add(mntmConsultar_2);

		JMenu mnPaciente = new JMenu("Pet");
		mnPaciente.setFont(new Font("Segoe UI", Font.BOLD, 20));
		mnPaciente.setForeground(Color.BLACK);
		menuBar.add(mnPaciente);

		JMenuItem mntmCadastro = new JMenuItem("Cadastro");
		mntmCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane = new CadastrarPet();
				setContentPane(contentPane);
				revalidate();
			}
		});
		mnPaciente.add(mntmCadastro);

		JMenuItem mntmConsultar = new JMenuItem("Consultar");
		mntmConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane = new ConsultarPet();
				setContentPane(contentPane);
				revalidate();
			}
		});
		mnPaciente.add(mntmConsultar);

		JMenu mnProcedimento = new JMenu("Procedimento");
		mnProcedimento.setFont(new Font("Segoe UI", Font.BOLD, 20));
		mnProcedimento.setForeground(Color.BLACK);
		menuBar.add(mnProcedimento);

		JMenuItem mntmCadastrar_2 = new JMenuItem("Cadastrar");
		mnProcedimento.add(mntmCadastrar_2);

		JMenuItem mntmConsultar_3 = new JMenuItem("Consultar");
		mnProcedimento.add(mntmConsultar_3);

		JMenu mnRelatrio = new JMenu("Relat\u00F3rio");
		mnRelatrio.setForeground(Color.BLACK);
		mnRelatrio.setFont(new Font("Segoe UI", Font.BOLD, 20));
		menuBar.add(mnRelatrio);

		JMenuItem mntmGerarRelatrio = new JMenuItem("Gerar Relat\u00F3rio");
		mnRelatrio.add(mntmGerarRelatrio);

		JMenu mnSobre = new JMenu("Sobre");
		mnSobre.setForeground(Color.BLACK);
		mnSobre.setFont(new Font("Segoe UI", Font.BOLD, 20));
		menuBar.add(mnSobre);
	}
}
