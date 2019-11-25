package model.dto;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import model.vo.Veterinario;

public class GeradorDePlanilhaVeterinario {
	byte[] Veterinario;

	public void gerarPlanilhaVeterinarioCompleta(List<RelatorioVeterinario> veterinarios, String caminho) {
		String[] colunasPlanilha = { "idVeterinario", "certificado", "crmv", "veterinario", "nome", "sobrenome",
				"endereco", "sexo", "cpf", "telefone", "email" };

		HSSFWorkbook planilha = new HSSFWorkbook();
		HSSFSheet abaPlanilha = planilha.createSheet("Veterinarios");

		Row headerRow = abaPlanilha.createRow(0);

		for (int i = 0; i < colunasPlanilha.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(colunasPlanilha[i]);

		}

		int rowNum = 1;
		for (RelatorioVeterinario veterinario : veterinarios) {
			Row novaLinha = abaPlanilha.createRow(rowNum++);

			novaLinha.createCell(0).setCellValue(veterinario.getIdVeterinario());
			novaLinha.createCell(1).setCellValue(veterinario.getCertificado());
			novaLinha.createCell(2).setCellValue(veterinario.getCrmv());
			novaLinha.createCell(3).setCellValue(veterinario.getVeterinario());
			novaLinha.createCell(4).setCellValue(veterinario.getNome());
			novaLinha.createCell(5).setCellValue(veterinario.getSobrenome());
			novaLinha.createCell(6).setCellValue(veterinario.getEndereco());
			novaLinha.createCell(7).setCellValue(veterinario.getSexo());
			novaLinha.createCell(8).setCellValue(veterinario.getCpf());
			novaLinha.createCell(9).setCellValue(veterinario.getTelefone());
			novaLinha.createCell(10).setCellValue(veterinario.getEmail());
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

	public void gerarPlanilhaPet(List<Veterinario> veterinarios, String caminho) {
		String[] colunasPlanilha = { "idVeterinario", "certificado", "crmv", "veterinario", "nome", "sobrenome",
				"endereco", "sexo", "cpf", "telefone", "email" };

		HSSFWorkbook planilha = new HSSFWorkbook();
		HSSFSheet abaPlanilha = planilha.createSheet("Veterinarios");

		Row headerRow = abaPlanilha.createRow(0);

		for (int i = 0; i < colunasPlanilha.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(colunasPlanilha[i]);

		}

		int rowNum = 1;
		for (Veterinario veterinario : veterinarios) {
			Row novaLinha = abaPlanilha.createRow(rowNum++);
			novaLinha.createCell(0).setCellValue(veterinario.getIdVeterinario());
			novaLinha.createCell(1).setCellValue(veterinario.getCertificado());
			novaLinha.createCell(2).setCellValue(veterinario.getCrmv());
			novaLinha.createCell(3).setCellValue(veterinario.getVeterinario());
			novaLinha.createCell(4).setCellValue(veterinario.getNome());
			novaLinha.createCell(5).setCellValue(veterinario.getSobrenome());
			novaLinha.createCell(6).setCellValue(veterinario.getEndereco());
			novaLinha.createCell(7).setCellValue(veterinario.getSexo());
			novaLinha.createCell(8).setCellValue(veterinario.getCpf());
			novaLinha.createCell(9).setCellValue(veterinario.getTelefone());
			novaLinha.createCell(10).setCellValue(veterinario.getEmail());

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
