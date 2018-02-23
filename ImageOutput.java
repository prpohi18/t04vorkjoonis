import java.awt.image.*;
import javax.imageio.*;
import java.awt.*;
import java.net.*;
import java.io.*;

public class ImageOutput {
    
    //muutujad
    protected String aadress;
    
    protected int suurimmass;
    protected int vaikseimmass;

    protected int suurimkorgus;
    protected int vaikseimkorgus;

    protected int kassidemassidesumma;
    protected int koertemassidesumma;

    protected int kassidekeskminekorgus;
    protected int koertekeskminekorgus;

    protected int kassidekeskminemass;
    protected int koertekeskminemass;

    protected int kassidekorgustesumma;
    protected int koertekorgustesumma;
    
    public void ImageOutput() throws Exception {
        
        //tekita pildikirjutaja
        BufferedImage bi = new BufferedImage(575, 575, BufferedImage.TYPE_INT_RGB);
        Graphics g = bi.createGraphics();
        
        //taust
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 575, 575);
        
        g.setColor(Color.BLUE);
        
        //sinine punkt keskmise jaoks
        g.fillOval(((kassidekeskminemass-vaikseimmass) * 500 / (suurimmass-vaikseimmass))-5+50,
                   500-(kassidekeskminekorgus-vaikseimkorgus) * 500 / (suurimkorgus-vaikseimkorgus)-5+25,
                   10,
                   10);
        
        //horisontaalne sinine joon
        g.drawLine(50,
                   (500-(kassidekeskminekorgus-vaikseimkorgus) * 500 / (suurimkorgus-vaikseimkorgus))+25,
                   ((kassidekeskminemass-vaikseimmass) * 500 / (suurimmass-vaikseimmass))+50,
                   (500-(kassidekeskminekorgus-vaikseimkorgus) * 500 / (suurimkorgus-vaikseimkorgus))+25);
        
        //vertikaalne sinine joon
        g.drawLine(((kassidekeskminemass-vaikseimmass) * 500 / (suurimmass-vaikseimmass))+50,
                   525,
                   ((kassidekeskminemass-vaikseimmass) * 500 / (suurimmass-vaikseimmass))+50,
                   500-(kassidekeskminekorgus-vaikseimkorgus) * 500 / (suurimkorgus-vaikseimkorgus)+25);
        
        g.setColor(Color.RED);
        
        //punane punkt keskmise jaoks
        g.fillOval(((koertekeskminemass-vaikseimmass) * 500 / (suurimmass-vaikseimmass))-5+50,
                   500-(koertekeskminekorgus-vaikseimkorgus) * 500 / (suurimkorgus-vaikseimkorgus)-5+25,
                   10,
                   10);
        
        //horisontaalne punane joon
        g.drawLine(50,
                   (500-(koertekeskminekorgus-vaikseimkorgus) * 500 / (suurimkorgus-vaikseimkorgus))+25,
                   ((koertekeskminemass-vaikseimmass) * 500 / (suurimmass-vaikseimmass))+50,
                   (500-(koertekeskminekorgus-vaikseimkorgus) * 500 / (suurimkorgus-vaikseimkorgus))+25);
        
        //vertikaalne punane joon
        g.drawLine(((koertekeskminemass-vaikseimmass) * 500 / (suurimmass-vaikseimmass))+50,
                   525,
                   ((koertekeskminemass-vaikseimmass) * 500 / (suurimmass-vaikseimmass))+50,
                   500-(koertekeskminekorgus-vaikseimkorgus) * 500 / (suurimkorgus-vaikseimkorgus)+25);
        
        g.setColor(Color.GRAY);
        
        //x telg ja nimi
        g.drawLine(50, 25, 50, 525);
        g.drawString("Kõrgus, cm", 45, 15);
        
        //y telg ja nimi
        g.drawLine(50, 525, 550, 525);
        g.drawString("Mass, g", 510, 565);
        
        //min ja max väärtused
        g.drawLine(45, 25, 55, 25);
        g.drawLine(550, 520, 550, 530);
        g.drawLine(45, 525, 55, 525);
        g.drawLine(50, 520, 50, 530);
        g.drawString(Integer.toString(suurimkorgus), 10, 30);
        g.drawString(Integer.toString(vaikseimkorgus), 10, 530);
        g.drawString(Integer.toString(suurimmass), 530, 550);
        g.drawString(Integer.toString(vaikseimmass), 25, 550);
        
        //keskmiste väärtused
        g.setColor(Color.BLUE);
        g.drawString(Integer.toString(kassidekeskminekorgus), 10, 500-(kassidekeskminekorgus-vaikseimkorgus) * 500 / (suurimkorgus-vaikseimkorgus)+2+25);
        g.drawString(Integer.toString(kassidekeskminemass), ((kassidekeskminemass-vaikseimmass) * 500 / (suurimmass-vaikseimmass))-3+50, 550);
        g.setColor(Color.RED);
        g.drawString(Integer.toString(koertekeskminekorgus), 10, 500-(koertekeskminekorgus-vaikseimkorgus) * 500 / (suurimkorgus-vaikseimkorgus)+2+25);
        g.drawString(Integer.toString(koertekeskminemass), ((koertekeskminemass-vaikseimmass) * 500 / (suurimmass-vaikseimmass))-3+50, 550);
        
        //legend
        g.setColor(Color.GRAY);
        g.drawString("Koerad", 80, 570);
        g.drawString("Kassid", 160, 570);
        g.drawString("Korete keskmine", 240, 570);
        g.drawString("Kasside keskmine", 380, 570);
        g.setColor(Color.RED);
        g.fillRect(65, 562, 8, 8);
        g.fillOval(225, 560, 10, 10);
        g.setColor(Color.BLUE);
        g.fillRect(145, 562, 8, 8);
        g.fillOval(365, 560, 10, 10);
        
        //kuna suurim ja vähim on olemas, loe fail uuuesti ja
        //sel korral arvuta koordinaadid graafiku iga punkti jaoks
        BufferedReader br = new BufferedReader(new InputStreamReader(new URL(aadress).openStream()));
        //loe read 0 ja 1
        String rida = br.readLine();
        rida = br.readLine();
        
        //loe faili ja arvuta
        while(rida != null) {
            String[] m = rida.split(",");
            
            if(m[0].equals("kass")) {
                g.setColor(Color.BLUE);
            } else if (m[0].equals("koer")) {
                g.setColor(Color.RED);
            }
            
            //tekita graafik nii, et iga punkt arvestatakse
            //eelnevalt leitud suurima ja vähima väärtuse järgi
            g.fillRect(((Integer.parseInt(m[1])-vaikseimmass) * 500 / (suurimmass-vaikseimmass))+50, (500-(Integer.parseInt(m[2])-vaikseimkorgus) * 500 / (suurimkorgus-vaikseimkorgus))-4+25, 4, 4);
            
            rida = br.readLine();
        }
        
        //sulge lugeja
        br.close();
        
        //salvesta pilt
        ImageIO.write(bi, "png", new File("joonis.png"));
        
        //teavita kasutajat
        System.out.println("Graafik salvestatud.\n");
    }
}