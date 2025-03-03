package model.card;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import engine.Game;
import model.Suit;
import model.card.standard.*;
import model.card.wild.*;
import model.card.standard.Standard;
import engine.GameManager;
import engine.board.*;

public class Deck {
	final static String CARDS_FILE = "Cards.csv";
	static ArrayList<Card> cardsPool;

	public static void main(String[] args) throws IOException {
		GameManager gm = new Game("Hi");
		BoardManager bm = new Board();
		Deck.loadCardPool(bm,gm);
	}
	public static void loadCardPool(BoardManager boardManager, GameManager gameManager) throws IOException {
		cardsPool = new ArrayList<>();
		//Log-Youssef: the method CSVReader got from ChatGPT

		File p = new File(CARDS_FILE);
		Scanner sc = new Scanner(p);
		while (sc.hasNext()) {
			Card card = null;
			String row = sc.nextLine();
			String[] line = row.split(",");
			int code = Integer.parseInt(line[0]);
			int f = Integer.parseInt(line[1]);
			String name = line[2];
			String description = line[3];
			if(code==14||code==15){
				if(code==14) {
					card = new Burner(name,description,boardManager,gameManager);
				} else{
					card = new Saver(name,description,boardManager,gameManager);
				}
			}else {
				int rank = 0;
				String type = null;
				if (line[4] != null) {
					rank = Integer.parseInt(line[4]);
					type = line[5];
				}

				if (code >= 0 && code <= 13) {
					Suit suitType = null;
					if (code != 0) {
						switch (type) {
							case "SPADE":
								suitType = Suit.SPADE;
								break;
							case "DIAMOND":
								suitType = Suit.DIAMOND;
								break;
							case "HEART":
								suitType = Suit.HEART;
								break;
							case "CLUB":
								suitType = Suit.CLUB;
								break;
							default:
								break;
						}
					}
					if (code == 13) {
						card = new King(name, description, suitType, boardManager, gameManager);

					} else if (code == 12) {
						card = new Queen(name, description, suitType, boardManager, gameManager);

					} else if (code == 11) {
						card = new Jack(name, description, suitType, boardManager, gameManager);

					} else if (code == 10) {
						card = new Ten(name, description, suitType, boardManager, gameManager);

					} else if (code == 7) {
						card = new Seven(name, description, suitType, boardManager, gameManager);

					} else if (code == 5) {
						card = new Five(name, description, suitType, boardManager, gameManager);

					} else if (code == 4) {
						card = new Four(name, description, suitType, boardManager, gameManager);

					} else if (code == 1) {
						card = new Ace(name, description, suitType, boardManager, gameManager);

					} else if (code == 0) {
						card = new Standard(name, description, rank, suitType, boardManager, gameManager);
					}

				}
			}
			if (card != null) {
				while (f-- > 0) {
					cardsPool.add(card);
				}
			}
		}
	}



	public static ArrayList<Card> drawCards() {
		Collections.shuffle(cardsPool);
		ArrayList<Card> hand = new ArrayList<>(cardsPool.subList(0, 4));
		cardsPool.removeAll(hand);
		return hand;
	}
}
