package Problema01;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Guloso {

    /**
     * It sorts the routes by their value, and then adds them to the truck with the
     * lowest sum of
     * routes
     * 
     * @param rotas A map with the routes and their values.
     * @return A map with the routes distributed among the trucks.
     */
    static Map<Integer, Map<Integer, Integer>> distribuirRotasGuloso(Map<Integer, Integer> rotas) {
        int numCaminhoes = rotas.get(0);

        rotas.remove(0);

        Map<Integer, Map<Integer, Integer>> resultados = new HashMap<>();

        // Creating a map for each truck.
        for (int j = 0; j < numCaminhoes; j++) {
            resultados.put(j, new HashMap<>());
        }

        // Sorting the routes by the value of the route.
        Map<Integer, Integer> rotasOrdenadas = rotas.entrySet().stream()
                .sorted(Collections.reverseOrder(Entry.comparingByValue()))
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        for (int i = 0; i < rotasOrdenadas.size(); i++) {

            // Sorting the trucks by the sum of the routes they have.
            resultados = resultados.entrySet().stream()
                    .sorted(Entry.comparingByValue((a, b) -> {
                        int result = -1;
                        if (a.values().stream().mapToInt(x -> x).sum() > b.values().stream().mapToInt(x -> x).sum()) {
                            result = 1;
                        }
                        return result;

                    }))
                    .collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

            // Adding the route to the truck with the lowest sum of routes.
            resultados
                    .get(
                            resultados.keySet().toArray()[0])
                    .put(
                            Integer.parseInt(rotasOrdenadas.keySet().toArray()[i].toString()),
                            Integer.parseInt(rotasOrdenadas.values().toArray()[i].toString()));

        }

        return resultados;
    }

}
