package exception;

public class IllegalMovementException extends ActionException{
	private static final long serialVersionUID = 1L;
	public IllegalMovementException(){
		super();
	}
	public IllegalMovementException(String message){
		super(message);
	}

}
