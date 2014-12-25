package servicos.exceptions;

public class MyException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6041204481963699070L;
	private String msg;  
	
    public MyException(String msg){  
      super(msg);  
      this.msg = msg;  
    }
    
    public String getMessage(){  
      return msg;  
    }  
}
