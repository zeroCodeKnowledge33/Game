package exception;

public class CannotDiscardException extends ActionException{
	private static final long serialVersionUID = 1L;
	public CannotDiscardException(){
		super();
	}
	public CannotDiscardException(String message){
		super(message);
	}

}
