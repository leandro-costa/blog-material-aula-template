public class Circulo extends Formas {
    public Circulo(int tamanho) {
        super(tamanho);
    }
    @Override
    public Formas clone() {
        return new Circulo(getTamanho());
    }
    @Override
    public String toString() {
        return "Circulo \nTamanho:" + getTamanho();
    }
}
