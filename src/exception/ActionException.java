package exception;

public abstract class ActionException extends GameException{
	private static final long serialVersionUID = 1L;
	public ActionException(){
		super();
	}
	public ActionException(String message){
		super(message);
	}
}
