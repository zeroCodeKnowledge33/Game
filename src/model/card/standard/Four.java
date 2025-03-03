package model.card.standard;

import model.card.standard.*;import engine.*;
import engine.board.*;
public class Four extends Standard{
	
	public Four(String name, String description,Suit suit, BoardManager boardManager, GameManager gameManager){
		super(name,description,4,suit,boardManager,gameManager);
	}
}
