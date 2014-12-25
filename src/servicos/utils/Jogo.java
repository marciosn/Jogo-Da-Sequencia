package servicos.utils;

import java.util.ArrayList;
import java.util.List;

import servicos.jogo.sequencia.JogoSequencia2;

public class Jogo {

	public static void main(String[] args) {
		/*JogoSequencia2 jogo = new JogoSequencia2();
		
		System.out.println(jogo.convertListStringToListInteger("3222,45,333,45,786,23,3,7,9").toString());
		
		List<Integer> sequencia = new ArrayList<>();
		sequencia.add(23);
		sequencia.add(88);
		sequencia.add(45);
		sequencia.add(76);
		sequencia.add(22);
		
		if(jogo.verificaJogadaCorreta("23,88,45,76,22", sequencia)){
			System.out.println("Correto!");
		}else
			System.out.println("Errado!");*/
		
		new JogoSequencia2().jogar();
	
	}

}
