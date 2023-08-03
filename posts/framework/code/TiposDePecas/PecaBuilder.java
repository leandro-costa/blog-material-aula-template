package com.mycompany.framework.TiposDePecas;

import com.mycompany.framework.Cor;

public abstract class PecaBuilder{
    public Cor cor;
    public int y;
    public int x;
    
    public PecaBuilder setCor(Cor cor) {
        this.cor = cor;
        return this;
    }
    
    public PecaBuilder setposicao(int y, int x){
        this.y = y;
        this.x = x;
        return this;
    }
    
     public abstract Peca build();
     
}
