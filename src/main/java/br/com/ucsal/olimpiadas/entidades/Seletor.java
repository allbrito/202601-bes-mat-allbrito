package br.com.ucsal.olimpiadas.entidades;

import java.util.List;
import java.util.Scanner;

public class Seletor {

    public static Participante selecionarParticipante(List<Participante> listaParticipantes, Scanner sc) {
        if (listaParticipantes.isEmpty()){
            return null;
        }
        System.out.println("\nParticipantes");
        for (var p : listaParticipantes) {
            System.out.printf("  %d) %s%n", p.getId(), p.getNome());
        }
        System.out.print("Escolha o id do participante: ");
        try {
            long id = Long.parseLong(sc.nextLine());
            return listaParticipantes.stream()
                    .filter(p -> p.getId() == id)
                    .findFirst()
                    .orElse(null);
        } catch (Exception e) {
            return null;
        }
    }

    public static Prova selecionarProva(List<Prova> listaProvas, Scanner sc){
        if (listaProvas.isEmpty()){
            return null;
        }
        System.out.println("\nProvas:");
        for (var p : listaProvas) {
            System.out.printf("  %d) %s%n", p.getId(), p.getTitulo());
        }
        System.out.print("Escolha o id da prova: ");
        try {
            long id = Long.parseLong(sc.nextLine());
            return listaProvas.stream()
                    .filter(p -> p.getId() == id)
                    .findFirst()
                    .orElse(null);
        } catch (Exception e) {;
            return null;
        }
    }
}
