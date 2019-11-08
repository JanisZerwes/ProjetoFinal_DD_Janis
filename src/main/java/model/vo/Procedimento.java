package model.vo;

import java.time.LocalDate;

public class Procedimento {
	private int idProcedimento;
	private Pet pet;
	private Veterinario veterinario;
	private String titulo;
	private LocalDate dtEntrada;
	private LocalDate dtSaida;
	private double valor;
	private String formaPagamento;
	private boolean situacaoPagamento;
	private Tipo tipo;

	public Procedimento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Procedimento(int idProcedimento, Pet pet, Veterinario veterinario, String titulo, LocalDate dtEntrada,
			LocalDate dtSaida, double valor, String formaPagamento, boolean situacaoPagamento, Tipo tipo) {
		super();
		this.idProcedimento = idProcedimento;
		this.pet = pet;
		this.veterinario = veterinario;
		this.titulo = titulo;
		this.dtEntrada = dtEntrada;
		this.dtSaida = dtSaida;
		this.valor = valor;
		this.formaPagamento = formaPagamento;
		this.situacaoPagamento = situacaoPagamento;
		this.tipo = tipo;
	}

	public Procedimento(int i, String tituloDigitado, String dataEntradaDigitada, String dataSaidaDigitada,
			String valorDigitada, String formaPagamentoDigitada, String situacaoPagamentoDigitada) {
		// TODO Auto-generated constructor stub
	}

	public int getIdProcedimento() {
		return idProcedimento;
	}

	public void setIdProcedimento(int idProcedimento) {
		this.idProcedimento = idProcedimento;
	}

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

	public Veterinario getVeterinario() {
		return veterinario;
	}

	public void setVeterinario(Veterinario veterinario) {
		this.veterinario = veterinario;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public LocalDate getDtEntrada() {
		return dtEntrada;
	}

//oie
	public void setDtEntrada(LocalDate dtEntrada) {
		this.dtEntrada = dtEntrada;
	}

	public LocalDate getDtSaida() {
		return dtSaida;
	}

	public void setDtSaida(LocalDate dtSaida) {
		this.dtSaida = dtSaida;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public boolean isSituacaoPagamento() {
		return situacaoPagamento;
	}

	public Boolean getSituacaoPagamento() {
		return situacaoPagamento;
	}

	public void setSituacaoPagamento(boolean situacaoPagamento) {
		this.situacaoPagamento = situacaoPagamento;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public static Procedimento salvar(Procedimento novoProcedimento) {
		// TODO Auto-generated method stub
		return null;
	}

}
