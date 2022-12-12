package problema02;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class app {

    static String meuCaminho = "./tp02/src/problema02/inputs/";

    public static void main(String[] args) {

        List<String> arquivosDeTeste = new ArrayList<>();

        arquivosDeTeste.add("temperaturas.txt");
        arquivosDeTeste.add("temperaturasExtremo.txt");

        List<Integer> todasTemperaturas = new LinkedList<Integer>();

        Map<Integer, List<Integer>> valoresTemperaturas = LeitorDeArquivo
                .lerArquivo(meuCaminho + arquivosDeTeste.get(0));

        valoresTemperaturas.forEach((key, value) -> {

            List<Integer> arr = new ArrayList<Integer>();

            for (int i = 0; i < value.size() - 2; i++) {
                arr.add(value.get(i + 1) - value.get(i));
            }

            System.out.println("");
            DivisaoEConquista d1 = new DivisaoEConquista();
            d1.divisaoEConquista(arr, 0, arr.size() - 1);
            System.out.println("Ano: " + key);
            System.out.println(d1.getMaiorPeriodo());
            System.out.println("-----------------------------------------------------");
            System.out.println("");

            arr.stream().forEach(num -> todasTemperaturas.add(num));

        });

        DivisaoEConquista d2 = new DivisaoEConquista();
        d2.divisaoEConquista(todasTemperaturas, 0, todasTemperaturas.size() - 1);
        System.out.println("Todos os anos");
        System.out.println(d2.getMaiorPeriodo());
        System.out.println("-----------------------------------------------------");
        System.out.println("");

        todasTemperaturas.clear();

        Map<Integer, List<Integer>> valoresTemperaturasExtremas = LeitorDeArquivo
                .lerArquivo(meuCaminho + arquivosDeTeste.get(1));

        valoresTemperaturasExtremas.forEach((key, value) -> {

            List<Integer> arr = new ArrayList<Integer>();

            for (int i = 0; i < value.size() - 2; i++) {
                arr.add(value.get(i + 1) - value.get(i));
            }

            System.out.println("");
            DivisaoEConquista d3 = new DivisaoEConquista();
            d3.divisaoEConquista(arr, 0, arr.size() - 1);
            System.out.println("Ano: " + (key == 10 ? key / 2 : key % 5));
            System.out.println(d3.getMaiorPeriodo());
            System.out.println("-----------------------------------------------------");
            System.out.println("");

            arr.stream().forEach(num -> todasTemperaturas.add(num));

        });

        DivisaoEConquista d = new DivisaoEConquista();
        d.divisaoEConquista(todasTemperaturas, 0, todasTemperaturas.size() - 1);
        System.out.println("Todos os anos");
        System.out.println(d.getMaiorPeriodo());
        System.out.println("-----------------------------------------------------");
        System.out.println("");
    }
}
