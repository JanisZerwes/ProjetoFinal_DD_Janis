package model.vo;

public class Tipo {
	private int idTipo;
	private String Descricao;

	public Tipo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tipo(int idTipo, String descricao, Procedimento procedimento) {
		super();
		this.idTipo = idTipo;
		Descricao = descricao;

	}

	public int getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}

	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
	}

}
