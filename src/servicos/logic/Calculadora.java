package servicos.logic;

import java.util.List;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import servicos.exceptions.EquacaoInvalida;
import servicos.exceptions.MyException;
import servicos.exceptions.RaizInvalida;
import servicos.interfaces.ICalculadora;
public class Calculadora implements ICalculadora{

	@Override
	public double Soma(double n1, double n2) {
		return n1 + n2;
	}

	@Override
	public double Subtracao(double n1, double n2) {
		return n1 - n2;
	}

	@Override
	public double Multiplicao(double n1, double n2) {
		return n1 * n2;
	}

	@Override
	public double Divisao(double n1, double n2) throws MyException {
		if(n2 <= 0)
			throw new MyException("N�o � possivel realizar divis�o por 0");
		else
			return n1/n2;
	}

	@Override
	public double Raiz(double n) throws RaizInvalida{
		if( n < 0 ){
			throw new RaizInvalida("Raiz Inv�lida, n�mero negativo");
			//throw new WebApplicationException(Response.Status.BAD_REQUEST);
		}else
		return Math.sqrt(n);
	}

	@Override
	public List<Double> Equacao(double a, double b, double c) throws EquacaoInvalida{
		if(a <= 0){
			throw new EquacaoInvalida("Equa��o Inv�lida, A n�o pode ser 0");
		}else
		return new CalculaEquacao().calculaEqua��o(a, b, c);
	}

}
