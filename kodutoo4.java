

// pilt
import java.awt.image.*; 
import javax.imageio.*;
import java.awt.*; 
import java.io.*;  
import java.net.*;
import java.util.Arrays;
import java.util.*;

public class kodutoo4{
	public static void main(String[] arg) throws Exception{
		BufferedImage bi=new BufferedImage(400,300, BufferedImage.TYPE_INT_RGB);
		Graphics g=bi.createGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(0,0,400,300); 
		
		String aadress="http://www.tlu.ee/~k2di/pictures/loomad.txt"; 
		BufferedReader br=new BufferedReader(new InputStreamReader(new URL(aadress).openStream())); 
		String rida=br.readLine(); //1. on pealkirja rida
		
		if(!rida.startsWith("liik")){
			System.out.println("sobiva pealkirjata fail");
			return;
		}
		rida=br.readLine();
		int kassidemassidkokku=0;
		int koertemassidkokku=0;
		int hiirtemassidkokku=0;
		int kassidekorgused=0;
		int koertekorgused=0;
		int hiirtekorguse=0;
		int kasskeskmine=0;
		int koerkeskmine=0;
		int hiirkeskmine=0;
		int kasskeskminek=0;
		int koerkeskminek=0;
		int hiirkeskminek=0;
		while(rida!=null){
			System.out.println(rida);
			String[] m=rida.split(",");
			if(m[0].equals("kass")){g.setColor(Color.gray);
				kassidemassidkokku+=Integer.parseInt(m[1]);
				kassidekorgused+=Integer.parseInt(m[2]);
				kasskeskmine=kassidemassidkokku/6;
				kasskeskminek=kassidekorgused/6;}
			if(m[0].equals("hiir")){g.setColor(Color.green);
				hiirtemassidkokku+=Integer.parseInt(m[1]);
				hiirtekorguse+=Integer.parseInt(m[2]);
				hiirkeskmine=hiirtemassidkokku/4;
				hiirkeskminek=hiirtekorguse/4;}
			if(m[0].equals("koer")){g.setColor(Color.red);
				koertemassidkokku+=Integer.parseInt(m[1]);
				koertekorgused+=Integer.parseInt(m[2]);
				koerkeskmine=koertemassidkokku/7;
				koerkeskminek=koertekorgused/7;}
				
			
			g.fillRect(Integer.parseInt(m[1])/30,300-Integer.parseInt(m[2])*2,5,5);
			rida=br.readLine();
		}
		g.setColor(Color.GREEN);
		g.drawLine(10,30,10,10);
		g.drawString("HIIRED     KESKMINE KAAL(g)/KÕRGUS(cm): "+hiirkeskmine+"/"+hiirkeskminek,15,25);
		g.setColor(Color.GRAY); 
		g.drawLine(10,60,10,40);
		g.drawString("KASSID     KESKMINE KAAL(g)/KÕRGUS(cm): "+kasskeskmine+"/"+kasskeskminek,15,55);
		g.setColor(Color.RED); 
		g.drawLine(10,90,10,70);
		g.drawString("KOERAD     KESKMINE KAAL(g)/KÕRGUS(cm): "+koerkeskmine+"/"+koerkeskminek,15,85);
		
		
		ImageIO.write(bi, "png", new File ("loomad.png"));
		
	}
}