import java.math.BigInteger;

public class Main {
	//Constantes da classe
	private static final String TAMANHO = "99999999999999999999";
	
	//Metodo principal de execução da classe
	public static void main(String[] args) {
		for(BigInteger i = BigInteger.ZERO; 
				true ;
				i = i.add(new BigInteger(TAMANHO))) {
				new Minerador(i.toString(),
					i.add(new BigInteger(TAMANHO)).toString()).start();
		}
	}
}
