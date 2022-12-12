import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Scanner;

public class SolPgDinamica {
	static ArrayList<Rota> rotas = new ArrayList<Rota>();
	static int count = 0;


	

	static ArrayList<Integer> init(Map<Integer, Integer> map) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<(map.get(0));i++) {
			list.add(0);
		}
		for(int j=1;j<map.size();j++) {
			Rota x = new Rota(j,map.get(j));
			rotas.add(x);
			}
		Collections.sort(rotas, new Rota.KmComparator());
		return list;
		
		 
	}
	
	static int calculaDiferenca(ArrayList<Integer> l) {
		int diferenca=0;
		int aux;
	for(int i=0; i<l.size();i++) {		
		for(int j=0; j<l.size();j++) {
			if(i != j) {
				aux= l.get(i)-l.get(j);
				if(aux<0) {
					aux=aux*-1;
				}
					diferenca=diferenca+aux;
				}
			}	
		}
	return diferenca;
	}
		

	@SuppressWarnings("unchecked")
	public static ArrayList<Integer> distribuirRotas(ArrayList<Integer> sol ) {
		int diferenca = 0;
		if(count==rotas.size()) {
			return sol;
		}
		int aux;
		ArrayList<Integer> temp = sol;		
		for(int i=0; i<temp.size(); i++) {
			System.out.println("Solução mantida: "+sol);
			if(i!=0) {
				temp.set(i-1,temp.get(i-1)-rotas.get(count).getKm());
			}
			
			temp.set(i, temp.get(i)+rotas.get(count).getKm()); //coloca o valor em i
			aux=calculaDiferenca(temp);// calcula a diferenca
			System.out.println("Possivel solução: "+temp);
			if(aux<diferenca || diferenca == 0) {// se a diferenca diminuir:
				diferenca=aux;//atualiza melhor diferença
				sol=(ArrayList<Integer>) temp.clone();	//atualiza solucao				
			}
		}
		count++; 
		distribuirRotas(sol);
		return sol;
	}
	
	static public long start(ArrayList<Integer> solucao) {  	
		long inicio = System.currentTimeMillis();   		
		distribuirRotas(solucao);		
		long tempo = System.currentTimeMillis() - inicio;
		return tempo;
	}
	 public static void main(String []args) {
		 Scanner entrada = new Scanner(System.in);
		  System.out.println("1 para caminhoes_compacto");
		  System.out.println("2 para caminhoes_disperso");
		  System.out.println("3 para caminhoes_longo");
		  int numero = entrada.nextInt();
		   switch (numero) {
		     case 1:
		    	 ArrayList<Integer> solucao =  init(LeitorDeArquivo.lerArquivo("C:\\Users\\gabri\\eclipse-workspace\\TrampoFinal\\testes\\caminhoes_compacto.txt"));
		    	 System.out.println("Tempo em ms: " + start(solucao));
		    	 break;
		     case 2:
		    	 ArrayList<Integer> solucao2 =   init(LeitorDeArquivo.lerArquivo("C:\\Users\\gabri\\eclipse-workspace\\TrampoFinal\\testes\\caminhoes_disperso.txt"));
		    	 System.out.println("Tempo em ms: " + start(solucao2));
		    	 break;
		     case 3:
		    	 ArrayList<Integer> solucao3 = 	 init(LeitorDeArquivo.lerArquivo("C:\\Users\\gabri\\eclipse-workspace\\TrampoFinal\\testes\\caminhoes_longo.txt"));
		    	 System.out.println("Tempo em ms: " + start(solucao3));
		    	 break;
		     
		     default:
		       System.out.println("O número escolhido é inválido! Digite um número entre 1 a 10.");
		   }
		   entrada.close();
		 
		 
		 
		 
		 
	 }
}
