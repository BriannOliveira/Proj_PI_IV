package Servidor;

public class PedidoDeCalculoDeRevisao extends Comunicado{

    private int numberReview;
    private String difficulty;

    public PedidoDeCalculoDeRevisao(int numberReview, String dificulty) {
        this.numberReview = numberReview;
        this.difficulty = dificulty;
    }

    public int getNumberReview() {
        return numberReview;
    }

    public void setNumberReview(int numberReview) {
        this.numberReview = numberReview;
    }

    public String getDificulty() {
        return difficulty;
    }

    public void setDificulty(String dificulty) {
        this.difficulty = dificulty;
    }

    @Override
    public String toString() {
        return "PedidoDeCalculoDeRevisao{" +
                "numberReview=" + numberReview +
                ", dificulty='" + difficulty + '\'' +
                '}';
    }
}
