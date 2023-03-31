public class Conteudo {
    
    private final String titulo;
    private final String urlDaImagem;

    public Conteudo(String titulo, String urlDaImagem) {
        this.titulo = titulo;
        this.urlDaImagem = urlDaImagem;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public String getUrlDaImagem() {
        return this.urlDaImagem;
    }

}