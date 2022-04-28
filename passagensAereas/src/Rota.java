public class Rota {

    private long id;
    private String trajeto;
    private int valor;
    private int assento;

    public Rota(int id, String trajeto, int i, int j) {
        this.id = id;
        this.trajeto = trajeto;
        this.valor = i;
        this.assento = j;

    }

    @Override
    public String toString() {
        return " Rota: " + trajeto + " || Valor $" + valor + " || Assentos disponíveis: " + assento + " || ID " + id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTrajeto() {
        return trajeto;
    }

    public void setTrajeto(String trajeto) {
        this.trajeto = trajeto;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getAssento() {
        return assento;
    }

    public void setAssento(int assento) {
        this.assento = assento;
    }
}
