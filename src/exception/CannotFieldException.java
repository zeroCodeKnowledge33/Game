package exception;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CannotFieldException extends ActionException{
	public CannotFieldException(){
		super();
	}
	public CannotFieldException(String message){
		super(message);
	}
}
