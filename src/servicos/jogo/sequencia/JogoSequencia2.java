package servicos.jogo.sequencia;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JogoSequencia2 {
	private int acertos = 0, indiceDaVez = 0;
	private List<Integer> sequencia;
	private boolean executando = true;
	private Scanner scanner = new Scanner(System.in);
	
	public JogoSequencia2() {
		sequencia = new ArrayList<Integer>();
	}
	
	public void jogar() {
		System.out.println("JOGO DA SEQUÊNCIA");
		System.out.println("Informe o intervalo desejado entre os números da sequência");
		int intervalo = Integer.valueOf(scanner.nextLine());

		if (intervalo > 3) {
			System.out.println("Informe o tamanho desejado da sequência");
			int tamanho = Integer.valueOf(scanner.nextLine());

			if (tamanho > 4) {
				sequencia = geraSequenciaInteger(intervalo, tamanho);
		
				while (executando) {
					System.out.println("Sequencia Esperada: " + getSequenciaDaVez(indiceDaVez, sequencia).toString());
					System.out.println("Entrada correta deve ser: " + getSequenciaDaVez(indiceDaVez, sequencia).get(indiceDaVez));
					System.out.println("Informe a jogada separada apenas por virgulas ex: 1,7,10,11");
					String jogada = scanner.nextLine();
					
					if(verificaJogadaCorreta(jogada, getSequenciaDaVez(indiceDaVez, sequencia))){
						System.out.println("Correto!");
						acertos++;
						indiceDaVez++;
					}else{
						System.out.println("Incorreto!");
						executando = false;
					}
					
					if(verificaSeVenceu(tamanho, acertos)){
						System.out.println("Você venceu!");
						executando = false;
					}
				}
				
			} else
				System.out.println("O tamanho deve ser de no minimo 5");
		} else
			System.out.println("O intervalo deve ser de no minino 4");
	}
	
	public List<Integer> getSequenciaDaVez(int indiceDaVez, List<Integer> sequencia){
		List<Integer> sequenciaDavez = new ArrayList<>();
			for(int i = 0 ; i <= indiceDaVez ; i++){
				sequenciaDavez.add(sequencia.get(i));
			}
		return sequenciaDavez;
	}
	
	public boolean verificaJogadaCorreta(String entrada, List<Integer> sequencia){
		boolean isCorreta = false;
		List<Integer> entradaInt = convertListStringToListInteger(entrada);
		try {
			if(entradaInt.equals(sequencia))
				isCorreta = true;
		} catch (NumberFormatException e) {
			e.printStackTrace();
			System.out.println(e.toString());
		}
		return isCorreta;
	}
	
	public List<Integer> convertListStringToListInteger(String list) throws NumberFormatException{
		List<Integer> seq = new ArrayList<>();
		String caractere = "", aux = "", aux2 = "", numero = "";
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
		return seq;
	}
	
	public List<Integer> geraSequenciaInteger(int intervaloNumero, int tamanhoDaSequencia) {
		List<Integer> seq = new ArrayList<Integer>();
		for (int i = 0; i < tamanhoDaSequencia; i++) {
			seq.add(((int) ((Math.random() * intervaloNumero) + 1)));
		}
		return seq;
	}

	public boolean verificaSeVenceu(int tamanho, int acertos){
		boolean venceu = false;
			if(tamanho == acertos)
				venceu = true;
		return venceu;
	}
}
