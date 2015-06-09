import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Arquivo {

	 String tipoVia;
	 String tipoV;
	 int qtVias;
	 int qtVeic;
	 int tamVia;
	 int capVia;
	 int tam;
	 int separador;
	 int placa;
	 int indvia;

	 
	
	public void lerArq (ArrayList<Via> arrayVia, ArrayList<Veiculo> arrayVeic, FileReader f){
	
	try { 
		
		BufferedReader lerArq = new BufferedReader(f); //joga para a memória o conteudo do arquivo
		String linha;
		
		linha = lerArq.readLine();
		qtVias = Integer.parseInt (linha);	//pega a quantidade de vias
		
		for (int i = 0; i<qtVias; i++){ //percorre as primeiras linhas do arquivo com informações sobre as vias
			
			linha = lerArq.readLine();
			tam = linha.length();
			separador = linha.indexOf(" ");
			tipoVia = linha.substring(0, separador); //parte a linha em strings usando o espaço como separador e pega o tipo de via
							
			tam = linha.length();
			linha = linha.substring(separador + 1, tam);
			separador = linha.indexOf(" ");
			tamVia = Integer.parseInt (linha.substring(0, separador)); //continua a leitura até o proximo " " e pega o tamanho da via
								
			tam = linha.length();
			linha = linha.substring(separador + 1, tam); //continua a leitura depois do tamanho da via + 1 espaço e pega o restante da linha que contém a capacidade da via
			capVia = Integer.parseInt (linha); //converte a string "capacidade da via" em inteiro
			
			
			if (tipoVia.equals("S")){ //cria o objeto com a referencia do tipo da via e atribui seus respectivos valores
				Rua r = new Rua ();
				arrayVia.add(r);
				r.tamvia = tamVia;
				r.capacidade = capVia;
			}
			
			if (tipoVia.equals("A")){
				Avenida av = new Avenida();
				arrayVia.add(av);
				av.tamvia = tamVia;
				av.capacidade = capVia;				
			}
			
			if (tipoVia.equals("H")){
				Rodovia rod = new Rodovia();
				arrayVia.add(rod);
				rod.tamvia = tamVia;
				rod.capacidade = capVia;
			}
			
		}// fim do for 		
				
		linha = lerArq.readLine(); //faz a leitura da próxima linha que contém a quantidade de veículos
		qtVeic = Integer.parseInt (linha);	//converte em inteiro a quantidade de veículos
		
		for (int i = 0; i<qtVeic; i++){ //repete a leitura das próximas linhas tantas vezes quanto for a quantidade de veículos
			
			linha = lerArq.readLine();
			tam = linha.length();
			separador = linha.indexOf(" ");
			tipoV = linha.substring(0, separador);
							
			tam = linha.length();
			linha = linha.substring(separador + 1, tam);
			separador = linha.indexOf(" ");
			placa = Integer.parseInt (linha.substring(0, separador));
								
			tam = linha.length();
			linha = linha.substring(separador + 1, tam);
			indvia = Integer.parseInt (linha);
			
			
			if (tipoV.equals("C")){ //cria os objetos do tipo Veículo
				Carro c = new Carro();
				arrayVeic.add(c);
				c.ident = placa;
				c.ind_via = indvia;

			}
			
			if (tipoV.equals("M")){
				Moto m = new Moto();
				arrayVeic.add(m);
				m.ident = placa;
				m.ind_via = indvia;

			}
			
			if (tipoV.equals("T")){
				Caminhao t = new Caminhao();
				arrayVeic.add(t);
				t.ident = placa;
				t.ind_via = indvia;

			}
					
		}// fim do for
	
		f.close();	
		System.out.println();
		
		} catch (IOException e) {
			System.out.println("Erro de I/O ");
			e.printStackTrace();
		} 
	}


	
	//FUNÇÃO IMPRIME OS CICLOS OU PASSOS
	public void printArq (ArrayList<Via> arrayVia, ArrayList<Veiculo> arrayVeic, int time, int duracao){		
		
		System.out.println ("=============================================");
		System.out.println ("Time: " + time + " de " + duracao);
		System.out.println ("---------------------------------------------");
		
		for (int j = 0; j < arrayVia.size(); j++){
			
			if (arrayVia.get(j) instanceof Rua){			
				System.out.println ("Via: Rua - Tamanho: " + arrayVia.get(j).tamvia); 
				System.out.println ("Veículos: ");				
				
				for (int i = 0; i < arrayVeic.size(); i++){					
					if (arrayVeic.get(i).ind_via == j){
						System.out.println (arrayVeic.get(i).getNome() + ": " + arrayVeic.get(i).ident + " - " + "posição: " + arrayVeic.get(i).pos ) ;
					}
				}
			}
				           						
			if (arrayVia.get(j) instanceof Avenida){
				System.out.println ("Via: Avenida - Tamanho: " + arrayVia.get(j).tamvia );  
				System.out.println ("Veículos: ");				
				
				for (int i = 0; i < arrayVeic.size(); i++){					
					if (arrayVeic.get(i).ind_via == j){
						System.out.println (arrayVeic.get(i).getNome() + ": " + arrayVeic.get(i).ident + " - " + "posição: " + arrayVeic.get(i).pos ) ;
					}
				}
			}
						
			if (arrayVia.get(j) instanceof Rodovia){
				System.out.println ("Via: Rodovia - Tamanho: " + arrayVia.get(j).tamvia);
				System.out.println ("Veículos: ");				
				
				for (int i = 0; i < arrayVeic.size(); i++){					
					if (arrayVeic.get(i).ind_via == j){
						System.out.println (arrayVeic.get(i).getNome() + ": " + arrayVeic.get(i).ident + " - " + "posição: " + arrayVeic.get(i).pos ) ;
					}
				}
			}

		    System.out.println ("---------------------------------------------");
		
			
			//System.out.println (); 
		
			}//fim do for
	}
}
