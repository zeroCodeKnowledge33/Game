package model.card.standard;

import model.card.standard.*;
import engine.*;
import engine.board.*;

public class King extends Standard {
	public King(String name, String description, Suit suit, BoardManager boardManager, GameManager gameManager) {
		super(name, description, 13, suit, boardManager, gameManager);
	}
}
