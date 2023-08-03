package com.mycompany.framework.Movimentos;
import com.mycompany.framework.TiposDePecas.Peca;

public class MovimentoDiagonalDireita extends Movimento{

    @Override
    public void mover(Peca peca) {
        peca.x = peca.x + 1;
        peca.y = peca.y + 1;
    }
    
}
