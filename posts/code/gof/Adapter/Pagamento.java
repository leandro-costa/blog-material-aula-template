package com.mycompany.adapter;

public interface Pagamento {
    public double fazerPagamento(double value);
    public double retornarTroco(double valorDaCompra);
}
