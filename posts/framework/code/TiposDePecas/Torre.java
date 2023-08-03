package com.mycompany.framework.TiposDePecas;

import com.mycompany.framework.Cor;

public class Torre extends Peca{

    public Torre(Cor cor, int y, int x) {
        super(cor, y, x);
    }
    
    
    @Override
    public Peca clonarPeca() {
        return new Torre(this.cor, this.y, this.x);
    }
    
}
