import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class loomad{
	public static void main(String[] arg) throws Exception{
		String aadress="http://www.tlu.ee/~jaagup/veeb1/loomad.txt";
		BufferedReader br=new BufferedReader(new InputStreamReader(new URL(aadress).openStream()));
		String rida=br.readLine();
		
		BufferedImage bi=new BufferedImage(400, 300, BufferedImage.TYPE_INT_RGB);
		Graphics g=bi.createGraphics();
		g.setColor(Color.YELLOW);
		g.fillRect(0, 0, 400, 300);
		
		int koerteMassideSumma=0;
		int kassideMassideSumma=0;
		int koerteKorgusteSumma=0;
		int kassideKorgusteSumma=0;
		int keskmineKoerteMass=0;
		int keskmineKassideMass=0;
		int keskmineKoerteKorgus=0;
		int keskmineKassideKorgus=0;
		int nr=0;
		int koerteNr=0;
		int kassideNr=0;
		
		while(rida!=null){
			System.out.println(rida);
			nr+=20;
			String[] r=rida.split(",");
		
			if(r[0].equals("koer")){g.setColor(Color.BLUE);
				koerteNr+=1;
				koerteMassideSumma+=Integer.parseInt(r[1]);	
				koerteKorgusteSumma+=Integer.parseInt(r[2]);
				keskmineKoerteKorgus=koerteKorgusteSumma/koerteNr;
				keskmineKoerteMass=koerteMassideSumma/koerteNr;
				g.drawString("Koera mass(g): " +Integer.parseInt(r[1])+ "kõrgus: "+Integer.parseInt(r[2]), 15, nr);
			}
			
			if(r[0].equals("kass")){g.setColor(Color.RED);
				kassideNr+=1;
				kassideMassideSumma+=Integer.parseInt(r[1]);	
				kassideKorgusteSumma+=Integer.parseInt(r[2]);
				keskmineKassideKorgus=kassideKorgusteSumma/kassideNr;
				keskmineKassideMass=kassideMassideSumma/kassideNr;
				g.drawString("Kassi mass(g): " +Integer.parseInt(r[1])+ " kõrgus(cm): "+Integer.parseInt(r[2]), 15, nr);
			}
			rida=br.readLine();
		}
		g.setColor(Color.BLUE);
		g.drawString("Koerad        Keskmine mass: "+keskmineKoerteMass+" Keskmine korgus :"+keskmineKoerteKorgus, 15, 10);
		g.setColor(Color.RED);
		g.drawString("Kassid        Keskmine mass: "+keskmineKassideMass+" Keskmine korgus :"+keskmineKassideKorgus, 15, 25);
		ImageIO.write(bi, "png", new File("loomad.png"));
	}
}