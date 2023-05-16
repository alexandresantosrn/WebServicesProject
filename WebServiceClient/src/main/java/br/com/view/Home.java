package br.com.view;

import java.time.LocalDate;
import java.util.Scanner;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

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

				// start = carregarQuestoes("início");
				// end = carregarQuestoes("fim");

//				startDate = LocalDate.parse(start, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
//				endDate = LocalDate.parse(end, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

				System.out.print("Informe a data início para o aluguel - (Formato: DD-MM-AAAA): ");
				start = in.next();

				System.out.print("Informe a data final para o aluguel - (Formato: DD-MM-AAAA): ");
				end = in.next();

				connect(option, start, end);

			}
		}

		System.out.println(" \n" + "Até logo!!");
	}

	private static void connect(int option, String start, String end) {

//		Client client = ClientBuilder.newClient();
//		// WebTarget target = client.target("http://localhost:8080/WebProject/rest");
//		WebTarget target = client.target("http://localhost:8080/WebServiceServer/rest");
//		String conect = target.path("/hello").request().get(String.class);
//		System.out.println(conect);

		Client client = ClientBuilder.newClient();
		WebTarget myResource = client.target("http://localhost:8080/WebServiceServer/rest/hello?estilo=esportivo&inicio=2023-06-01&fim=2023-06-07");
		String response = myResource.request(MediaType.TEXT_PLAIN).get(String.class);
		System.out.println(response);
	}

}
