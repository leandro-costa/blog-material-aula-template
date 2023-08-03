package com.mycompany.framework.TiposDePecas;

import com.mycompany.framework.Movimentos.Movimento;
import com.mycompany.framework.Tabuleiro;

public class PromocaoPeaoDecorator extends Peca {
    private Peao pecaPeao;
    private Peca pecaQueFoiPromovida;

    public PromocaoPeaoDecorator(Peao pecaPeao, Peca pecaQueFoiPromovida) {
        super(pecaPeao.cor, pecaPeao.y, pecaPeao.x);
        this.pecaPeao = pecaPeao;
        this.pecaQueFoiPromovida = pecaQueFoiPromovida;
    }

    public Peca retornarPecaPromovida() {
        return pecaQueFoiPromovida;
    }

    @Override
    public Peca clonarPeca() {
        return pecaQueFoiPromovida.clonarPeca();
    }

    @Override
    public void mover(Tabuleiro tabuleiro, Movimento movimento) {
        pecaQueFoiPromovida.mover(tabuleiro, movimento);
    }
}


 
