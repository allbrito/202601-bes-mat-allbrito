package br.com.ucsal.olimpiadas.cadastros.questao;

import br.com.ucsal.olimpiadas.App;
import br.com.ucsal.olimpiadas.entidades.Prova;
import br.com.ucsal.olimpiadas.entidades.questao.Questao;
import br.com.ucsal.olimpiadas.entidades.questao.QuestaoSeed;

import java.util.List;
import java.util.Scanner;

public class CadastroQuestaoSeed extends CadastroQuestao{


    public CadastroQuestaoSeed(List<Questao> listaQuestoes, List<Prova> listaProvas, Scanner scanner) {
        super(listaQuestoes, listaProvas, scanner);
    }

    @Override
    public Questao cadastrarEspecifica(long provaId, String enunciado) {
        enunciado = "Questão1: Mate em 1.\n" +
                "É a vez das brancas.\n" +
                "Encontre o lance que dá mate imediatamente";

        var jogadaCorreta = "Qc8#";

        return new QuestaoSeed(App.proximaQuestaoId++, provaId, enunciado, jogadaCorreta);
    }
}
