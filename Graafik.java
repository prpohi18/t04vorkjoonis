import java.awt.image.*;
import javax.imageio.*;
import java.awt.*;
import java.io.*;
import java.net.*;

public class Graafik{
    public static void graph() throws Exception{
        BufferedImage bi = new BufferedImage(500, 400, BufferedImage.TYPE_INT_RGB);
        Graphics g = bi.createGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 500, 400);
        String aadress = "http://www.tlu.ee/~jaagup/veeb1/loomad.txt";

        BufferedReader br = new BufferedReader(new InputStreamReader(
            new URL(aadress).openStream()));
        String rida = br.readLine();
        rida = br.readLine();
        int kassidmass = 0;
        int koeradmass = 0;
        int kassidkorgus = 0;
		int koeradkorgus = 0;
		int koerad = 0;
		int kassid = 0;
        while (rida != null) {
            String[] m = rida.split(",");
            if (m[0].equals("kass")){
                Arvud kass = new Arvud();
                kass.kassidListi(Integer.parseInt(m[1]), Integer.parseInt(m[2]));
                g.setColor(Color.GRAY);
                kassidmass = kassidmass + Integer.parseInt(m[1]);
				kassidkorgus = kassidkorgus + Integer.parseInt(m[2]);
				kassid++;
            } else {
                Arvud koer = new Arvud();
                koer.koeradListi(Integer.parseInt(m[1]), Integer.parseInt(m[2]));
				g.setColor(Color.RED);
				koeradmass = koeradmass + Integer.parseInt(m[1]);
				koeradkorgus = koeradkorgus +Integer.parseInt(m[2]);
				koerad++;
            }
            g.fillRect(Integer.parseInt(m[1]) / 30 + 25, 400-Integer.parseInt(m[2])*2 - 30, 7, 7);
            rida = br.readLine();
        }
        
		koeradmass = koeradmass / koerad;
		koeradkorgus = koeradkorgus / koerad;
		kassidmass = kassidmass / kassid;
        kassidkorgus = kassidkorgus / kassid;
        
		g.setColor(Color.BLUE);
		g.fillOval(kassidmass / 30 + 25, 400-kassidkorgus*2 - 30, 11, 11);
		//System.out.println("Sinine punkt joonisel on kasside keskmine mass.");
		g.setColor(Color.GREEN);
		g.fillOval(koeradmass / 30 + 25, 400-koeradkorgus*2 - 30, 11, 11);
        //System.out.println("Roheline punkt joonisel on koerte keskmine mass.");

        g.setFont(new Font("Arial", Font.BOLD, 14));
        g.setColor(Color.BLUE);
        g.fillOval(15, 28, 8, 8);
        g.setColor(Color.GREEN);
        g.fillOval(15, 47, 8, 8);
        g.setColor(Color.BLACK);
        g.drawString("Kasside keskmine mass " + kassidmass + ", kõrgus " + kassidkorgus, 30, 35);
        g.drawString("Koerte keskmine mass " + koeradmass + ", kõrgus " + koeradkorgus, 30, 55);

        g.setColor(Color.BLACK);
        g.drawLine(30, 370, 440, 370);
        g.drawLine(30, 170, 30, 370);
        g.setFont(new Font("Arial", Font.BOLD, 16));
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