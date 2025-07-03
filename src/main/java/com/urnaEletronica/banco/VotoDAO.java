package com.urnaEletronica.banco;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.urnaEletronica.model.Voto;
import org.bson.Document;

public class VotoDAO {
    private MongoClient mongoClient;//cliente mongodb
    private MongoDatabase database;//banco de dados 
    private MongoCollection<Document> colecaoVotos;//coleção votos 

    public VotoDAO() {
        mongoClient = MongoClients.create("mongodb://localhost:27017");//conecta no mongo local
        database = mongoClient.getDatabase("urnaEletronica");//seleciona o banco
        colecaoVotos = database.getCollection("votos");//seleciona a coleção que é votos
    }
    
    //registra um voto no banco
    public void registrarVoto(Voto voto) {
        Document doc = new Document("numeroVotado", voto.getNumeroVotado())//numero que foi votado
                .append("branco", voto.isBranco())//se o voto é branco
                .append("nulo", voto.isNulo())//se o voto é nulo
                .append("horario", voto.getHorario().toString());//hora do voto
        colecaoVotos.insertOne(doc);//coloca o voto lá na coleção
    }

    //então fecha a conexão com o banco
    public void close() {
        mongoClient.close();
    }
}
