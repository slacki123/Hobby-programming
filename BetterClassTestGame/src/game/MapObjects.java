package game;

import java.util.Random;

public class MapObjects {

	private String name;
	private double yPos;
	private double xPos;
	private double distanceFromObject;
	private Random rand = new Random();

	public MapObjects(String name) {
		this.xPos = rand.nextInt(3)+1;
		this.yPos = rand.nextInt(3)+1;
		this.name = name;
	}

	public double getyPos() {
		return yPos;
	}

	public double getxPos() {
		return xPos;
	}

	public void setyPos(double yPos) {
		this.yPos = yPos;
	}

	public void setxPos(double xPos) {
		this.xPos = xPos;
	}

	public String getObjectName() {
		return name;
	}
	
	public String getObjectCoordinates() {
		return "This object is located at [" + this.xPos + "," + this.yPos + "]";
	}

	public void setObjectCoordinates(double yPos, double xPos) {
		this.yPos = yPos;
		this.xPos = xPos;
	}
	
	public void objectFunctionality() {}
	
	public String toString() {
		return name;
	}

}
