package br.com.view;

import java.time.LocalDate;
import java.util.Scanner;

public class Home {

	public static void main(String[] args) {

		LocalDate startDate, endDate;
		int option = 100;
		String start, end;

		try (Scanner in = new Scanner(System.in)) {

			System.out.println("-----------------------------------------------------------");
			System.out.println("-----------------------------------------------------------");
			System.out.println("Caro cliente, informe a opção de traje desejada para aluguel:");
			System.out.println("1 - Aluguel de roupas esportivas.");
			System.out.println("2 - Aluguel de roupas tradicionais.");
			System.out.println("3 - Aluguel de roupas para festas.");
			System.out.println("0 - Sair.");
			System.out.print("Opção desejada: ");
			option = in.nextInt();

			while (option != 0) {

				start = carregarQuestoes("início");
				end = carregarQuestoes("fim");

//				startDate = LocalDate.parse(start, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
//				endDate = LocalDate.parse(end, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

				mostrarDados(option, start, end);

			}
		}

		System.out.println(" \n" + "Até logo!!");
	}

	private static String carregarQuestoes(String tipo) {

		try (Scanner in2 = new Scanner(System.in)) {
			String date = "";

			System.out.print("Informe a data " + tipo + " para o aluguel - (Formato: DD/MM/AAAA): ");
			date = in2.nextLine();
			return date;
		}
	}

	private static void mostrarDados(int option, String start, String end) {

		// Código de conexão com webservice.

	}

}
