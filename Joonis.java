import java.awt.image.*;
import javax.imageio.*;
import java.awt.*;
import java.net.*;
import java.io.*;

public class Joonis{
    public static void main(String[] arg) throws Exception{

        String source = "http://www.tlu.ee/~jaagup/veeb1/loomad.txt";

        int suurimMass= 0;
        int vaikseimMass= 0;
    
        int suurimKorgus= 0;
        int vaikseimKorgus= 0;
        
        int kassiKorgusteSumma= 0;
        int koeraKorgusteSumma= 0;
    
        int kassiMassideSumma= 0;
        int koeraMassideSumma= 0;
    
        int kassideKeskmineKorgus= 0;
        int koerteKeskmineKorgus= 0;
    
        int kassideKeskmineMass= 0;
        int koerteKeskmineMass= 0;
    
        int koerteKogus= 0;
        int kassideKogus= 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(new URL(source).openStream()));

        String rida = br.readLine();

        if(!rida.startsWith("liik")){
            System.out.println("sobiva pealkirjata fail");
            return;
        }

        rida = br.readLine();

        String[] osad = rida.split(",");

        vaikseimMass = Integer.parseInt(osad[1]);
        suurimMass = Integer.parseInt(osad[1]);
        vaikseimKorgus = Integer.parseInt(osad[2]);
        suurimKorgus = Integer.parseInt(osad[2]);

        while(rida != null){
            String[] m = rida.split(",");

            if(m[0].equals("kass")){
                kassiMassideSumma += Integer.parseInt(m[1]);
                kassiKorgusteSumma += Integer.parseInt(m[2]);
                kassideKogus += 1;
            } else if(m[0].equals("koer")) {
                koeraMassideSumma += Integer.parseInt(m[1]);
                koeraKorgusteSumma += Integer.parseInt(m[2]);
                koerteKogus += 1;
            }

            if (Integer.parseInt(m[1]) > suurimMass) {
                suurimMass = Integer.parseInt(m[1]);
            } else if (Integer.parseInt(m[1]) < vaikseimMass) {
                vaikseimMass = Integer.parseInt(m[1]);
            }

            if (Integer.parseInt(m[2]) > suurimKorgus) {
                suurimKorgus = Integer.parseInt(m[2]);
            } else if (Integer.parseInt(m[2]) < vaikseimKorgus) {
                vaikseimKorgus = Integer.parseInt(m[2]);
            }
            rida = br.readLine();
        }

        //Keskmised
        kassideKeskmineMass = kassiMassideSumma / kassideKogus;
        kassideKeskmineKorgus = kassiKorgusteSumma / kassideKogus;

        koerteKeskmineMass = koeraMassideSumma / koerteKogus;
        koerteKeskmineKorgus = koeraKorgusteSumma / koerteKogus;

        br.close();

        BufferedImage bi = new BufferedImage(575, 575, BufferedImage.TYPE_INT_RGB);
        Graphics g = bi.createGraphics();

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 575, 575);

   
        g.setColor(Color.BLUE);
        g.fillOval(((kassideKeskmineMass-vaikseimMass) * 500 / (suurimMass-vaikseimMass))-5+50,
                   500-(kassideKeskmineKorgus-vaikseimKorgus) * 500 / (suurimKorgus-vaikseimKorgus)-5+25,
                   12,
                   12);
        g.drawString("Kassid", 200, 30);

        g.setColor(Color.RED);
        g.fillOval(((koerteKeskmineMass-vaikseimMass) * 500 / (suurimMass-vaikseimMass))-5+50,
                500-(koerteKeskmineKorgus-vaikseimKorgus) * 500 / (suurimKorgus-vaikseimKorgus)-5+25,
                12,
                12);
        g.drawString("Koerad", 400, 30);

        g.setColor(Color.BLACK);
        g.drawLine(50, 25, 50, 525);
        g.drawString("Kõrgus", 5, 305);

        g.drawLine(50, 525, 550, 525);
        g.drawString("Mass", 300, 540);   
        
        g.drawString(Integer.toString(suurimKorgus), 20, 30);
        g.drawString(Integer.toString(vaikseimKorgus), 30, 520);
        g.drawString(Integer.toString(suurimMass), 530, 540);
        g.drawString(Integer.toString(vaikseimMass), 55, 540);

        BufferedReader br2 = new BufferedReader(new InputStreamReader(new URL(source).openStream()));

        String rida2 = br2.readLine();
        rida2 = br2.readLine();
        
        while(rida2 != null) {
            String[] m = rida2.split(",");
            
            if(m[0].equals("kass")) {
                g.setColor(Color.BLUE);
            } else if (m[0].equals("koer")) {
                g.setColor(Color.RED);
            }
            g.fillRect(((Integer.parseInt(m[1])-vaikseimMass) * 490 / (suurimMass-vaikseimMass))+50, (500-(Integer.parseInt(m[2])-vaikseimKorgus) * 490 / (suurimKorgus-vaikseimKorgus))-4+25, 6, 6);
            rida2 = br2.readLine();
        }
        
        br2.close();

        ImageIO.write(bi, "png", new File("tulemused.png"));

        PrintWriter print = new PrintWriter(new FileWriter("tulemused.txt"));

        print.println("Suurim mass: " + suurimMass);
        print.println("V2ikseim mass: " + vaikseimMass);
        print.println("Suurim kõrgus: " + suurimKorgus);
        print.println("Väikseim kõrgus: " + vaikseimKorgus);
        print.println("Kassid:");
        print.println("Kõrguste summa: " + kassiKorgusteSumma);
        print.println("Masside summa: " + kassiMassideSumma);
        print.println("Keskmine mass: " + kassideKeskmineMass);
        print.println("Keskmine kõrgus: " + kassideKeskmineKorgus);
        print.println("Koerad:");
        print.println("Kõrguste summa: " + koeraKorgusteSumma);
        print.println("Masside summa: " + koeraMassideSumma);
        print.println("Keskmine mass: " + koerteKeskmineMass);
        print.println("Keskmine kõrgus: " + koerteKeskmineKorgus);
        print.close();

        System.out.println("Korras!\n");
    }
}