package exception;

public class SplitOutOfRangeException extends InvalidSelectionException{
	private static final long serialVersionUID = 1L;
	public SplitOutOfRangeException(){
		super();
	}
	public SplitOutOfRangeException(String message){
		super(message);
	}
}
