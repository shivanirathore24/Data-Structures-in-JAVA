package ticTacToe;

import java.util.Scanner;

public class TicTacToe {
	private Player player1, player2;
	private Board board;
	private int numPlayers;
	
	public static void main(String args[])
	{
		TicTacToe t = new TicTacToe();
		t.startGame();
	}
	
	public void startGame()
	{
		Scanner s = new Scanner(System.in);
		//Take players input
		player1 = takePlayerInput(+numPlayers);
		player2 = takePlayerInput(+numPlayers);
		while(player1.getSymbol() == player2.getSymbol()) {
			System.out.println("Symbol already taken ! Pick another symbol !");
			player2.setSymbol(s.next().charAt(0));
		}
		
		//Create the board
		board = new Board(player1.getSymbol(),player2.getSymbol());
		
		//Play the game
		boolean player1Turn = true;
		int status;
		//while() {  
			if(player1Turn) {
				System.out.println("Player 1-"+ player1.getName() + "'s turn");
				System.out.println("Enter x: ");
				int x = s.nextInt();
				System.out.println("Enter y: ");
				int y = s.nextInt();
				
				//board.move(player1.getSymbol(), x, y);
			}
			else {
				
			}
		//}
	}
	
	private Player takePlayerInput(int num)
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Player"+ num + " name: ");
		String name = s.nextLine();
		System.out.println("Enter Player"+ num + " symbol: ");
		char symbol = s.next().charAt(0);
		Player p = new Player(name, symbol);
		return p;	
	}
}
