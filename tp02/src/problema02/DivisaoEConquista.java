public class DivisaoEConquista {
    static void DivisaoEConquista(int a[], int inicio, int fim) {
        if (inicio == fim) {
            return a[inicio];
        } else if (inicio == fim - 1) {
            return a[fim] - a[inicio];
        } else {
            int meio = (fim + inicio) / 2;
            int eSoma = somatorio(a, inicio, meio); // soma lado esquerdo
            int dSoma = somatorio(a, meio + 1, fim); // soma lado direito

            return eSoma - dSoma;
        }
    }
}
