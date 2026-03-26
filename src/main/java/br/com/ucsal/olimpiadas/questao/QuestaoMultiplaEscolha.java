package br.com.ucsal.olimpiadas.questao;

public class QuestaoMultiplaEscolha extends Questao{

    private String[] alternativas = new String[5];
    private char alternativaCorreta;


    public QuestaoMultiplaEscolha(long id, Long provaId, String enunciado, String[] alternativas, char alternativaCorreta) {
        super(id, provaId, enunciado);
        this.alternativas = alternativas;
        this.alternativaCorreta = alternativaCorreta;
    }

    @Override
    public void exibir() {
        System.out.println(enunciado);
        for(String alt: alternativas)
            System.out.println(alt);
    }

    @Override
    public boolean validarResposta(String resposta) {
        if(resposta==null || resposta.isEmpty())
            return false;
        try{
            return Character.toUpperCase(resposta.charAt(0)) == alternativaCorreta;
        } catch (Exception e) {
            return false;
        }

    }

    public static char normalizar(char c) {
        char up = Character.toUpperCase(c);
        if (up < 'A' || up > 'E') {
            throw new IllegalArgumentException("Alternativa deve estar entre A e E.");
        }
        return up;
    }
}
