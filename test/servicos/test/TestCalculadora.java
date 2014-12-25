package servicos.test;

import static org.junit.Assert.*;

import org.junit.Test;

import servicos.exceptions.EquacaoInvalida;
import servicos.exceptions.MyException;
import servicos.exceptions.RaizInvalida;
import servicos.logic.Calculadora;

public class TestCalculadora {
	Calculadora calculadora = new Calculadora();

	/**
	 * Testando soma com valores positivos, o objetivo � que a soma seja realizada com sucesso
	 * */

	@Test
	public void testSoma() {
		assertEquals(calculadora.Soma(1, 1), 2, 0);
	}
	
	/**
	 * Testando soma com valores negativos, o objetivo � que a soma seja realizada com sucesso
	 * */
	
	@Test
	public void testSomaNegativo() {
		assertEquals(calculadora.Soma(-1, -1), -2, 0);
	}
	
	
	/**
	 * Testando subtra��o com valores positivos, o objetivo � que a subtrac�o seja realizada com sucesso
	 * */
	@Test
	public void testSubtracao() {
		assertEquals(calculadora.Subtracao(3, 1), 2, 0);
	}
	
	/**
	 * Testando subtra��o com valores negativos, o objetivo � que a subtra��o seja realizada com sucesso
	 * */
	@Test
	public void testSubtracaoNegativa() {
		assertEquals(calculadora.Subtracao(-10, 1), -11, 0);
	}
	
	/**
	 * Testando multiplica��o com valores positivos, o objetivo � que a multiplica��o seja realizada com sucesso
	 * */
	@Test
	public void testMultiplicao() {
		assertEquals(calculadora.Multiplicao(2, 1), 2, 0);
	}
	
	/**
	 * Testando multiplica��o com valores negativos, o objetivo � que a multiplica��o seja realizada com sucesso
	 * */
	@Test
	public void testMultiplicaoNegativa() {
		assertEquals(calculadora.Multiplicao(2, -1), -2, 0);
	}
	
	/**
	 * Testando Divis�o Inv�lida com denominador 0, o objetivo � que seja retornada uma exce��o do tipo MyException
	 * */
	@Test(expected = MyException.class)
	public void testDivisaoInvalida() throws MyException {
		assertEquals(calculadora.Divisao(1, 0), 0, 0);	
	}
	
	/**
	 * Testando Divis�o v�lida, o objetivo � que a divis�o seja realizada com sucesso
	 * */
	@Test
	public void testDivisaoValida() throws MyException{
		assertEquals(calculadora.Divisao(100, 10), 10, 0);	
	}
	
	/**
	 * Testando Calculo de raiz, o objetivo � que seja retornada uma raiz valida
	 * */
	@Test
	public void testRaiz() throws RaizInvalida {
		assertEquals(calculadora.Raiz(49), 7, 0);
	}
	
	/**
	 * Testando calculo de raiz inv�lida, o objetivo � que seja retornada uma exce��o do tipo MyException
	 * */
	@Test(expected = RaizInvalida.class)
	public void testRaizNegativa() throws RaizInvalida {
		assertEquals(calculadora.Raiz(-49), 7, 0);
	}
	
	/**
	 * Testando Equacao do segundo grau valida, o objetivo � que sejam retornadas duas raizes da equacao
	 * */
	@Test
	public void testEquacao() throws EquacaoInvalida {
		double r1 = calculadora.Equacao(1, -10, 24).get(0);
		double r2 = calculadora.Equacao(1, -10, 24).get(1);
		assertEquals(r1, 4, 0);
		assertEquals(r2, 6, 0);
	}
	
	/**
	 * Testando Equacao do segundo grau inv�lida, o objetivo � que seja retornada uma exce��o do tipo EquacaoInvalida
	 * */
	@Test(expected = EquacaoInvalida.class)
	public void testEquacaoInvalida() throws EquacaoInvalida {
		calculadora.Equacao(0, -10, 24).get(0);
		calculadora.Equacao(0, -10, 24).get(1);
		assertEquals("Passando a com valor 0, o resultado esperado � uma exce��o EquacaoInvalida", 4, 0);
		assertEquals("Passando a com valor 0, o resultado esperado � uma exce��o EquacaoInvalida", 6, 0);
	}
	
	/**
	 * Testando testDivisaoInvalidaFail, o objetivo � que a exce��o MyException seja levantada
	 * */

	@Test
	public void testDivisaoInvalidaFail() throws MyException {
		try {
			assertEquals(calculadora.Divisao(1, 0), 0, 0);
			fail();
		} catch (MyException e) {
			System.out.println("Disparou a exce��o MyException, passou! "+ e.toString());
		}		
	}
	
	/**
	 * Testando testRaizNegativaFail, o objetivo � que a exce��o RaizInvalida seja levantada
	 * */
	@Test
	public void testRaizNegativaFail() throws RaizInvalida {
		try {
			assertEquals(calculadora.Raiz(-49), 7, 0);
			fail();
		} catch (RaizInvalida e) {
			System.out.println("Disparou a exce��o RaizInvalida, passou! " + e.toString());
		}
	}
	
	/**
	 * Testando testEquacaoInvalidaFail, o objetivo � que a exce��o RaizInvalida seja levantada
	 * */
	@Test
	public void testEquacaoInvalidaFail() throws EquacaoInvalida {
		try {
			double r1 = calculadora.Equacao(0, -10, 24).get(0);
			double r2 = calculadora.Equacao(0, -10, 24).get(1);
			assertEquals("Passando a com valor 0, o resultado esperado � uma exce��o EquacaoInvalida",r1, 4, 0);
			assertEquals("Passando a com valor 0, o resultado esperado � uma exce��o EquacaoInvalida",r2, 6, 0);
			
			fail();
		} catch (EquacaoInvalida e) {
			System.out.println("Disparou a exce��o RaizInvalida, passou! " + e.toString());
		}
		
	}
}
