package com.mycompany.kodutoo;
import java.net.*;
import java.io.*;

public class vork {
     public static void main(String[] arg) throws Exception{
        String aadress="http://www.tlu.ee/~jaagup/veeb1/loomad.txt";
        BufferedReader br=new BufferedReader(new InputStreamReader(
          new URL(aadress).openStream()));
        String rida=br.readLine();
        if(!rida.startsWith("liik")){
            System.out.println("sobiva pealkirjata fail");
            return;
        }
        rida=br.readLine();
        int kassidemassidesumma=0;
        int i=0;
        int koeradesumma=0;
        int b=0;
        int massidesumma=0;
        int koerkõrg=0;
        int kassikõrg=0;
        int koerkeskkõrg=0;
        int kasskeskkõrg=0;
        int kasskeskmass=0;
        int koerkeskmass=0;
        int suurimkass=0;
        int suurimkass1=0;
        int suurimkoer=0;
        int suurimkoer1=0;
        int väikseimkass=0;
        int väikseimkass1=1000;
        int väikseimkoer=0;
        int väikseimkoer1=12000;
                
        while(rida!=null){
            System.out.println(rida);
            String[] m=rida.split(",");
            //Sisesta kaks arvu koerte massideks ning kolm arvu kasside massideks. Näita, kummast liigist loomade masside summa on suurem.
            if(m[0].equals("kass") && i!=3){
                kassidemassidesumma+=Integer.parseInt(m[1]);
                i++;
            }
            if(m[0].equals("koer")&& b!=2){
                b++;
                koeradesumma+=Integer.parseInt(m[1]);
            }
            //Lisa funktsioonid suurima, vähima ja aritmeetilise keskmise massi väärtuse leidmiseks.
            if(m[0].equals("kass")){
                suurimkass= Integer.parseInt(m[1]);
                väikseimkass=Integer.parseInt(m[1]);
                kassidemassidesumma+=Integer.parseInt(m[1]);
                kassikõrg+=Integer.parseInt(m[2]);
                i++;
                if(suurimkass1<suurimkass){
                    suurimkass1= suurimkass;}   
             }
                if(väikseimkass1>väikseimkass){
                    väikseimkass1=väikseimkass;
                }
            if(m[0].equals("koer")){
                suurimkoer=Integer.parseInt(m[1]);
                väikseimkoer=Integer.parseInt(m[1]);
                b++;
                koeradesumma+=Integer.parseInt(m[1]);
                koerkõrg+=Integer.parseInt(m[2]);
                if(suurimkoer1<suurimkoer){
                    suurimkoer1=suurimkoer;
                }
                if(väikseimkoer1>väikseimkoer){
                    väikseimkoer1=väikseimkoer;
                }
            }
            
            massidesumma=koeradesumma+kassidemassidesumma;
            rida=br.readLine();
            
        }
        System.out.println("Kassimasside summa on :"+kassidemassidesumma);
        System.out.println("Koertemasside summa on:"+koeradesumma);
        System.out.println("Masside summa on:"+massidesumma);
        System.out.println("Suurima kassi mass on:"+suurimkass1);
        System.out.println("Suurima koera mass on:"+suurimkoer1);
        System.out.println("Väikseim kass on:"+väikseimkass1);
        System.out.println("Väikseim koer on:"+väikseimkoer1);
        if(koeradesumma<kassidemassidesumma){
            System.out.println("Kasside masside summa on suurem.");
        }else{
            System.out.println("Koerte masside summa on suurem.");
        }
    }
}