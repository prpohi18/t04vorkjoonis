import java.awt.image.*;
import javax.imageio.*;
import java.awt.*;
import java.net.*;
import java.io.*;

public class Vork {

    public static void main(String[] arg) throws Exception {

        // Deklareerin muutujad
        int catWeight = 0;
        int dogWeight = 0;
        int catLength = 0;
        int dogLength = 0;
        int catCount = 0;
        int dogCount = 0;

        BufferedImage bi = new BufferedImage(600, 400, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = bi.createGraphics();

        graphics.setColor(Color.black);
        graphics.fillRect(0, 0, 600, 400);

        graphics.setColor(Color.white);
        graphics.drawString("Loomade kaalu ja kõrguse suhe", 190, 20);

        graphics.setColor(Color.blue);
        graphics.drawString("Koerad", 15, 320);

        graphics.setColor(Color.red);
        graphics.drawString("Kassid", 15, 340);

        graphics.setColor(Color.gray);
        graphics.drawString("Koerte keskmine", 75, 320);

        graphics.setColor(Color.pink);
        graphics.drawString("Kasside keskmine", 75, 340);

        // Loen andmed sisse
        String aadress = "http://www.tlu.ee/~jaagup/veeb1/loomad.txt";
        BufferedReader br = new BufferedReader(new InputStreamReader(
                new URL(aadress).openStream()));
        // Loen ridadesse
        String line = br.readLine();
        // Ignoreerin esimest rida
        line = br.readLine();

        while (line != null) {
            String[] dataArray = line.split(",");
            if (dataArray[0].equals("kass")) {
                graphics.setColor(Color.red);
                catWeight = catWeight + Integer.parseInt(dataArray[1]);
                catLength = catLength + Integer.parseInt(dataArray[2]);
                catCount++;
            } else {
                graphics.setColor(Color.blue);
                dogWeight = dogWeight + Integer.parseInt(dataArray[1]);
                dogLength = dogLength + Integer.parseInt(dataArray[2]);
                dogCount++;
            }

            graphics.fillRect(Integer.parseInt(dataArray[1]) / 30, 300 - Integer.parseInt(dataArray[2]) * 2, 5, 5);
            line = br.readLine();

        }

        int catAvgLength = catLength / catCount;
        int catAvgWeight = catWeight / catCount;
        int dogAvgLength = dogLength / dogCount;
        int dogAvgWeight = dogWeight / dogCount;

        if (catAvgLength > dogAvgLength) {
            System.out.println("Kassid on keskmiselt kõrgemad kui koerad");
        } else if (catAvgLength == dogAvgLength) {
            System.out.println("Koerad on keskmiselt sama kõrged nagu kassid");
        } else {
            System.out.println("Koerad on keskmiselt kõrgemad kui kassid");
        }

        System.out.println("Koeri on: " + dogCount + " ja kasse on: " + catCount);
        System.out.println("Koerte keskmine kaal: " + dogAvgWeight);
        System.out.println("Koerte keskmine pikkus: " + dogAvgLength);
        System.out.println("Kasside keskmine kaal: " + catAvgWeight);
        System.out.println("Kasside keskmine pikkus: " + catAvgLength);

        graphics.setColor(Color.pink);
        graphics.fillRect(catAvgWeight / 30, 300 - catAvgLength * 2, 5, 5);
        graphics.setColor(Color.gray);
        graphics.fillRect(dogAvgWeight / 30, 300 - dogAvgLength * 2, 5, 5);

        // Annan x ja y koordinaatidele algus ja lõpppunktid
        graphics.setColor(Color.white);
        graphics.drawLine(10, 290, 550, 290);
        graphics.drawLine(10, 40, 10, 290);

        graphics.drawString("Weight", 515, 310);

        graphics.drawString("Length", 20, 40);

        ImageIO.write(bi, "png", new File("Animals.png"));
    }
}