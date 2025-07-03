package com.urnaEletronica.banco;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.text.DecimalFormat;

public class RelatorioDAO {
    private MongoClient mongoClient;//cliente do mongodb
    private MongoDatabase database;//banco de dados
    private MongoCollection<Document> colecaoVotos;//coleção no mongodb
    private DecimalFormat df = new DecimalFormat("0.00");//formata numero decimal com 2 casas

        //conectaa o banco e seleciona a coleção
    public RelatorioDAO() {
        mongoClient = MongoClients.create("mongodb://localhost:27017");//conecta no mongo
        database = mongoClient.getDatabase("urnaEletronica");//seleciona o banco
        colecaoVotos = database.getCollection("votos");//seleciona a coleção
    }

    //gera o relatorio com a porcentagme e o total de votos
    public String gerarRelatorio() {
        long total = colecaoVotos.countDocuments();//total de votos

        //contabranco e nulo
        long brancos = colecaoVotos.countDocuments(new Document("branco", true));
        long nulos   = colecaoVotos.countDocuments(new Document("nulo", true));

        //criando o relatorio
        
        StringBuilder sb = new StringBuilder();//monta o texto do relatorrio
        sb.append("Total de votos: ").append(total).append("\n\n");//total
        
        /*sb é o StringBuilder(montar textos grandes sem usarr mais strings) 
        e o .append() é o metodo que adiciona um pedaço de texto no final do sb*/
        
        //branco e nulo com porcentagem e quantidade
        sb.append("Votos Brancos: ")
          .append(df.format(brancos * 100.0 / total)).append("% (")
          .append(brancos).append(" votos)\n");
        sb.append("Votos Nulos: ")
          .append(df.format(nulos * 100.0 / total)).append("% (")
          .append(nulos).append(" votos)\n\n");

        //numero de candidato distinto na coleção
        for (String numero : colecaoVotos.distinct("numeroVotado", String.class)) {
        if (numero.equalsIgnoreCase("Branco")) continue;

        //conta votos válidos para esse candidato (não branco nem nulo)
        long count = colecaoVotos.countDocuments(new Document("numeroVotado", numero)
                                            .append("branco", false)
                                            .append("nulo", false));
        //adiciona candidato, porcentagem e quantidade de votos
        sb.append("Candidato (").append(numero).append("): ")
        .append(df.format(count * 100.0 / total)).append("% (")
        .append(count).append(" votos)\n");
}

        mongoClient.close();//fecha conexão
        return sb.toString();//retorna o relatorio
    }
}
