package com.mycompany.framework.TiposDePecas;

public class TorreBuilder extends PecaBuilder{

    @Override
    public Peca build() {
        return new Torre(this.cor, this.y, this.x);
    }
    
}
