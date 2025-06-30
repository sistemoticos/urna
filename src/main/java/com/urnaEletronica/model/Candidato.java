package com.urnaEletronica.model;

public class Candidato {
    private String numero;
    private String nome;
    private String partido;
    private String foto;
    
public Candidato(String numero, String nome, String partido, String foto){
    this.numero = numero; 
    this.nome = nome;
    this.partido = partido;
    this.foto = foto;
}

public String getNumero()   { return numero; }
public String getNome()   { return nome; }
public String getPartido()   { return partido; }
public String getFoto()   { return foto; }

public void setNumero() { this.numero = numero; }
public void setNome() { this.nome = nome; }
public void setPartido() { this.partido = partido; }
public void setFoto() { this.foto = foto; }
}
