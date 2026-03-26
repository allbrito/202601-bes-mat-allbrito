package br.com.ucsal.olimpiadas.cadastro;

import br.com.ucsal.olimpiadas.App;
import br.com.ucsal.olimpiadas.Prova;

import java.util.List;
import java.util.Scanner;

public class CadastroProva implements ICadastrador{

    private List<Prova> listaProvas;
    private Scanner in;

    public CadastroProva(List<Prova> listaProvas, Scanner in) {
        this.listaProvas = listaProvas;
        this.in = in;
    }

    @Override
    public void cadastrar() {
        System.out.print("Título da prova: ");
        var titulo = in.nextLine();

        if (titulo == null || titulo.isBlank()) {
            System.out.println("Título obrigatório");
            return;
        }

        listaProvas.add(new Prova(App.proximaProvaId++, titulo));
        System.out.println("Prova criada: " + listaProvas.getLast().getId());
    }
}
