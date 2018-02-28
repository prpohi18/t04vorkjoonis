
package ee.tlu.sergei.kodutoo4;
import java.awt.image.*;
import javax.imageio.*;
import java.awt.*;
import java.io.*;
import java.net.*;

public class Graph{
    public static void graph() throws Exception{
        BufferedImage bi = new BufferedImage(500, 400, BufferedImage.TYPE_INT_RGB);
        Graphics g = bi.createGraphics();
        g.setColor(Color.lightGray);
        g.fillRect(0, 0, 600, 450);
        String aadress = "http://www.tlu.ee/~jaagup/veeb1/loomad.txt";

        BufferedReader br = new BufferedReader(new InputStreamReader(new URL(aadress).openStream()));
        String rida = br.readLine();
        rida = br.readLine();
        int kassMass = 0;
        int koerMass = 0;
        int kassKorgus = 0;
        int koerKorgus = 0;
        int koerad = 0;
        int kassid = 0;
        int loomadeKeskMass = 0;
        while (rida != null) {
            String[] m = rida.split(",");
            if (m[0].equals("kass")){
                Loomad kass = new Loomad();
                kass.kassidListi(Integer.parseInt(m[1]), Integer.parseInt(m[2]));
                g.setColor(Color.GRAY);
                kassMass = kassMass + Integer.parseInt(m[1]);
                kassKorgus = kassKorgus + Integer.parseInt(m[2]);
                kassid++;
            } else {
                Loomad koer = new Loomad();
                koer.koeradListi(Integer.parseInt(m[1]), Integer.parseInt(m[2]));
				g.setColor(Color.RED);
				koerMass = koerMass + Integer.parseInt(m[1]);
				koerKorgus = koerKorgus +Integer.parseInt(m[2]);
				koerad++;
            }
            g.fillRect(Integer.parseInt(m[1]) / 30 + 25, 400-Integer.parseInt(m[2])*2 - 30, 7, 7);
            rida = br.readLine();
        }
        
            koerMass = koerMass / koerad;
            koerKorgus = koerKorgus / koerad;
            kassMass = kassMass / kassid;
            kassKorgus = kassKorgus / kassid;
            loomadeKeskMass = (koerMass + kassMass)/(koerad+kassid);
        
            g.setColor(Color.YELLOW);
            g.fillOval(kassMass / 30 + 25, 400-kassKorgus*2 - 30, 11, 11);
           
            g.setColor(Color.BLUE);
            g.fillOval(koerMass / 30 + 25, 400-koerKorgus*2 - 30, 11, 11);
            

        g.setFont(new Font("Serif", Font.BOLD, 12));
        g.setColor(Color.YELLOW);
        g.fillOval(17, 30, 10, 10);
        g.setColor(Color.BLUE);
        g.fillOval(17, 50, 10, 10);
        g.setColor(Color.BLACK);
        g.drawString("Kasside keskmine mass " + kassMass + ", kõrgus " + kassKorgus, 30, 35);
        g.drawString("Koerte keskmine mass " + koerMass + ", kõrgus " + koerKorgus, 30, 55);

        g.setColor(Color.BLACK);
        g.drawLine(30, 370, 440, 370);
        g.drawLine(30, 170, 30, 370);
        g.setFont(new Font("Serif", Font.BOLD, 12));
        g.drawString("Mass", 230, 390);
        g.drawString("12000", 445, 375);
        g.drawString("Kõrgus", 20, 140);
        g.drawString("100", 20, 160);
        
		/*System.out.println("Koerte keskmine mass " + koeradmass);
		System.out.println("Koerte keskmine kõrgus " + koeradkorgus);
		System.out.println("Kasside keskmine mass " + kassidmass);
        System.out.println("Kasside keskmine kõrgus " + kassidkorgus);*/
        
        ImageIO.write(bi, "png", new File("loomad.png"));
    }
}