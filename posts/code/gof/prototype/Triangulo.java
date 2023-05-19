public class Triangulo extends Formas {
    public Triangulo(int tamanho) {
        super(tamanho);
    }
    @Override
    public Formas clone() {
        return new Triangulo(getTamanho());
    }
    @Override
    public String toString() {
        return "Triangulo \nTamanho:" + getTamanho();
    } 
    
}
