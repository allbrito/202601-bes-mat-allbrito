package br.com.ucsal.olimpiadas;

import java.util.ArrayList;
import java.util.List;

public class Tentativa {
	private long id;
	private long participanteId;
	private long provaId;

	private final List<Resposta> respostas = new ArrayList<>();

	public Tentativa(long id, long participanteId, long provaId){
		this.id = id;
		this.participanteId = participanteId;
		this.provaId = provaId;
	}

	public int calcularTotalAcertos() {
		int acertos = 0;
		for(Resposta r: respostas){
			if(r.isCorreta())
				acertos++;
		}
		return acertos;
	}

	public static void listarTentativas(List<Tentativa> tentativas) {
		System.out.println("\n--- Histórico de Tentativas ---");
		if (tentativas.isEmpty()) {
			System.out.println("Nenhuma tentativa registrada.");
			return;
		}

		tentativas.forEach(t -> {
			System.out.printf("Tentativa #%d | Part: %d | Prova: %d | Nota: %d/%d%n",
					t.getId(), t.getParticipanteId(), t.getProvaId(),
					t.calcularTotalAcertos(),
					t.getRespostas().size());
		});
	}

	public long getId() {
		return id;
	}

	public long getParticipanteId() {
		return participanteId;
	}

	public long getProvaId() {
		return provaId;
	}

	public List<Resposta> getRespostas() {
		return respostas;
	}

}
