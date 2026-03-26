package br.com.ucsal.olimpiadas.cadastro;

import br.com.ucsal.olimpiadas.App;
import br.com.ucsal.olimpiadas.Participante;

import java.util.List;
import java.util.Scanner;

public class CadastroParticipante implements ICadastrador {

    private List<Participante> listaParticipantes;
    private Scanner in;

    public CadastroParticipante(List<Participante> listaParticipante, Scanner in) {
        this.listaParticipantes = listaParticipante;
        this.in = in;
    }

    @Override
    public void cadastrar() {
        System.out.print("Nome: ");
        var nome = in.nextLine();

        System.out.print("Email (opcional): ");
        var email = in.nextLine();

        if (nome == null || nome.isBlank()) {
            System.out.println("Nome obrigatório");
            return;
        }
        listaParticipantes.add(new Participante(App.proximoParticipanteId++, nome, email));
        System.out.println("Participante cadastrado: " + listaParticipantes.getLast().getId());
    }
}
