package servicos.jogo.sequencia;

import java.util.ArrayList;
import java.util.List;

public class JogoSequencia3 {
	private List<Integer> sequencia;
	
	public JogoSequencia3() {
		sequencia = new ArrayList<Integer>();
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

	public List<Integer> geraSequenciaInteger(int intervaloNumero, int tamanhoDaSequencia) {
		for (int i = 0; i < tamanhoDaSequencia; i++) {
			sequencia.add(((int) ((Math.random() * intervaloNumero) + 1)));
		}
		return sequencia;
	}
}
