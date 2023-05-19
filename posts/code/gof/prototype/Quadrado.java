public class Quadrado extends Formas {
    public Quadrado(int tamanho) {
        super(tamanho);
    }
    @Override
    public Formas clone() {
        return new Quadrado(getTamanho());
    }
    @Override
    public String toString() {
        return "Quadrado \nTamanho:" + getTamanho();
    }    
}
