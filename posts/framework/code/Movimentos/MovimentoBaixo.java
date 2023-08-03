package com.mycompany.framework.Movimentos;

import com.mycompany.framework.TiposDePecas.Peca;

public class MovimentoBaixo extends Movimento{

    @Override
    public void mover(Peca peca) {
        peca.y = peca.y - 1;
    }
    
}
