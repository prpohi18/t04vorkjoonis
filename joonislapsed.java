import java.awt.image.*;
import javax.imageio.*;
import java.awt.*;
import java.io.*;
import java.net.*;

public class joonislapsed{
    public static void graph() throws Exception{
        BufferedImage bi = new BufferedImage(400, 300, BufferedImage.TYPE_INT_RGB);
        Graphics g = bi.createGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 400, 300);
        String aadress = "http://www.tlu.ee/~jaagup/andmed/muu/5klass.txt";

        BufferedReader br = new BufferedReader(new InputStreamReader(new URL(aadress).openStream()));
        String rida = br.readLine();
		int poisidpikkused=0;
		int tüdrukudpikkused=0;
		int poisidmassid = 0;
		int tüdrukudmassid = 0;
		int poisid=0;
		int tüdrukud=0;
		while (rida != null) {
            String[] m = rida.split(",");
			if (m[3].equals("m")){
				arvuhoidmine poiss = new arvuhoidmine();
				poiss.poisidList(Integer.parseInt(m[1]), Integer.parseInt(m[2]));
				g.setColor(Color.GRAY);
				poisidmassid = poisidmassid + Integer.parseInt(m[2]);
				poisidpikkused = poisidpikkused + Integer.parseInt(m[1]);
				poisid++;
			} else {
				arvuhoidmine tüdruk = new arvuhoidmine();
				tüdruk.tüdrukudList(Integer.parseInt(m[1]), Integer.parseInt(m[2]));
				g.setColor(Color.RED);
				tüdrukudmassid = tüdrukudmassid + Integer.parseInt(m[2]);
				tüdrukudpikkused = tüdrukudpikkused +Integer.parseInt(m[1]);
				tüdrukud++;
			}
            g.fillRect(Integer.parseInt(m[1]) / 30 + 25, 400-Integer.parseInt(m[2])*2 - 30, 7, 7);
            rida = br.readLine();
		}
		poisidmassid = poisidmassid / poisid;
		poisidpikkused = poisidpikkused / poisid;
		tüdrukudmassid = tüdrukudmassid / tüdrukud;
        tüdrukudmassid = tüdrukudmassid / tüdrukud;
        
		g.setColor(Color.BLUE);
		g.fillOval(tüdrukudmassid / 30 + 25, 400-tüdrukudpikkused*2 - 30, 11, 11);
		g.setColor(Color.GREEN);
		g.fillOval(poisidmassid / 30 + 25, 400-poisidpikkused*2 - 30, 11, 11);

        g.setFont(new Font("Arial", Font.BOLD, 14));
        g.setColor(Color.BLUE);
        g.fillOval(15, 28, 8, 8);
        g.setColor(Color.GREEN);
        g.fillOval(15, 47, 8, 8);
        g.setColor(Color.BLACK);
        g.drawString("Tüdrukute keskmine kaal " + tüdrukudmassid + ", ja pikkus " + tüdrukudpikkused, 30, 35);
        g.drawString("Poiste keskmine kaal " + poisidmassid + ", ja pikkus " + poisidpikkused, 30, 55);

        g.setColor(Color.BLACK);
        g.drawLine(30, 370, 440, 370);
        g.drawLine(30, 170, 30, 370);
        g.setFont(new Font("Arial", Font.BOLD, 16));
        g.drawString("Kaal", 230, 390);
        g.drawString("12000", 445, 375);
        g.drawString("Pikkus", 20, 140);
        g.drawString("100", 20, 160);
		
        ImageIO.write(bi, "png", new File("lapsed.png"));
    }
}