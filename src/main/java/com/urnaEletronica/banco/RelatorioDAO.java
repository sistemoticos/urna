package com.urnaEletronica.banco;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.text.DecimalFormat;

public class RelatorioDAO {
    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> colecaoVotos;
    private DecimalFormat df = new DecimalFormat("0.00");

    public RelatorioDAO() {
        mongoClient = MongoClients.create("mongodb://localhost:27017");
        database = mongoClient.getDatabase("urnaEletronica");
        colecaoVotos = database.getCollection("votos");
    }

    public String gerarRelatorio() {
        long total = colecaoVotos.countDocuments();

        //contabranco e nulo
        long brancos = colecaoVotos.countDocuments(new Document("branco", true));
        long nulos   = colecaoVotos.countDocuments(new Document("nulo", true));

        //criando o relatorio
        StringBuilder sb = new StringBuilder();
        sb.append("Total de votos: ").append(total).append("\n\n");

        //branco e nulo
        sb.append("Votos Brancos: ")
          .append(df.format(brancos * 100.0 / total)).append("% (")
          .append(brancos).append(" votos)\n");
        sb.append("Votos Nulos: ")
          .append(df.format(nulos * 100.0 / total)).append("% (")
          .append(nulos).append(" votos)\n\n");

        //contar por candidato
        for (Document doc : colecaoVotos.distinct("numeroVotado", Document.class)) {
            String numero = doc.getString("_id") != null
                ? doc.getString("_id")
                : doc.toJson();
            // só candidatos válidos
            if (numero.equalsIgnoreCase("Branco")) continue;
            long count = colecaoVotos.countDocuments(new Document("numeroVotado", numero)
                                                        .append("branco", false)
                                                        .append("nulo", false));
            sb.append("Candidato (").append(numero).append("): ")
              .append(df.format(count * 100.0 / total)).append("% (")
              .append(count).append(" votos)\n");
        }

        mongoClient.close();
        return sb.toString();
    }
}
