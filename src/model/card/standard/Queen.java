package model.card.standard;

import model.card.standard.*;
import engine.*;
import engine.board.*;
public class Queen extends Standard{
	
	public Queen(String name, String description,Suit suit, BoardManager boardManager, GameManager gameManager){
		super(name,description,12,suit,boardManager,gameManager);
	}
}
