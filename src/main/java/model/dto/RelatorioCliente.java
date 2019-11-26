package model.dto;

import model.vo.Pessoa;

public class RelatorioCliente extends Pessoa {
	private Boolean adimplente;
	private int idCliente;

	public Boolean getAdimplente() {
		return adimplente;
	}

	public void setAdimplente(Boolean adimplente) {
		this.adimplente = adimplente;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public RelatorioCliente() {
		super();

	}

	public RelatorioCliente(int idCliente, Boolean adimplente, String nome, String sobrenome, String endereco,
			String sexo, String cpf, String telefone, String email) {
		super();
		this.idCliente = idCliente;
		this.adimplente = adimplente;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.endereco = endereco;
		this.sexo = sexo;
		this.cpf = cpf;
		this.telefone = telefone;
		this.email = email;
	}

}
