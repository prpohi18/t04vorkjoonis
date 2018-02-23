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
import java.io.InputStreamReader;
import java.net.URL;
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
            int kassidemassidesumma=0;
            int koertemassidesumma=0;
            while (rida != null) {
                String[] m = rida.split(",");
                
                   
                    if("koer".equals(m[0])){
                        koeradMass.add(m[1]);
                        koeradKorgus.add(m[2]);
                        koertemassidesumma+=Integer.parseInt(m[1]);
                        
                        g.setColor(Color.gray);
                        g.fillRect(Integer.parseInt(m[1])/30, 300-Integer.parseInt(m[2])*2, 5, 5);
                        
                    }else if("kass".equals(m[0])){
                        kassidemassidesumma+=Integer.parseInt(m[1]);
                        kassidMass.add(m[1]);
                        kassidKorgus.add(m[2]);
                        
                        
                        
                        g.setColor(Color.red);
                        g.fillRect(Integer.parseInt(m[1])/30, 300-Integer.parseInt(m[2])*2, 5, 5);
                    }
                    
                    
                    rida = br.readLine();
                    
                
                ImageIO.write(bi, "png", new File("loomad.png"));
                
            }
            
            br.close();
            
            
            
            if(kassidemassidesumma>koertemassidesumma){
                System.out.println("Kasside masside summa on suurim ja see on: "+kassidemassidesumma);
            }else if(koertemassidesumma>kassidemassidesumma){
                System.out.println("Koerte masside summa on suurim ja see on: "+koertemassidesumma);
            }
            System.out.println("Kasside massid "+kassidMass);
            System.out.println("Kasside kõrgused "+kassidKorgus);
            System.out.println("Koerte massid "+koeradMass);
            System.out.println("Koerte kõrgused "+koeradKorgus);
            
            System.out.println("kohal");
            
            
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