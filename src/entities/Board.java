package entities;

public class Board {

	private Move[][] moves;
	private int round = 0;

	public Board() {
		this.moves = new Move[3][3];
	}

	public Move[][] getMoves() {
		return moves;
	}
	
	public int getRound() {
		return round;
	}

	public void printBoard() {
		for (int i = 0; i < 3; i++) {
			System.out.print(i);
			for (int j = 0; j < 3; j++) {
				if (moves[i][j] == null) {
					System.out.print("[ ]");
				} else {
					System.out.print("[" + moves[i][j].getPlayer() + "]");
				}
			}
			System.out.println();
		}
		System.out.print("  0  1  2");
	}
	
	public char changePlayer(int round) {
		if (round % 2 == 0) {
			return 'X';
		}
		else {
			return 'O';
		}
	}
	
	public boolean freePosition(int row, int column) {
		if (moves[row][column] != null) {
			return false;
		} 
		else {
			return true;
		}
	}
		
	
	public void makeMove(Move move) {
		moves[move.getRow()][move.getColumn()] = move;
	}

	public Integer checkVictory(Move[][] moves) {
		//row 1
		if (moves[0][0] != null && moves[0][1] != null && moves[0][2] != null) {
			if (moves[0][0].getPlayer() == moves[0][1].getPlayer()
					&& moves[0][0].getPlayer() == moves[0][2].getPlayer()) {
				return 1;
			}
		}
		// row 2
		if (moves[1][0] != null && moves[1][1] != null && moves[1][2] != null) {
			if (moves[1][0].getPlayer() == moves[1][1].getPlayer()
					&& moves[1][0].getPlayer() == moves[1][2].getPlayer()) {
				return 1;
			}
		}
		// row 3
		if (moves[2][0] != null && moves[2][1] != null && moves[2][2] != null) {
			if (moves[2][0].getPlayer() == moves[2][1].getPlayer()
					&& moves[2][0].getPlayer() == moves[2][2].getPlayer()) {
				return 1;
			}
		}

		// column 0
		if (moves[0][0] != null && moves[1][0] != null && moves[2][0] != null) {
			if (moves[0][0].getPlayer() == moves[1][0].getPlayer()
					&& moves[0][0].getPlayer() == moves[2][0].getPlayer()) {
				return 1;
			}
		}
		// column 1
		if (moves[0][1] != null && moves[1][1] != null && moves[2][1] != null) {
			if (moves[0][1].getPlayer() == moves[1][1].getPlayer()
					&& moves[0][1].getPlayer() == moves[2][1].getPlayer()) {
				return 1;
			}
		}
		// column 2
		if (moves[0][2] != null && moves[1][2] != null && moves[2][2] != null) {
			if (moves[0][2].getPlayer() == moves[1][2].getPlayer()
					&& moves[0][2].getPlayer() == moves[2][2].getPlayer()) {
				return 1;
			}
		}
		// diagonal 0,0 - 1,1 - 2,2
		if (moves[0][0] != null && moves[1][1] != null && moves[2][2] != null) {
			if (moves[0][0].getPlayer() == moves[1][1].getPlayer()
					&& moves[0][0].getPlayer() == moves[2][2].getPlayer()) {
				return 1;
			}
		}
		// diagonal 0,2 - 1,1 - 2,0,
		if (moves[0][2] != null && moves[1][1] != null && moves[2][0] != null) {
			if (moves[0][2].getPlayer() == moves[1][1].getPlayer()
					&& moves[0][2].getPlayer() == moves[2][0].getPlayer()) {
				return 1;
			}
		} 
		int counter = 0;
		for (int i = 0; i < moves.length; i++) {
			for (int j = 0; j < moves.length; j++) {
				if (moves[i][j] != null) {
					counter++;
				}
				if (counter == 9) {
					return 2;
				}
			}
		}
		return null;
	}
	
	// https://stackoverflow.com/questions/2979383/java-clear-the-console
	public static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}	
	
}
