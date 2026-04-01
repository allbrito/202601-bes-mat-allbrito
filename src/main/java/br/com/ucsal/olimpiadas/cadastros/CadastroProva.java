package br.com.ucsal.olimpiadas.cadastros;

import br.com.ucsal.olimpiadas.App;
import br.com.ucsal.olimpiadas.entidades.Prova;

import java.util.List;
import java.util.Scanner;

public class CadastroProva implements ICadastrador{

    private List<Prova> listaProvas;
    private Scanner sc;

    public CadastroProva(List<Prova> listaProvas, Scanner sc) {
        this.listaProvas = listaProvas;
        this.sc = sc;
    }

    @Override
    public void cadastrar() {
        System.out.println("Titulo da prova: ");
        var titulo = sc.nextLine();

        if(titulo == null || titulo.isBlank()){
            System.out.println("Título Obrigatório");
            return;
        }
        listaProvas.add(new Prova(App.proximaProvaId++, titulo));
        System.out.println("Prova Cadastrada. ID: " + listaProvas.getLast().getId());
    }
}
