package engine.board;

import engine.GameManager;
import model.Colour;

import java.util.ArrayList;
import java.util.Collections;

public class Board implements BoardManager{
	private final GameManager gameManager;
	private final ArrayList<Cell> track;
	private final ArrayList<SafeZone> safeZones;
	private int splitDistance;

	public Board(ArrayList<Colour> colourOrder, GameManager gameManager){
		this.gameManager = gameManager;
		this.track = new ArrayList<>();
		this.safeZones = new ArrayList<>();
		this.splitDistance = 3;
		
		for (int i = 0; i < 100; i++) {
            track.add(new Cell(CellType.NORMAL));
        }
		for(int i = 0;i<100;i+=25){
			track.get(i).setCellType(CellType.BASE);
		}
		for(int i = 23;i<100;i+=25){
			track.get(i).setCellType(CellType.ENTRY);
		}
		
		for(int i = 0;i<8;i++){
			assignTrapCell();
		}
        for (Colour colour : colourOrder) {
            safeZones.add(new SafeZone(colour));
        }
	}
	
	@Override
	public int getSplitDistance() {
		return splitDistance;
	}
	public void setSplitDistance(int splitDistance) {
        this.splitDistance = splitDistance;
    }
    private void assignTrapCell() {
        ArrayList<Integer> indices = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
        	if(i%25!=0 && i!=23 && i!=48 && i!=73 && i!=98 && !track.get(i).isTrap())
        		indices.add(i);
        }
        Collections.shuffle(indices);
        for (int i = 0; i < 8; i++) {
            track.get(indices.get(i)).setTrap(true);
        }
    }
    
	public ArrayList<Cell> getTrack() {
		return track;
	}

	public ArrayList<SafeZone> getSafeZones() {
		return safeZones;
	}
	public GameManager getGameManager() {
		return gameManager;
	}
	
}
