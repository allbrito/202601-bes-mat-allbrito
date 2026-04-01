package br.com.ucsal.olimpiadas.entidades.questao;

public class QuestaoMultiplaEscolha extends Questao{

    private String[] alternativas;
    private char alternativaCorreta;

    public QuestaoMultiplaEscolha(long id, long provaId, String enunciado, String[] alternativas, char alternativaCorreta) {
        super(id, provaId, enunciado);
        this.alternativas = alternativas;
        this.alternativaCorreta = alternativaCorreta;
    }

    @Override
    public void exibir() {
        System.out.println(enunciado);
        for (var alt: alternativas)
            System.out.println(alt);
    }

    @Override
    public boolean validarResposta(String resposta) {
        if(resposta.isBlank())
            return false;
        try{
            return Character.toUpperCase(resposta.charAt(0)) == alternativaCorreta;
        } catch (Exception e) {
            return false;
        }
    }
}
