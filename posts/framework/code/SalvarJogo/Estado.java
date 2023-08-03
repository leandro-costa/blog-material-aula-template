package com.mycompany.framework.SalvarJogo;
import com.mycompany.framework.Cor;
import com.mycompany.framework.Jogo;
import com.mycompany.framework.Tabuleiro;

public class Estado {
    public Jogo jogoReferencia;
    public Tabuleiro tabuleiroReferencia;
    private Cor cor;
    private int y;
    private int x;

    public Estado(Jogo jogoReferencia, Tabuleiro tabuleiroReferencia, Cor cor, int y, int x) {
        this.jogoReferencia      = jogoReferencia;
        this.tabuleiroReferencia = tabuleiroReferencia;
        this.cor                 = cor;
        this.y                   = y;
        this.x                   = x;
    }

    public Cor getCor() {
        return cor;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
    
}
