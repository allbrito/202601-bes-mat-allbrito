package br.com.ucsal.olimpiadas;

import br.com.ucsal.olimpiadas.cadastros.questao.CadastroQuestao;
import br.com.ucsal.olimpiadas.cadastros.questao.CadastroQuestaoSeed;
import br.com.ucsal.olimpiadas.entidades.Participante;
import br.com.ucsal.olimpiadas.entidades.Prova;
import br.com.ucsal.olimpiadas.entidades.questao.Questao;

import java.util.List;
import java.util.Scanner;

public class ProvaSeed {

    public static void executar(List<Prova> listaProvas, List<Questao> listaQuestoes, Scanner scanner){
        Prova prova = new Prova(App.proximaProvaId, "Prova Seed");
        listaProvas.add(prova);

        CadastroQuestao cadastroQuestao = new CadastroQuestaoSeed(listaQuestoes, listaProvas, scanner);
        listaQuestoes.add(cadastroQuestao.cadastrarEspecifica(App.proximaProvaId++, ""));
    }
}
