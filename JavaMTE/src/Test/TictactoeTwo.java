package Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TictactoeTwo {
	static ArrayList<Integer> p1Positions =  new ArrayList<Integer>();
	static ArrayList<Integer> p2Positions =  new ArrayList<Integer>();

	//public static void main(String[] args) {
		public TictactoeTwo() {
		char [][] gameBoard = {{' ', '|', ' ', '|', ' '}, 
				{'-', '+', '-', '+', '-'},
				{' ', '|', ' ', '|', ' '}, 
				{'-', '+', '-', '+', '-'}, 
				{' ', '|', ' ', '|', ' '}};
		
		printGameBoard(gameBoard);		
		
		while(true) {
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter your placement (1-9):");
			int p1Pos = scan.nextInt();	
			while(p1Positions.contains(p1Pos) || p2Positions.contains(p1Pos)) {
			System.out.println("position taken! Enter a correct position");
			p1Pos = scan.nextInt();
			}
			placePiece(gameBoard, p1Pos, "p1");
			
			printGameBoard(gameBoard);
			
			String result = checkWinner();
			if(result.length() > 0) {	
				System.out.println(result);
				break;
			}
			
			System.out.println("Enter your placement (1-9):");
			int p2Pos = scan.nextInt();	
			while(p1Positions.contains(p2Pos) || p2Positions.contains(p2Pos)) {
			System.out.println("position taken! Enter a correct position");
			p2Pos = scan.nextInt();
			}
			placePiece(gameBoard, p2Pos, "p2");
			
			printGameBoard(gameBoard);
			
			 result = checkWinner();
			if(result.length() > 0) {	
				System.out.println(result);
				break;
			}	
			
		}		
	}
	
	public static void printGameBoard(char[][] gameBoard) {
		
		for(char[] row : gameBoard) {
			for(char c : row) {
				System.out.print(c);
			}
			System.out.println();
		}		
	}
	
	public static void placePiece(char [][] gameBoard, int pos, String user) { 
		
		char symbol = ' ';
		
		if(user.equals("p1")) {
			
			symbol = 'X';
			p1Positions.add(pos);
		} else if(user.equals("p2")) {
		    p2Positions.add(pos);
		symbol = '0';
		
		}
		
		switch(pos) {
		   case 1:
			   gameBoard[0][0] = symbol;
			   break;
		   
		   case 2:
			   gameBoard[0][2] = symbol;
			   break;
			   
		   case 3:
			   gameBoard[0][4] = symbol;
			   break;
			   
		   case 4:
			   gameBoard[2][0] = symbol;
			   break;
			   
		   case 5:
			   gameBoard[2][2] = symbol;
			   break;
			   
		   case 6:
			   gameBoard[2][4] = symbol;
			   break;
			   
		   case 7:
			   gameBoard[4][0] = symbol;
			   break;
			   
		   case 8:
			   gameBoard[4][2] = symbol;
			   break;
			   
		   case 9:
			   gameBoard[4][4] = symbol;
			   break;
		}
		
	}
	public static String checkWinner() {
		
		List<Integer> topRow = Arrays.asList(1, 2, 3);
		List<Integer> midRow = Arrays.asList(4, 5, 6);
		List<Integer> botRow = Arrays.asList(7, 8, 9);
		List<Integer> leftCol = Arrays.asList(1, 4, 7);
		List<Integer> midCol = Arrays.asList(2, 5, 8);
		List<Integer> rightCol = Arrays.asList(3, 6, 9);
		List<Integer> cross1 = Arrays.asList(1, 5, 9);
		List<Integer> cross2 = Arrays.asList(7, 5, 3);
		
		List<List<Integer>> winning = new ArrayList<>();
		winning.add(topRow);
		winning.add(midRow);
		winning.add(botRow);
		winning.add(leftCol);
		winning.add(midCol);
		winning.add(rightCol);
		winning.add(cross1);
		winning.add(cross2);
		
		for(List<Integer> l : winning) {
			if(p1Positions.containsAll(l)) {
				return "Player 1 WINS";
		   }else if(p2Positions.containsAll(l)) {
			   return "Player 2 WINS";
		   }else if(p1Positions.size() + p2Positions.size() == 9) {
			   return "Draw";
		   }
		}
		
		return "";
		
	}
}

