package br.com.ucsal.olimpiadas.entidades.questao;

public abstract class Questao {

	protected long id;
	protected long provaId;
	protected String enunciado;

	public Questao(long id, long provaId, String enunciado) {
		this.id = id;
		this.provaId = provaId;
		this.enunciado = enunciado;
	}

	public abstract void exibir();

	public abstract boolean validarResposta(String resposta);

	public long getId() {
		return id;
	}

	public long getProvaId() {
		return provaId;
	}

	public String getEnunciado() {
		return enunciado;
	}
}
