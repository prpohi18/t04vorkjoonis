/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.kodunetoo4;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import javax.imageio.ImageIO;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;


public class KassidKoerad {
    java.util.List<DescriptiveStatistics> kassidMass;
    java.util.List<DescriptiveStatistics> kassidKorgus;
    java.util.List<DescriptiveStatistics> koeradMass;
    java.util.List<DescriptiveStatistics> koeradKorgus;
    
  
     
    
    
    
    
    
    
    public static void main(String[] arg) throws Exception {
            
            ArrayList<String> kassidMass = new ArrayList<>();
            ArrayList<String> kassidKorgus = new ArrayList<>();
            ArrayList<String> koeradMass = new ArrayList<>();
            ArrayList<String> koeradKorgus = new ArrayList<>();
             
             
            BufferedImage bi=new BufferedImage(400, 300, BufferedImage.TYPE_INT_RGB);
            Graphics g=bi.createGraphics();
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, 400, 300);

            
           
            try {   
                String address= "http://www.tlu.ee/~jaagup/veeb1/loomad.txt";
                BufferedReader br=new BufferedReader( new InputStreamReader(new URL(address).openStream()));
                String rida = br.readLine();
                
                rida = br.readLine();
                String [] test = new String[rida.split(",").length];
            
            while (rida != null) {
                String[] m = rida.split(",");
                
                   
                    if("koer".equals(m[0])){
                        
                        koeradMass.add(m[1]);
                        
                        koeradKorgus.add(m[2]);
                        
                        
                        
                        g.setColor(Color.gray);
                        g.fillRect(Integer.parseInt(m[1])/30, 300-Integer.parseInt(m[2])*2, 5, 5);
                        
                    }else if("kass".equals(m[0])){
                        
                        kassidMass.add(m[1]);
                        kassidKorgus.add(m[2]);
                        
                        
                        
                        g.setColor(Color.red);
                        g.fillRect(Integer.parseInt(m[1])/30, 300-Integer.parseInt(m[2])*2, 5, 5);
                    }
                    
                    
                    rida = br.readLine();
                    
                
                
                ImageIO.write(bi, "png", new File("loomad/loomad.png"));
              
                
            }
            /*
            double ekraaniY = getHeight()-(int)(y*grkoef);
            return (int)(x*grkoef);
            int minX= ekraaniX(kirjeldused.get(0).getMin());
            int keskY= ekraaniY(kirjeldused.get(1).getMean());
            int ylaY=ekraaniY(kirjeldused.get(1).getMean()+kirjeldused.get(1).getStandardDeviation());
            g.drawLine(minX, 0, minX, 300);
            g.drawLine(0, keskY, 400, keskY);
            g.setColor(Color.GRAY);
            g.drawLine(0,ylaY,400,ylaY);
            */
            
            /*int KMK = koertemassidesumma/koeradMass.size();
            int SMK = kassidemassidesumma/kassidMass.size();
            int KKK = koertekorgustesumma/koeradMass.size();
            int SKK = kassidekorgustesumma/kassidMass.size();
            
            g.setColor(Color.green);
            
            g.drawLine(KMK,0,SMK,400);
            //g.drawLine(0,KKK,300,SKK);
            
            ImageIO.write(bi, "png", new File("loomad/loomad.png"));*/
            
            br.close();
               
        
 
             try{
                    PrintWriter pw=new PrintWriter(new FileWriter("loomad/kassid.txt"));
                    pw.println("Kasside massid");
                    pw.println(String.join(", ",kassidMass));
                    pw.println("Kasside korgused");
                    pw.println(String.join(", ", kassidKorgus));
                    pw.close();

                } catch(Exception ex){
                    ex.printStackTrace();
                } 
             
                try{
                    PrintWriter pw=new PrintWriter(new FileWriter("loomad/koerad.txt"));
                    pw.println("Koerte massid");
                    pw.println(String.join(", ",koeradMass ));
                    pw.println("Koerte korgused");
                    pw.println(String.join(", ",koeradKorgus ));
                    pw.close();

                } catch(Exception ex){
                    ex.printStackTrace();
                } 
            
            
            
            
            /*System.out.println("Kasside massid "+kassidMass);
            System.out.println("Kasside kõrgused "+kassidKorgus);
            System.out.println("Koerte massid "+koeradMass);
            System.out.println("Koerte kõrgused "+koeradKorgus);*/
            arvutamine a1 = new arvutamine();
            
            
            
            
            
            
            
        } catch (Exception ex) {
                    ex.printStackTrace();}
        
        
       
}   
}
//http://www.tlu.ee/~jaagup/veeb1/loomad.txt



/*String[] array_1 = new String[];
String[] array_2 = new String[];
...

String[][] arrays = { array_1, array_2, ...}
*/