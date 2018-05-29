import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.net.*;
import java.io.*;
import javax.imageio.ImageIO;
        
public class Vorkjoonis {
    public static void main (String[] arg) throws Exception {
        BufferedImage bi = new BufferedImage(475, 475, BufferedImage.TYPE_INT_RGB);
        Graphics g = bi.createGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 475, 475);
        
        String aadress = "http://www.tlu.ee/~jaagup/veeb1/loomad.txt";
        BufferedReader br = new BufferedReader(new InputStreamReader(
                new URL(aadress).openStream()));
        
        String rida = br.readLine();
        rida = br.readLine();
            
        int kassideMassid = 0;
        int kassideKorgused = 0;
        int kassCounter = 0;
        int koerteMassid = 0;
        int koerteKorgused = 0;
        int koerCounter = 0;
            //KASSIDE MASSID NING KÕRGUSED
        while (rida != null) {
            String[] m = rida.split(",");
            if (m[0].equals("kass")) {
                kassideMassid += Integer.parseInt(m[1]);
                kassideKorgused += Integer.parseInt(m[2]);
                kassCounter++;
                g.setColor(Color.CYAN);
            } //KOERTE MASSID NING KÕRGUSED
            if (m[0].equals("koer")) {
                koerteMassid += Integer.parseInt(m[1]);
                koerteKorgused += Integer.parseInt(m[2]);
                koerCounter++;
                g.setColor(Color.PINK);
            }
            // KASSI JA KOERA MASSIDE NING KÕRGUSE SUHE
            g.fillOval(Integer.parseInt(m[1]) / 30 + 30, 400 - Integer.parseInt(m[2]) * 2 - 30, 8, 8);
            rida = br.readLine();
        }
        br.close();
        //KASSIDE KESKMINE
        g.setColor(Color.blue);
        g.fillOval((kassideMassid / kassCounter) / 30 + 30, 400 - (kassideKorgused / kassCounter) * 2 - 30, 9, 9);
        g.fillOval(50, 60, 9, 9);
        g.drawString("Kassid", 65, 69);
        //KOERTE KESKMINE
        g.setColor(Color.MAGENTA);
        g.fillOval((koerteMassid / koerCounter) / 30 + 30, 400 - (koerteKorgused / koerCounter) * 2 - 30, 9, 9);
        g.fillOval(50, 80, 9, 9);
        g.drawString("Koerad", 65, 89);
        //X TELG JA Y TELG 
        g.setColor(Color.RED);
        g.drawLine(30, 370, 440, 370);
        g.drawLine(30, 170, 30, 370);
        
        ImageIO.write(bi, "png", new File("animals.png"));
    }
}