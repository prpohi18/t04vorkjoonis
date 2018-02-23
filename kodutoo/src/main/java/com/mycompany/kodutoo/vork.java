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
        while(rida!=null){
            System.out.println(rida);
            String[] m=rida.split(",");
            if(m[0].equals("kass") && i!=3){
                kassidemassidesumma+=Integer.parseInt(m[1]);
                i++;
            }
            if(m[0].equals("koer")&& b!=2){
                b++;
                koeradesumma+=Integer.parseInt(m[1]);
            }  
            massidesumma=koeradesumma+kassidemassidesumma;
            rida=br.readLine();
            
        }
        System.out.println("Kassimasside summa on :"+kassidemassidesumma);
        System.out.println("Koertemasside summa on:"+koeradesumma);
        System.out.println("Masside summa on:"+massidesumma);
        if(koeradesumma<kassidemassidesumma){
            System.out.println("Kasside masside summa on suurem.");
        }else{
            System.out.println("Koerte masside summa on suurem.");
        }
    }
}