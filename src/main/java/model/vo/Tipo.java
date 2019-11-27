package model.vo;

public class Tipo {
	private int idTipo;
	private String descricao;

	@Override
	public String toString() {
		return descricao;
	}

	public Tipo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tipo(int idTipo, String descricao) {
		super();
		this.idTipo = idTipo;
		this.descricao = descricao;

	}

	public int getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		descricao = descricao;
	}

}
