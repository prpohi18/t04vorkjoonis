import java.awt.image.*;
import javax.imageio.*;
import java.awt.*;
import java.net.*;
import java.io.*;

public class kassidjakoerad{
    public static void main(String[] arg) throws Exception{

        String source = "http://www.tlu.ee/~jaagup/veeb1/loomad.txt";

        int suurimmass= 0;
        int vaikseimmass= 0;
		int suurimk6rgus= 0;
        int v2ikseimk6rgus= 0;
        int kassik6rgustesumma= 0;
        int koerak6rgustesumma= 0;
        int kassimassidesumma= 0;
        int koeramassidesumma= 0;
        int kassidekeskk6rgus= 0;
        int koertekeskk6rgus= 0;
        int kassidekeskmass= 0;
        int koertekeskmass= 0;
        int koertekogus= 0;
        int kassidekogus= 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(new URL(source).openStream()));

        String rida = br.readLine();

        if(!rida.startsWith("liik")){
            System.out.println("sobiva pealkirjata fail");
            return;
        }

        rida = br.readLine();

        String[] m1 = rida.split(",");

        vaikseimmass = Integer.parseInt(m1[1]);
        suurimmass = Integer.parseInt(m1[1]);
        v2ikseimk6rgus = Integer.parseInt(m1[2]);
        suurimk6rgus = Integer.parseInt(m1[2]);

        while(rida != null){
            String[] m = rida.split(",");

            if(m[0].equals("kass")){
                kassimassidesumma += Integer.parseInt(m[1]);
                kassik6rgustesumma += Integer.parseInt(m[2]);
                kassidekogus += 1;
            } else if(m[0].equals("koer")) {
                koeramassidesumma += Integer.parseInt(m[1]);
                koerak6rgustesumma += Integer.parseInt(m[2]);
                koertekogus += 1;
            }

            if (Integer.parseInt(m[1]) > suurimmass) {
                suurimmass = Integer.parseInt(m[1]);
            } else if (Integer.parseInt(m[1]) < vaikseimmass) {
                vaikseimmass = Integer.parseInt(m[1]);
            }

            if (Integer.parseInt(m[2]) > suurimk6rgus) {
                suurimk6rgus = Integer.parseInt(m[2]);
            } else if (Integer.parseInt(m[2]) < v2ikseimk6rgus) {
                v2ikseimk6rgus = Integer.parseInt(m[2]);
            }
            rida = br.readLine();
        }

        kassidekeskmass = kassimassidesumma / kassidekogus;
        kassidekeskk6rgus = kassik6rgustesumma / kassidekogus;

        koertekeskmass = koeramassidesumma / koertekogus;
        koertekeskk6rgus = koerak6rgustesumma / koertekogus;

        br.close();

        BufferedImage bi = new BufferedImage(575, 575, BufferedImage.TYPE_INT_RGB);
        Graphics g = bi.createGraphics();

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 575, 575);

   
        g.setColor(Color.BLACK);
        g.fillOval(((kassidekeskmass-vaikseimmass) * 500 / (suurimmass-vaikseimmass))-5+50,
                   500-(kassidekeskk6rgus-v2ikseimk6rgus) * 500 / (suurimk6rgus-v2ikseimk6rgus)-5+25,
                   12,
                   12);
        g.drawString("Kassid", 200, 30);

        g.setColor(Color.RED);
        g.fillOval(((koertekeskmass-vaikseimmass) * 500 / (suurimmass-vaikseimmass))-5+50,
                500-(koertekeskk6rgus-v2ikseimk6rgus) * 500 / (suurimk6rgus-v2ikseimk6rgus)-5+25,
                12,
                12);
        g.drawString("Koerad", 400, 30);

        g.setColor(Color.BLACK);
        g.drawLine(50, 25, 50, 525);
        g.drawString("Kõrgus", 5, 305);

        g.drawLine(50, 525, 550, 525);
        g.drawString("Mass", 300, 540);   
        
        g.drawString(Integer.toString(suurimk6rgus), 20, 30);
        g.drawString(Integer.toString(v2ikseimk6rgus), 30, 520);
        g.drawString(Integer.toString(suurimmass), 530, 540);
        g.drawString(Integer.toString(vaikseimmass), 55, 540);

        BufferedReader br2 = new BufferedReader(new InputStreamReader(new URL(source).openStream()));

        String rida2 = br2.readLine();
        rida2 = br2.readLine();
        
        while(rida2 != null) {
            String[] m = rida2.split(",");
            
            if(m[0].equals("kass")) {
                g.setColor(Color.BLACK);
            } else if (m[0].equals("koer")) {
                g.setColor(Color.RED);
            }
            g.fillRect(((Integer.parseInt(m[1])-vaikseimmass) * 490 / (suurimmass-vaikseimmass))+50, (500-(Integer.parseInt(m[2])-v2ikseimk6rgus) * 490 / (suurimk6rgus-v2ikseimk6rgus))-4+25, 6, 6);
            rida2 = br2.readLine();
        }
        
        br2.close();

        ImageIO.write(bi, "png", new File("joonis.png"));

        PrintWriter print = new PrintWriter(new FileWriter("loomad.txt"));

        print.println("Suurim mass: " + suurimmass);
        print.println("Väikseim mass: " + vaikseimmass);
        print.println("Suurim kõrgus: " + suurimk6rgus);
        print.println("Väikseim kõrgus: " + v2ikseimk6rgus);
        print.println("Kasside andmed:");
        print.println("Kõrguste summa: " + kassik6rgustesumma);
        print.println("Masside summa: " + kassimassidesumma);
        print.println("Keskmine mass: " + kassidekeskmass);
        print.println("Keskmine kõrgus: " + kassidekeskk6rgus);
        print.println("Koerte andmed:");
        print.println("Kõrguste summa: " + koerak6rgustesumma);
        print.println("Masside summa: " + koeramassidesumma);
        print.println("Keskmine mass: " + koertekeskmass);
        print.println("Keskmine kõrgus: " + koertekeskk6rgus);
        print.close();

        System.out.println("Korras!\n");
    }
} 