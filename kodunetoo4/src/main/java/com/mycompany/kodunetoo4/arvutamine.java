
package com.mycompany.kodunetoo4;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public final class arvutamine {
    public arvutamine() throws IOException 
    {
        arvuta();
    }  
    public String arvuta() throws IOException{   
        int kassidemassidesumma=0;
        int koertemassidesumma=0;
        int kassidekorgustesumma=0;
        int koertekorgustesumma=0;
        int kassMinMass = 2000;
        int kassMinKorgus = 100;
        int koerMinMass = 12000;
        int koerMinKorgus = 200;
        int kassMaxMass = 0;
        int kassMaxKorgus = 0;
        int koerMaxMass = 0;
        int koerMaxKorgus = 0;
        int KMK = 0;
        int KKK = 0;
        int PMK = 0;
        int PKK = 0;
        try {
            try (BufferedReader br = new BufferedReader(new FileReader("loomad\\kassid.txt"))) {
                String rida = br.readLine();
                rida = br.readLine();
                String[] m = rida.split(", ");
                for (int i=0; i<m.length; i++) {
                    kassidemassidesumma = kassidemassidesumma + (Integer.parseInt(m[i]));
                    if (i< kassMinMass){
                        kassMinMass = (Integer.parseInt(m[i]));
                    }
                    if (i > kassMaxMass){
                        kassMaxMass = (Integer.parseInt(m[i]));
                    }
                }
                rida = br.readLine();
                rida = br.readLine();
                String[] k = rida.split(", ");
                for(int i=0; i<k.length; i++){
                    kassidekorgustesumma = kassidekorgustesumma +(Integer.parseInt (k[i]));
                    if (i< kassMinKorgus){
                        kassMinKorgus =(Integer.parseInt(k[i]));
                    }
                    if (i > kassMaxKorgus){
                        kassMaxKorgus = (Integer.parseInt(k[i]));
                    }
                }
                KMK = kassidemassidesumma / m.length;
                KKK = kassidekorgustesumma / k.length;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(arvutamine.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            try (BufferedReader br = new BufferedReader(new FileReader("loomad\\koerad.txt"))) {
                String rida = br.readLine();
                rida = br.readLine();
                String[] m = rida.split(", ");
                for (int i=0; i<m.length; i++) {
                    koertemassidesumma = koertemassidesumma + (Integer.parseInt(m[1]));
                    if (i< koerMinMass){
                        koerMinMass = (Integer.parseInt( m[i]));
                    }
                    if (i > koerMaxMass){
                        koerMaxMass = (Integer.parseInt( m[i]));
                    }
                }
                rida = br.readLine();
                rida = br.readLine();
                String[] k = rida.split(", ");
                for(int i=0; i<k.length; i++){
                    koertekorgustesumma = koertekorgustesumma +(Integer.parseInt (k[i]));
                    if (i< koerMinKorgus){
                        koerMinKorgus =(Integer.parseInt( k[i]));
                    }
                    if (i > koerMaxKorgus){
                        koerMaxKorgus = (Integer.parseInt( k[i]));
                    }
                }
                br.close();                     
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(arvutamine.class.getName()).log(Level.SEVERE, null, ex);
        }
        String vastus = "Kasside masside keskmine: "+KMK+"\nKasside korguste keskmine: "+KKK+"\nKasside max mass "+kassMaxMass+" ja korgus "+kassMaxKorgus+"\n"
        + "Kasside min mass "+kassMinMass+" ja korgus "+kassMinKorgus+"\nKoerte masside keskmine: "+PMK+"\nKoerte korguste keskmine: "+PKK+"\nKoerte max mass "+koerMaxMass+" ja korgus "+koerMaxKorgus+"\n"
        + "Koerte min mass "+koerMinMass+" ja korgus "+koerMinKorgus;
       try{
            try (PrintWriter pw = new PrintWriter(new FileWriter("loomad/arvutused.txt"))) {
                pw.println(vastus);
            }
        } catch(IOException ex){
        } 
        return vastus;
    } 
}
