package exception;

public class CannotFieldException extends ActionException{
	private static final long serialVersionUID = 1L;
	public CannotFieldException(){
		super();
	}
	public CannotFieldException(String message){
		super(message);
	}

}
