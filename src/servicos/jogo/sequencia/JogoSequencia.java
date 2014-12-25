package servicos.jogo.sequencia;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JogoSequencia {
	private int acertos = 0;
	private List<Integer> sequencia;
	private boolean executando = true;
	private String temp = "";
	private String seq = "";
	private String palpite = "";
	private Scanner scanner = new Scanner(System.in);

	public JogoSequencia() {
		sequencia = new ArrayList<Integer>();
	}

	public List<Integer> geraSequencia(int intervaloNumero, int tamanhoDaSequencia) {
		List<Integer> seq = new ArrayList<Integer>();
		for (int i = 0; i < tamanhoDaSequencia; i++) {
			seq.add(((int) ((Math.random() * intervaloNumero) + 1)));
		}
		return seq;
	}

	public void jogar() {
		System.out.println("JOGO DA SEQU�NCIA");

		System.out.println("Informe o intervalo desejado entre os n�meros da sequ�ncia");
		int intervalo = Integer.valueOf(scanner.nextLine());

		if (intervalo > 3) {

			System.out.println("Informe o tamanho desejado da sequ�ncia");
			int tamanho = Integer.valueOf(scanner.nextLine());

			if (tamanho > 4) {
				sequencia = geraSequencia(intervalo, tamanho);
				
				for(Integer i : sequencia){
					temp += String.valueOf(i) + " ";
				} 
				System.out.println("Sequ�ncia completa: "+temp);
				
				while (executando && (acertos < tamanho)) {
					String seque = "";
									
					System.out.println("Digite o palpite sem espaco");
					palpite = scanner.nextLine();
					seq += palpite;
					
					String sequenciaSemEspaco = temp.replaceAll(" ", "");
					String palpiteSemEspaco = seq.replaceAll(" ", "");
					
					System.out.println("Sequencia sem espa�o "+sequenciaSemEspaco);
					System.out.println("palpite sem espa�o "+palpiteSemEspaco);
					 
					for(int i = 0 ; i < palpiteSemEspaco.length(); i++){
						seque += String.valueOf(sequenciaSemEspaco.charAt(i));
					}
					
					System.out.println("Seque " + seque);
					
					if(palpiteSemEspaco.equals(seque)){
						System.out.println("IGUAL: " + palpiteSemEspaco+"="+seque);
						palpite = "";
						seq = "";
					}else{
						executando = false;
						System.out.println("VOC� PERDEU");
					}
					acertos ++;
				}

			} else
				System.out.println("O tamanho deve ser de no minimo 10");
		} else
			System.out.println("O intervalo deve ser de no minino 4");
	}
	
	

}
