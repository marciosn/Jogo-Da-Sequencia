package servicos.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import servicos.exceptions.FormatoEntradaInvalido;
import servicos.jogo.sequencia.JogoSequencia2;

public class TestJogoSequencia {

	JogoSequencia2 jogo = new JogoSequencia2();
	
	@Test
	public void testFormatoEntradaInvalida() throws NumberFormatException{
		try {
			jogo.convertListStringToListInteger("5 5 5");
			fail();
		} catch (NumberFormatException e) {
			//System.out.println("Sucesso a exceção foi lançada " + e.toString());
		}
	}
	
	@Test
	public void testVerificaJogada(){
		List<Integer> sequencia = new ArrayList<>();
		sequencia.add(54);
		sequencia.add(67);
		sequencia.add(3);
		sequencia.add(854);
		sequencia.add(134);
		sequencia.add(4);
		assertTrue(jogo.verificaJogadaCorreta("54,67,3,854,134,4", sequencia));
	}
	
	@Test
	public void testVerificaVenceu(){
		assertTrue(jogo.verificaSeVenceu(10, 10));
	}

}
