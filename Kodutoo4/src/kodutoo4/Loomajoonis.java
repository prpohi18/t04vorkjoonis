package kodutoo4;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URL;
import javax.imageio.ImageIO;

public class Loomajoonis {
    public static void main (String[] args) throws Exception {
        BufferedImage bi = new BufferedImage(300, 300, BufferedImage.TYPE_INT_RGB);
        Graphics g = bi.createGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 300, 300);
        String aadress = "http://www.tlu.ee/~jaagup/veeb1/loomad.txt";
        try (BufferedReader br = new BufferedReader (new InputStreamReader (new URL(aadress).openStream()))) {
            br.readLine();
            String rida = br.readLine();
            
            int kassi_massi_summa = 0;
            int koerte_massi_summa = 0;
            int count = 20;
            
            while (rida != null) {
                g.setColor(Color.black);
                g.drawLine(1, 0, 1, 350);
                g.drawLine(2, 299, 390, 299);
                g.drawString("Kaal", 5, 15);
                g.drawString("Kõrgus", 261, 295);
                System.out.println(rida);
                
                String[] m = rida.split(",");
                int korgus = Integer.parseInt(m[2]);
                int kaal = Integer.parseInt(m[1]);
                if (m[0].equals("kass")) {
                    g.setColor(Color.red);
                    g.drawLine(count, kaal*2, count, 300-korgus);
                    count += 20;
                } else {
                    g.setColor(Color.blue);
                    g.drawLine(count, 300, count, 300-korgus);
                    count += 20;
                }

                rida = br.readLine();
            }
        }
        ImageIO.write(bi, "png", new File("graafik.png"));
    }
}

