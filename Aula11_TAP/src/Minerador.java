import java.math.BigInteger;
import java.security.MessageDigest;

public class Minerador extends Thread{
	
	//Constantes da classe
	private static final String CRITERIO = "000000000";
	
	//Propriedades da classe
	private String inicio = null;
	private String fim = null;
	
	
	//Construtor cheio
	public Minerador(String inicio, String fim) {
		super();
		this.inicio = inicio;
		this.fim = fim;
	}
	
	//Metodo da classe
	private String calcularHash(String numero) throws Exception {
		String retorno = "";
		
		MessageDigest algoritmo = MessageDigest.getInstance("SHA-256");
		byte[] resumo = algoritmo.digest(numero.getBytes("UTF-8"));
		
		for (int i = 0; i < resumo.length; i++) {
			String hex = Integer.toHexString(0xff & resumo[i]);
			if(hex.length() == 1) {
				retorno += "0";
		        }
			retorno += hex;
		}
		return retorno;
	}
	
	//Metodo de execução paralela da classe
	public void run() {
		try {
			for (BigInteger candidato = new BigInteger(inicio);
					candidato.compareTo(new BigInteger(fim)) < 0;
					candidato = candidato.add(BigInteger.ONE)) {
				String hash = calcularHash(calcularHash(candidato.toString()));
				
				if(hash.startsWith(CRITERIO)) {
					System.out.println("FODA-SE O MUNDO " + "FIQUEI MILIONÁRIO! " + candidato + " " + hash);
					System.exit(0);
				}
				//System.out.println(candidato);
			}
		} catch (Exception erro) {
			System.out.println(erro);
			// TODO: handle exception
		}

	}
}