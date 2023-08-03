
package com.mycompany.framework.TiposDePecas;

import com.mycompany.framework.Cor;
import com.mycompany.framework.Movimentos.Movimento;
import com.mycompany.framework.Tabuleiro;

public class PecaProxy{
    private Peca peca;
    public Cor cor;
    public int y;
    public int x;

    public PecaProxy(Peca peca) {
        this.peca = peca;
        this.cor  = peca.cor;
        this.y    = peca.y;
        this.x    = peca.x;
    }

    public Peca getPeca() {
        return peca;
    }
    
    public void mover(Tabuleiro tabuleiro, Movimento movimento){
        int antigoY = this.y;
        int antigoX = this.x;
        movimento.mover(peca);
        if(this.y <= (tabuleiro.altura - 1) && this.x <= (tabuleiro.largura - 1)){
            tabuleiro.tabela[antigoY][antigoX] = null;
            peca.mover(tabuleiro, movimento);
        }else{
            System.out.println("Movimento inválido!");
        }
 }

    
}
