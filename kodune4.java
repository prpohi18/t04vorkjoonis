
import java.awt.image.*;
import javax.imageio.*;
import java.awt.*;
import java.net.*;
import java.io.*;

public class kodune4 {
   
    public static void main(String[] arg) throws Exception {

        String aadress = "http://www.tlu.ee/~jaagup/veeb1/loomad.txt";
        
        BufferedReader br = new BufferedReader(new InputStreamReader(new URL(aadress).openStream()));
        
        String rida = br.readLine();

        if(!rida.startsWith("liik")) {
            System.out.println("Error: Ei ole õige fail.");
            return;
        }

        rida = br.readLine();
        
        String[] suurused = rida.split(",");

        int suurimmass = Integer.parseInt(suurused[1]);
        int vaikseimmass = Integer.parseInt(suurused[1]);
        int suurimkorgus = Integer.parseInt(suurused[2]);
        int vaikseimkorgus = Integer.parseInt(suurused[2]);
        
        int kassidemassidesumma = 0;
        int koertemassidesumma = 0;
		int kassidekorgustesumma = 0;
		int koertekorgustesumma = 0;
		
		int kassidekeskminemass = 0;
		int kassidekeskminekorgus = 0;
		int koertekeskminemass = 0;
		int koertekeskminekorgus = 0;
		
		int kassekokku = 0;
		int koerikokku = 0;

        while(rida != null) {
            String[] m = rida.split(",");

            if(m[0].equals("kass")) {
                kassidemassidesumma += Integer.parseInt(m[1]);
				kassidekorgustesumma += Integer.parseInt(m[2]);
				kassekokku += 1;
            } else if (m[0].equals("koer")) {
                koertemassidesumma += Integer.parseInt(m[1]);
				koertekorgustesumma += Integer.parseInt(m[2]);
				koerikokku += 1;
            }
            if (Integer.parseInt(m[1]) > suurimmass) {
                suurimmass = Integer.parseInt(m[1]);
            } else if (Integer.parseInt(m[1]) < vaikseimmass) {
                vaikseimmass = Integer.parseInt(m[1]);
            }
            if (Integer.parseInt(m[2]) > suurimkorgus) {
                suurimkorgus = Integer.parseInt(m[2]);
            } else if (Integer.parseInt(m[2]) < vaikseimkorgus) {
                vaikseimkorgus = Integer.parseInt(m[2]);
            }
            rida = br.readLine();
        }
		kassidekeskminemass = kassidemassidesumma / kassekokku;
		kassidekeskminekorgus = kassidekorgustesumma / kassekokku;
		koertekeskminemass = koertemassidesumma / koerikokku;
		koertekeskminekorgus = koertekorgustesumma / koerikokku;
        
        br.close();

        PrintWriter pw = new PrintWriter(new FileWriter("vastus.txt"));

        pw.println("Kasside kogumass: " + kassidemassidesumma);
        pw.println("Koerte kogumass: " + koertemassidesumma);
        pw.println("Maksimum mass: " + suurimmass);
        pw.println("Miinimum mass: " + vaikseimmass);
        pw.println("Kõrgeim: " + suurimkorgus);
        pw.println("Madalaim: " + vaikseimkorgus);
		pw.println("Kasside keskmine mass: " + kassidekeskminemass);
        pw.println("Koerte keskmine mass: " + koertekeskminemass);
		pw.println("Kasside keskmine kõrgus: " + kassidekeskminekorgus);
        pw.println("Koerte keskmine kõrgus: " + koertekeskminekorgus);

        if (kassidemassidesumma > koertemassidesumma) {
            pw.println("Kasside masside summa on suurem.");
        } else if (koertemassidesumma > kassidemassidesumma) {
            pw.println("Koerte masside summa on suurem.");
        } else {
            pw.println("Masside summad on võrdsed.");
        }

        pw.close();

        BufferedImage bi = new BufferedImage(575, 575, BufferedImage.TYPE_INT_RGB);
        Graphics g = bi.createGraphics();

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 575, 575);

        g.setColor(Color.GRAY);

        g.drawLine(50, 300, 50, 525);
        g.drawString("Kõrgus", 45, 275);

        g.drawLine(50, 525, 475, 525);
        g.drawString("Mass", 500, 565);

        g.drawString(Integer.toString(suurimkorgus), 10, 300);
        g.drawString(Integer.toString(vaikseimkorgus), 10, 530);
        g.drawString(Integer.toString(suurimmass), 450, 550);
        g.drawString(Integer.toString(vaikseimmass), 40, 550);

        g.drawString("Koerad", 230, 60);
        g.drawString("Kassid", 330, 60);
		g.drawString("Koerte keskmine", 230, 90);
        g.drawString("Kasside keskmine", 230, 120);
		
        g.setColor(Color.RED);
        g.fillRect(215, 50, 7, 7);
        g.setColor(Color.BLUE);
        g.fillRect(315, 50, 7, 7);
		
        g.setColor(Color.GREEN);
        g.fillOval(215, 80, 10, 10);
        g.setColor(Color.YELLOW);
        g.fillOval(215, 110, 10, 10);
		
		g.setColor(Color.GREEN);
		g.fillOval((kassidekeskminemass/30)+50, 500-kassidekeskminekorgus*2, 10, 10);

		g.setColor(Color.YELLOW);
		g.fillOval((koertekeskminemass/30)+50, 500-koertekeskminekorgus*2, 10, 10);

        BufferedReader br2 = new BufferedReader(new InputStreamReader(new URL(aadress).openStream()));

        rida = br2.readLine();
        rida = br2.readLine();
        
        while(rida != null) {
            String[] m = rida.split(",");
            
            if(m[0].equals("kass")) {
                g.setColor(Color.BLUE);
            } else if (m[0].equals("koer")) {
                g.setColor(Color.RED);
            }

            g.fillRect((Integer.parseInt(m[1])/30)+50,500-Integer.parseInt(m[2])*2,5,5);

            rida = br2.readLine();
        }
        
        br2.close();

        ImageIO.write(bi, "png", new File("joonis.png"));
    }
} 