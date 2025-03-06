package engine.board;

import engine.GameManager;
import model.Colour;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

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
		Random ran = new Random();
		int i;
       	while(true){
			i = ran.nextInt(100);
        	if(i%25!=0 && i!=23 && i!=48 && i!=73 && i!=98 && !track.get(i).isTrap()) {
				break;
			}
        }
		track.get(i).setTrap(true);
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
