package servicos.jogo.sequencia;

import java.util.ArrayList;
import java.util.List;

public class JogoSequencia3 {
	private List<Integer> sequencia;
	
	public JogoSequencia3() {
		sequencia = new ArrayList<Integer>();
	}
	public int iteraContador(int indice){
		return indice + 1;
	}
	
	public List<Integer> getSequenciaDaVez(int indiceDaVez, List<Integer> sequencia) throws IndexOutOfBoundsException{
		List<Integer> sequenciaDavez = new ArrayList<>();
		try {
			for(int i = 0 ; i <= indiceDaVez ; i++){
				sequenciaDavez.add(sequencia.get(i));
			}
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.toString());
		}
		return sequenciaDavez;
	}

	
	public boolean verificaJogada(List<Integer> jogadas, List<Integer> sequencia){
		boolean isCorreta = false;
		System.out.println("JOGADAS "+jogadas.toString());
		System.out.println("SEQUENCIA "+sequencia.toString());
		
		try {
			for(int k = 0 ; k < jogadas.size() ; k++){
				System.out.println(jogadas.get(k) + " = " + sequencia.get(k));
				if(jogadas.get(k) == sequencia.get(k)){
					isCorreta = true;
				}else
					return false;
			}

		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return isCorreta;
	}
	
	public boolean verificaJogada(int jogadas, int seqIndice){
		boolean isCorreta = false;
		System.out.println("Jogada "+jogadas);
		System.out.println("É esperado " + seqIndice);
		try {
			if(jogadas == seqIndice){
					isCorreta = true;
			}

		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return isCorreta;
	}
	
	public boolean verificaJogada(String jogadas, int seqIndice){
		boolean isCorreta = false;
		System.out.println("Você digitou: "+jogadas);
		System.out.println("O esperado é: " + seqIndice);
		try {
			if(Integer.valueOf(jogadas) == seqIndice){
					isCorreta = true;
			}

		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return isCorreta;
	}
	
	public String getSequenceListString(String result, String jogada){
		String temp;
		if(!result.equals("")){
			temp = result + "," + jogada;
		}else
			temp = jogada;
		return temp;
	}
	
	public List<Integer> convertListStringToListInteger(String list) throws NumberFormatException{
		//System.out.println("List "+ list);
		String caractere = "", aux = "", aux2 = "", numero = "";
		List<Integer> seq = new ArrayList<>();
		try {
			for(int k = 0 ; k < list.length() ; k++){
				caractere = String.valueOf(list.charAt(k));
				if(!(caractere.equals(","))){
					aux += caractere;
						if(k == list.length()-1)					
							aux2 = aux;
				}else{
					numero = aux;
					seq.add(Integer.valueOf(numero));
					aux = "";
				}
			}
			seq.add(Integer.valueOf(aux2));
		} catch (NumberFormatException e) {
			System.out.println("convertListStringToListInteger "+ e.toString());
		}
		
		return seq;
	}

	public List<Integer> geraSequenciaInteger(int intervaloNumero, int tamanhoDaSequencia) {
		for (int i = 0; i < tamanhoDaSequencia; i++) {
			sequencia.add(((int) ((Math.random() * intervaloNumero) + 1)));
		}
		return sequencia;
	}
}
