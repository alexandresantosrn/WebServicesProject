package br.com.model;

public class Roupa {

	String nome;
	String estilo;
	float preco;
	boolean alugado;

	public Roupa(String nome, String estilo, float preco) {
		super();
		this.nome = nome;
		this.estilo = estilo;
		this.preco = preco;
	}

	public String getNome() {
		return nome;
	}

	public String getEstilo() {
		return estilo;
	}

	public float getPreco() {
		return preco;
	}

	public boolean isAlugado() {
		return alugado;
	}

	public void setAlugado(boolean alugado) {
		this.alugado = alugado;
	}

}
