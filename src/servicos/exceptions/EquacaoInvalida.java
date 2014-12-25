package servicos.exceptions;

public class EquacaoInvalida extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2773725603007564519L;
	private String msg;  
	public EquacaoInvalida(String msg){  
	      super(msg);  
	      this.msg = msg;  
	    }
	    
	    public String getMessage(){  
	      return msg;  
	    }  
}
