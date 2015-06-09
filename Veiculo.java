

public abstract class Veiculo {
	
	protected int ident;		//identificador do veiculo
	protected int veloc_max; 	//limite de velocidade de cada tipo de veiculo
	protected int pos; 			//posicao que o carro se encontra na via
	protected int ind_via;		//indice da via na qual o veic está percorrendo
	protected String nome;
	

		
	public String getNome(){
		return this.nome;
	}
	
	protected void anda(){ 		//gera o movimento do veiculo em cada hora
		
	}


}
