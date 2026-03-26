package br.com.ucsal.olimpiadas;

import br.com.ucsal.olimpiadas.cadastro.CadastroParticipante;
import br.com.ucsal.olimpiadas.cadastro.CadastroProva;
import br.com.ucsal.olimpiadas.cadastro.cadastroQuestao.CadastroQuestao;
import br.com.ucsal.olimpiadas.cadastro.cadastroQuestao.CadastroQuestaoMultipla;
import br.com.ucsal.olimpiadas.questao.Questao;
import br.com.ucsal.olimpiadas.questao.QuestaoSeed;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

	public static long proximoParticipanteId = 1;
	public static long proximaProvaId = 1;
	public static long proximaQuestaoId = 1;
	public static long proximaTentativaId = 1;

	public static final List<Participante> participantes = new ArrayList<>();
	public static final List<Prova> provas = new ArrayList<>();
	public static final List<Questao> questoes = new ArrayList<>();
	public static final List<Tentativa> tentativas = new ArrayList<>();

	private static final Scanner in = new Scanner(System.in);

	public static void main(String[] args) {

		QuestaoSeed seed = new QuestaoSeed(proximaQuestaoId++, proximaProvaId++);
		AplicadorProva aplicadorProva = new AplicadorProva(participantes, provas, questoes, tentativas, in);
		CadastroParticipante cadastroParticipante = new CadastroParticipante(participantes, in);
		CadastroProva cadastroProva = new CadastroProva(provas, in);
		CadastroQuestao cadastroQuestao = new CadastroQuestaoMultipla(questoes, provas, in);

		while (true) {
			System.out.println("\n=== OLIMPÍADA DE QUESTÕES (V1) ===");
			System.out.println("1) Cadastrar participante");
			System.out.println("2) Cadastrar prova");
			System.out.println("3) Cadastrar questão (A–E) em uma prova");
			System.out.println("4) Aplicar prova (selecionar participante + prova)");
			System.out.println("5) Listar tentativas (resumo)");
			System.out.println("0) Sair");
			System.out.print("> ");

			switch (in.nextLine()) {
				case "1" -> cadastroParticipante.cadastrar();
				case "2" -> cadastroProva.cadastrar();
				case "3" -> cadastroQuestao.cadastrar();
				case "4" -> aplicadorProva.aplicar();
				case "5" -> Tentativa.listarTentativas(tentativas);
				case "0" -> {
					System.out.println("tchau");
					return;
				}
				default -> System.out.println("opção inválida");
			}
		}
	}
}
