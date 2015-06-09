import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;



public class ClassePrincipal {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		int time = 0;
		int duracao = 3;
		Arquivo arq = new Arquivo ();
		ArrayList<Via> arrayVia = new ArrayList<Via>();
		ArrayList<Veiculo> arrayVeic = new ArrayList<Veiculo>();
		
		FileReader f = new FileReader ("c:\\Workbench\\arq.txt");
		
		arq.lerArq(arrayVia , arrayVeic, f);
		arq.printArq(arrayVia, arrayVeic, time, duracao);		

	}
}
