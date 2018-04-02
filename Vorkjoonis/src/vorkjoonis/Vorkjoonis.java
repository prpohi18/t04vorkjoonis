package vorkjoonis;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URL;
import javax.imageio.ImageIO;

public class Vorkjoonis {
    public static void main(String[] args) throws Exception {
        BufferedImage bi = new BufferedImage(300, 300, BufferedImage.TYPE_INT_RGB);
        Graphics g = bi.createGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 300, 300);
        String aadress = "http://www.tlu.ee/~jaagup/veeb1/pikkused.txt";
        try (BufferedReader br = new BufferedReader (new InputStreamReader(new URL(aadress).openStream()))) {
            String rida = br.readLine();
            
            int count = 0;
            int summa = 0;
            int max = 0;
            int min = 10000;
            double keskmine = 0;
            double halve_rida = 0;
            double halve_kokku = 0;
            double halve = 0;
            
            //reanumbrid
            while (rida != null) {
                count += 1;
                if (Integer.parseInt(rida)>max) {
                    max = Integer.parseInt(rida);
                }
                if (Integer.parseInt(rida)<min) {
                    min = Integer.parseInt(rida);
                }
                summa += Integer.parseInt(rida);
                rida = br.readLine();
            }
            
            keskmine = summa*1.0/count;
            
            BufferedReader bn = new BufferedReader(new InputStreamReader(new URL(aadress).openStream()));
            String Rida = bn.readLine();
            
            while (Rida != null) {
                halve_rida = (Integer.parseInt(Rida)-keskmine)*(Integer.parseInt(Rida)-keskmine);
                halve_kokku += halve_rida;
                Rida = bn.readLine();
            }
            
            halve = Math.sqrt((halve_kokku)/(count-1));
            
            //pikkuste lisamine
            g.setColor(Color.WHITE);
            g.drawLine(30, 300, 30, 135);
            g.drawLine(45, 300, 45, 137);
            g.drawLine(60, 300, 60, 129);
            g.drawLine(75, 300, 75, 135);
            g.drawLine(90, 300, 90, 122);
            g.drawLine(105, 300, 105, 135);
            g.drawLine(120, 300, 120, 137);
            g.drawLine(135, 300, 135, 129);
            g.drawLine(150, 300, 150, 119);
            g.drawLine(165, 300, 165, 135);
            g.drawLine(180, 300, 180, 117);
            g.drawLine(195, 300, 195, 128);
            g.drawLine(210, 300, 210, 141);
            g.drawLine(225, 300, 225, 137);
            g.drawLine(240, 300, 240, 133);
            g.drawLine(255, 300, 255, 137);
            
            
            //aritmeetiline keskmine
            g.setColor(Color.CYAN);
            g.drawLine(0, 131, 300, 131);
            
            //uhe halve kaugus
            g.setColor(Color.MAGENTA);
            g.drawLine(0, 122, 300, 122);
            g.drawLine(0, 138, 300, 138);
            
            //kahe halve kaugus
            g.setColor(Color.YELLOW);
            g.drawLine(0, 114, 300, 114);
            g.drawLine(0, 146, 300, 146);
            
            //tulemuste valjastamine
            System.out.println("Aritmeetiline keskmine on " + keskmine);
            System.out.println("Maksimum on " + max);
            System.out.println("Miinimum on " + min);
            System.out.println("H2lve on " + halve);
        }
        
        ImageIO.write(bi, "png", new File("graafik.png"));
    }
    
}

/*
Aritmeetiline keskmine on 169.9375
Maksimum on 187
Miinimum on 159
H2lve on 8.34640641234298
BUILD SUCCESSFUL (total time: 0 seconds)
*/
