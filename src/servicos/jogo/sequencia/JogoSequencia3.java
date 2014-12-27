package servicos.jogo.sequencia;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;

public class JogoSequencia3 {
	private List<Integer> sequencia;
	@Context private HttpServletRequest req;
	@Context private HttpServletResponse resp;
	private HttpSession session;
	private int count = 0;
	private int count2 = 0;
	private int tamanho = 0;
	
	public JogoSequencia3(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		sequencia = new ArrayList<Integer>();
		this.session = session;
		this.req = request;
		this.resp = response;
		//session = req.getSession(true);
	}
	
	public JogoSequencia3() {
		sequencia = new ArrayList<Integer>();
	}

	public void imprime(HttpSession session, HttpServletRequest request, List<Integer> sequencia){
		try {
			session.setAttribute("teste", sequencia);
			System.out.println("Testando sessão " + session.getAttribute("teste").toString());
		
		} catch (NullPointerException e) {
			System.out.println("imprime " + e.toString());
		}
		
	}
	
	public List<Integer> getSequenciaDaVez(int indiceDaVez, List<Integer> sequencia){
		List<Integer> sequenciaDavez = new ArrayList<>();
		try {
			for(int i = 0 ; i <= indiceDaVez ; i++){
				sequenciaDavez.add(sequencia.get(i));
			}
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.toString());
		}
		return sequenciaDavez;
	}
	
	public List<Integer> geraSequenciaInteger(int intervaloNumero, int tamanhoDaSequencia) {		
		try {
			for (int i = 0; i < tamanhoDaSequencia; i++) {
				sequencia.add(((int) ((Math.random() * intervaloNumero) + 1)));
			}
		} catch (NullPointerException e) {
			System.out.println("geraSequenciaInteger " + e.toString());
		}
		
		return sequencia;
	}
	
	public boolean verificaJogada(String jogadas, int seqIndice){
		boolean isCorreta = false;
		System.out.println("Você digitou: "+jogadas);
		System.out.println("O esperado é: " + seqIndice);
		try {
			if(Integer.valueOf(jogadas) == seqIndice){
					isCorreta = true;
			}

		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return isCorreta;
	}
	
	@SuppressWarnings("unchecked")
	public String verificaJogada(HttpSession session, HttpServletRequest request, String jogada){
		String result = "verifica";
		try {
			
			tamanho = (int) session.getAttribute("tamanho");
			sequencia = (List<Integer>) session.getAttribute("lista");
			count = (int) session.getAttribute("count");
			count2 = (int) session.getAttribute("count2");
			
			if(verificaJogada(jogada, sequencia.get(count))){
					result = "Acertou";							
					session.setAttribute("count", count  + 1);
					
					count = (int) session.getAttribute("count");
					count2 = (int) session.getAttribute("count2");
					
					if(count == count2){
						session.setAttribute("count", 0);
						session.setAttribute("count2", count2  + 1);
					}
					
			}else{
					result = "Errou";
					session.setAttribute("count", 0);
					session.setAttribute("count2", 0);
			}	
		
			if(count == tamanho){
				session.setAttribute("count", 0);
				session.setAttribute("count2", 0);
				return "Venceu";	
			}
				
		} catch (NullPointerException e) {
			System.out.println("verificaJogada JogoSequencia3 "+e.toString());
		}catch (IndexOutOfBoundsException e) {
			System.out.println("verificaJogada JogoSequencia3 "+e.toString());
		}

		return result;

	}
	
	public String criaSequencia(HttpSession session, HttpServletRequest request, int intervalo, int tamanho){
		session = request.getSession(true);
		sequencia = geraSequenciaInteger(intervalo, tamanho);
		session.setAttribute("lista", sequencia);
		session.setAttribute("count", count);
		session.setAttribute("count2", 1);
		session.setAttribute("tamanho", tamanho);
		
		return sequencia.toString();
	}
	
	public String limpaSesso(HttpSession session, HttpServletRequest request){
		session = request.getSession(true);
		try {
			session.setAttribute("jogadas", "");
		} catch (NullPointerException e) {
			System.out.println("Limpar " + e.toString());
		}
		return "Sessão Limpa";
	}

	public String pegarDica(HttpSession session, HttpServletRequest request){
		String dica = "";
		session = request.getSession(true);
		sequencia = (List<Integer>) session.getAttribute("lista");
		count = (int) session.getAttribute("count");
		try {

			dica = getSequenciaDaVez(count, sequencia).toString();
			
		} catch (IndexOutOfBoundsException e) {
			System.out.println("pegarDica " + e.toString());
		}
		
		return dica;
	}

}
