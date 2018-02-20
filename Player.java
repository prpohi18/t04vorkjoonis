import java.io.*;
public class Player {
	protected String name;
	protected String position;
	protected float points;
	
	public Player(String name, String position, float points) {
		this.name = name;
		this.position = position;
		this.points = points;
	}
	public float getPoints(){
		return points;
	}
	public String getPosition(){
		return position;
	}
	public String getName(){
		return name;
	}
}