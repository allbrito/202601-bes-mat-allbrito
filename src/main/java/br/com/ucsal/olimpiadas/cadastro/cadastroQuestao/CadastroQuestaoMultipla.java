package br.com.ucsal.olimpiadas.cadastro.cadastroQuestao;

import br.com.ucsal.olimpiadas.App;
import br.com.ucsal.olimpiadas.Prova;
import br.com.ucsal.olimpiadas.questao.Questao;
import br.com.ucsal.olimpiadas.questao.QuestaoMultiplaEscolha;

import java.util.List;
import java.util.Scanner;

public class CadastroQuestaoMultipla extends CadastroQuestao {

    public CadastroQuestaoMultipla(List<Questao> listaQuestoes, List<Prova> listaProvas, Scanner in) {
        super(listaQuestoes, listaProvas, in);
    }

    @Override
    public Questao questaoEspecifica(long provaId, String enunciado){
        var alternativas = new String[5];
        for (int i = 0; i < 5; i++) {
            char letra = (char) ('A' + i);
            System.out.print("Alternativa " + letra + ": ");
            alternativas[i] = letra + ") " + in.nextLine();
        }

        System.out.print("Alternativa correta (A–E): ");
        char correta;
        try {
            correta = QuestaoMultiplaEscolha.normalizar(in.nextLine().trim().charAt(0));
        } catch (Exception e) {
            System.out.println("alternativa inválida");
            return null;
        }
        return new QuestaoMultiplaEscolha(App.proximaQuestaoId++, provaId, enunciado, alternativas, correta);
    }
}
