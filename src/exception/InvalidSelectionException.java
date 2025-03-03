package exception;

public abstract class InvalidSelectionException extends GameException{
	private static final long serialVersionUID = 1L;
	public InvalidSelectionException(){
		super();
	}
	public InvalidSelectionException(String message){
		super(message);
	}
}
