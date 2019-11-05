package model.vo;

import java.text.DateFormat;

public class Procedimento {
	private int idProcedimento;
	private Pet pet;
	private Veterinario veterinario;
	private String titulo;
	private DateFormat dtEntrada;
	private DateFormat dtSaida;
	private double valor;
	private String formaPagamento;
	private boolean situacaoPagamento;
	private Tipo tipo;

}
