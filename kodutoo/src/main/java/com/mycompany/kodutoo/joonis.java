package com.mycompany.kodutoo;
import java.awt.image.*;
import javax.imageio.*;
import java.awt.*;
import java.net.*;
import java.io.*;

public class joonis{
    public static void main(String[] arg) throws Exception{
        BufferedImage bi=new BufferedImage(300, 600, BufferedImage.TYPE_INT_RGB);
        Graphics g=bi.createGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 300, 600);
        String aadress="http://www.tlu.ee/~jaagup/veeb1/loomad.txt";
        BufferedReader br=new BufferedReader(new InputStreamReader(
          new URL(aadress).openStream()));
        String rida=br.readLine();
        rida=br.readLine();
        
        //muutujad:
        String mass=new String("");
        String kõrg=new String("");

        while(rida!=null){
            String[] m=rida.split(",");
            if(m[0].equals("kass")){
                g.setColor(Color.orange);
                mass= m[1];
                kõrg=m[2];
            }
            else{
                g.setColor(Color.white);
                mass= m[1];
                kõrg=m[2];
            }
            g.drawString(mass,10000/Integer.parseInt(m[1]),10000/Integer.parseInt(m[1]));//string,int x, int y
            g.drawString(kõrg,10000/Integer.parseInt(m[2]),10000/Integer.parseInt(m[2]));//string intx int y
            rida=br.readLine();
        }
        ImageIO.write(bi, "png", new File("loomad.png"));
    }
}
