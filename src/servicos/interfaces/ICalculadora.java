package servicos.interfaces;

import java.util.List;

import servicos.exceptions.EquacaoInvalida;
import servicos.exceptions.MyException;
import servicos.exceptions.RaizInvalida;

public interface ICalculadora {
	
	double Soma(double n1, double n2);
	double Subtracao(double n1, double n2);
	double Multiplicao(double n1, double n2);
	double Divisao(double n1, double n2) throws MyException;
	double Raiz(double n) throws RaizInvalida;
	List<Double> Equacao(double a, double b, double c) throws EquacaoInvalida;

}
