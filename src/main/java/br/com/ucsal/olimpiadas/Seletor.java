package br.com.ucsal.olimpiadas;

import java.util.List;
import java.util.Scanner;

public class Seletor {

    public static Participante selecionarParticipante(List<Participante> participantes, Scanner in){
        System.out.println("\nParticipantes:");
        for (var p : participantes) {
            System.out.printf("  %d) %s%n", p.getId(), p.getNome(), p.getEmail());
        }
        System.out.print("Escolha o id do participante: ");

        try {
            long id = Long.parseLong(in.nextLine());
            return participantes.stream()
                    .filter(p -> p.getId() == id)
                    .findFirst()
                    .orElse(null);
        } catch (Exception e) {
            return null;
        }
    }

    public static Prova selecionarProva(List<Prova> provas, Scanner in){
        System.out.println("\nProvas:");
        for (var p : provas) {
            System.out.printf("  %d) %s%n", p.getId(), p.getTitulo());
        }
        System.out.print("Escolha o id da prova: ");
        try {
            long id = Long.parseLong(in.nextLine());
            return provas.stream()
                    .filter(p -> p.getId() == id)
                    .findFirst()
                    .orElse(null);
        } catch (Exception e) {
            return null;
        }
    }
}
