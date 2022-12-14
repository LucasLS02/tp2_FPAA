package Problema01;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class app {

    static String meuCaminho = "C:/Users/celfa/OneDrive/Documentos/GitHub/tp2_FPAA/tp02/src/Problema01/inputs/";

    public static void main(String[] args) {

        List<String> arquivosDeTeste = new ArrayList<>();

        arquivosDeTeste.add("caminhoes_compacto.txt");
        arquivosDeTeste.add("caminhoes_disperso.txt");
        arquivosDeTeste.add("caminhoes_longo.txt");

        for (String arquivoTest : arquivosDeTeste) {

            Map<Integer, Integer> valoresDeTeste = LeitorDeArquivo.lerArquivo(meuCaminho + arquivoTest);

            // System.out.println("");
            // System.out.println("Análise do arquivo " + arquivoTest);

            // System.out.println("-----------------------------------------------------");

            // System.out.println("");
            // System.out.println("Input: " + valoresDeTeste);
            // System.out.println("");

            // Long tempoInicial = System.nanoTime();

            // Map<Integer, Map<Integer, Integer>> resultado =
            // Guloso.distribuirRotasGuloso(valoresDeTeste);

            // Long tempoFinal = System.nanoTime();

            // System.out.println("-----------------------------------------------------");
            // System.out.println("Tempo de execução(em milisegundos): " + (tempoFinal -
            // tempoInicial) / 1_000_000);
            // System.out.println("-----------------------------------------------------");

            // System.out.println("");
            // System.out.println("Output: " + resultado);
            // System.out.println("");

            // System.out.println("-----------------------------------------------------");
            // System.out.println("");

            // System.out.println("");
            // System.out.println("");

            // System.out.println("");
            // System.out.println("-----------------------------------------------------");

            Long tempoInicial = System.currentTimeMillis();

            Map<Integer, Map<Integer, Integer>> test = Backtracking.distribuirRotas(valoresDeTeste);

            System.out.println("-----------------------------------------------------");
            System.out.println(test);
            System.out.println("-----------------------------------------------------");
            test.values().stream().forEach(a -> System.out.println(a.values().stream().mapToInt(b -> b).sum()));
            System.out.println();

            Long tempoFinal = System.currentTimeMillis();

            System.out.println("Tempo de execução(em milisegundos): " + (tempoFinal - tempoInicial));
        }

    }

}
