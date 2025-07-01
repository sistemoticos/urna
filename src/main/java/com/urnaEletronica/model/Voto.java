package com.urnaEletronica.model;

//classe pra armazenar a data e a hora que foi feito o voto
import java.time.LocalDateTime; 


//classe que representa um voto na urna 
public class Voto {
    //número do candidato votado
    private String numeroVotado;
    //horário do voto
    private LocalDateTime horario;
    //voto em branco e nulo
    private boolean branco;
    private boolean nulo;
    
    //definindo atributos do voto
    public Voto(String numeroVotado, boolean branco, boolean nulo) {
        this.numeroVotado = numeroVotado; //número digitado pelo eleitor
        this.horario = LocalDateTime.now();//hora do voto
        this.nulo = nulo;//se for nulo
        this.branco = branco;//se for branco
    }
    
     public String getNumeroVotado() { return numeroVotado; }//retorna o número do candidato votado
     public LocalDateTime getHorario() { return horario; }//retorna a hora da votação
     public boolean isNulo() { return nulo; }//retorn se foi nulo
     public boolean isBranco() { return branco; }//retorna se foi branco
}
