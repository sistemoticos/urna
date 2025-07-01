package com.urnaEletronica.model;

//classe q representa um candidato da urna eletrônica
public class Candidato {
    private String numero;//número do candidato
    private String nome;//nome do candidato
    private String partido;//partido do candidato
    private String foto;//foto do candidato
    
    //definindo atributos de um candidato
public Candidato(String numero, String nome, String partido, String foto){
    this.numero = numero; 
    this.nome = nome;
    this.partido = partido;
    this.foto = foto;
}

public String getNumero()   { return numero; }//retorna o número do candidato
public String getNome()   { return nome; }//retorna o nome do candidato
public String getPartido()   { return partido; }//retorna o partido do candidato
public String getFoto()   { return foto; }//retorna o caminho da foto do candidato

public void setNumero(String numero) { this.numero = numero; }//atualiza o número do candidato
public void setNome(String nome) { this.nome = nome; }//atualiza o nome do candidato
public void setPartido(String partido) { this.partido = partido; }//atualiza o partido
public void setFoto(String foto) { this.foto = foto; }//atualiza a foto do candidato
}
