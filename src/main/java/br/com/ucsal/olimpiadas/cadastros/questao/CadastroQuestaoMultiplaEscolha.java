package br.com.ucsal.olimpiadas.cadastros.questao;

import br.com.ucsal.olimpiadas.App;
import br.com.ucsal.olimpiadas.entidades.Prova;
import br.com.ucsal.olimpiadas.entidades.questao.Questao;
import br.com.ucsal.olimpiadas.entidades.questao.QuestaoMultiplaEscolha;

import java.util.List;
import java.util.Scanner;

public class CadastroQuestaoMultiplaEscolha extends CadastroQuestao{

    public CadastroQuestaoMultiplaEscolha(List<Questao> listaQuestoes, List<Prova> listaProvas, Scanner scanner) {
        super(listaQuestoes, listaProvas, scanner);
    }

    @Override
    public Questao cadastrarEspecifica(long provaId, String enunciado) {
        var alternativas = new String[5];

        for (int i=0; i<5; i++) {
            char letra = (char) ('A' + i);
            System.out.println("Alternativa " + letra + ": ");
            alternativas[i] = letra + ") " + getScanner().nextLine();
        }

        System.out.println("Qual a alternativa correta? (A-E): ");
        char correta;
        try{
            correta = normalizar(getScanner().nextLine().trim().charAt(0));
        } catch (Exception e) {
            return null;
        }
        return new QuestaoMultiplaEscolha(App.proximaQuestaoId++, provaId, enunciado, alternativas, correta);
    }

    private char normalizar(char c) {
        char up =Character.toUpperCase(c);
        if (up < 'A' || up > 'E')
            throw new IllegalArgumentException();
        return up;
    }
}
