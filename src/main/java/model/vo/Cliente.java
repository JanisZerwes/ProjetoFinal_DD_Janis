package model.vo;

public class Cliente extends Pessoa {
	private Boolean adimplente;
	private int idCliente;

	public Cliente() {

	}

	public Cliente(String nome, String sobrenome, String endereco, String sexo, String cpf, String telefone,
			String email, Boolean adimplente, int idCliente) {
		super(nome, sobrenome, endereco, sexo, cpf, telefone, email);
		this.adimplente = adimplente;
		this.idCliente = idCliente;
	}

	public Boolean getAdimplente() {
		return adimplente;
	}

	public void setAdimplente(Boolean adimplente) {
		this.adimplente = adimplente;

	}

	@Override
	public String toString() {
		return "Cliente [adimplente=" + adimplente + ", idCliente=" + idCliente + ", nome=" + nome + ", sobrenome="
				+ sobrenome + ", endereco=" + endereco + ", sexo=" + sexo + ", cpf=" + cpf + ", telefone=" + telefone
				+ ", email=" + email + "]";
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getIdCliente() {
		// TODO Auto-generated method stub
		return idCliente;
	}

}
