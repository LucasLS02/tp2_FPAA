package Problema01;

import java.util.Map;
import java.util.HashMap;

public class Backtracking {

    public static void backTracking(
            Map<Integer, Map<Integer, Integer>> caminhao, Map<Integer, Integer> rotas, double coeficiente) {

        caminhao.forEach((key, value) -> {
            System.out.println("");
            System.out.println("Key: " + key);
            System.out.println("Value: " + value);
            System.out.println("Coeficiente: " + coeficiente);
            System.out.println("Rotas: " + rotas);

            System.out.println("-----------------------------------------------------");
            System.out.println("");

        });
    }

    public static Map<Integer, Map<Integer, Integer>> distribuirRotas(Map<Integer, Integer> rotas) {

        // Getting the number of trucks and removing it from the map.
        int numCaminhoes = rotas.get(0);

        rotas.remove(0);

        // Creating a map of maps.
        Map<Integer, Map<Integer, Integer>> resultados = new HashMap<>();

        // Creating a map for each truck.
        for (int j = 0; j < numCaminhoes; j++) {
            resultados.put(j, new HashMap<>());
        }

        // Calculating the average weight of the routes.
        double coeficientePesoMedio = Math
                .ceil(((rotas.values().stream().mapToInt(x -> x).sum()) / (float) numCaminhoes));

        backTracking(resultados, rotas, coeficientePesoMedio);

        return resultados;

    }

}
