package servicos.logic;

import java.util.ArrayList;
import java.util.List;

public class CalculaEquacao {
	
	public List<Double> calculaEquação(double a, double b, double c){
		
		List<Double> raizes = new ArrayList<Double>();
		
		double delta = calculaDelta(a, b, c);
		
		double r1 = calculaRaiz1(delta, a, b);
		double r2 = calculaRaiz2(delta, a, b);
		
		raizes.add(r2);
		raizes.add(r1);
		return raizes ;
	}
	
	private double calculaDelta(double a, double b, double c){
		double delta;
		delta = (b * b) - (4 * a * c);
		return delta;
	}
	
	private double calculaRaiz1(double delta, double a, double b){
		double raiz1;
		if(delta >= 0)
			raiz1 = ((-1) * b + (Math.sqrt(delta))) / (2/a);
		else
			raiz1 = (-b) / (2*a) + (Math.sqrt(delta)) / (2*a);	
		return raiz1;
	}
	
	private double calculaRaiz2(double delta, double a, double b){
		double raiz2;
		if(delta >= 0)
			raiz2 = ((-1) * b - (Math.sqrt(delta))) / (2/a);
		else
			raiz2 = (-b) / (2*a) - (Math.sqrt(delta)) / (2*a);
		return raiz2;
	}

}
