package com.mycompany.framework;

public class JogoConcreto extends Jogo{

    @Override
    public Tabuleiro criarTabuleiro(int altura, int largura) {
        System.out.println("-- NOVO JOGO CRIADO --");
        return new TabuleiroConcreto(altura, largura);
    }
    
}
