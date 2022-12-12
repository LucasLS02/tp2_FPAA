import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Scanner;

public class SolPgDinamica2 {
	static ArrayList<Caminhao> cs = new ArrayList<Caminhao>();
	static ArrayList<Rota> rotas = new ArrayList<Rota>();
	static int count = 0;
	static int cp; // coeficiente perfeito
	

	static void init(Map<Integer, Integer> map) {
		int sum=0;
		for(int j=1;j<map.size();j++) {
			Rota x = new Rota(j,map.get(j));
			rotas.add(x);
			}
		Collections.sort(rotas, new Rota.KmComparator());
		for(int i=0;i<rotas.size();i++) {
			sum+=rotas.get(i).getKm();
		}
		cp=sum/map.get(0);
		for(int i=0;i<map.get(0);i++) {
			Caminhao c = new Caminhao();
			cs.add(c);
			
		}	 
	}
	
	static int calculaSoma(ArrayList<Rota> l) {
		int soma=0;
		for(int i=0; i<l.size();i++) {
		 soma+=l.get(i).getKm();
		}
	return soma;
	}
	
	static int dif(int i) {
		if(i>0) {
			return i;
		}
		else {
			return i*-1;
		}
	}

	@SuppressWarnings("unchecked")
	static void  distribuirRotas( ) {
		if(count==cs.size()) {
			return;
		}		
		while(calculaSoma(cs.get(count).rotas)<cp) {
			int i=0;
			if(rotas.size()!=0) {
			cs.get(count).rotas.add(rotas.get(i));
			rotas.remove(i);			
			i++;
			}
		}
		for(int i=0; i<cs.get(count).rotas.size();i++) {
			for(int j=0; j<rotas.size();j++) {				
				ArrayList<Rota> aux = (ArrayList<Rota>) cs.get(count).rotas.clone();
				aux.remove(i);	//remove uma rota
				aux.add(rotas.get(j));	//add uma nova rota		
				if((dif(cp-calculaSoma(aux)))<dif(cp-calculaSoma(cs.get(count).rotas))){//verifica se a nova solução é melhor
					rotas.add(cs.get(count).rotas.get(i));//adicionando oq tirou do caminhao em rotas disponiveis
					cs.get(count).rotas.remove(i);//removendo oq tirou do caminhao
					cs.get(count).rotas.add(rotas.get(j));//adicionando a outra rota na lista de rotas do caminhao
					rotas.remove(j);//removendo a rota recem adicionada na lista do caminhao	
					
				}
			}
		}
		count++;
		distribuirRotas();
		
	}
	
	
	static public long start() {  	
    		long inicio = System.currentTimeMillis();   		
    		distribuirRotas(); 			
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
	    	 init(LeitorDeArquivo.lerArquivo("C:\\Users\\gabri\\eclipse-workspace\\TrampoFinal\\testes\\caminhoes_compacto.txt"));
		       break;
		     case 2:
		    init(LeitorDeArquivo.lerArquivo("C:\\Users\\gabri\\eclipse-workspace\\TrampoFinal\\testes\\caminhoes_disperso.txt"));
		       break;
		     case 3:
		    	 init(LeitorDeArquivo.lerArquivo("C:\\Users\\gabri\\eclipse-workspace\\TrampoFinal\\testes\\caminhoes_longo.txt"));
		       break;
		     
		     default:
		       System.out.println("O número escolhido é inválido! Digite um número entre 1 a 3.");
		   }
		// init(LeitorDeArquivo.lerArquivo("C:\\Users\\gabri\\eclipse-workspace\\TrampoFinal\\testes\\caminhoes_compacto.txt"));
		// System.out.println(cp); 
		 System.out.println("Tempo decorrido em ms: "+start());
		 for(int i=0;i<cs.size();i++) {
			 System.out.println(cs.get(i).rotas);
			 System.out.println("Soma total de km: "+calculaSoma(cs.get(i).rotas));
			 
			 
		 }
	
		 entrada.close();
		 
		 
	 }
}