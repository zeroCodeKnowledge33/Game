package exception;

public class IllegalSwapException extends ActionException{
	private static final long serialVersionUID = 1L;
	public IllegalSwapException(){
		super();
		
	}
	public IllegalSwapException(String message){
		super(message);
	}
	
}
