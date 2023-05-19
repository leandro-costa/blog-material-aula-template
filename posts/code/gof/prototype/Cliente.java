import java.util.ArrayList;

public class Cliente {
    public static void main(String[] args) {
        Circulo c1 = new Circulo(20);
        Circulo c2 = (Circulo) c1.clone();


        Triangulo t1 = new Triangulo(20);
        Triangulo t2 = (Triangulo) t1.clone();
       
        Quadrado q1 = new Quadrado(20);
        Quadrado q2 = (Quadrado) q1.clone();


        Colecao colecao = new Colecao();
        colecao.addFormas(c1);
        colecao.addFormas(t1);
        colecao.addFormas(q1);
        colecao.showColecao();
        /* Circulo
        Tamanho:20
        Triangulo
        Tamanho:20
        Quadrado
        Tamanho:20 */


        Colecao colecao2 = colecao.clone();
        colecao2.getFormas().get(0).setTamanho(50);
        colecao2.getFormas().get(1).setTamanho(50);
        colecao2.getFormas().get(2).setTamanho(50);
        colecao2.showColecao();
        /* Circulo
        Tamanho:50
        Triangulo
        Tamanho:50
        Quadrado
        Tamanho:50 */
        colecao.showColecao();
    }
}
