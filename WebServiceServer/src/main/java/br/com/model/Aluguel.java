package br.com.model;

import java.time.LocalDate;

public class Aluguel {

	Roupa roupa;
	LocalDate inicio;
	LocalDate fim;

	public Aluguel(Roupa roupa, LocalDate inicio, LocalDate fim) {
		super();
		this.roupa = roupa;
		this.inicio = inicio;
		this.fim = fim;
	}

	public Roupa getRoupa() {
		return roupa;
	}

	public LocalDate getInicio() {
		return inicio;
	}

	public LocalDate getFim() {
		return fim;
	}
}
