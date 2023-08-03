package com.mycompany.framework;

import com.mycompany.framework.TiposDePecas.Peca;

public abstract class Tabuleiro {
    public int altura;
    public int largura;
    public Peca[][] tabela;

    public Tabuleiro(int altura, int largura) {
        this.altura  = altura;
        this.largura = largura;
        tabela       = new Peca[altura][largura];
    }
    
    public void inicializarTabuleiro() {
        criarTabuliero();
        mostarTabuliero();
    }
    
    public void criarTabuliero(){
    for (int i = 0; i < this.altura; i++) {
        for (int j = 0; j < this.largura; j++) {
            tabela[i][j] = null;
    }
    
}}
    
    public void mostarTabuliero(){
    System.out.println("-- TABELA --");
    for (int i = 0; i < this.altura; i++) {
        for (int j = 0; j < this.largura; j++) {
        System.out.print(tabela[i][j] + " ");
    }
    System.out.println();
}}
    
    public void AtualizarPecaNoTabuleiro(Peca peca){ 
        System.out.println("-- TABULEIRO ATUAL -- ");
        tabela[peca.y][peca.x] = peca;
        mostarTabuliero();
     
    }
    protected void posicionarPecas(Peca peca){
        this.tabela[peca.y] [peca.x] = peca;
        mostarTabuliero();
    }
}
