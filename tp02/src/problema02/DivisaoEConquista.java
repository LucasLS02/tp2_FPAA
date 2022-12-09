package problema02;

import java.util.List;

public class DivisaoEConquista {

    private String maiorPeriodo;
    private int maiorSoma = Integer.MIN_VALUE;

    public int maiorSomaMediana(List<Integer> arr, int inicio, int meio, int fim) {

        int soma = 0;
        int eSoma = Integer.MIN_VALUE;
        int eFirst = inicio;
        int eLast = 0;
        for (int i = meio; i >= inicio; i--) {
            soma = soma + arr.get(i);
            if (soma > eSoma) {
                eSoma = soma;
                eLast = i;
            }
        }

        soma = 0;
        int dSoma = Integer.MIN_VALUE;
        int dFirst = meio + 1;
        int dLast = 0;
        for (int i = meio + 1; i <= fim; i++) {
            soma = soma + arr.get(i);
            if (soma > dSoma) {
                dSoma = soma;
                dLast = i;
            }
        }

        int test = Math.max(eSoma + dSoma, Math.max(eSoma, dSoma));

        if (test > maiorSoma) {
            maiorSoma = test;
            if ((eSoma + dSoma) > Math.max(eSoma, dSoma)) {
                maiorPeriodo = String.format("Período: %d-%d\nAcumulo temperatura: %d", eLast, dLast, maiorSoma);
            } else if (eSoma > dSoma) {
                maiorPeriodo = String.format("Período: %d-%d\nAcumulo temperatura: %d", eFirst, eLast, maiorSoma);
            } else {
                maiorPeriodo = String.format("Período: %d-%d\nAcumulo temperatura: %d", dFirst, dLast, maiorSoma);
            }
        }

        return Math.max(eSoma + dSoma,
                Math.max(eSoma, dSoma));
    }

    public int divisaoEConquista(List<Integer> arr, int inicio, int fim) {

        if (inicio == fim) {
            return arr.get(inicio);
        }

        int meio = (inicio + fim) / 2;

        return Math.max(Math.max(divisaoEConquista(arr, inicio, meio), divisaoEConquista(arr, meio + 1, fim)),
                maiorSomaMediana(arr, inicio, meio, fim));
    }

    public void setMaiorPeriodo(String maiorPeriodo) {
        this.maiorPeriodo = maiorPeriodo;
    }

    public String getMaiorPeriodo() {
        return maiorPeriodo;
    }

    public void setMaiorSoma(int maiorSoma) {
        this.maiorSoma = maiorSoma;
    }

    public int getMaiorSoma() {
        return maiorSoma;
    }
}
