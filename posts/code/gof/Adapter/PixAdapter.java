package com.mycompany.adapter;

public class PixAdapter implements Pagamento{
    private double chave;
    private String tipo;
    Pix pix;

    public PixAdapter(double chave, String tipo) {
        this.chave = chave;
        this.tipo  = tipo;
        this.pix   = new Pix(this.chave, this.tipo); }
    
    @Override
    public double fazerPagamento(double value){
        System.out.println("O pagamento foi feito no Pix: R$ " + value);
        System.out.println("Chave: " + pix.getChave());
        System.out.println("Tipo: "  + pix.getTipo());
        return value;
        
    }
    
    @Override
    public double retornarTroco(double valorDaCompra){
        System.out.println(" - Essa função não está disponível no Pix");
        return 0.0;
    }
    
  
  

 
    
}
