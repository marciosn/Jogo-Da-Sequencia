package servicos.resources;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

import servicos.jogo.sequencia.JogoSequencia3;

@Path("/sequencia")
public class JogoSequenciaResource{
	private JogoSequencia3 jogo;
	@Context private HttpServletRequest request;
	@Context private HttpServletResponse response;
	private List<Integer> sequencia;
	private HttpSession session;
	private int count = 0;
	private int count2 = 0;
	private int tamanho = 0;
	
	public JogoSequenciaResource() {
		jogo = new JogoSequencia3();
	}
	
	@GET
	@Path("/index")
	public String Index() throws IOException{
		response.sendRedirect("/servicos/index.html"); 
		return "index";
	}
	
	@GET
	@Path("/limpar")
	public String limpaSesso(){
		session = request.getSession(true);
		try {
			session.setAttribute("jogadas", "");
		} catch (NullPointerException e) {
			System.out.println("Limpar " + e.toString());
		}
		return "Sessão Limpa";
	}

	@GET
	@Path("/jogar/{intervalo}/{tamanho}")
	@Produces("application/json")
	public String criaSequencia(@PathParam("intervalo") int intervalo, @PathParam("tamanho") int tamanho){
		session = request.getSession(true);
		sequencia = jogo.geraSequenciaInteger(intervalo, tamanho);
		session.setAttribute("lista", sequencia);
		session.setAttribute("count", count);
		session.setAttribute("count2", 1);
		session.setAttribute("tamanho", tamanho);
		return sequencia.toString();
	}
	
	@SuppressWarnings("unchecked")
	@GET
	@Path("/jogar")
	@Produces("text/plain")
	public String pegarDica(){
		String dica = "";
		session = request.getSession(true);
		sequencia = (List<Integer>) session.getAttribute("lista");
		count = (int) session.getAttribute("count");
		try {

			dica = "Entrada esperada: "+jogo.getSequenciaDaVez(count, sequencia).toString();
			
		} catch (IndexOutOfBoundsException e) {
			System.out.println("pegarDica " + e.toString());
		}
		
		return dica;
	}
	
	@SuppressWarnings("unchecked")
	@GET
	@Path("/jogar/{jogada}")
	@Produces("text/plain")
	public String verificaJogada(@PathParam("jogada") String jogada){
		session = request.getSession(true);
		String result = "verifica";
		try {
			
			tamanho = (int) session.getAttribute("tamanho");
			sequencia = (List<Integer>) session.getAttribute("lista");
			count = (int) session.getAttribute("count");
			count2 = (int) session.getAttribute("count2");
			
			if(jogo.verificaJogada(jogada, sequencia.get(count))){
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
			System.out.println("verificaJogada "+e.toString());
		}catch (IndexOutOfBoundsException e) {
			System.out.println("verificaJogada "+e.toString());
		}

		return result;
	}
	
}
