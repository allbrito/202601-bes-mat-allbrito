package br.com.ucsal.olimpiadas;

import br.com.ucsal.olimpiadas.cadastros.CadastroParticipante;
import br.com.ucsal.olimpiadas.cadastros.CadastroProva;
import br.com.ucsal.olimpiadas.cadastros.questao.CadastroQuestao;
import br.com.ucsal.olimpiadas.cadastros.questao.CadastroQuestaoMultiplaEscolha;
import br.com.ucsal.olimpiadas.entidades.Participante;
import br.com.ucsal.olimpiadas.entidades.Prova;
import br.com.ucsal.olimpiadas.entidades.Tentativa;
import br.com.ucsal.olimpiadas.entidades.questao.Questao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

	private static final Scanner scanner = new Scanner(System.in);

	public static long proximoParticipanteId = 1;
	public static long proximaProvaId = 1;
	public static long proximaQuestaoId = 1;
	public static long proximaTentativaId = 1;

	public static final List<Participante> participantes = new ArrayList<>();
	public static final List<Prova> provas = new ArrayList<>();
	public static final List<Questao> questoes = new ArrayList<>();
	public static final List<Tentativa> tentativas = new ArrayList<>();

	public static void main(String[] args) {

		CadastroParticipante cadastroParticipante = new CadastroParticipante(participantes, scanner);
		CadastroProva cadastroProva = new CadastroProva(provas, scanner);
		CadastroQuestao cadastroQuestao = new CadastroQuestaoMultiplaEscolha(questoes, provas, scanner);
		AplicadorProva prova = new AplicadorProva(participantes, provas, questoes, tentativas, scanner);

		ProvaSeed.executar(participantes, provas, questoes, scanner);

		while (true){
			System.out.println("\n=== OLIMPÍADA DE QUESTÕES (V1) ===");
			System.out.println("1) Cadastrar Participante");
			System.out.println("2) Cadastrar Prova");
			System.out.println("3) Cadastrar Questão em uma prova");
			System.out.println("4) Aplicar Prova (selecionar participante + prova)");
			System.out.println("5) Listar tentativas (resumo)");
			System.out.println("0) Sair");
			System.out.print("> ");

			switch (scanner.nextLine()) {
				case "1" -> cadastroParticipante.cadastrar();
				case "2" -> cadastroProva.cadastrar();
				case "3" -> cadastroQuestao.cadastrar();
				case "4" -> prova.aplicar();
				case "5" -> System.out.println("Listar tentativas");
				case "0" -> {
					System.out.println("Aplicação Encerrada");
					for(var p: provas){
						System.out.println(p.getTitulo());
					}
					return;
				}
				default -> System.out.println("Opção Inválida");
			}
		}
	}
}