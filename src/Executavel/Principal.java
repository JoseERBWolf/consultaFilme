package Executavel;

import Arquivo.GeradorDeArquivos;
import Excecao.ErroDeAnoException;
import Filme.FilmeOmdb;
import Filme.FilmeTitulo;
import HttpRR.HttpRequestResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        HttpRequestResponse http = new HttpRequestResponse();
        GeradorDeArquivos arquivo = new GeradorDeArquivos();
        List<FilmeTitulo> filmesLista = new ArrayList<>();



        String opcao = "";

        System.out.println("Digite nome de algum filme: ");
        String urlFilme = scanner.nextLine();

        while (!opcao.equalsIgnoreCase("nao") || !opcao.equalsIgnoreCase("não")){

            try {
                FilmeOmdb novoFilme = http.buscaFilme(urlFilme);
                FilmeTitulo filmeTitulo = new FilmeTitulo(novoFilme);
                filmesLista.add(filmeTitulo);
                System.out.println("Filme encontrado!");

            } catch (NumberFormatException e){
                System.out.println("Aconteceu algum erro com algum valor numérico: ");
                System.out.println(e.getMessage());
            }catch (IllegalArgumentException e){
                System.out.println("Não foi possível encontrar o filme descrito");
                System.out.println(e.getMessage());
            } catch (ErroDeAnoException e) {
                System.out.println(e.getMessage());
            }

            System.out.println("Escolher outro filme? \"sim\" ou \"nao\".");
            opcao = scanner.nextLine();

            if(opcao.equalsIgnoreCase("nao") || opcao.equalsIgnoreCase("não")){
                System.out.println("encerrando");
                break;
            }else if(opcao.equalsIgnoreCase("sim")) {
                System.out.println("Digite nome de algum filme: ");
                urlFilme = scanner.nextLine();
            }
        }

        Collections.sort(filmesLista);
        for(FilmeTitulo x : filmesLista){
            System.out.println(x.toString());
        }
        arquivo.gerarArquivoJson(filmesLista);



    }

}
