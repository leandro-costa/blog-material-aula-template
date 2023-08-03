
package com.mycompany.framework.TiposDePecas;


public class PeaoBuilder extends PecaBuilder{

    @Override
    public Peca build() {
        return new Peao(this.cor, this.y, this.x);
    }
    
}
