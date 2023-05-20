package br.com.repository;

import java.util.ArrayList;

import br.com.model.Aluguel;
import br.com.model.Loja;
import br.com.model.Roupa;

public class BDRepository {

	public ArrayList<Roupa> roupas = new ArrayList<>();
	public ArrayList<Loja> lojas = new ArrayList<>();
	public ArrayList<Aluguel> alugueis = new ArrayList<Aluguel>();

	public void adicionarRoupa(Roupa roupa) {

		roupas.add(roupa);
	}

	public void adicionarLoja(Loja loja) {

		lojas.add(loja);
	}

	public void adicionarAluguel(Aluguel aluguel) {

		alugueis.add(aluguel);
	}

	public ArrayList<Roupa> retornarRoupasByEstilo(String estilo) {
		ArrayList<Roupa> roupasReturn = new ArrayList<>();

		for (Roupa roupa : roupas) {
			if (roupa.getEstilo().equals(estilo)) {
				roupasReturn.add(roupa);
			}
		}

		return roupasReturn;
	}

	public ArrayList<Loja> getLojas() {
		return lojas;
	}

	public ArrayList<Aluguel> getAlugueis() {
		return alugueis;
	}

}
