package com.urnaEletronica.banco;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.urnaEletronica.model.Voto;
import org.bson.Document;

public class VotoDAO {
    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> colecaoVotos;

    public VotoDAO() {
        mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
        database = mongoClient.getDatabase("urnaEletronica");
        colecaoVotos = database.getCollection("votos");
    }

    public void registrarVoto(Voto voto) {
        Document doc = new Document("numeroVotado", voto.getNumeroVotado())
            .append("branco", voto.isBranco())
            .append("nulo", voto.isNulo())
            .append("horario", voto.getHorario().toString());
        colecaoVotos.insertOne(doc);
    }

    public void close() {
        mongoClient.close();
    }
}
