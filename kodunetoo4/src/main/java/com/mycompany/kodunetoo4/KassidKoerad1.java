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
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;


public class KassidKoerad1 extends JPanel{
    double grkoef=10;
    java.util.List<DescriptiveStatistics> kassid;
    
    java.util.List<DescriptiveStatistics> koerad;
    java.util.List<double[]> loomad;
    
     
     public java.util.List<double[]> kysiLoomadeAndmed() {   
            if(loomad==null){
                kassid = new ArrayList<>();
                loomad = new ArrayList<>();
                koerad = new ArrayList<>();



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
                    double[] dm=new double[m.length];
                    for(int i=0; i<rida.split(",").length; i++){
                    koerad.add(new DescriptiveStatistics());

                    kassid.add(new DescriptiveStatistics());
                    }

                        if("koer".equals(m[0])){

                            koertemassidesumma+=Integer.parseInt(m[1]);
                            for (int i = 0; i < m.length; i++) {
                            dm[i]=Double.parseDouble(m[i]);
                            koerad.get(i).addValue(dm[i]);
                            }
                            g.setColor(Color.gray);
                            g.fillRect(Integer.parseInt(m[1])/30, 300-Integer.parseInt(m[2])*2, 5, 5);

                        }else if("kass".equals(m[0])){
                            kassidemassidesumma+=Integer.parseInt(m[1]);
                           for (int i = 0; i < m.length; i++) {
                            dm[i]=Double.parseDouble(m[i]);
                            kassid.get(i).addValue(dm[i]);
                            }



                            g.setColor(Color.red);
                            g.fillRect(Integer.parseInt(m[1])/30, 300-Integer.parseInt(m[2])*2, 5, 5);
                        }

                        loomad.add(dm);
                        rida = br.readLine();


                    ImageIO.write(bi, "png", new File("loomad.png"));

                }

                br.close();



                if(kassidemassidesumma>koertemassidesumma){
                    System.out.println("Kasside masside summa on suurim ja see on: "+kassidemassidesumma);
                }else if(koertemassidesumma>kassidemassidesumma){
                    System.out.println("Koerte masside summa on suurim ja see on: "+koertemassidesumma);
                }




            } catch (Exception ex) {
                        ex.printStackTrace();}

                }
            return loomad;
     }
     
     int ekraaniY(double y){
        return getHeight()-(int)(y*grkoef);
    }
    int ekraaniX(double x){
        return (int)(x*grkoef);
    }
     
     
     
     
   
    void joonistaOunad(Graphics g){
        for(double[] m: kysiLoomadeAndmed()){
           g.fillOval(ekraaniX(m[0]),ekraaniY(m[1]), 5, 5);
           g.fillOval(ekraaniX(m[0]),ekraaniY(m[1]), 5, 5);
        }
        int minXK= (int) koerad.get(0).getMin();
        int keskYK=(int) koerad.get(1).getMean();
        int minXS= (int) kassid.get(0).getMin();
        int keskYS=(int) kassid.get(1).getMean();
    }
    
   
        
        //Lisage joon septembri keskmise väärtuse kohta 
    
    void loomaJoonisFaili(){
       try{
         BufferedImage bi=new BufferedImage(400, 300, BufferedImage.TYPE_INT_RGB);
         Graphics g=bi.createGraphics();
         g.setColor(Color.YELLOW);
         g.fillRect(0, 0, 400, 300);
         g.setColor(Color.RED);
         joonistaOunad(g);
         ImageIO.write(bi, "png", new File("C:\\Users\\ketuo\\t04vorkjoonis\\kodunetoo4\\loomad.png"));
       }catch(Exception ex){ex.printStackTrace();}
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        joonistaOunad(g);
        loomaJoonisFaili();
    }
        public static void main(String[] arg) throws Exception {
            JFrame f = new JFrame("Loomad");
            f.getContentPane().add(new KassidKoerad1());
            f.setSize(400, 300);
            f.setVisible(true);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        }
       
 
}
//http://www.tlu.ee/~jaagup/veeb1/loomad.txt



/*String[] array_1 = new String[];
String[] array_2 = new String[];
...

String[][] arrays = { array_1, array_2, ...}
*/