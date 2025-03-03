package engine.board;

import model.player.*;

public class Cell {
	private Marble marble;
	private CellType cellType;
	private boolean trap;
	
	public Cell(CellType cellType){
		this.setCellType(cellType);
		this.setMarble(null);
		this.setTrap(false);
	}

	public Marble getMarble() {
		return marble;
	}

	public void setMarble(Marble marble) {
		this.marble = marble;
	}

	public CellType getCellType() {
		return cellType;
	}

	public void setCellType(CellType cellType) {
		this.cellType = cellType;
	}

	public boolean isTrap() {
		return trap;
	}

	public void setTrap(boolean trap) {
		this.trap = trap;
	}
}
