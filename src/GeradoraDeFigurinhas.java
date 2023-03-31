import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas  {
    
    public void cria(InputStream inputStream, String nomeArquivo) throws Exception {


        // leitura da image
        
        // cria a imagem em memória e com transparência e tamanho novo
        //BufferedImage imagemOriginal = ImageIO.read(new File("entrada/filme.jpg"));
        //InputStream inputStream = new FileInputStream(new File("entrada/filme.jpg"));
        //InputStream inputStream = 
        //new 
        //URL("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies_10.jpg")
        //.openStream();

        BufferedImage imagemOriginal = ImageIO.read(inputStream);
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        final int novaAltura = (int)(altura * 1.2);
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        // copiar a imagem original para nova imagem
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0,0, null);

        // configurar a fonted
        var fonte = new Font(Font.MONOSPACED, Font.BOLD, (int)largura/7);
        graphics.setFont(fonte);


        // escrever uma frase na nova imagem
        graphics.setColor(Color.YELLOW);
        graphics.drawString("  TOPZERA",0,novaAltura-100);


        // escrever a imagem nova em um arquivo
        ImageIO.write(novaImagem, "png", new File(nomeArquivo));

    }

    /*
    public static void ma in(String[] args) throws Exception {

        var geradora = new GeradoraDeFigurinhas();
        InputStream inputStream = 
        new 
        URL("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies_10.jpg")
        .openStream();

        geradora.cria(inputStream, "saida/figurinha.jpg");
    }
     */

    public GeradoraDeFigurinhas() {
    }
    public GeradoraDeFigurinhas(String s) {
    }

}
