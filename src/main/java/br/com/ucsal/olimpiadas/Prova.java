package br.com.ucsal.olimpiadas;

public class Prova {

	private long id;
	private String titulo;

	public Prova(long id, String titulo){
		this.id = id;
		this.titulo = titulo;
	}

	public long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

}
