package engine;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;


import model.Colour;
import model.card.Card;
import model.card.Deck;
import model.player.CPU;
import model.player.Player;
import engine.board.Board;

public class Game implements GameManager{
	private final Board board;
	private final ArrayList<Player> players;
	private final ArrayList<Card> firePit = new ArrayList<>();
	private int currentPlayerIndex;
	private int turn;


	public Game(String playerName) throws IOException {
		ArrayList<Colour> colourOrder = new ArrayList<>();
		Collections.addAll(colourOrder, Colour.RED, Colour.GREEN, Colour.BLUE, Colour.YELLOW);
		Collections.shuffle(colourOrder);

		board = new Board(colourOrder, this);
		players = new ArrayList<>();
		currentPlayerIndex = 0;
		turn = 0;
		Deck.loadCardPool(board, this);
		players.add(new Player(playerName, colourOrder.get(0)));

		
		for (int i = 1; i < colourOrder.size(); i++) {
			players.add(new CPU("CPU " + i, colourOrder.get(i), board));
		}
		for(int i= 0;i<players.size();i++){
			ArrayList<Card> set = Deck.drawCards();
			players.get(i).setHand(set);
		}

	}
	public Board getBoard(){
		return board;
	}
	public Player getCurrentPlayer() {
		return players.get(currentPlayerIndex);
	}
	public ArrayList<Player> g etPlayers() {
	        return players;
	}
	public ArrayList<Card> getFirePit(){
		return firePit;
	}
}
