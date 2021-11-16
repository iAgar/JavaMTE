package Test;

import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args) {
		System.out.println("Java MTE Project");
		System.out.println();
		System.out.println("Ishaan Agarwal & Karan Singh");
		System.out.println("2K19/SE/055    & 2K19/SE/062");
		System.out.println();		
		System.out.println("Games and Portal");
		System.out.println("Main Menu");
		System.out.println("1. TicTacToe");
		System.out.println("2. Snake Game");
		System.out.println("Choose a game: ");
		Scanner input = new Scanner(System.in);
		int choice = input.nextInt();
		
		switch(choice) {
		case 1:
			int choose;
			System.out.println("Choose: ");
			System.out.println("1. v/s Computer");
			System.out.println("2. 2 players");
			choose = input.nextInt();
			switch(choose) {
			case 1:
				tictactoe t1 = new tictactoe();
				break;
			case 2:
				TictactoeTwo t2 = new TictactoeTwo();
				break;
			default:
				System.out.println("Enter a valid choice");
				break;
			}
			break;
		case 2:
			Snake s = new Snake(0);
			break;
			
		default:
			System.out.println("Enter a valid choice");
			break;
		}
	}
}

