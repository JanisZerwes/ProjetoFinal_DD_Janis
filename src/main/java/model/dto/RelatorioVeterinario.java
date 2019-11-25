package model.dto;

import model.vo.Pessoa;

public class RelatorioVeterinario extends Pessoa {
	private int idVeterinario;
	private String certificado;
	private String crmv;
	private int veterinario;

	public RelatorioVeterinario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RelatorioVeterinario(int idVeterinario, String certificado, String crmv, int veterinario, String nome,
			String sobrenome, String endereco, String sexo, String cpf, String telefone, String email) {
		super();
		this.idVeterinario = idVeterinario;
		this.certificado = certificado;
		this.crmv = crmv;
		this.veterinario = veterinario;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.endereco = endereco;
		this.sexo = sexo;
		this.cpf = cpf;
		this.telefone = telefone;
		this.email = email;
	}

	public int getIdVeterinario() {
		return idVeterinario;
	}

	public void setIdVeterinario(int idVeterinario) {
		this.idVeterinario = idVeterinario;
	}

	public String getCertificado() {
		return certificado;
	}

	public void setCertificado(String certificado) {
		this.certificado = certificado;
	}

	public String getCrmv() {
		return crmv;
	}

	public void setCrmv(String crmv) {
		this.crmv = crmv;
	}

	public int getVeterinario() {
		return veterinario;
	}

	public void setVeterinario(int veterinario) {
		this.veterinario = veterinario;
	}

}
