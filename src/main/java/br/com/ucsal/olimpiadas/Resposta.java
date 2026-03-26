package br.com.ucsal.olimpiadas;

public class Resposta {

	private long questaoId;
	private String alternativaMarcada;
	private boolean correta;

	public Resposta(long questaoId, String alternativaMarcada, boolean correta){
		this.questaoId = questaoId;
		this.alternativaMarcada = alternativaMarcada;
		this.correta = correta;
	}

	public long getQuestaoId() {
		return questaoId;
	}

	public String getAlternativaMarcada() {
		return alternativaMarcada;
	}

	public boolean isCorreta() {
		return correta;
	}
}
