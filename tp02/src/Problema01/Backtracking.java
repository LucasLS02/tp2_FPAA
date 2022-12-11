package Problema01;

import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.Collections;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.LinkedHashMap;

public class Backtracking {

    public static boolean compararResultados(Map<Integer, Map<Integer, Integer>> comparar, Map<Integer, Map<Integer, Integer>> atual) {
        IntSummaryStatistics atualEstatisticas = atual.values().stream().mapToInt(c -> c.values().stream().mapToInt(a -> a).sum()).summaryStatistics();
        IntSummaryStatistics compararEstatisticas = comparar.values().stream().mapToInt(c -> c.values().stream().mapToInt(a -> a).sum()).summaryStatistics();
        if(atualEstatisticas.getMax() == 0) {
            return true;
        }
        return atualEstatisticas.getMax() - atualEstatisticas.getMin() >
            compararEstatisticas.getMax() - compararEstatisticas.getMin();
    }

    public static boolean poda(Map<Integer, Map<Integer, Integer>> caminhoes, int caminhaoAtual, Map<Integer, Integer> rotas,
            Map<Integer, Map<Integer, Integer>> resultadoAtual, double coeficiente, int valorRota) {
        IntSummaryStatistics estatisticas = caminhoes.values().stream().mapToInt(a -> a.values().stream().mapToInt(b -> b).sum()).summaryStatistics();
        int quilometragemCaminhao = caminhoes.get(caminhaoAtual).values().stream().mapToInt(a -> a).sum();
        return quilometragemCaminhao <= coeficiente &&
        estatisticas.getMax() - (quilometragemCaminhao + valorRota) <= rotas.values().stream().mapToInt(a -> a).max().orElse(0);
    }

    public static void inserirValores(Map<Integer, Map<Integer, Integer>> caminhoes, Map<Integer, Map<Integer, Integer>> resultado) {
        for (int j = 0; j < caminhoes.size(); j++) {
            resultado.put(j, new HashMap<>());
        }
        resultado.forEach((key, value) -> {
            value.putAll(caminhoes.get(key));
        });
    }

    public static void backTracking( Map<Integer, Map<Integer, Integer>> caminhoes,
            Map<Integer, Integer> rotasDisponiveis, double coeficiente, int rotaAtual,  Map<Integer, Map<Integer, Integer>> resultadoAtual) {
        if(resultadoAtual.values().stream().mapToInt(c -> c.values().stream().mapToInt(a -> a).sum()).sum() == 0) {
            if (rotaAtual <= rotasDisponiveis.size()) {
                for(int caminhaoAtual = 0; caminhaoAtual < caminhoes.size(); caminhaoAtual++) {
                    if(poda(caminhoes, caminhaoAtual, rotasDisponiveis, resultadoAtual, coeficiente, rotasDisponiveis.get(rotaAtual))) {
                        caminhoes.get(caminhaoAtual).put(rotaAtual, rotasDisponiveis.get(rotaAtual));
                        backTracking(caminhoes, rotasDisponiveis, coeficiente, rotaAtual + 1, resultadoAtual);
                        caminhoes.get(caminhaoAtual).remove(rotaAtual);
                    }
                }
            }
            if(rotasDisponiveis.size() < rotaAtual) {
                if(compararResultados(caminhoes, resultadoAtual)) {
                    inserirValores(caminhoes, resultadoAtual);
                }
            }
        }
    }

    public static Map<Integer, Map<Integer, Integer>> distribuirRotas(Map<Integer, Integer> rotas) {

        // Getting the number of trucks and removing it from the map.
        int numCaminhoes = rotas.get(0);

        rotas.remove(0);

        // Creating a map of maps.
        Map<Integer, Map<Integer, Integer>> resultados = new HashMap<>();

        Map<Integer, Map<Integer, Integer>> caminhoes = new HashMap<>();

        // Creating a map for each truck.
        for (int j = 0; j < numCaminhoes; j++) {
            caminhoes.put(j, new HashMap<>());
            resultados.put(j, new HashMap<>());
        }

        // Sorting the routes by the value of the route.
        Map<Integer, Integer> rotasOrdenadas = rotas.entrySet().stream()
                .sorted(Collections.reverseOrder(Entry.comparingByValue()))
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        // Calculating the average weight of the routes.
        double coeficientePesoMedio = Math
                .ceil(((rotas.values().stream().mapToInt(x -> x).sum()) / (float) numCaminhoes));

        backTracking(caminhoes, rotasOrdenadas, coeficientePesoMedio, 1, resultados);

        return resultados;

    }

}
