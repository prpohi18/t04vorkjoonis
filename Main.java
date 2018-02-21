import java.net.*;
import java.io.*;
import java.util.*;
import java.awt.image.*;
import java.awt.*;
import javax.imageio.*;
public class Main{
	public static void main(String[] arg) throws Exception {
		String location = "http://www.tlu.ee/~mkivikin/players.txt";
		ArrayList<Player> Players = new ArrayList<Player>();
		//Alustan andmete lugemist
		BufferedReader bi = new BufferedReader(new InputStreamReader(new URL(location).openStream()));
		//Loen ära tulba headerid, sest neid pole praegu vaja
		String rida = bi.readLine();
		if(!rida.startsWith("name")) {
			System.out.println("Sobimatu vorminguga fail");
			return; 
		}
		rida = bi.readLine();
		while (rida != null) {
			String[] Info = rida.split(", ");
			//Loon tekstifailist saadud andmetega mängija objekti
			//System.out.println(Info[0]+ " " + Info[1] + " " + Info[2]);
			Player p = new Player(Info[0], Info[1], (Float.parseFloat(Info[2])));
			Players.add(p);
			rida = bi.readLine();
		}
		//System.out.println(getAvg(Players, "SG"));
		drawGraph(Players, "SG", "PG");
		System.out.println(getMin(Players, "SG"));
		System.out.println(getMax(Players, "SG"));
		
		
			
	}
	//Funktsioon keskmise leidmiseks
	public static float getAvg(ArrayList<Player> Players, String position) {
			float sum = 0;
			int index = 0;
			int count = 0;
			for(Player k : Players){
				//Kui mängija objekti positsioon on võrdne kasutaja sisestatud positsiooniga
				if((Players.get(index)).getPosition().equals(position)) {
					//System.out.println(Players.get(index).getPoints());
					sum = sum + ((Players.get(index)).getPoints());
					count++;
				}
				index++;
			}
			float avg = sum/(count);
			return avg;
		}
	//Leiab miinimumi	
	public static float getMin(ArrayList<Player> Players, String position){
		float min = Players.get(0).getPoints();
		int index = 0;
		for(Player k : Players){
				//Kui mängija objekti positsioon on võrdne kasutaja sisestatud positsiooniga
				if((Players.get(index)).getPosition().equals(position)) {
					if((Players.get(index)).getPoints()< min) {
					//System.out.println(Players.get(index).getPoints());
					min =((Players.get(index)).getPoints());
					}
				}
				index++;
			}
			return min;
	}
	
	public static float getMax(ArrayList<Player> Players, String position){
		float max = Players.get(0).getPoints();
		int index = 0;
		for(Player k : Players){
				//Kui mängija objekti positsioon on võrdne kasutaja sisestatud positsiooniga
				if((Players.get(index)).getPosition().equals(position)) {
					if((Players.get(index)).getPoints()>max) {
					//System.out.println(Players.get(index).getPoints());
					max =((Players.get(index)).getPoints());
					}
				}
				index++;
			}
			return max;
	}
	public static void drawGraph(ArrayList<Player> Players, String pos1, String pos2) throws Exception{
		int imgWidth = 500;
		int imgHeight = 500;
		BufferedImage bi = new BufferedImage(imgWidth, imgHeight, BufferedImage.TYPE_INT_RGB);
		Graphics g = bi.createGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 500, 500);
		int index = 0;
		int x1 = 25;
		int dotSize = 3;
		int ypos = 0;
		//Joonestab esimese positsiooni mängijate punktid
		for (Player p : Players) {
			if ((Players.get(index)).getPosition().equals(pos1)) {
				g.setColor(Color.BLUE);
				int points = (Math.round(Players.get(index).getPoints())*10);
				System.out.println(points);
				ypos = imgHeight-points;
				g.fillOval(x1, ypos, dotSize, dotSize);
				x1 = x1+25;
			}
			if ((Players.get(index)).getPosition().equals(pos2)) {
				g.setColor(Color.RED);
				int points = (Math.round(Players.get(index).getPoints())*10);
				ypos = imgHeight-points;
				g.fillOval(x1, ypos, dotSize, dotSize);
				x1 = x1+25;
			}
			index++;
		}
		ypos = imgHeight-(Math.round(getAvg(Players, pos1))*10);
		//Joonestab sirge mis on esimese positsiooni keskmine punktide arv
		g.setColor(Color.BLUE);
		g.drawLine(0, ypos, 500, ypos);
		ypos = imgHeight-(Math.round(getAvg(Players, pos2))*10);
		//Joonestab sirge mis on võrdne teise positsiooni keskmise punktide arvuga
		g.setColor(Color.RED);
		g.drawLine(0, ypos, 500, ypos);
		//Joonestan mingid graafiku skaala
		g.setColor(Color.BLACK);
		index = 5;
		ypos = imgHeight-50;
		int points = 5;
		while (index<(imgWidth/10)){
			g.drawLine(0, ypos, 10, ypos);
			ypos = ypos-5; 
			g.drawString(String.valueOf(points), 3, ypos);
			ypos= ypos - 45;
			points = points+5;
			index = index+5;
		}
		ImageIO.write(bi, "png", new File("keskmised.png"));
	}
		
}
