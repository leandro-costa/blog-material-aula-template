package com.mycompany.adapter;

public class Client {

    public static void main(String[] args) {
        Pagamento pd = new PagamentoEmDinheiro();
        pd.fazerPagamento(49.50);
        pd.retornarTroco(50.50);
        
        PixAdapter pp = new PixAdapter(234332.0);
        pp.fazerPagamento(12.90);
        pp.retornarTroco(13.00);
        pp.retornarChavePixQuefoiPaga();
         
    }
}
