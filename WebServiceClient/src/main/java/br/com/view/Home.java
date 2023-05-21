package br.com.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import br.com.exception.RestRequestException;

public class Home {

	public static void main(String[] args) throws RestRequestException {

		int option = 100;
		String estilo, inicio, fim;

		try (Scanner in = new Scanner(System.in)) {
			System.out.println("--------------------------------------------------------------");
			System.out.println("--------------------------------------------------------------");
			System.out.println("Caro cliente, informe a opção de traje desejada para aluguel:");
			System.out.println("1 - Aluguel de roupas esportivas.");
			System.out.println("2 - Aluguel de roupas tradicionais.");
			System.out.println("3 - Aluguel de roupas para festas.");
			System.out.println("0 - Sair.");
			System.out.print("Opção desejada: ");
			option = in.nextInt();

			switch (option) {
			
			case 1:
				estilo = "Esportivo";
				break;
			case 2:
				estilo = "Tradicional";
				break;
			case 3:
				estilo = "Festa";
				break;
			default:
				estilo = "Inválido";
				break;
				
			}

			while (option != 0) {

				System.out.print("Informe a data início para o aluguel - (Formato: DD-MM-AAAA): ");
				inicio = in.next();

				System.out.print("Informe a data final para o aluguel - (Formato: DD-MM-AAAA): ");
				fim = in.next();

				connect(estilo, inicio, fim);

			}
		}

		System.out.println(" \n" + "Até logo!!");
	}

	private static void connect(String estilo, String inicio, String fim) throws RestRequestException {

		String uri = "http://localhost:8080/WebServiceServer/rest/roupas/roupas-service/" + estilo + "/" + inicio + "/"
				+ fim + "/";
		Map<String, String> headerParams = new HashMap<String, String>();

		headerParams.put("accept", "application/json");

		String response = HttpUtils.httpGetRequest(uri, headerParams);

		System.out.println(response);

	}

}
