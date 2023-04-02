public enum API {
    IMDB_TOP_MOVIES("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json", new ExtratorDeConteudoDoIMDB()),
    LOCAL_PARA_TESTES("http://127.0.0.1:5000/mockapi/armando", new ExtratorDeConteudoDoIMDB()),
    NASA_APOD("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/NASA-APOD.json", new ExtratorDeConteudoDaNasa());

    private String url;
    private ExtratorDeConteudo extrator;

    API(String url, ExtratorDeConteudo extrator) {
        this.url = url;
        this.extrator = extrator;
    }
    public String getUrl() {
        return this.url;
    }
    public ExtratorDeConteudo getExtrator() {
        return this.extrator;
    }
}
