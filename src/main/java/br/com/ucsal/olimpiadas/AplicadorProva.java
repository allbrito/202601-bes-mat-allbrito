package br.com.ucsal.olimpiadas;

import br.com.ucsal.olimpiadas.questao.Questao;

import java.util.List;
import java.util.Scanner;

public class AplicadorProva {

    private List<Participante> participantes;
    private List<Prova> provas;
    private List<Questao> questoes;
    private List<Tentativa> tentativas;
    private Scanner in;

    public AplicadorProva(List<Participante> participantes, List<Prova> provas, List<Questao> questoes, List<Tentativa> tentativas, Scanner in) {
        this.participantes = participantes;
        this.provas = provas;
        this.questoes = questoes;
        this.tentativas = tentativas;
        this.in = in;
    }

    public void aplicar(){
        var participante = Seletor.selecionarParticipante(participantes, in);
        var prova = Seletor.selecionarProva(provas, in);
        if (participante==null){
            System.out.println("Cadastre participantes primeiro");
            return;
        }

        var questoesDaProva = questoes.stream()
                .filter(q -> q.getProvaId() == prova.getId())
                .toList();

        if(questoesDaProva.isEmpty()){
            System.out.println("Esta prova não possui questões cadastradas");
            return;
        }

        var tentativa = new Tentativa(App.proximaTentativaId++, participante.getId(), prova.getId());

        System.out.println("\n--- Início da Prova ---");
        for (var q : questoesDaProva) {
            System.out.println("\nQuestão #" + q.getId());
            q.exibir();
            System.out.print("Resposta: ");
            var resposta = in.nextLine();
            var acertou = q.validarResposta(resposta);
            tentativa.getRespostas().add(new Resposta(q.getId(), resposta, acertou));
        }
        tentativas.add(tentativa);
        System.out.println("\n--- Prova Finalizada ---");
        System.out.printf("Nota: %d/%d%n", tentativa.calcularTotalAcertos(), tentativa.getRespostas().size());
    }
}
