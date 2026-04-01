package br.com.ucsal.olimpiadas;

import br.com.ucsal.olimpiadas.entidades.*;
import br.com.ucsal.olimpiadas.entidades.questao.Questao;

import java.util.List;
import java.util.Scanner;

public class AplicadorProva {

    private List<Participante> listaParticipantes;
    private List<Prova> listaProvas;
    private List<Questao> listaQuestoes;
    private List<Tentativa> listaTentativas;
    private Scanner sc;

    private List<Questao> questoesProva;
    private Participante participante;
    private Prova prova;

    public AplicadorProva(List<Participante> participantes, List<Prova> provas, List<Questao> questoes, List<Tentativa> tentativas, Scanner sc) {
        this.listaParticipantes = participantes;
        this.listaProvas = provas;
        this.listaQuestoes = questoes;
        this.listaTentativas = tentativas;
        this.sc = sc;
    }

    public void aplicar(){
        if(verificar()){
            var tentativa = new Tentativa(App.proximaTentativaId++, participante.getId(), prova.getId());

            System.out.println("\n--- Início da Prova ---");
            for (var q : questoesProva) {
                System.out.println("\nQuestão #" + q.getId());
                q.exibir();
                System.out.print("Resposta: ");
                var resposta = sc.nextLine();
                var acertou = q.validarResposta(resposta);
                tentativa.getListaRespostas().add(new Resposta(q.getId(), resposta, acertou));
            }
            listaTentativas.add(tentativa);
            System.out.println("\n--- Prova Finalizada ---");
            System.out.printf("Nota: %d/%d%n", tentativa.calcularTotalAcertos(), tentativa.getListaRespostas().size());
        }
        return;
    }

    private boolean verificar(){
        participante = Seletor.selecionarParticipante(listaParticipantes, sc);
        if(participante == null) {
            System.out.println("É Necessário: Participante cadastrado e Passar ID's válidos");
            return false;
        }
        prova = Seletor.selecionarProva(listaProvas, sc);
        if(prova == null) {
            System.out.println("É Necessário: Prova cadastrada e Passar ID's válidos");
            return false;
        }

        questoesProva = listaQuestoes.stream()
                .filter(q -> q.getProvaId() == prova.getId())
                .toList();

        if(questoesProva.isEmpty()){
            System.out.println("Essa prova não possui questões cadastradas");
            return false;
        }
        return true;
    }
}
