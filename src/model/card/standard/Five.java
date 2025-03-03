package model.card.standard;

import model.Suit;
import engine.*;
import engine.board.*;
public class Five extends Standard{
	
	public Five(String name, String description,Suit suit, BoardManager boardManager, GameManager gameManager){
		super(name,description,5,suit,boardManager,gameManager);
	}
}
