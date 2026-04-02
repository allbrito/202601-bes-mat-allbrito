package br.com.ucsal.olimpiadas.cadastros;

import br.com.ucsal.olimpiadas.App;
import br.com.ucsal.olimpiadas.entidades.Participante;

import java.util.List;
import java.util.Scanner;

public class CadastroParticipante implements ICadastrador{

    private List<Participante> listaParticipantes;
    private Scanner sc;

    public CadastroParticipante(List<Participante> listaParticipantes, Scanner sc) {
        this.listaParticipantes = listaParticipantes;
        this.sc = sc;
    }

    @Override
    public void cadastrar() {
        System.out.println("Nome: ");
        var nome = sc.nextLine();

        if(nome == null || nome.isBlank()){
            System.out.print("Nome Obrigatório");
            return;
        }
        listaParticipantes.add(new Participante(App.proximoParticipanteId++, nome));
        System.out.println("Participante Cadastrado. ID: " + listaParticipantes.getLast().getId());
    }
}
