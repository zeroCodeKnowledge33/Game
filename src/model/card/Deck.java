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
import model.card.standard.*;
import engine.Game;

import model.card.standard.*;
import model.card.wild.*;
import model.card.standard.Standard;
import engine.GameManager;
import engine.board.*;

public class Deck {
	final static String CARDS_FILE = "Cards.csv";
	private static ArrayList<Card> cardsPool;


	public static void loadCardPool(BoardManager boardManager, GameManager gameManager) throws IOException {
		cardsPool = new ArrayList<>();
		//Log-Youssef: the method CSVReader got from ChatGPT

		File p = new File(CARDS_FILE);
		Scanner sc = new Scanner(p);
		while (sc.hasNext()) {
			Card card = null;
			String row = sc.nextLine();

			String[] line = row.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
			int code = Integer.parseInt(line[0]);
			int f = Integer.parseInt(line[1]);
			String name = line[2];
			String description = line[3];
			if(code==14||code==15){
				if(code==14) {
					while (f-- > 0) {
						card = new Burner(name,description,boardManager,gameManager);
						cardsPool.add(card);
					}
				} else{
					while (f-- > 0) {
						card = new Saver(name,description,boardManager,gameManager);
						cardsPool.add(card);
					}
				}
			}else {
				int rank = 0;
				String type = null;
				if (line[4] != "") {
					rank = Integer.parseInt(line[4]);
					type = line[5];
				}
				if (code >= 0 && code <= 13) {
					switch (code) {
						case 13:
							while (f-- > 0) {
								card = new King(name, description, Suit.valueOf(type), boardManager, gameManager);
								cardsPool.add(card);
							}
							break;
						case 12:
							while (f-- > 0) {
								card = new Queen(name, description, Suit.valueOf(type), boardManager, gameManager);
								cardsPool.add(card);
							}
							break;
						case 11:
							while (f-- > 0) {
								card = new Jack(name, description, Suit.valueOf(type), boardManager, gameManager);
								cardsPool.add(card);
							}
							break;
						case 10:
							while (f-- > 0) {
								card = new Ten(name, description, Suit.valueOf(type), boardManager, gameManager);
								cardsPool.add(card);
							}
							break;
						case 7:
							while (f-- > 0) {
								card = new Seven(name, description, Suit.valueOf(type), boardManager, gameManager);
								cardsPool.add(card);
							}
							break;
						case 5:
							while (f-- > 0) {
								card = new Five(name, description, Suit.valueOf(type), boardManager, gameManager);
								cardsPool.add(card);
							}
							break;
						case 4:
							while (f-- > 0) {
								card = new Four(name, description, Suit.valueOf(type), boardManager, gameManager);
								cardsPool.add(card);
							}
							break;
						case 1:
							while (f-- > 0) {
								card = new Ace(name, description, Suit.valueOf(type), boardManager, gameManager);
								cardsPool.add(card);
							}
							break;
						case 0:
							while (f-- > 0) {
								card = new Standard(name, description, rank, Suit.valueOf(type), boardManager, gameManager);
								cardsPool.add(card);
							}
							break;
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException{
		GameManager gm = null;
		Deck.loadCardPool(null,null);
		for(int i =0;i<cardsPool.size();i++){
			System.out.println(cardsPool.get(i).getDescription());
		}
	}
	public static ArrayList<Card> drawCards() {
		Collections.shuffle(cardsPool);
		int drawCount = Math.min(4, cardsPool.size());
		ArrayList<Card> hand = new ArrayList<>(cardsPool.subList(0, drawCount));
		cardsPool.removeAll(hand);
		return hand;
	}
}
