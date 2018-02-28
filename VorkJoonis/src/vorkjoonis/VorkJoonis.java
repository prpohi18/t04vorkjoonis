package vorkjoonis;

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.awt.image.*;
import java.io.File;
import javax.imageio.*;

public class VorkJoonis extends JPanel {

    void joonistaLoomad(Graphics g) {
        try {
            System.out.println("vorkjoonis.VorkJoonis.joonistaLoomad()");
            String aadress = "http://www.tlu.ee/~jaagup/veeb1/loomad.txt";
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    new URL(aadress).openStream()
            ));
            String rida = br.readLine();
            System.out.println("Tulbad: " + rida);
            rida = br.readLine();
            int koef = 100;
            while (rida != null) {
                String[] m = rida.split(",");
                if (m[0].equals("kass")) {
                    System.out.println(Integer.parseInt(m[1]));
                    g.setColor(Color.BLUE);
                    g.fillOval(Integer.parseInt(m[1])/koef, getHeight()- Integer.parseInt(m[2]), 5, 5);
                } else {
                    g.setColor(Color.RED);
                    g.fillOval(Integer.parseInt(m[1])/koef, getHeight()- Integer.parseInt(m[2]), 5, 5);
                }
                rida = br.readLine();
            }
            br.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    void ounteJoonisFaili(){
       try{
         BufferedImage bi=new BufferedImage(400, 300, BufferedImage.TYPE_INT_RGB);
         Graphics g=bi.createGraphics();
         g.setColor(Color.YELLOW);
         g.fillRect(0, 0, 400, 300);
         g.setColor(Color.RED);
         joonistaLoomad(g);
         ImageIO.write(bi, "png", new File("C:\\Users\\Taavi Meinberg\\Documents\\loomad1.png"));
       }catch(Exception ex){ex.printStackTrace();}
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        joonistaLoomad(g);
        ounteJoonisFaili();
    }

    public static void main(String[] args) {
        Kass kass1 = new Kass(1200, 28);
        Kass kass2 = new Kass(1500, 24);
        Kass kass3 = new Kass(1700, 25);

        Koer koer1 = new Koer(1600, 35);
        Koer koer2 = new Koer(2400, 48);

        ArrayList<Koer> koerad = new ArrayList<Koer>();
        ArrayList<Kass> kassid = new ArrayList<Kass>();

        int kassideMassideSumma = 0;
        int koerteMassideSumma = 0;

        koerad.add(koer1);
        koerad.add(koer2);

        kassid.add(kass1);
        kassid.add(kass2);
        kassid.add(kass3);

        for (Kass kass : kassid) {
            kassideMassideSumma += kass.getMass();
        }

        for (Koer koer : koerad) {
            koerteMassideSumma += koer.getMass();
        }

        System.out.println("Kasside masside summa on: " + kassideMassideSumma);
        System.out.println("Koerte masside summa on: " + koerteMassideSumma);
        
        JFrame f = new JFrame("Kassid ja koerad");
        f.getContentPane().add(new VorkJoonis());
        f.setSize(400, 300);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
