package com.mycompany.adapter;

public class Client {

    public static void main(String[] args) {
        
        Pagamento pagamentoDinheiro = new PagamentoEmDinheiro();
        pagamentoDinheiro.fazerPagamento(11);
        pagamentoDinheiro.retornarTroco(10);
        
        
        Pagamento pagamentoPix = new PixAdapter(02233.4, "Chave Aleatória");
        pagamentoPix.fazerPagamento(11);
        pagamentoPix.retornarTroco(10);
       
         
    }
}
