package com.urnaEletronica.controller;

import com.urnaEletronica.model.Candidato;

import java.util.ArrayList;
import java.util.List;

public class Verificador {
    //lista pra armazenar os candidatos que vão estar disponiveis
    private List<Candidato> listaCandidatos;
    
    //adicionando os candidatos
    public Verificador(){
        listaCandidatos = new ArrayList<>();
        
        //partido dos esportes
        listaCandidatos.add(new Candidato("91001", "Golfe", "PEsp", "fotos/golfe.jpg"));
        listaCandidatos.add(new Candidato("91002", "Beisebol", "PEsp", "fotos/beisebol.jpg"));
        listaCandidatos.add(new Candidato("91003", "Ginástica Artística", "PEsp", "fotos/ginastica.jpg"));
        
        //partido dos ritmos musicais
        
    }
    
    
    
}
