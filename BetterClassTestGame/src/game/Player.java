package game;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {

	private String name;
	private double yPos;
	private double xPos;
	private double startingDistance;
	private final double startingPositionY = 0;
	private final double startingPositionX = 0;
	private ArrayList<MapObjects> inventory = new ArrayList<MapObjects>();
	MapObjects rock = new MapObjects("rock");
	
	public Player(String name) {
		this.name = name;
		this.xPos = startingPositionX;
		this.yPos = startingPositionY;

	}

	public double getyPos() {
		return yPos;
	}

	public double getxPos() {
		return xPos;
	}

	public void setPlayerCoordinates(double yPos, double xPos) {
		this.yPos = yPos;
		this.xPos = xPos;
	}

	public String playerMove(String input) {
		if (input.equals("north")) {
			yPos = yPos + 1;
		} else if (input.equals("south")) {
			yPos = yPos - 1;
		} else if (input.equals("east")) {
			xPos = xPos + 1;
		} else if (input.equals("west")) {
			xPos = xPos - 1;
		} 
		return getPlayerCoordinates();

	}
	//Using the Pythagorean theorem
	public double getStartingDistance() {
		this.startingDistance = Math.sqrt(this.xPos * this.xPos + this.yPos * this.yPos);
		return this.startingDistance;
	}

	public String getPlayerCoordinates() {
		return "Your coordinates are [" + this.xPos + "," + this.yPos + "]";

	}
//Using the Pythagorean theorem
	public double getDistanceToObject(MapObjects object) {
		double objectDistance = Math
				.sqrt(Math.pow(object.getyPos() - this.getyPos(), 2) + Math.pow(object.getxPos() - this.getxPos(), 2));
		System.out.println("Your distance to " + object.getObjectName() + " is " + String.format("%.1f", objectDistance) + "m");
		return  objectDistance;

	}
	
	public void playerTakeAction(String input) {
		if(input.equals("inventory")) {
			System.out.println("Your inventory: " + inventory);
		}
		else if (input.equals("position")) {
			System.out.println(getPlayerCoordinates());
		}
//		else if (input.equals("take")) {
//			playerPickUpObject(getObjectName());
//		}
		else {
			System.out.println("Sorry, I didn't catch that");
	
		}
	}
	
	public void playerPickUpObject(MapObjects object) {
		if(this.getDistanceToObject(object)==0) {
			object.setyPos(this.getyPos());
			object.setxPos(this.getxPos());
		}
		inventory.add(object);
		System.out.println(object.getObjectName() + " added to inventory");
	}

}
