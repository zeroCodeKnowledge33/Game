package engine.board;

import java.util.*;

import model.*;
public class SafeZone {
	private final Colour colour;
	private final ArrayList<Cell> cells;
	public SafeZone(Colour colour){
		cells = new ArrayList<>();
		this.colour = colour;
		for(int i =0;i<4;i++){
			Cell cell = new Cell(CellType.SAFE);
			cells.add(cell);
		}
	}
	public ArrayList<Cell> getCells() {
        return cells;
    }
	public Colour getColour() {
		return colour;
	}
	
}
