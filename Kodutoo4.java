package krislyn.kodutoo4;

import java.awt.image.*;
import javax.imageio.*;
import java.awt.*;
import java.net.*;
import java.io.*;

public class Kodutoo4 {


    public static void main(String[] args) throws Exception {
        int kassimass = 0;
        int koeramass = 0;
        int kassipikkus = 0;
        int koerapikkus = 0;
        int kassiCount = 0;
        int koeraCount = 0;
        
        BufferedImage bi=new BufferedImage(400,300, BufferedImage.TYPE_INT_RGB);
    Graphics g=bi.createGraphics();
    g.setColor(Color.WHITE);
    g.fillRect(0, 0, 400, 300);
        g.setColor(Color.BLUE);
        g.drawString("Loomade kaalu ja kõrguse suhe: ", 110, 20);
        g.setColor(Color.RED);
        g.drawString("Koertel", 10, 40);
        g.setColor(Color.GREEN);
        g.drawString("Kassidel", 10, 60);
        g.setColor(Color.PINK);
        g.drawString("Kasside keskmine: ", 65, 60);
        g.setColor(Color.BLACK);
        g.drawString("Koerte keskmine: ", 65, 40);
        
        String aadress="http://www.tlu.ee/~jaagup/veeb1/loomad.txt";
        BufferedReader br=new BufferedReader(new InputStreamReader(
        new URL(aadress).openStream()));
        String rida=br.readLine();
        rida=br.readLine();
        
        while (rida!=null){
            String[] dataArray=rida.split(",");
            if(dataArray[0].equals("kass")){
                    g.setColor(Color.blue);
                    kassimass = kassimass + Integer.parseInt(dataArray[1]);
                    kassipikkus = kassipikkus + Integer.parseInt(dataArray[2]);
                    kassiCount++;
            }
            else{
                    g.setColor(Color.ORANGE);
                    koeramass = koeramass + Integer.parseInt(dataArray[1]);
                    koerapikkus = koerapikkus + Integer.parseInt(dataArray[2]);
                    koeraCount++;
            }
    g.fillRect(Integer.parseInt(dataArray[1])/30,300-Integer.parseInt(dataArray[2])*2, 5, 5);
    rida=br.readLine();
            }
        
        int kassideKpikkus = kassipikkus/kassiCount;
        int kassideKmass = kassimass/kassiCount;
        int koeraKpikkus = koerapikkus/koeraCount;
        int koeraKmass = koeramass/koeraCount;
        
        
        if(kassideKpikkus>koeraKpikkus){
                System.out.println("Kassid on keskmiselt kõrgemad kui koerad.");
        }
        else if(kassideKpikkus==koeraKpikkus){
                System.out.println("Kassid on keskmiselt sama kõrged kui koerad.");
        }
        else{
                 System.out.println("Kassid on keskmiselt madalamad kui koerad.");
        }
        
        System.out.println("Koeri on: "+koeraCount+" ja kasse on: "+kassiCount);
        System.out.println("Koerte keskmine kaal: "+koeraKmass+"g");
        System.out.println("Koerte keskmine kõrgus: "+koeraKpikkus+"cm");
        System.out.println("Kasside keskmine kaal: "+kassideKmass+"g");
        System.out.println("Kasside keskmine kõrgus: "+kassideKpikkus+"cm");
           
        g.setColor(Color.YELLOW);
        g.drawLine(10,300,300,300);
        g.drawLine(10,190,10,300);
        
        g.drawString("Kaal",320,300);
        
        g.drawString("Kõrgus",10,160);
        
            ImageIO.write(bi, "png", new File("kassidkoerad.png"));
        
        }
}
    

/* Kassid on keskmiselt madalamad kui koerad.
Koeri on: 7 ja kasse on: 6
Koerte keskmine kaal: 6571g
Koerte keskmine kõrgus: 64cm
Kasside keskmine kaal: 1300g
Kasside keskmine kõrgus: 27cm */
