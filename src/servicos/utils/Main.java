package servicos.utils;

import java.util.ArrayList;
import java.util.List;


public class Main {
	static String sequencia = "3,24,92,40,50,60,70,80,55";
	static String c = "";
	static String c2 = "";
	static String caractere = "";
	static String caractere2 = "";
	static String temp = "";
	static int indice;
	static char numero;
	static List<Integer> seq = new ArrayList<>();

	public static void main(String[] args) {

		criarLista(sequencia);
	}
	
	public static List<Integer> criarLista(String list){
		String c = "";
		String caractere2 = "";
		String aux = "";
		String temp = "";
		String numero = "";
		List<Integer> seq = new ArrayList<>();

		//System.out.println("Tamanho de list: " + list);
		
		for(int k = 0 ; k < list.length() ; k++){

			caractere2 = String.valueOf(list.charAt(k));
			
			if(!(caractere2.equals(","))){
				aux += caractere2;
					if(k == list.length()-1)					
						temp = aux;
			}else{
				numero = aux;
				seq.add(Integer.valueOf(numero));
				aux = "";
			}
		}
		seq.add(Integer.valueOf(temp));
		imprimeLista(seq);
		return seq;
	}
	
	public static String lista(String sequencia){
		String c = "";
		for(int i = 0; i < sequencia.length(); i++){
			caractere += String.valueOf(sequencia.charAt(i));			
			c = caractere.replaceAll(" ", ",");
		}
		//System.out.println("Lista -> " +c);
		return c;
	}
	
	public static void imprimeLista(List<Integer> seq){
		for(Integer i : seq){
			System.out.println(i);
		}
	}
	
}


















