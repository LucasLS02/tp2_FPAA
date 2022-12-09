package problema02;

import javax.lang.model.element.Element;

public class Test {

    static String maiorPeriodo;
    static int maiorSoma = Integer.MIN_VALUE;

    static int maiorSomaMediana(int arr[], int inicio, int meio, int fim) {

        int soma = 0;
        int eSoma = Integer.MIN_VALUE;
        int eFirst = inicio;
        int eLast = 0;
        for (int i = meio; i >= inicio; i--) {
            soma = soma + arr[i];
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
            soma = soma + arr[i];
            if (soma > dSoma) {
                dSoma = soma;
                dLast = i;
            }
        }

        int test = Math.max(eSoma + dSoma, Math.max(eSoma, dSoma));

        if (test > maiorSoma) {
            maiorSoma = test;
            if ((eSoma + dSoma) > Math.max(eSoma, dSoma)) {
                maiorPeriodo = String.format("%d, %d, %d", eLast, dLast, maiorSoma);
            } else if (eSoma > dSoma) {
                maiorPeriodo = String.format("%d, %d, %d", eFirst, eLast, maiorSoma);
            } else {
                maiorPeriodo = String.format("%d, %d, %d", dFirst, dLast, maiorSoma);
            }
        }

        return Math.max(eSoma + dSoma,
                Math.max(eSoma, dSoma));
    }

    static int divisaoEConquista(int arr[], int inicio, int fim) {
        if (inicio == fim) {
            return arr[inicio];
        }

        int meio = (inicio + fim) / 2;

        return Math.max(Math.max(divisaoEConquista(arr, inicio, meio), divisaoEConquista(arr, meio + 1, fim)),
                maiorSomaMediana(arr, inicio, meio, fim));
    }

    public static void main(String[] args) {
        int arr[] = { -4, 1, -4, -2, -2, -1, -1, 0, -1, -2, 0, -3, -2, 1, 0, -4, -2, -4, -3, -4, 1, -2, -3, 1, -1, -2,
                0, -2, 1, -3, -2, -5, -6, -8, -4, -7, -7, -7, -3, -4, -3, -4, -3, -8, -4, -4, -5, -7, -8, -4, -8, -8,
                -3, -7, -6, -7, -8, -3, -5, 1, 2, -6, -5, 1, 0, 1, -4, -2, -5, -7, 6, 6, -12, -9, -13, 1, 5, -2, -8, 1,
                5, -1, -12, -12, -11, -3, 5, -13, 5, 4, -16, -13, -16, -13, -16, -14, -14, -14, -14, -17, -14, -14, -15,
                -14, -17, -15, -16, -16, -17, -15, -17, -17, -14, -14, -13, -12, -15, -14, -15, -17, -15, -14, -14, -15,
                -13, -17, -17, -15, -17, -18, -16, -16, -15, -15, -16, -14, -14, -19, -17, -15, -17, -14, -17, -15, -17,
                -16, -19, -15, -18, -17, -16, -20, -20, -21, -20, -21, -17, -16, -18, -18, -19, -16, -21, -21, -21, -21,
                -21, -17, -17, -17, -16, -21, -18, -20, -18, -17, -20, -20, -19, -19, -21, -23, -21, -22, -21, -22, -22,
                -21, -23, -22, -21, -21, -23, -23, -23, -22, -18, -22, -22, -22, -17, -19, -17, -18, -17, -23, -23, -21,
                -19, -17, -21, -22, -22, -17, -18, -22, -20, -22, -17, -20, -20, -22, -21, -18, -21, -21, -21, -17, -17,
                -22, -20, -20, -19, -20, -19, -18, -21, -19, -17, -21, -17, -19, -22, -16, -16, -16, -19, -14, -18, -19,
                -18, -19, -20, -18, -15, -14, -21, -16, -17, -19, -15, -18, -16, -18, -18, -15, -16, -15, -17, -16, -14,
                -16, -15, -13, -16, -14, -14, -15, -16, -16, -16, -12, -13, -12, -12, -14, -13, -11, -10, -13, -14, -13,
                -15, -16, -15, -12, -14, -15, -10, -13, -10, -12, -16, -16, -7, -10, -6, -9, -6, -10, -7, -7, -9, -8,
                -10, -7, -10, -8, -10, -7, -10, -7, -7, -10, -10, -11, -8, -10, -11, -9, -7, -11, -9, -6, -5, -7, -5,
                -7, -6, -2, -1, -7, -6, -3, -1, -6, -2, -6, -3, -6, -2, -2, -1, -2, -3, -3, -4, -4, -1, -2, -7, -4, -7,
                -4, -7 };
        int n = arr.length;
        int max_sum = divisaoEConquista(arr, 0, n - 1);

        System.out.println("Maximum contiguous soma is "
                + max_sum);

        System.out.println(maiorPeriodo);
    }
}
