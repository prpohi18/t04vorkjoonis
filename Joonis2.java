package kodutoo4;

import java.awt.image.*;
import javax.imageio.*;
import java.awt.*;
import java.net.*;
import java.io.*;

public class Joonis2{
	
	public static void main(String[] arg) throws Exception{
		
		int kassimass = 0;
		int koeramass = 0;
		int kassipikkus = 0;
		int koerapikkus = 0;
		int kassCount = 0;
		int koerCount = 0;
		
		BufferedImage bi=new BufferedImage(400,300, BufferedImage.TYPE_INT_RGB);
        	Graphics g=bi.createGraphics();
        	g.setColor(Color.WHITE);
       	 	g.fillRect(0, 0, 400, 300);
		g.setColor(Color.BLACK);
		g.drawString("Loomade kaalu ja kõrguse suhe", 110, 20);
		g.setColor(Color.BLUE);
		g.drawString("KOERAD", 5, 40);
		g.setColor(Color.RED);
		g.drawString("KASSID", 5, 60);
		g.setColor(Color.GRAY);
		g.drawString("KASSID KESKMINE", 65, 60);
		g.setColor(Color.GREEN);
		g.drawString("KOERAD KESKMINE", 65, 40);
		
        	String aadress="http://www.tlu.ee/~jaagup/veeb1/loomad.txt";
        	BufferedReader br=new BufferedReader(new InputStreamReader(
        	new URL(aadress).openStream()));
        	String rida=br.readLine();
        	rida=br.readLine();
		
       	 	while(rida!=null){
            		String[] dataArray=rida.split(",");
            		if(dataArray[0].equals("kass")){
				g.setColor(Color.red);
				kassimass = kassimass + Integer.parseInt(dataArray[1]);
				kassipikkus = kassipikkus + Integer.parseInt(dataArray[2]);
				kassCount++;
			}
            		else{
				g.setColor(Color.blue);
				koeramass = koeramass + Integer.parseInt(dataArray[1]);
				koerapikkus = koerapikkus + Integer.parseInt(dataArray[2]);
				koerCount++;
			}
			
            	g.fillRect(Integer.parseInt(dataArray[1])/30,300-Integer.parseInt(dataArray[2])*2,5,5);
            	rida=br.readLine();
			
        	}
	
		int kassikeskminepikkus = kassipikkus/kassCount;
		int kassikeskminemass = kassimass/kassCount;
		int koerakeskminepikkus = koerapikkus/koerCount;
		int koerakeskminemass = koeramass/koerCount;
		
		if(kassikeskminepikkus>koerakeskminepikkus){
			System.out.println("Kassid on keskmiselt kõrgemad kui koerad");
		}
		else if(kassikeskminepikkus==koerakeskminepikkus){
			System.out.println("Koerad on keskmiselt sama kõrged nagu kassid");
		}
		else{
			System.out.println("Koerad on keskmiselt kõrgemad kui kassid");
		}
	
		System.out.println("Koeri on: "+koerCount+" ja kasse on: "+kassCount);
		System.out.println("Koerte keskmine kaal: "+koerakeskminemass);
		System.out.println("Koerte keskmine pikkus: "+koerakeskminepikkus);
		System.out.println("Kasside keskmine kaal: "+kassikeskminemass);
		System.out.println("Kasside keskmine pikkus: "+kassikeskminepikkus);
		
		g.setColor(Color.GRAY);
		g.fillRect(kassikeskminemass/30,300-kassikeskminepikkus*2 ,5,5);
		g.setColor(Color.GREEN);
		g.fillRect(koerakeskminemass/30,300-koerakeskminepikkus*2 ,5,5);
		
        	g.setColor(Color.BLACK);
        	g.drawLine(10, 290, 290, 290);
        	g.drawLine(10, 180, 10, 290);
 
        	g.drawString("KAAL", 315, 290);
 
        	g.drawString("KÕRGUS", 10, 160);
		
		ImageIO.write(bi, "png", new File("loomad.png"));
    	}
}
