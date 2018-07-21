package game;

import java.util.Scanner;

public class Game {

	Player seb = new Player("Seb");
	MapObjects sword = new MapObjects("Sword");

	public void newGame(Player player) {
		
		player.playerPickUpObject("iPhone");
		System.out.println(sword.getObjectCoordinates());
		
		intro();

		playerMoveLoop(player);

	}

	public void intro() {
		System.out.println(
				"Welcome, adventurer! You have found yourself within a castle where there's nothing to do. Go out for a walk.");
		System.out.println("Where would you like to move? \nType in either " + "'north', 'south', 'west', 'east'");
		System.out.println("\nAt any point in the game you can type in 'action' to do other things than walking\n");

	}

	public void playerMoveLoop(Player player) {
		boolean temp = true;
		while (temp) {
			Scanner sc = new Scanner(System.in);
			System.out.print("> ");
			String input = sc.nextLine().toLowerCase();
			if (input.equals("action")) {
				System.out.println(
						"Type in 'inventory' to check inventory \nor type in 'position' to obtain your coordinates");
				System.out.print("> ");
				String input1 = sc.nextLine().toLowerCase();
				player.playerTakeAction(input1);
			}
			player.playerMove(input);
			System.out.println("You are " + String.format("%.1f", player.getStartingDistance())
					+ "m away from the castle, keep walking or type 'action'");
			if (player.getStartingDistance() > 3 && player.getStartingDistance() <= 5) {
				temp = false;
				System.out.println("You're too far from the castle! Go back or the wolves will eat you.");
				playerMoveLoop(player);
			} else if (player.getStartingDistance() > 4) {
				temp = false;
				System.out.println("The wolves have eaten you. You are dead. Type in anything to start again.");
				System.out.print("> ");
				sc.nextLine();
				player.setPlayerCoordinates(0, 0);
				newGame(player);
			}

		}
	}

}
