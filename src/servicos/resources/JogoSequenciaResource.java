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
	private HttpSession session;
	
	public JogoSequenciaResource() {
		jogo = new JogoSequencia3();
	}
	
	@GET
	@Path("/index")
	@Produces("text/plain")
	public String Index() throws IOException{
		response.sendRedirect("/servicos/index.html"); 
		return "index";
	}
	
	@GET
	@Path("/limpar")
	@Produces("text/plain")
	public String limpaSesso(){
		session = request.getSession(true);		
		return jogo.limpaSesso(session, request);
	}

	@GET
	@Path("/jogar/{intervalo}/{tamanho}")
	@Produces("application/json")
	public String criaSequencia(@PathParam("intervalo") int intervalo, @PathParam("tamanho") int tamanho){
		session = request.getSession(true);
		return jogo.criaSequencia(session, request, intervalo, tamanho);
	}
	
	@GET
	@Path("/jogar")
	@Produces("text/plain")
	public String pegarDica(){
		session = request.getSession(true);
		return jogo.pegarDica(session, request);
	}
	
	@GET
	@Path("/jogar/{jogada}")
	@Produces("text/plain")
	public String verificaJogada(@PathParam("jogada") String jogada){
		session = request.getSession(true);
		return jogo.verificaJogada(session, request, jogada);
	}
	
}
