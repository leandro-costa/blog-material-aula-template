package com.mycompany.adapter;

public class PixAdapter implements Pagamento{
    private double chave;

    public PixAdapter(double chave) {
        this.chave = chave;
    }
    
    @Override
    public double fazerPagamento(double value) {
        System.out.println("O pagamento foi feito no pix: R$ " + value);
        return value;
       
    }

    @Override
    public double retornarTroco(double valorDaCompra) {
        System.out.println("Essa função não está disponível no Pix");
        return 0.0;
        
    }
    
    public double retornarChavePixQuefoiPaga(){
        System.out.println("A chave do cobrador é" + this.chave);
        return this.chave;
        
    }
    
}
