package model.card;

import engine.board.*;
import engine.*;

public abstract class Card {
	private final String name;
	private final String description;
	protected BoardManager boardManager;
	protected GameManager gameManager;
	
	public Card(String name, String description, BoardManager boardManager, GameManager gameManager){
		this.name= name;
		this.description = description;
		this.boardManager= boardManager;
		this.gameManager = gameManager;
		
	}

	public String getName() {
		return name;
	}

	public BoardManager getBoardManager() {
		return boardManager;
	}

	public void setBoardManager(BoardManager boardManager) {
		this.boardManager = boardManager;
	}

	public GameManager getGameManager() {
		return gameManager;
	}

	public void setGameManager(GameManager gameManager) {
		this.gameManager = gameManager;
	}

	public String getDescription() {
		return description;
	}
}
