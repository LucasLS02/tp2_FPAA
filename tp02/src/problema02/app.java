package problema02;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.rowset.spi.SyncResolver;

public class app {

    static String meuCaminho = "./tp02/src/problema02/inputs/";

    public static void main(String[] args) {

        List<String> arquivosDeTeste = new ArrayList<>();

        arquivosDeTeste.add("temperaturas.txt");
        arquivosDeTeste.add("temperaturasExtremo.txt");

        for (String arquivoTest : arquivosDeTeste) {

            Map<Integer, List<Integer>> valoresDeTeste = LeitorDeArquivo.lerArquivo(meuCaminho + arquivoTest);

            valoresDeTeste.forEach((key, value) -> {
                System.out.println("");
                System.out.println("Key: " + key);
                System.out.println("Value: " + value);
    
                System.out.println("-----------------------------------------------------");
                System.out.println("");
    
            });
        }
    }
}
