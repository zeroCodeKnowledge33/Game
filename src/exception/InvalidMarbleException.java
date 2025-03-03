package exception;

public class InvalidMarbleException extends InvalidSelectionException {
	private static final long serialVersionUID = 1L;
	public InvalidMarbleException(){
		super();
	}
	public InvalidMarbleException(String message){
		super(message);
	}
}
