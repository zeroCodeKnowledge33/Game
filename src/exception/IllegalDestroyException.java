package exception;

public class IllegalDestroyException extends ActionException{
	private static final long serialVersionUID = 1L;
	public IllegalDestroyException(){
		super();
	}
	public IllegalDestroyException(String message){
		super(message);
	}

}
