package com.company;

import java.awt.image.*;
import javax.imageio.*;
import java.awt.*;
import java.net.*;
import java.io.*;

public class Main {

    public static void main(String[] arg) throws Exception{
        BufferedImage bi=new BufferedImage(600, 600, BufferedImage.TYPE_INT_RGB);
        Graphics g=bi.createGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 600, 600);
        String aadress="http://www.tlu.ee/~jaagup/veeb1/loomad.txt";
        BufferedReader br=new BufferedReader(new InputStreamReader(new URL(aadress).openStream()));
        String line=br.readLine();
        line=br.readLine();

        String weight=new String("");
        String height=new String("");

        while(line!=null){
            String[] m=line.split(",");
            if(m[0].equals("kass")){
                g.setColor(Color.red);
                weight= m[1];
                height=m[2];
            }
            else{
                g.setColor(Color.green);
                weight= m[1];
                height=m[2];
            }

            g.drawString(weight,10000/Integer.parseInt(m[1]),10000/Integer.parseInt(m[1]));//string,int x, int y
            g.drawString(height,10000/Integer.parseInt(m[2]),10000/Integer.parseInt(m[2]));//string intx int y
            line=br.readLine();
        }
        ImageIO.write(bi, "png", new File("kotopes.png"));
    }
}
