public abstract class Formas implements Prototype<Formas>{
    private int tamanho;
    public Formas(int tamanho) {
        this.tamanho = tamanho;
    }
    public int getTamanho() {
        return tamanho;
    }
    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }    
    public abstract Formas clone();    
}