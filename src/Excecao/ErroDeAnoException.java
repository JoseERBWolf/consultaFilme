package Excecao;

public class ErroDeAnoException extends RuntimeException {

    private String mensagem;

    public ErroDeAnoException(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public String getMessage() {
        return this.mensagem;
    }
}
