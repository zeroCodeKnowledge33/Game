package model.player;

import model.Colour;
import engine.board.BoardManager;

public class CPU extends Player{
	private final BoardManager boardManager;

	public CPU(String name, Colour colour, BoardManager boardManager) {
		super(name, colour);
		this.boardManager = boardManager;
	}

	public BoardManager getBoardManager() {
		return boardManager;
	}	
	
}
