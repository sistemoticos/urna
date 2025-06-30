package com.urnaEletronica.model;

import java.time.LocalDateTime;

public class Voto {
    private String numeroVotado;
    private LocalDateTime horario;
    
    
    public Voto(String numeroVotado) {
        this.numeroVotado = numeroVotado;
        this.horario = LocalDateTime.now();
        
    }
    public String getNumeroVotado(){
        return numeroVotado;
    }
    public LocalDateTime getHorario(){
        return horario;
    }
}
