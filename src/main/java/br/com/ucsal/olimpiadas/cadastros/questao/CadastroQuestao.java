package br.com.ucsal.olimpiadas.cadastros.questao;

import br.com.ucsal.olimpiadas.cadastros.ICadastrador;
import br.com.ucsal.olimpiadas.entidades.Prova;
import br.com.ucsal.olimpiadas.entidades.Seletor;
import br.com.ucsal.olimpiadas.entidades.questao.Questao;

import java.util.List;
import java.util.Scanner;

public abstract class CadastroQuestao implements ICadastrador {

    private List<Questao> listaQuestoes;
    private List<Prova> listaProvas;
    private Scanner scanner;

    public CadastroQuestao(List<Questao> listaQuestoes, List<Prova> listaProvas,  Scanner scanner) {
        this.listaQuestoes = listaQuestoes;
        this.listaProvas = listaProvas;
        this.scanner = scanner;
    }

    @Override
    public void cadastrar() {
        var provaId = escolherProva();
        if(provaId==null)
            return;

        System.out.println("Enunciado: ");
        var enunciado = scanner.nextLine();

        Questao questao = cadastrarEspecifica(provaId, enunciado);

        if (questao!=null) {
            listaQuestoes.add(questao);
            System.out.println("Questão Cadastrada. ID: " + listaQuestoes.getLast().getId());
        }
    }

    public abstract Questao cadastrarEspecifica(long provaId, String enunciado);

    private Long escolherProva(){
        Prova prova = Seletor.selecionarProva(listaProvas, scanner);
        if(prova==null){
            System.out.println("ID Inválido");
            return null;
        }
        return prova.getId();
    }

    public Scanner getScanner() {
        return scanner;
    }
}
