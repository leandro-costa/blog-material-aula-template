package com.mycompany.framework.TiposDePecas;

import com.mycompany.framework.Cor;

public class Dama extends Peca{

    public Dama(Cor cor, int y, int x) {
        super(cor, y, x);
    }
    

    @Override
    public Peca clonarPeca() {
        return new Dama(this.cor, this.y, this.x);
    }
    
}
