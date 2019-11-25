package model.dto;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import model.vo.Procedimento;

public class GeradorDePlanilhaProcedimento {
	byte[] Procedimentos;

	public void gerarPlanilhaPetCompleta(List<RelatorioProcedimento> procedimentos, String caminho) {
		String[] colunasPlanilha = { "idProcedimento", "pet", "veterinario", "titulo", "dtEntrada", "dtSaida", "valor",
				"formaPagamento", "situacaoPagamento", "tipo" };

		HSSFWorkbook planilha = new HSSFWorkbook();
		HSSFSheet abaPlanilha = planilha.createSheet("Procedimentos");

		Row headerRow = abaPlanilha.createRow(0);

		for (int i = 0; i < colunasPlanilha.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(colunasPlanilha[i]);

		}

		int rowNum = 1;
		for (RelatorioProcedimento procedimento : procedimentos) {
			Row novaLinha = abaPlanilha.createRow(rowNum++);

			novaLinha.createCell(0).setCellValue(procedimento.getIdProcedimento());
			novaLinha.createCell(1).setCellValue(String.valueOf(procedimento.getPet()));
			novaLinha.createCell(2).setCellValue(String.valueOf(procedimento.getVeterinario()));
			novaLinha.createCell(3).setCellValue(procedimento.getTitulo());
			novaLinha.createCell(4).setCellValue(String.valueOf(procedimento.getDtEntrada()));
			novaLinha.createCell(5).setCellValue(String.valueOf(procedimento.getDtSaida()));
			novaLinha.createCell(6).setCellValue(procedimento.getValor());
			novaLinha.createCell(7).setCellValue(procedimento.getFormaPagamento());
			novaLinha.createCell(8).setCellValue(procedimento.getSituacaoPagamento());
			novaLinha.createCell(9).setCellValue(String.valueOf(procedimento.getTipo()));

		}

		for (int i = 0; i < colunasPlanilha.length; i++) {
			abaPlanilha.autoSizeColumn(i);
		}

		FileOutputStream fileOut = null;
		try {
			fileOut = new FileOutputStream(caminho + ".xls");
			planilha.write(fileOut);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fileOut != null) {
				try {
					fileOut.close();
					planilha.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public void gerarPlanilhaPet(List<Procedimento> procedimentos, String caminho) {
		String[] colunasPlanilha = { "idProcedimento", "pet", "veterinario", "titulo", "dtEntrada", "dtSaida", "valor",
				"formaPagamento", "situacaoPagamento", "tipo" };

		HSSFWorkbook planilha = new HSSFWorkbook();
		HSSFSheet abaPlanilha = planilha.createSheet("Procedimentos");

		Row headerRow = abaPlanilha.createRow(0);

		for (int i = 0; i < colunasPlanilha.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(colunasPlanilha[i]);

		}

		int rowNum = 1;
		for (Procedimento procedimento : procedimentos) {
			Row novaLinha = abaPlanilha.createRow(rowNum++);

			novaLinha.createCell(0).setCellValue(procedimento.getIdProcedimento());
			novaLinha.createCell(1).setCellValue(String.valueOf(procedimento.getPet()));
			novaLinha.createCell(2).setCellValue(String.valueOf(procedimento.getVeterinario()));
			novaLinha.createCell(3).setCellValue(procedimento.getTitulo());
			novaLinha.createCell(4).setCellValue(String.valueOf(procedimento.getDtEntrada()));
			novaLinha.createCell(5).setCellValue(String.valueOf(procedimento.getDtSaida()));
			novaLinha.createCell(6).setCellValue(procedimento.getValor());
			novaLinha.createCell(7).setCellValue(procedimento.getFormaPagamento());
			novaLinha.createCell(8).setCellValue(procedimento.getSituacaoPagamento());
			novaLinha.createCell(9).setCellValue(String.valueOf(procedimento.getTipo()));

		}

		for (int i = 0; i < colunasPlanilha.length; i++) {
			abaPlanilha.autoSizeColumn(i);
		}

		FileOutputStream fileOut = null;
		try {
			fileOut = new FileOutputStream(caminho + ".xls");
			planilha.write(fileOut);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fileOut != null) {
				try {
					fileOut.close();
					planilha.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
