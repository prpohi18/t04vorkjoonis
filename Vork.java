import java.net.*;
import java.io.*;
import java.lang.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
public class Vork{
	public static void main(String[] arg) throws Exception {
		BufferedImage bi=new BufferedImage(400, 300, BufferedImage.TYPE_INT_RGB);
		Graphics g=bi.createGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(0,0,400,300);
		String aadress="http://www.tlu.ee/~mhaava/pikkused.txt";
		BufferedReader br=new BufferedReader(new InputStreamReader(new URL(aadress).openStream()));
		String rida=br.readLine();
		int counter=0;
		int px=-10;
		float artmKesk=0;
		double halve=0;
		while(rida!=null){
			counter++;
			artmKesk=artmKesk + Integer.parseInt(rida);
			System.out.println(counter+". "+rida);
			rida=br.readLine();
		}
		br.close();
		BufferedReader br2=new BufferedReader(new InputStreamReader(new URL(aadress).openStream()));
		artmKesk=artmKesk/counter;
		g.setColor(Color.BLACK);
		g.drawLine(0, 300-Math.round(artmKesk), 400, 300-Math.round(artmKesk));
		int graafikuvahed=400/counter;
		for(int i=0; i<counter; i++){
			rida=br2.readLine();
			px=px+graafikuvahed;
			g.drawLine(px, 300, px, 300-Integer.parseInt(rida));
			halve=halve+((Integer.parseInt(rida)-artmKesk)*(Integer.parseInt(rida)-artmKesk));
		}
		System.out.println("Aritmeetiline keskmine on: "+ artmKesk);
		halve=Math.sqrt(halve/counter);
		System.out.println("Hälve on: "+ halve);
		g.setColor(Color.BLUE);
		g.drawLine(0, 300-Math.round(artmKesk)-(int)halve, 400, 300-Math.round(artmKesk)-(int)halve);
		g.drawLine(0, 300-Math.round(artmKesk)+(int)halve, 400, 300-Math.round(artmKesk)+(int)halve);
		g.setColor(Color.RED);
		g.drawLine(0, 300-Math.round(artmKesk)-(int)(halve*2), 400, 300-Math.round(artmKesk)-(int)(halve*2));
		g.drawLine(0, 300-Math.round(artmKesk)+(int)(halve*2), 400, 300-Math.round(artmKesk)+(int)(halve*2));
		br2.close();
		//pilt
		
		ImageIO.write(bi, "png", new File("graafik.png"));
	}
}