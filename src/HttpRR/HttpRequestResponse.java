package HttpRR;

import Filme.FilmeOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpRequestResponse {

    public FilmeOmdb buscaFilme(String urlFilme) throws IOException, InterruptedException {

        URI endereco = URI.create("http://www.omdbapi.com/?t=" + urlFilme.replace(" ", "+") + "&apikey=932db2c7");

            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                    .setPrettyPrinting()
                    .create();

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(endereco)
                    .build();


            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            FilmeOmdb filmeOmdb = gson.fromJson(response.body(), FilmeOmdb.class);
            return filmeOmdb;

    }

}
