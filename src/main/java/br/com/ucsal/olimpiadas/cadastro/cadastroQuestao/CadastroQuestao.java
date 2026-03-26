package br.com.ucsal.olimpiadas.cadastro.cadastroQuestao;

import br.com.ucsal.olimpiadas.Prova;
import br.com.ucsal.olimpiadas.Seletor;
import br.com.ucsal.olimpiadas.cadastro.ICadastrador;
import br.com.ucsal.olimpiadas.questao.Questao;

import java.util.List;
import java.util.Scanner;

public abstract class CadastroQuestao implements ICadastrador {

    protected List<Questao> listaQuestoes;
    protected List<Prova> listaProvas;
    protected Scanner in;

    public CadastroQuestao(List<Questao> listaQuestoes, List<Prova> listaProvas, Scanner in) {
        this.listaQuestoes = listaQuestoes;
        this.listaProvas = listaProvas;
        this.in = in;
    }

    @Override
    public void cadastrar() {
        if (listaProvas.isEmpty()) {
            System.out.println("Não há provas cadastradas");
            return;
        }
        var provaId = escolherProva();
        if (provaId == null)
            return;

        System.out.println("Enunciado: ");
        String enunciado = in.nextLine();

        Questao questao = questaoEspecifica(provaId, enunciado);

        if (questao != null) {
            listaQuestoes.add(questao);
            System.out.println("Questão salva com sucesso!");
        } else {
            return;
        }
    }

    public abstract Questao questaoEspecifica(long provaId, String enunciado);

    private Long escolherProva() {
        Prova prova = Seletor.selecionarProva(listaProvas, in);
        if(prova==null) {
            System.out.println("Id inválido ou Prova Inexistente");
            return null;
        }
        return prova.getId();
    }


}
