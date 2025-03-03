package model.card.standard;

import model.card.standard.*;
import engine.*;
import engine.board.*;
public class Jack extends Standard{
	
	public Jack(String name, String description,Suit suit, BoardManager boardManager, GameManager gameManager){
		super(name,description,11,suit,boardManager,gameManager);
	}
}
