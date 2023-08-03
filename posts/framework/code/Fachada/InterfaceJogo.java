package com.mycompany.framework.Fachada;

import com.mycompany.framework.Cor;
import com.mycompany.framework.Jogo;
import com.mycompany.framework.JogoConcreto;
import com.mycompany.framework.Movimentos.Movimento;
import com.mycompany.framework.Movimentos.MovimentoBaixo;
import com.mycompany.framework.Movimentos.MovimentoCima;
import com.mycompany.framework.SalvarJogo.EstadosPeca;
import com.mycompany.framework.Tabuleiro;
import com.mycompany.framework.TiposDePecas.Peca;
import com.mycompany.framework.TiposDePecas.PecaBuilder;
import com.mycompany.framework.TiposDePecas.PecaProxy;

public class InterfaceJogo {
    Tabuleiro tabuleiro;
    Jogo novoJogo;
    PecaProxy pecaProxy;
    EstadosPeca memoria;
    
    
    public void novoJogoDamas(int altura, int largura){
        Jogo novoJogo            = new JogoConcreto();
        Tabuleiro tabuleiro      = novoJogo.criarTabuleiro(altura, largura);
    
    }

    
    public Peca criarPeca(Cor cor, int y, int x, PecaBuilder builder){
        PecaBuilder consDePecas = builder;
        consDePecas.setCor(cor);
        consDePecas.setposicao(y, x);
        Peca peca = consDePecas.build();
        tabuleiro.AtualizarPecaNoTabuleiro(peca);
        return peca;
    }
    
    
    public void movimentarPeca(Peca peca, String direcao){
        pecaProxy = new PecaProxy(peca);
        Movimento movimento;
                
        if("cima".equals(direcao)){
            movimento = new MovimentoCima();
            pecaProxy.mover(tabuleiro, movimento);
            salvar();
        }
        
        if("baixo".equals(direcao)){
            movimento = new MovimentoBaixo();
            pecaProxy.mover(tabuleiro, movimento);
            salvar();
        }
       
    }
    
    public void salvar(){
        pecaProxy.getPeca().salvarEstado(novoJogo, tabuleiro, memoria);
    }
  
}