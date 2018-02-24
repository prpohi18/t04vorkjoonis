
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

/*
Kasside masside keskmine: 1300
Kasside kõrguste kõrguste keskmine: 1300
Kasside max mass 1200 ja kõrgus 28
Kasside min mass 800 ja kõrgus 20
Koerte masside keskmine: 3000
Koerte kõrguste keskmine: 6571
Koerte max mass 3000 ja kõrgus 40
Koerte min mass 12000 ja kõrgus 100
*/

