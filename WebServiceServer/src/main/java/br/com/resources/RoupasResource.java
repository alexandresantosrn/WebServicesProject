package br.com.resources;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.model.Aluguel;
import br.com.model.Loja;
import br.com.model.Roupa;
import br.com.repository.BDRepository;

@Path("hello")
public class RoupasResource {

	BDRepository rp = new BDRepository();

	// Criação das lojas
	Loja loja1 = new Loja("Alguém Veste");
	Loja loja2 = new Loja("Ponto Xique");
	Loja loja3 = new Loja("Natal Rigor");

	// Criação das roupas
	Roupa roupa1 = new Roupa("Short preto básico para corrida", "Esportivo", 15);
	Roupa roupa2 = new Roupa("Caça legging", "Esportivo", 50);
	Roupa roupa3 = new Roupa("Camisa musculação", "Esportivo", 30);
	Roupa roupa4 = new Roupa("Camisa social padrão", "Tradicional", 40);
	Roupa roupa5 = new Roupa("Vestido tradicional", "Tradicional", 70);
	Roupa roupa6 = new Roupa("Calça Jeans padrão", "Tradicional", 30);
	Roupa roupa7 = new Roupa("Terno completo", "Festa", 100);
	Roupa roupa8 = new Roupa("Vestido para noiva", "Festa", 200);
	Roupa roupa9 = new Roupa("Smoking tradicional", "Festa", 150);

	// Criando localdates para aluguéis
	LocalDate localDate1 = LocalDate.of(2023, 03, 01);
	LocalDate localDate2 = LocalDate.of(2023, 03, 15);

	// Registrando aluguéis
	Aluguel aluguel1 = new Aluguel(roupa1, localDate1, localDate2);
	Aluguel aluguel2 = new Aluguel(roupa2, localDate1, localDate2);

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHello() {
		String msg = "";
		popularObjetos();

		msg = retornarRoupas();
		return msg;
	}

	private void popularObjetos() {

		// Adicionando roupas as lojas
		loja1.adicionarRoupa(roupa1);
		loja2.adicionarRoupa(roupa2);
		loja3.adicionarRoupa(roupa3);
		loja1.adicionarRoupa(roupa4);
		loja2.adicionarRoupa(roupa5);
		loja3.adicionarRoupa(roupa6);
		loja1.adicionarRoupa(roupa7);
		loja2.adicionarRoupa(roupa8);
		loja3.adicionarRoupa(roupa9);

		// Adicionando roupas ao repositório
		rp.adicionarRoupa(roupa1);
		rp.adicionarRoupa(roupa2);
		rp.adicionarRoupa(roupa3);
		rp.adicionarRoupa(roupa4);
		rp.adicionarRoupa(roupa5);
		rp.adicionarRoupa(roupa6);
		rp.adicionarRoupa(roupa7);
		rp.adicionarRoupa(roupa8);
		rp.adicionarRoupa(roupa9);

		// Adicionando lojas ao repositório
		rp.adicionarLoja(loja1);
		rp.adicionarLoja(loja2);
		rp.adicionarLoja(loja3);

		// Adicionando aluguéis ao repositório
		rp.adicionarAluguel(aluguel1);
		rp.adicionarAluguel(aluguel2);
	}
	
	private String retornarRoupas() {
		
		String estilo = "Esportivo";
		LocalDate inicio = LocalDate.of(2023, 03, 01);
		LocalDate fim = LocalDate.of(2023, 03, 15);
		
		ArrayList<Roupa> roupas = new ArrayList<>();
		roupas = rp.retornarRoupasByEstilo(estilo);

		ArrayList<Loja> lojas = new ArrayList<>();
		lojas = rp.getLojas();

		ArrayList<Aluguel> alugueis = new ArrayList<>();
		alugueis = rp.getAlugueis();

		long dias = ChronoUnit.DAYS.between(inicio, fim);

		if (dias == 0)
			dias = 1;

		// Percorrendo as listas para identificar as roupas alugadas.
		for (Aluguel aluguel : alugueis) {
			for (Roupa roupa : roupas) {
				if (aluguel.getRoupa().equals(roupa)) {
					if (!(aluguel.getInicio().isAfter(fim) || aluguel.getFim().isBefore(inicio))) {
						roupa.setAlugado(true);
					}

				}
			}
		}

		String msg = "\nSeguem as roupas encontradas para o estilo selecionado: " + estilo + ". \n";

		for (Loja loja : lojas) {
			for (Roupa roupa : roupas) {
				if (loja.checarRoupaEmLoja(roupa)) {
					if (!roupa.isAlugado()) {
						msg = msg + "Produto: " + roupa.getNome() + " de preço (diária): " + roupa.getPreco()
								+ " reais, localizado na loja: " + loja.getNome() + ". (Valor total da locação: R$"
								+ (roupa.getPreco() * dias) + ")" + " \n";
					} else {
						msg = msg + "Produto: " + roupa.getNome() + " de preço (diária): " + roupa.getPreco()
								+ " reais, localizado na loja: " + loja.getNome()
								+ ". (Roupa alugada no período. Indisponível para locação)" + "\n";
					}

				}
			}
		}

		return msg;
	}

}
