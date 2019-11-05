package model.vo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Pet {
	private int idPet;
	private Cliente cliente;
	private String nome;
	private LocalDate dtNascimento;
	private double peso;
	private String porte;
	private String especie;
	private String raca;
	private String observacao;
	private String sexo;

	DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern(" yyyy-MM-dd ");

	public Pet(int idPet, String nomePetDigitado, String pesoPetDigitado, String porteDigitado, String racaDigitada,
			String dataNascimentoDigitada, String sexo) {
		super();

	}

	public Pet(int idPet, Cliente cliente, String nome, LocalDate dtNascimento, double peso, String porte,
			String especie, String raca, String sexo) {

		super();
		this.idPet = idPet;
		this.cliente = cliente;
		this.nome = nome;
		this.dtNascimento = dtNascimento;
		this.peso = peso;
		this.porte = porte;
		this.especie = especie;
		this.raca = raca;
		this.sexo = sexo;

	}

	public Pet() {
		// TODO Auto-generated constructor stub
	}

	public int getIdPet() {
		return idPet;
	}

	public void setIdPet(int idPet) {
		this.idPet = idPet;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
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

}
