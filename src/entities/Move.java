package entities;

public class Move {

	private int row;
	private int column;
	private char player;
	
	public Move(int row, int column, char player) {
		this.row = row;
		this.column = column;
		this.player = player;
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	public char getPlayer() {
		return player;
	}
	
}
