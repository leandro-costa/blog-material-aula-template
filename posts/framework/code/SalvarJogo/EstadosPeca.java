package com.mycompany.framework.SalvarJogo;
import java.util.List;
import java.util.ArrayList;

public class EstadosPeca {
    List <Estado> listaDeEstados;

    public EstadosPeca() {
        this.listaDeEstados = new ArrayList();
    }
    
    public void adicionarEstado(Estado estado){
        listaDeEstados.add(estado);
    }
    
    public Estado getEstado(int indice){
        return listaDeEstados.get(indice);
        
    }
     
}
