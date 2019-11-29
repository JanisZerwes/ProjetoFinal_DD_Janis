package model.dto;

import java.sql.Date;

import model.vo.Pessoa;

public class SeletorCliente extends Pessoa {
	private int idClienteSeletor;
	private String nomeCliente;
	private Boolean adimplenteSeletor;
	private Date dataInicioCadastro;
	private Date dataFinalCadastro;
	private int limite;
	private int pagina;

	public SeletorCliente(int idClienteSeletor, String nomeCliente, Boolean adimplenteSeletor, Date dataInicioCadastro,
			Date dataFinalCadastro, int limite, int pagina) {
		super();
		this.idClienteSeletor = idClienteSeletor;
		this.nomeCliente = nomeCliente;
		this.adimplenteSeletor = adimplenteSeletor;
		this.dataInicioCadastro = dataInicioCadastro;
		this.dataFinalCadastro = dataFinalCadastro;
		this.limite = limite;
		this.pagina = pagina;
	}

	public SeletorCliente() {
		super();

	}

	public int getIdClienteSeletor() {
		return idClienteSeletor;
	}

	public void setIdClienteSeletor(int idClienteSeletor) {
		this.idClienteSeletor = idClienteSeletor;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public Boolean getAdimplenteSeletor() {
		return adimplenteSeletor;
	}

	public void setAdimplenteSeletor(Boolean adimplenteSeletor) {
		this.adimplenteSeletor = adimplenteSeletor;
	}

	public Date getDataInicioCadastro() {
		return dataInicioCadastro;
	}

	public void setDataInicioCadastro(Date dataInicioCadastro) {
		this.dataInicioCadastro = dataInicioCadastro;
	}

	public Date getDataFinalCadastro() {
		return dataFinalCadastro;
	}

	public void setDataFinalCadastro(Date dataFinalCadastro) {
		this.dataFinalCadastro = dataFinalCadastro;
	}

	public int getLimite() {
		return limite;
	}

	public void setLimite(int limite) {
		this.limite = limite;
	}

	public int getPagina() {
		return pagina;
	}

	public void setPagina(int pagina) {
		this.pagina = pagina;
	}

	public SeletorCliente(String nome, String sobrenome, String endereco, String sexo, String cpf, String telefone,
			String email) {
		super(nome, sobrenome, endereco, sexo, cpf, telefone, email);
		// TODO Auto-generated constructor stub
	}

	public void ClienteSeletor() {
		this.limite = 0;
		this.pagina = -1;

	}

	public boolean temPaginacao() {
		return ((this.limite > 0) && (this.pagina > -1));
	}

	public int getOffset() {
		return (this.limite * (this.pagina - 1));
	}

}
