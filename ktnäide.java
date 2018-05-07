import java.awt.*;
import java.net.*;
import java.io.*;
import java.awt.image.*;
import javax.imageio.*;

public class ktnäide{
	public static void main(String[] arg) throws Exception{
		String aadress = "http://www.tlu.ee/~jaagup/veeb1/loomad.txt";//Veebist andmete k2tte saamine

		//Hunniku muutujate defineerimine
		int maxMass = 0;
		int minMass = 0;
		int maxKorgus = 0;
		int minKorgus = 0;
		int kassMassSumma = 0;
		int koerMassSumma = 0;
		int kassKorgusSumma = 0;
		int koerKorgusSumma = 0;
		int koerKeskKorgus = 0;
		int kassKeskKorgus = 0;
		int koerKeskMass = 0;
		int kassKeskMass = 0;
		int kasseKokku = 0;
		int koeriKokku = 0;
		
		BufferedReader br=new BufferedReader(new InputStreamReader(new URL(aadress).openStream()));
		String rida = br.readLine();
		rida = br.readLine();
		
		String[] tulbad = rida.split(",");//Kui on koma, siis teeb slipti, et andmed eraldada(kass/koer, mass ja korgus)
		maxMass = Integer.parseInt(tulbad[1]);
		minMass = Integer.parseInt(tulbad[1]);
		maxKorgus = Integer.parseInt(tulbad[2]);
		minKorgus = Integer.parseInt(tulbad[2]);
		
		while(rida != null){//Teeb nii kaua kuni ühtegi andmetulpa enam ei ole, ehk siis lõpetab kui andmed otsa saavad ja tühi rida tuleb
			String[] m = rida.split(",");
			if(m[0].equals ("kass")){//Kui on tegemist kassiga
				kassKorgusSumma += Integer.parseInt(m[2]);
				kassMassSumma += Integer.parseInt(m[1]);
				kasseKokku += 1;
			}else if(m[0].equals ("koer")){//Kui on tegemist koeraga
				koerKorgusSumma += Integer.parseInt(m[2]);
				koerMassSumma += Integer.parseInt(m[1]);
				koeriKokku += 1;
			}
			if(Integer.parseInt(m[1])>maxMass){	//suurimate ja v2himate v22rtuste leidmine
				maxMass = Integer.parseInt(m[1]);
			}else if(Integer.parseInt(m[1]) < minMass){
				minMass = Integer.parseInt(m[1]);
			}
			if(Integer.parseInt(m[2])>maxKorgus){	
				maxKorgus = Integer.parseInt(m[2]);
			}else if(Integer.parseInt(m[2]) < minKorgus){
				minKorgus = Integer.parseInt(m[2]);
			}
			rida = br.readLine();
		}
		//Lihtne keskmiste suuruste arvutamine
		kassKeskMass = kassMassSumma / kasseKokku;
		koerKeskMass = koerMassSumma / koeriKokku;
		kassKeskKorgus = kassKorgusSumma / kasseKokku;
		koerKeskKorgus = koerKorgusSumma / koeriKokku;
		
		br.close();
		
		System.out.println(kassKeskMass);
		System.out.println(minMass);
		System.out.println(maxMass);
		System.out.println(minKorgus);
		System.out.println(maxKorgus);
		System.out.println(kassKeskKorgus);
		System.out.println(koerKeskMass);
		System.out.println(koerKeskKorgus);
		
		
		
		BufferedImage bi = new BufferedImage(575, 575, BufferedImage.TYPE_INT_RGB);
        Graphics g = bi.createGraphics();

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 575, 575);

   
        g.setColor(Color.BLUE);
        g.fillOval(((kassKeskMass-minMass) * 500 / (maxMass-minMass))+45,
                   500-(kassKeskKorgus-minKorgus) * 500 / (maxKorgus-minKorgus)+45,
                   12,
                   12);
        g.drawString("Kassid", 200, 30);

        g.setColor(Color.RED);
        g.fillOval(((koerKeskMass-minMass) * 500 / (maxMass-minMass))-5+50,
                500-(koerKeskKorgus-minKorgus) * 500 / (maxKorgus-minKorgus)-5+25,
                12,
                12);
        g.drawString("Koerad", 400, 30);

        g.setColor(Color.BLACK);
        g.drawLine(50, 25, 50, 525);
        g.drawString("Kõrgus", 5, 305);

        g.drawLine(50, 525, 550, 525);
        g.drawString("Mass", 300, 540);   
        
        g.drawString(Integer.toString(maxKorgus), 20, 30);
        g.drawString(Integer.toString(minKorgus), 30, 520);
        g.drawString(Integer.toString(maxMass), 530, 540);
        g.drawString(Integer.toString(minMass), 55, 540);
		
		ImageIO.write(bi, "png", new File("tulemused.png"));
		/*Hakkan tegema joonist
		
		BufferedImage bi = new BufferedImage(700, 700, BufferedImage.TYPE_INT_RGB);
		Graphics g = bi.createGraphics();
		
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 700, 700);
		
		g.setColor(Color.BLUE);
        g.fillOval((50+(int)kassKeskMass/10), ((600-(int)kassKeskKorgus))/10), 5, 5);
        g.drawString("Kassid", 200, 30);
		
		g.setColor(Color.RED);
		g.fillOval((50+(int)koerKeskMass)/10, 600-(600-(int)koerKeskKorgus)/10, 5, 5);
        g.drawString("Koerad", 400, 30);
		
		//teljed
		g.setColor(Color.BLACK);
        g.drawLine(50, 50, 50, 600);
        g.drawString("Kõrgus", 5, 300);
        g.drawLine(50, 600, 600, 600);
        g.drawString("Mass", 300, 620);
		
		ImageIO.write(bi, "png", new File("tulemused.png"));
		*/
		
		
	}
}