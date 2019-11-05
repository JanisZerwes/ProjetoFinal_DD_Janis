package model.vo;

public class Cliente extends Pessoa {
	private Boolean adimplente;
	private int idCliente;

	public Cliente() {

	}

	public Cliente(int idCliente, String nome, String sobrenome, String endereco, String sexo, String cpf,
			String telefone, String email, Boolean adimplente) {
		super();
		this.adimplente = adimplente;
		this.idCliente = idCliente;
	}

	public Boolean getAdimplente() {
		return adimplente;
	}

	public void setAdimplente(Boolean adimplente) {
		this.adimplente = adimplente;

	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getIdCliente() {
		// TODO Auto-generated method stub
		return idCliente;
	}

}
