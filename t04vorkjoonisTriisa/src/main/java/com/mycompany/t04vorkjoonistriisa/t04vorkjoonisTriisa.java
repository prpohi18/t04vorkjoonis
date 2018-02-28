/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.t04vorkjoonistriisa;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.net.*;
import java.io.*;
import java.util.stream.IntStream;
import javax.imageio.ImageIO;

public class t04vorkjoonisTriisa {
    
    public static int arvudSumma(int[] arvud) {
        return IntStream.of(arvud).sum();
    }
    
    public static int arvudMin(int[] arvud) {
        return IntStream.of(arvud).min().getAsInt();
    }
    
    public static int arvudMax(int[] arvud) {
        return IntStream.of(arvud).max().getAsInt();
    }
      
    public static void main(String[] arg) throws Exception{
        
        BufferedImage bi = new BufferedImage(475, 475, BufferedImage.TYPE_INT_RGB);
        Graphics g = bi.createGraphics();
        g.setColor(Color.darkGray);
        g.fillRect(0, 0, 475, 475);
        
        
        String aadress="http://www.tlu.ee/~jaagup/veeb1/loomad.txt";
        BufferedReader br=new BufferedReader(new InputStreamReader(
          new URL(aadress).openStream()));
        String rida = br.readLine();

        int kassCounter = 0;
        int koerCounter = 0;
        int kassMax = 6;
        int koerMax = 7;
        int[] koeradeMassid = new int[koerMax]; 
        int[] kassideMassid = new int[kassMax]; 
        int[] koeradeKorgused = new int[koerMax]; 
        int[] kassideKorgused = new int[kassMax]; 
                
        while(rida != null){
            String[] m = rida.split(",");
            if(m[0].equals("kass") && kassCounter < kassMax ){
                kassideMassid[kassCounter] = Integer.parseInt(m[1]);
                kassideKorgused[kassCounter] = Integer.parseInt(m[2]);
                kassCounter++;
                g.setColor(Color.pink);
            }
            if(m[0].equals("koer") && koerCounter < koerMax){
                koeradeMassid[koerCounter] = Integer.parseInt(m[1]);
                koeradeKorgused[koerCounter] = Integer.parseInt(m[2]);
                koerCounter++;
                g.setColor(Color.cyan);
            }
            if(kassCounter != 0 || koerCounter != 0){ 
                g.fillOval(Integer.parseInt(m[1]) / 30 + 30, 400-Integer.parseInt(m[2])*2 - 30, 7, 7);
            }
            rida=br.readLine();         
        }
        
        g.setColor(Color.red);
        g.fillOval((arvudSumma(kassideMassid)/kassMax) / 30 + 30, 400-(arvudSumma(kassideKorgused)/kassMax)*2 - 30, 10, 10);

        g.setColor(Color.blue);
        g.fillOval((arvudSumma(koeradeMassid)/koerMax) / 30 + 30, 400-(arvudSumma(koeradeKorgused)/koerMax)*2 - 30, 10, 10);
        
        g.setColor(Color.white);
        g.drawLine(30, 370, 440, 370);
        g.drawLine(30, 170, 30, 370);
        
        System.out.println("Kassi masside summa on : "+arvudSumma(kassideMassid));
        System.out.println("Koerte masside summa on: "+arvudSumma(koeradeMassid));
        if(arvudSumma(kassideMassid) < arvudSumma(koeradeMassid)){
            System.out.println("Koerte masside summa on suurem.");
        } else {
            System.out.println("Kasside masside summa on suurem.");
        }
        System.out.println("Suurima kassi mass on: "+arvudMax(kassideMassid));
        System.out.println("Suurima koera mass on: "+arvudMax(koeradeMassid));
        System.out.println("Väikseim kass on: "+arvudMin(kassideMassid));
        System.out.println("Väikseim koer on: "+arvudMin(koeradeMassid));
        System.out.println("Kasside masside artimeetiline keskmine on: "+(arvudSumma(kassideMassid)/(float)kassMax));
        System.out.println("Koerade masside artimeetiline keskmine on: "+(arvudSumma(koeradeMassid)/(float)koerMax));
        
        ImageIO.write(bi, "png", new File("loomad.png"));
    }
}

/*
Kassi masside summa on : 7800
Koerte masside summa on: 46000
Koerte masside summa on suurem.
Suurima kassi mass on: 2000
Suurima koera mass on: 12000
Väikseim kass on: 800
Väikseim koer on: 2000
Kasside masside artimeetiline keskmine on: 1300.0
Koerade masside artimeetiline keskmine on: 6571.4287
*/