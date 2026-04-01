package br.com.ucsal.olimpiadas.entidades;

public class Participante {

	private long id;
	private String nome;

	public Participante(long id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
}
