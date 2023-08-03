package com.mycompany.framework.TiposDePecas;

public class DamaBuilder extends PecaBuilder{

    @Override
    public Peca build() {
        return new Dama(this.cor, this.y, this.x);
    }
    
}
