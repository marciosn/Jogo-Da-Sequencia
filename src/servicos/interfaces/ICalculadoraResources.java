package servicos.interfaces;

import servicos.exceptions.EquacaoInvalida;
import servicos.exceptions.MyException;
import servicos.exceptions.RaizInvalida;

public interface ICalculadoraResources {
	
	String calcularSoma(double n1, double n2);
	String calcularSubtracao(double n1, double n2);
	String calcularMultiplicao(double n1, double n2);
	String calcularDivisao(double n1, double n2) throws MyException;
	String calcularRaiz(double n) throws RaizInvalida;
	String calcularEquacao(double a, double b, double c) throws EquacaoInvalida;
	
	
	

}
