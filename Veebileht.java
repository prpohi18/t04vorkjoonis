import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.lang.Math;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
public class Veebileht{
	public static void main(String[] arg) throws Exception{
		String aadress="http://www.tlu.ee/~jaagup/veeb1/pikkused.txt";
		BufferedReader br=new BufferedReader(new InputStreamReader(new URL(aadress).openStream()));
		String rida=br.readLine();
		int kokku=0;
		float keskmine=0;
		int loendur=0;
		int rida_nr=1;
		ArrayList<Integer> arvud = new ArrayList<Integer>();
		//Prindib igat rida, mis on lehel. Listi lisamine rida 23
		while(rida!=null){
			loendur++;
			System.out.println(rida_nr+". "+rida);
			rida_nr++;
			//System.out.println(rida);
			int arv1 = Integer.parseInt(rida);
			kokku=arv1+kokku;
			arvud.add(Integer.parseInt(rida));
			rida=br.readLine();
		}
		float arvude_keskmine = ((float)kokku/loendur);
		br.close();
		//Hälve leidmine
		double halve = 0;
		loendur = 0;
		for (int i=0; i<arvud.size(); i++){
			loendur++;
			halve = Math.pow((arvud.get(i)-keskmine), 2) + halve;
		}
		//Standarthälve leidmine
		double standHalve = 0;
		standHalve = Math.sqrt(halve/loendur);
		System.out.println("Arvude summa on: "+kokku);
		System.out.println("Arvude keskmine on: "+(arvude_keskmine));
		//System.out.println(arvud.get(1)); //Listist võtab indeksiga 1 väärtuse ja prindib
		System.out.println("Standarthälve on: "+standHalve);
		//Pildi loomine standarthälvest
		BufferedImage bi=new BufferedImage(400, 300, BufferedImage.TYPE_INT_RGB);
		Graphics g=bi.createGraphics();
		g.setColor(Color.YELLOW);
		g.fillRect(0, 0, 400, 300);
		g.setColor(Color.RED);
		int x1 = 20;
		int y1 = 300;
		int x2 = 20;
		int y2 = 0;
		for (int i=0; i<arvud.size(); i++){
			y2 = y1 - arvud.get(i);
			g.drawLine(x1, y1, x2, y2); //x1 y1 x2 y2
			x1 += 20;
			x2 += 20;
		}
		//aritmeetilise keskmise joon
		g.setColor(Color.GREEN);
		g.drawLine(0, (int)Math.round(y1-arvude_keskmine), 400, (int)Math.round(y1-arvude_keskmine));
		ImageIO.write(bi, "png", new File("pilt1.png"));
	}
}
