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
        listaCandidatos.add(new Candidato("91001", "Golfe", "PEsp", "fotos/golfe.png"));
        listaCandidatos.add(new Candidato("91002", "Beisebol", "PEsp", "fotos/beisebol.png"));
        listaCandidatos.add(new Candidato("91003", "Ginástica Artística", "PEsp", "fotos/ginastica.png"));
        
        //partido dos ritmos musicais
        listaCandidatos.add(new Candidato("92001", "Rock", "PMus", "fotos/rock.png"));
        listaCandidatos.add(new Candidato("92002", "Sertanejo", "PMus", "fotos/sertanejo.png"));
        listaCandidatos.add(new Candidato("92003", "MPB", "PMus", "fotos/mpb.png"));
       
        //partido das profissões
        listaCandidatos.add(new Candidato("93001", "Astronauta", "PProf", "fotos/astronauta.png"));
        listaCandidatos.add(new Candidato("93002", "Pintor", "PProf", "fotos/pintor.png"));
        listaCandidatos.add(new Candidato("93003", "Enfermeira", "PProf", "fotos/enfermeira.png"));
        
        //partido das festas populares
        listaCandidatos.add(new Candidato("94001", "Páscoa", "PFest", "fotos/pascoa.png"));
        listaCandidatos.add(new Candidato("94002", "Oktoberfest", "PFest", "fotos/oktoberfest.png"));
        listaCandidatos.add(new Candidato("94003", "Reveillon", "PFest", "fotos/reveillon.png"));
        
        //partido do folclore
        listaCandidatos.add(new Candidato("95001", "Curupira", "PFolc", "fotos/curupira.png"));
        listaCandidatos.add(new Candidato("95002", "Cabra Cabriola", "PFolc", "fotos/cabra.png"));
        listaCandidatos.add(new Candidato("95003", "Cuca", "PFolc", "fotos/cuca.png"));
    }
        
        public Candidato buscarPorNumero(String numero){
            for (Candidato candidato : listaCandidatos){
                if (candidato.getNumero().equals(numero)){
                    return candidato;
                }
            }
    
           return null;
    
}
        //retorna lista completa de candidatos
        public List<Candidato> getTodosCandidatos() {
            return listaCandidatos;
        }
}
