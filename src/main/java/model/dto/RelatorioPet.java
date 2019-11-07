package model.dto;

import java.time.LocalDate;

public class RelatorioPet {
	private int idPet;
	private String cliente;
	private String nome;
	private LocalDate dtNascimento;
	private double peso;
	private String porte;
	private String especie;
	private String raca;
	private String observacao;
	private String sexo;
	private int contagemProcedimentos;
	private double valorTotalProcedimentos;

	public RelatorioPet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RelatorioPet(int idPet, String cliente, String nome, LocalDate dtNascimento, double peso, String porte,
			String especie, String raca, String observacao, String sexo, int contagemProcedimentos,
			double valorTotalProcedimentos) {
		super();
		this.idPet = idPet;
		this.cliente = cliente;
		this.nome = nome;
		this.dtNascimento = dtNascimento;
		this.peso = peso;
		this.porte = porte;
		this.especie = especie;
		this.raca = raca;
		this.observacao = observacao;
		this.sexo = sexo;
		this.contagemProcedimentos = contagemProcedimentos;
		this.valorTotalProcedimentos = valorTotalProcedimentos;
	}

	public int getIdPet() {
		return idPet;
	}

	public void setIdPet(int idPet) {
		this.idPet = idPet;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(LocalDate dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public String getPorte() {
		return porte;
	}

	public void setPorte(String porte) {
		this.porte = porte;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getContagemProcedimentos() {
		return contagemProcedimentos;
	}

	public void setContagemProcedimentos(int contagemProcedimentos) {
		this.contagemProcedimentos = contagemProcedimentos;
	}

	public double getValorTotalProcedimentos() {
		return valorTotalProcedimentos;
	}

	public void setValorTotalProcedimentos(double valorTotalProcedimentos) {
		this.valorTotalProcedimentos = valorTotalProcedimentos;
	}

}
