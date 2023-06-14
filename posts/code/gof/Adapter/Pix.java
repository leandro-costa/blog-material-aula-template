package com.mycompany.adapter;

public class Pix {
    private double chave;
    private String tipo;

    public Pix(double chave, String tipo) {
        this.chave = chave;
        this.tipo  = tipo;
    }

    public double getChave() {
        return chave;
    }

    public String getTipo() {
        return tipo;
    }
   
}
