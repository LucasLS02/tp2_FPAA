package problema02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.swing.ListModel;

public class LeitorDeArquivo {

    /**
     * It reads a file and returns a map with the values of the file
     * 
     * @param caminho path to the file
     * @return A map with the values of the file.s
     */

    static int ano = 1;

    public static Map<Integer, List<Integer>> lerArquivo(String caminho) {
        
        Map<Integer, List<Integer>> valores = new HashMap<>();
        
        try (BufferedReader buffRead = new BufferedReader(new FileReader(caminho))) {
            String linha = buffRead.readLine();
            
            while (linha != null) {
                String[] rotas = linha.split(";");
                List<Integer> temperaturas = new LinkedList<Integer>();
                
                for (String num : rotas) {
                    temperaturas.add(Integer.parseInt(num));
                }
                
                valores.put(ano, temperaturas);
                linha = buffRead.readLine();
                ano++;
            }

            buffRead.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return valores;
    }
}
