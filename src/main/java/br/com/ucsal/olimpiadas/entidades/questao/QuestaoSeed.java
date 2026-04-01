package br.com.ucsal.olimpiadas.entidades.questao;

public class QuestaoSeed extends Questao{

    private String jogadaCorreta;
    private String fen;

    public QuestaoSeed(long id, long provaId, String enunciado, String jogadaCorreta) {
        super(id, provaId, enunciado);
        this.jogadaCorreta = jogadaCorreta;
        this.fen = "6k1/5ppp/8/8/8/7Q/6PP/6K1 w - - 0 1";
    }

    @Override
    public void exibir() {
        System.out.println("---TABULEIRO DE XADREZ---");
        System.out.println(enunciado);
        imprimirTabuleiro(fen);
        System.out.println("Dica: use a anotação correta (ex:Qa1#, Kh2#)");
    }

    @Override
    public boolean validarResposta(String resposta) {
        if(resposta.isBlank())
            return false;
        try{
            return resposta.equalsIgnoreCase(jogadaCorreta.trim());
        } catch (Exception e) {
            return false;
        }
    }

    private void imprimirTabuleiro(String fen) {
        String parteTabuleiro = fen.split(" ")[0];
        String[] ranks = parteTabuleiro.split("/");

        System.out.println();
        System.out.println("    a b c d e f g h");
        System.out.println("   -----------------");

        for (int r = 0; r < 8; r++) {

            String rank = ranks[r];
            System.out.print((8 - r) + " | ");

            for (char c : rank.toCharArray()) {

                if (Character.isDigit(c)) {
                    int vazios = c - '0';
                    for (int i = 0; i < vazios; i++) {
                        System.out.print(". ");
                    }
                } else {
                    System.out.print(c + " ");
                }
            }

            System.out.println("| " + (8 - r));
        }

        System.out.println("   -----------------");
        System.out.println("    a b c d e f g h");
        System.out.println();
    }
}
