package model.dto;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import model.vo.Cliente;

public class GeradorDePlanilhaCliente {
	byte[] Cliente;

	public void gerarPlanilhaClienteCompleta(List<RelatorioCliente> clientes, String caminho) {
		String[] colunasPlanilha = { "idCliente", "nome", "sobrenome", "endereco", "sexo", "cpf", "telefone", "email" };

		HSSFWorkbook planilha = new HSSFWorkbook();
		HSSFSheet abaPlanilha = planilha.createSheet("Clientes");

		Row headerRow = abaPlanilha.createRow(0);

		for (int i = 0; i < colunasPlanilha.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(colunasPlanilha[i]);

		}

		int rowNum = 1;
		for (RelatorioCliente cliente : clientes) {
			Row novaLinha = abaPlanilha.createRow(rowNum++);

			novaLinha.createCell(0).setCellValue(cliente.getIdCliente());
			novaLinha.createCell(1).setCellValue(cliente.getNome());
			novaLinha.createCell(2).setCellValue(cliente.getSobrenome());
			novaLinha.createCell(3).setCellValue(cliente.getEndereco());
			novaLinha.createCell(4).setCellValue(cliente.getSexo());
			novaLinha.createCell(5).setCellValue(cliente.getCpf());
			novaLinha.createCell(6).setCellValue(cliente.getTelefone());
			novaLinha.createCell(7).setCellValue(cliente.getEmail());

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

	public void gerarPlanilhaPet(List<Cliente> clientes, String caminho) {
		String[] colunasPlanilha = { "idCliente", "nome", "sobrenome", "endereco", "sexo", "cpf", "telefone", "email" };

		HSSFWorkbook planilha = new HSSFWorkbook();
		HSSFSheet abaPlanilha = planilha.createSheet("Clientes");

		Row headerRow = abaPlanilha.createRow(0);

		for (int i = 0; i < colunasPlanilha.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(colunasPlanilha[i]);

		}

		int rowNum = 1;
		for (Cliente cliente : clientes) {
			Row novaLinha = abaPlanilha.createRow(rowNum++);
			novaLinha.createCell(0).setCellValue(cliente.getIdCliente());
			novaLinha.createCell(1).setCellValue(cliente.getNome());
			novaLinha.createCell(2).setCellValue(cliente.getSobrenome());
			novaLinha.createCell(3).setCellValue(cliente.getEndereco());
			novaLinha.createCell(4).setCellValue(cliente.getSexo());
			novaLinha.createCell(5).setCellValue(cliente.getCpf());
			novaLinha.createCell(6).setCellValue(cliente.getTelefone());
			novaLinha.createCell(7).setCellValue(cliente.getEmail());

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