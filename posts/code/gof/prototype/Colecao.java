import java.util.ArrayList;

public class Colecao  implements Prototype<Colecao>{
    private ArrayList<Formas> formas;    
    public Colecao() {
        this.formas = new ArrayList();
    }
    public void addFormas(Formas formas) {
        this.formas.add(formas);
    }
    public ArrayList<Formas> getFormas() {
        return formas;
    }
    @Override
    public Colecao clone() {
        Colecao clone = new Colecao();
        formas.forEach(
            forma -> {
                clone.addFormas(forma.clone());
            }
        );
        return clone;
    }
    public void showColecao() {
        for(Formas formas : this.formas) {
            System.out.println(formas);
        }
    }
}
