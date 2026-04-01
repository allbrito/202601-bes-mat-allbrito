package br.com.ucsal.olimpiadas.entidades;

import java.util.ArrayList;
import java.util.List;

public class Tentativa {

	private long id;
	private long participanteID;
	private long provaID;

	private final List<Resposta> listaRespostas = new ArrayList<>();

	public Tentativa(long id, long participanteID, long provaID) {
		this.id = id;
		this.participanteID = participanteID;
		this.provaID = provaID;
	}

	public int calcularTotalAcertos() {
		int acertos = 0;
		for(Resposta r: listaRespostas){
			if(r.getCorreta())
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
					t.getId(), t.getParticipanteID(), t.getProvaID(),
					t.calcularTotalAcertos(),
					t.getListaRespostas().size());
		});
	}

	public long getId() {
		return id;
	}

	public long getParticipanteID() {
		return participanteID;
	}

	public long getProvaID() {
		return provaID;
	}

	public List<Resposta> getListaRespostas() {
		return listaRespostas;
	}
}
