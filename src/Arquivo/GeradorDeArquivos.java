package Arquivo;

import Filme.FilmeTitulo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GeradorDeArquivos {

    public void gerarArquivoJson(List<FilmeTitulo> filmesLista)  throws IOException {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        FileWriter arquivoJson = new FileWriter("filmes.json");
        arquivoJson.write(gson.toJson(filmesLista));
        arquivoJson.close();

    }


}
