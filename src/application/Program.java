package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import entities.Move;
import entities.Board;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Board t = new Board();
		Move move;
		t.printBoard();
		int column = 0;
		int row = 0;
		int round = 0;
		int result = t.checkVictory(t.getMoves());

		while (result == 0) {
			sc = new Scanner(System.in);
			System.out.println();
			System.out.print("Player " + t.changePlayer(round));
			System.out.println();

			try {
			System.out.print("Enter row: ");
			row = sc.nextInt();
			System.out.print("Enter column: ");
			column = sc.nextInt();
			if (t.freePosition(row, column)) {
				move = new Move(row, column, t.changePlayer(round));
				t.makeMove(move);
			} else {
				while (!t.freePosition(row, column)) {
					System.out.println("This position is already taken, try again!");
					System.out.print("Enter row: ");
					row = sc.nextInt();
					System.out.print("Enter column: ");
					column = sc.nextInt();
				}
				move = new Move(row, column, t.changePlayer(round));
				t.makeMove(move);
			}
			System.out.println();
			t.printBoard();
			result = t.checkVictory(t.getMoves());
			round++;
			t.changePlayer(round);
			}
			catch(IndexOutOfBoundsException e) {
				System.out.println("The entered position is invalid, try again!");
			}
			catch(InputMismatchException e) {
				System.out.println("The entered value is invalid, try again!");
			}	
		}
		sc.close();
	}
}
