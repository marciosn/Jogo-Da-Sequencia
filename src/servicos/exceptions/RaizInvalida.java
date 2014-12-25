package servicos.exceptions;

public class RaizInvalida extends Exception{
	
/**
	 * 
	 */
	private static final long serialVersionUID = -2792152968231086577L;
	private String msg;  
	
    public RaizInvalida(String msg){  
      super(msg);  
      this.msg = msg;  
    }
    
    public String getMessage(){  
      return msg;  
    }  
}
