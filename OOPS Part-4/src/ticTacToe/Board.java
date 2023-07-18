package ticTacToe;

public class Board {
	private char board[][];
	private int boardSize = 3;
	private char p1Symbol, p2Symbol;
	//count the number of cells are filled.
	private int count;
	private static final char EMPTY = ' ';
	public static final int PLAYER1WINS = 1;
	public static final int PLAYER2WINS = 2;
	public static final int DRAW = 3;
	public static final int INCOMPLETE = 4;
	public static final int INVALIDMOVE = 5;

	public Board(char p1Symbol, char p2Symbol)
	{
		board = new char[boardSize][boardSize];
		for(int i = 0; i < boardSize; i++)
		{
			for(int j = 0; j < boardSize; j++)
			{
				board[i][j] = EMPTY;
			}
		}
		this.p1Symbol = p1Symbol;
		this.p2Symbol = p2Symbol;
	}

	public void print()
	{
		System.out.println("---------------");
		for(int i = 0; i < boardSize; i++) {
			for(int j = 0; j < boardSize; j++) {
				System.out.print("| "+ board[i][j] + " |");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("---------------");
	}
}
