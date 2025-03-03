package model.card.standard;

import engine.*;
import engine.board.*;
import model.card.standard.*;
import model.card.*;

public class Standard extends Card{
	private final int rank;
	private final Suit suit;

	public Standard(String name, String description, int rank, Suit suit, BoardManager boardManager, GameManager gameManager) {
		super(name,description,boardManager,gameManager);
		this.rank = rank;
		this.suit = suit;
	}


	public int getRank() {
		return rank;
	}


	public Suit getSuit() {
		return suit;
	}

}
