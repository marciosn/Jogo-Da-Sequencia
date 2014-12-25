package servicos.exceptions;

public class FormatoEntradaInvalido extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5476475736295295876L;
	private String msg;  
	
    public FormatoEntradaInvalido(String msg){  
      super(msg);  
      this.msg = msg;  
    }
    
    public String getMessage(){  
      return msg;  
    }  
}
