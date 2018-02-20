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
		System.out.println(getAvg(Players));
			
	}
	//Funktsioon keskmise leidmiseks
	public static float getAvg(ArrayList<Player> Players) {
			float sum = 0;
			int index = 0;
			for(Player k : Players){
				sum = sum + ((Players.get(index)).getPoints());
				index++;
			}
			float avg = sum/(index+1);
			return avg;
		}
}
