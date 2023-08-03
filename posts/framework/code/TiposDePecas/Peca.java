package com.mycompany.framework.TiposDePecas;
import com.mycompany.framework.Cor;
import com.mycompany.framework.Jogo;
import com.mycompany.framework.Movimentos.Movimento;
import com.mycompany.framework.SalvarJogo.Estado;
import com.mycompany.framework.SalvarJogo.EstadosPeca;
import com.mycompany.framework.Tabuleiro;

public abstract class Peca {
    public Cor cor;
    public int y;
    public int x;

    public Peca(Cor cor, int y, int x) {
        this.cor = cor;
        this.y   = y;
        this.x   = x;
    }
    
    public void salvarEstado(Jogo jogoReferencia, Tabuleiro tabuleiroReferencia, EstadosPeca estadosPeca){
        Estado temp = new Estado(jogoReferencia, tabuleiroReferencia, this.cor, this.y, this.x);
        estadosPeca.adicionarEstado(temp);
    }
    
    public void restaurarEstado(EstadosPeca estadosPeca, int indice){
        Estado temp = estadosPeca.getEstado(indice);
        this.cor    = temp.getCor();
        this.y      = temp.getY();
        this.x      = temp.getX();
        
    }
    
    @Override
    public String toString() {
        return "Peca";
    }
       
    
    public abstract Peca clonarPeca();
    
    
    public void mover(Tabuleiro tabuleiro, Movimento movimento){
        tabuleiro.AtualizarPecaNoTabuleiro(this);
    
    }









//
}



