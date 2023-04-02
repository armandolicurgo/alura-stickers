//import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;


public class App {
    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {


        API api = API.NASA_APOD;

        final String url = api.getUrl();
        var extrator = api.getExtrator();

        //final String url = "";
        //var extrator = new ExtratorDeConteudoDaNasa();

        var http = new ClienteHttp();
        String json = http.buscaDados(url);
        
        GeradoraDeFigurinhas geradora = new GeradoraDeFigurinhas();


        var conteudos = extrator.extraiConteudos(json);


        for (int i = 0; i < 3; i++) {

            Conteudo conteudo = conteudos.get(i);

            InputStream inputStream = new URL(conteudo.urlDaImagem()).openStream();
            String nomeArquivo = "saida/" + conteudo.titulo() + ".png";

            geradora.cria(inputStream, nomeArquivo);

            System.out.println(conteudo.titulo());
            System.out.println();

        }    

    }

}
