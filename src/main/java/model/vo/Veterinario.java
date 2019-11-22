package model.vo;

import model.dao.VeterinarioDAO;

public class Veterinario extends Pessoa {
	private int idVeterinario;
	private String certificado;
	private String crmv;
	private int veterinario;

	public Veterinario(int idVeterinario, String nome, String sobrenome, String endereco, String sexo, String cpf,
			String telefone, String email) {
		super(nome, sobrenome, endereco, sexo, cpf, telefone, email);
	}

	@Override
	public String toString() {
		return "Veterinario [idVeterinario=" + idVeterinario + ", certificado=" + certificado + ", crmv=" + crmv
				+ ", veterinario=" + veterinario + "]";
	}

	public Veterinario(int i, String nomeDigitado, String sobrenomeDigitado, String enderecoDigitado,
			String sexoDigitado, String cpfDigitado, String telefoneDigitado, String emailDigitado,
			String certificadoDigitado, String crmvDigitado) {
		this.idVeterinario = idVeterinario;
		this.certificado = certificado;
		this.crmv = crmv;

		this.veterinario = veterinario;
	}

	public Veterinario() {
		// TODO Auto-generated constructor stub
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

	public Veterinario consultarVeterinarioBO(Veterinario veterinarioVO) {
		VeterinarioDAO veterinarioDAO = new VeterinarioDAO();
		veterinarioVO = veterinarioDAO.consultarVeterinarioPorID(veterinarioVO.getIdVeterinario());
		return veterinarioVO;
	}

}
