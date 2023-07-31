package Filme;


import Excecao.ErroDeAnoException;

public class FilmeTitulo  implements Comparable<FilmeTitulo>{

    private String titulo;
    private int anoLancamento;
    private int duracao;
    private String genero;

    private String diretor;

    public FilmeTitulo (FilmeOmdb filme) {
        this.titulo = filme.title();
        if(filme.year().length() > 4){
            throw new ErroDeAnoException("Não possível mostrar o filme, " +
                    "pois o ano tem mais de 04 caracteres");
        }
        this.anoLancamento = Integer.valueOf(filme.year());
        this.duracao = Integer.valueOf(filme.runtime().substring(0,3));
        this.genero = filme.genre();
        this.diretor = filme.director();
    }


    public String getTitulo() {
        return titulo;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public int getDuracao() {
        return duracao;
    }

    public String getGenero() {
        return genero;
    }

    public String getDiretor() {
        return diretor;
    }

    @Override
    public String toString() {
        return "titulo = " + titulo +
                ", anoLancamento = " + anoLancamento +
                ", duracao = " + duracao +
                ", genero = " + genero +
                ", diretor = " + diretor;
    }

    @Override
    public int compareTo(FilmeTitulo outroTitulo) {
        return this.getTitulo().compareTo(outroTitulo.getTitulo());
    }
}
