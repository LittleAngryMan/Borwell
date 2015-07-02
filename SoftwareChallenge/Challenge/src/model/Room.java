package model;

public class Room {
	
	/*Fields*/
	private double length;
	private double width;
	private double depth;
	
	/*Constructors*/
	//Default Constructor
	public Room() {
		length = 0;
		width = 0;
		depth = 0;
	}
	
	//Input Constructor
	public Room(double length, double width, double depth) {
		this.length = length;
		this.width = width;
		this.depth = depth;
	}
	
	/*Methods*/
	//Setters
	public void setLength(double length) {
		this.length = length;
	}
	
	public void setWidth(double width) {
		this.width = width;
	}
	
	public void setDepth(double depth) {
		this.depth = depth;
	}
	
	//Getters
	public double getLength() {
		return length;
	}
	
	public double getWidth() {
		return width;
	}
	
	public double getDepth() {
		return depth;
	}
	
	//Outputs
	public double getFloorArea() {
		return length*width;
	}
	
	public double getPaintRequired() {
		double paintSpace, paintNeededLitres;
		paintSpace = ((width*depth)*2 + (length*depth)*2);
		paintNeededLitres = paintSpace/14;
		return paintNeededLitres;
	}
	
	public double getVolume() {
		return width*length*depth;
	}
}
