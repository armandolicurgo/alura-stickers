import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;
import java.net.URL;
import java.io.FileInputStream;
import java.io.InputStream;


public class App {
    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        // Abrir conexao http, versao nova
        // Guardar o conteudo em uma string
        // buscar os top 250 filmes

        // url original do servico - limitada em 100 chamadas diarias
        // final String url = "https://imdb-api.com/en/API/Top250Movies/k_rg1s0lsu";

        // mockado para evitar o limite de uso da api original
        //final String url = "http://127.0.0.1:5000/mockapi/k_rg1s0lsu";
        final String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";

        //final String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/MostPopularTVs.json";

        // formatacao no terminal
        final String negrito = "\u001b[1m";
        final String semNegrito = "\u001b[m";

        // emoji utilizado para mostrar o rating visualmente
        final String estrelaAmarela = "\u2B50";
    
        

        URI endereco = URI.create(url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(endereco)
           .GET()
           .build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
        System.out.println(body);

        // parsear somente os campos desepjados
        //   o titulo, o poster, a avaliacao

        JsonParser parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);

        // exibir e manipular os dados que desejar
        GeradoraDeFigurinhas geradora = new GeradoraDeFigurinhas();

        for (Map<String,String> filme : listaDeFilmes) {

            String tituloDoFilme = filme.get("title");
            String urlDaImagem = filme.get("image");

            //System.out.println(negrito+"URL da Imagem:"+semNegrito+" "+urlDaImagem);
            System.out.println(negrito+"Título:"+semNegrito+" "+tituloDoFilme);

            InputStream inputStream = new URL(urlDaImagem).openStream();
    
            geradora.cria(inputStream, "saida/"+tituloDoFilme+".png");
          
            //System.out.println(filme.get("imDbRating"));
            for (int index = 0; index < (int)Float.parseFloat(filme.get("imDbRating")); index++) {                
                System.out.print(estrelaAmarela);
            }
            System.out.println();            
        }
    }

}
