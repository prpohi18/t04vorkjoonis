import java.awt.image.*;
import javax.imageio.*;
import java.awt.*;
import java.net.*;
import java.io.*;

public class Joonis2{
	
	public static void main(String[] arg) throws Exception{
		
		BufferedImage bi=new BufferedImage(400,300, BufferedImage.TYPE_INT_RGB);
        Graphics g=bi.createGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 400, 300);
		g.setColor(Color.BLACK);
		g.drawString("Loomade massi ja kõrguse suhe", 110, 20);
		g.setColor(Color.BLUE);
		g.drawString("koerad", 110, 40);
		g.setColor(Color.PINK);
		g.drawString("kassid", 110, 60);
		g.setColor(Color.RED);
		g.drawString("keskmine", 170, 60);
		g.setColor(Color.GREEN);
		g.drawString("keskmine", 170, 40);
		
        String aadress="http://www.tlu.ee/~jaagup/veeb1/loomad.txt";
        BufferedReader br=new BufferedReader(new InputStreamReader(
        new URL(aadress).openStream()));
        String rida=br.readLine();
        rida=br.readLine();

		int kassimass = 0;
		int koeramass = 0;
		int kassipikkus = 0;
		int koerapikkus = 0;
		int i = 0;
		int j = 0;
		
        while(rida!=null){
            String[] m=rida.split(",");
            if(m[0].equals("kass")){
				g.setColor(Color.pink);
				kassimass = kassimass + Integer.parseInt(m[1]);
				kassipikkus = kassipikkus + Integer.parseInt(m[2]);
				i++;
			}
            else{
				g.setColor(Color.blue);
				koeramass = koeramass + Integer.parseInt(m[1]);
				koerapikkus = koerapikkus + Integer.parseInt(m[2]);
				j++;
			}
			
            g.fillRect(Integer.parseInt(m[1])/30,300-Integer.parseInt(m[2])*2,5,5);
            rida=br.readLine();
			
        }
	
		int kassikeskminepikkus = kassipikkus/i;
		int kassikeskminemass = kassimass/i;
		int koerakeskminepikkus = koerapikkus/j;
		int koerakeskminemass = koeramass/j;
		
		if(kassikeskminepikkus>koerakeskminepikkus){
			System.out.println("Kassid on keskmiselt kõrgemad kui koerad");
		}if(kassikeskminepikkus==koerakeskminepikkus){
			System.out.println("Koerad on keskmiselt sama kõrged nagu kassid");
		}else{
			System.out.println("Koerad on keskmiselt kõrgemad kui kassid");
		}
	
		System.out.println("Koeri on kokku "+j+" ja kasse on kokku "+i);
		System.out.println("Koerte keskmine mass: "+koerakeskminemass);
		System.out.println("Koerte keskmine pikkus: "+koerakeskminepikkus);
		System.out.println("Kasside keskmine mass: "+kassikeskminemass);
		System.out.println("Kasside keskmine pikkus: "+kassikeskminepikkus);
		
		g.setColor(Color.RED);
		g.fillRect(kassikeskminemass/30,300-kassikeskminepikkus*2 ,5,5);
		g.setColor(Color.GREEN);
		g.fillRect(koerakeskminemass/30,300-koerakeskminepikkus*2 ,5,5);
		
        g.setColor(Color.BLACK);
        g.drawLine(10, 290, 290, 290);
        g.drawLine(10, 180, 10, 290);
 
        g.drawString("Mass", 230, 290);
 
        g.drawString("Kõrgus", 10, 160);
		
		ImageIO.write(bi, "png", new File("loomad.png"));
    }
}