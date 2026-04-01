package br.com.ucsal.olimpiadas.entidades;

public class Prova {

	private long id;
	private String nome;

	public Prova(long id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public long getId() {
		return id;
	}

	public String getTitulo() {
		return nome;
	}
}
