package kodut664;

import java.net.*;
import java.io.*;
import java.util.*;
import java.awt.image.*;
import java.awt.*;
import javax.imageio.*;

public class main {
    public static void main(String[] arg) throws Exception {
        String location = "http://www.tlu.ee/~daisyp/soccer.txt";
        ArrayList<Soccer> Players = new ArrayList<Soccer>();
        //Alustan andmete lugemist
        BufferedReader bi = new BufferedReader(new InputStreamReader(new URL(location).openStream()));
        String rida = bi.readLine();
        if(!rida.startsWith("nimi")) {
            System.out.println("Sobimatu vorminguga fail");
            return;
        }
        rida = bi.readLine();
        while (rida != null) {
            String[] Info = rida.split(", ");
            //Loon tekstifailist saadud andmetega mängija objekti
            Soccer p = new Soccer(Info[0], Info[1], (Integer.parseInt(Info[2])));
            Players.add(p);
            rida = bi.readLine();
        }
        drawGraph(Players, "ST", "RW");
        System.out.println(getMin(Players, "ST"));
        System.out.println(getMax(Players, "ST"));

    }
    //Keskmise leidmine
    public static float getAvg(ArrayList<Soccer> Players, String position) {
        float sum = 0;
        int index = 0;
        int count = 0;
        for(Soccer k : Players){
            //Kui mängija objekti positsioon on võrdne kasutaja sisestatud positsiooniga
            if((Players.get(index)).getPosition().equals(position)) {
                sum = sum + ((Players.get(index)).getPoints());
                count++;
            }
            index++;
        }
        float avg = sum/(count);
        return avg;
    }
    //Miinimumi leidmine
    public static float getMin(ArrayList<Soccer> Players, String position){
        float min = Players.get(0).getPoints();
        int index = 0;
        for(Soccer k : Players){
            if((Players.get(index)).getPosition().equals(position)) {
                if((Players.get(index)).getPoints()< min) {
                    min =((Players.get(index)).getPoints());
                }
            }
            index++;
        }
        return min;
    }
    //Maksimumi leidmine
    public static float getMax(ArrayList<Soccer> Players, String position){
        float max = Players.get(0).getPoints();
        int index = 0;
        for(Soccer k : Players){
            if((Players.get(index)).getPosition().equals(position)) {
                if((Players.get(index)).getPoints()>max) {
                    max =((Players.get(index)).getPoints());
                }
            }
            index++;
        }
        return max;
    }
    public static void drawGraph(ArrayList<Soccer> Players, String pos1, String pos2) throws Exception{
        int imgWidth = 500;
        int imgHeight = 500;
        BufferedImage bi = new BufferedImage(imgWidth, imgHeight, BufferedImage.TYPE_INT_RGB);
        Graphics g = bi.createGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 500, 500);
        int index = 0;
        int x1 = 25;
        int dotSize = 3;
        int ypos = 0;
        //Esimese positsiooni mängijate punktid
        for (Soccer p : Players) {
            if ((Players.get(index)).getPosition().equals(pos1)) {
                g.setColor(Color.BLUE);
                int points = (Math.round(Players.get(index).getPoints())*10);
                System.out.println(points);
                ypos = imgHeight-points;
                g.fillOval(x1, ypos, dotSize, dotSize);
                x1 = x1+25;
            }
            if ((Players.get(index)).getPosition().equals(pos2)) {
                g.setColor(Color.RED);
                int points = (Math.round(Players.get(index).getPoints())*10);
                ypos = imgHeight-points;
                g.fillOval(x1, ypos, dotSize, dotSize);
                x1 = x1+25;
            }
            index++;
        }
        ypos = imgHeight-(Math.round(getAvg(Players, pos1))*10);
        //Sirge mis on esimese positsiooni keskmine punktide arv
        g.setColor(Color.BLUE);
        g.drawLine(0, ypos, 500, ypos);
        g.drawString("ST keskmine sirge", 350, 400);
        ypos = imgHeight-(Math.round(getAvg(Players, pos2))*10);
        //Sirge mis on võrdne teise positsiooni keskmise punktide arvuga
        g.setColor(Color.RED);
        g.drawLine(0, ypos, 500, ypos);
        g.drawString("RW keskmine sirge", 350, 460);
        //Skaala
        g.setColor(Color.BLACK);
        index = 5;
        ypos = imgHeight-50;
        int points = 5;
        while (index<(imgWidth/10)){
            g.drawLine(0, ypos, 10, ypos);
            ypos = ypos-5;
            g.drawString(String.valueOf(points), 3, ypos);
            ypos= ypos - 45;
            points = points+5;
            index = index+5;
        }
        ImageIO.write(bi, "png", new File("jalka.png"));
    }

}
