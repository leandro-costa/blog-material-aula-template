package com.mycompany.adapter;

public class PagamentoEmDinheiro implements Pagamento{
    double value;

    @Override
    public double fazerPagamento(double value){
        System.out.println("O pagamento foi feito em dinheiro: R$ " + value);
        this.value = value;
        return value;
        
    }
    @Override
    public double retornarTroco(double valorDaCompra){
        double troco = this.value - valorDaCompra;
        if(troco <= 0){
            troco = 0;
        }
        System.out.println("Seu troco é R$ " + troco);
        return troco;
        
    }
    
}
