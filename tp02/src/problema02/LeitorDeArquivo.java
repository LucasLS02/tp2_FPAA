package Problema01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class LeitorDeArquivo {

    /**
     * It reads a file and returns a map with the values of the file
     * 
     * @param caminho path to the file
     * @return A map with the values of the file.s
     */

    public static Map<Integer, Integer> lerArquivo(String caminho){

        Map<Integer, Integer> valores = new HashMap<>();

        try (BufferedReader buffRead = new BufferedReader(new FileReader(caminho))) {
            String linha = buffRead.readLine();

            valores.put(0, Integer.parseInt(linha));

            linha = buffRead.readLine();

            while(linha != null){
                String[] rotas = linha.split(";");

                valores.put(Integer.parseInt(rotas[0]), Integer.parseInt(rotas[1]));
                linha = buffRead.readLine();

            }

            buffRead.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

		return valores;
    }
}
