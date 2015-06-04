

public abstract class Veiculo {
	
	protected int placa;		//identificador do veiculo
	protected int veloc_max; 	//limite de velocidade de cada tipo de veiculo
	protected int pos; 			//posicao que o carro se encontra na via
	
	protected Veiculo(){
	}
	
	public int getPlaca() {
		return placa;
	}


	public int getVeloc_max() {
		return veloc_max;
	}


	public int getPos() {
		return pos;
	}


	public void setPlaca(int placa) {
		this.placa = placa;
	}


	public void setVeloc_max(int veloc_max) {
		this.veloc_max = veloc_max;
	}


	public void setPos(int pos) {
		this.pos = pos;
	} 
	
	
	protected void anda(){ 		//gera o movimento do veiculo em cada hora
		
	}


}
