package model.dto;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import model.vo.Pet;

public class GeradorDePlanilha {
	byte[] Pet;

	public void gerarPlanilhaPetCompleta(List<RelatorioPet> pets, String caminho) {
		String[] colunasPlanilha = { "ID", "Nome", "Dt Nascimento", "Peso", "Porte", "Especie", "Raça", "Sexo", "Dono",
				"QTD Proc", "Valor Total" };

		HSSFWorkbook planilha = new HSSFWorkbook();
		HSSFSheet abaPlanilha = planilha.createSheet("Pets");

		Row headerRow = abaPlanilha.createRow(0);

		for (int i = 0; i < colunasPlanilha.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(colunasPlanilha[i]);

		}

		int rowNum = 1;
		for (RelatorioPet pet : pets) {
			Row novaLinha = abaPlanilha.createRow(rowNum++);

			novaLinha.createCell(0).setCellValue(pet.getIdPet());
			novaLinha.createCell(1).setCellValue(pet.getNome());
			novaLinha.createCell(2).setCellValue(String.valueOf(pet.getDtNascimento()));
			novaLinha.createCell(3).setCellValue(String.valueOf(pet.getPeso()));
			novaLinha.createCell(4).setCellValue(pet.getPorte());
			novaLinha.createCell(5).setCellValue(pet.getEspecie());
			novaLinha.createCell(6).setCellValue(pet.getRaca());
			novaLinha.createCell(7).setCellValue(pet.getSexo());
			novaLinha.createCell(8).setCellValue(pet.getCliente());
			novaLinha.createCell(9).setCellValue(pet.getContagemProcedimentos());
			novaLinha.createCell(10).setCellValue(pet.getValorTotalProcedimentos());

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

	public void gerarPlanilhaPet(List<Pet> pets, String caminho) {
		String[] colunasPlanilha = { "ID", "Nome", "Dt Nascimento", "Peso", "Porte", "Especie", "Raça", "Sexo" };

		HSSFWorkbook planilha = new HSSFWorkbook();
		HSSFSheet abaPlanilha = planilha.createSheet("Pets");

		Row headerRow = abaPlanilha.createRow(0);

		for (int i = 0; i < colunasPlanilha.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(colunasPlanilha[i]);

		}

		int rowNum = 1;
		for (Pet pet : pets) {
			Row novaLinha = abaPlanilha.createRow(rowNum++);

			novaLinha.createCell(0).setCellValue(pet.getIdPet());
			novaLinha.createCell(1).setCellValue(pet.getNome());
			novaLinha.createCell(2).setCellValue(String.valueOf(pet.getDtNascimento()));
			novaLinha.createCell(3).setCellValue(String.valueOf(pet.getPeso()));
			novaLinha.createCell(4).setCellValue(pet.getPorte());
			novaLinha.createCell(5).setCellValue(pet.getEspecie());
			novaLinha.createCell(6).setCellValue(pet.getRaca());
			novaLinha.createCell(7).setCellValue(pet.getSexo());

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

	public void gerarPlanilhaClienteCompleta(List<RelatorioCliente> clientes, String caminho) {
		String[] colunasPlanilha = { "idCliente", "nome", "sobrenome", "endereco", "sexo", "cpf", "telefone", "email",
				"qtd pets" };

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
			novaLinha.createCell(8).setCellValue(cliente.getQuantidadePets());

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