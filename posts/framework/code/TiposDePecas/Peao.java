package com.mycompany.framework.TiposDePecas;
import com.mycompany.framework.Cor;

public class Peao extends Peca{

    public Peao(Cor cor, int y, int x) {
        super(cor, y, x);
    }
    
    @Override
    public Peca clonarPeca(){
        return new Peao(this.cor, this.y, this.x);
    }
    
}
