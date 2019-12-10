package model.dto;

import model.vo.Pet;
import model.vo.Tipo;
import model.vo.Veterinario;

public class SeletorProcedimento {

	private Pet pet;
	private Veterinario veterinario;
	private String situacaoPagamento;
	private Tipo tipo;
	private int limite;
	private int pagina;

	public void ProcedimentoSeletor() {
		this.limite = 0;
		this.pagina = -1;

	}

	public SeletorProcedimento(Pet pet, Veterinario veterinario, String situacaoPagamento, Tipo tipo, int limite,
			int pagina) {
		super();
		this.pet = pet;
		this.veterinario = veterinario;
		this.situacaoPagamento = situacaoPagamento;
		this.tipo = tipo;
		this.limite = limite;
		this.pagina = pagina;
	}

	public Pet getPet() {
		return pet;
	}

	public SeletorProcedimento() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getSituacaoPagamento() {
		return situacaoPagamento;
	}

	public void setSituacaoPagamento(String situacaoPagamento) {
		this.situacaoPagamento = situacaoPagamento;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public int getLimite() {
		return limite;
	}

	public void setLimite(int limite) {
		this.limite = limite;
	}

	public int getPagina() {
		return pagina;
	}

	public void setPagina(int pagina) {
		this.pagina = pagina;
	}

	public boolean temPaginacao() {
		return ((this.limite > 0) && (this.pagina > -1));
	}

	public int getOffset() {
		return (this.limite * (this.pagina - 1));
	}

	public boolean temFiltro() {
		boolean temFiltroPreenchido = false;

		if ((this.pet != null)) {
			temFiltroPreenchido = true;
		}
		if ((this.veterinario != null)) {
			temFiltroPreenchido = true;
		}
		if ((this.tipo != null)) {
			temFiltroPreenchido = true;
		}
		if ((this.situacaoPagamento != null) && (this.situacaoPagamento.trim().length() > 0)) {
			temFiltroPreenchido = true;
		}

		return temFiltroPreenchido;
	}

}
