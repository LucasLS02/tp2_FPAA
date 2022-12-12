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

        int maxSoma = Math.max(eSoma + dSoma, Math.max(eSoma, dSoma));

        if (maxSoma > maiorSoma) {
            maiorSoma = maxSoma;
            if ((eSoma + dSoma) > Math.max(eSoma, dSoma)) {
                maiorPeriodo = String.format("Período: %s - %s\nAcumulo temperatura: %d",
                        new Data().geraData(eFirst + 1), new Data().geraData(dLast + 2), maiorSoma);
            } else if (eSoma > dSoma) {
                maiorPeriodo = String.format("Período: %s - %s\nAcumulo temperatura: %d",
                        new Data().geraData(eFirst + 1), new Data().geraData(eLast + 2), maiorSoma);
            } else {
                maiorPeriodo = String.format("Período: %s - %s\nAcumulo temperatura: %d",
                        new Data().geraData(dFirst + 1), new Data().geraData(dLast + 2), maiorSoma);
            }
        }

        return maxSoma;
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
