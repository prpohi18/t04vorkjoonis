package com.company;

import java.net.*;
import java.io.*;

public class vork {
    public static void main(String[] arg) throws Exception{
        String aadress="http://www.tlu.ee/~jaagup/veeb1/loomad.txt";
        BufferedReader br=new BufferedReader(new InputStreamReader(
                new URL(aadress).openStream()));
        String line=br.readLine();
        if(!line.startsWith("liik")){
            System.out.println("sobiva pealkirjata fail");
            return;
        }
        line=br.readLine();

        //muutujad
        int catsWeightsSum=0;
        int i=0;
        int dogsWeightSum=0;
        int b=0;
        int weightSum=0;
        int dogHeight=0;
        int catHeight=0;
        int biggestCat=0;
        int biggestCat2=0;
        int biggestDog=0;
        int biggestDog2=0;
        int smallestCat=0;
        int smallestCat2=1000;
        int smallestDog=0;
        int smallestDog2=12000;
        int cat=0;
        int dog=0;

        while(line!=null){
            String[] m=line.split(",");
            if(m[0].equals("kass") && i!=3){
                catsWeightsSum+=Integer.parseInt(m[1]);
                i++;
            }
            if(m[0].equals("koer")&& b!=2){
                b++;
                dogsWeightSum+=Integer.parseInt(m[1]);
            }
            if(m[0].equals("kass")){
                biggestCat= Integer.parseInt(m[1]);
                smallestCat=Integer.parseInt(m[1]);
                catsWeightsSum+=Integer.parseInt(m[1]);
                catHeight+=Integer.parseInt(m[2]);
                cat++;
                if(biggestCat2<biggestCat){
                    biggestCat2= biggestCat;}
            }
            if(smallestCat2>smallestCat){
                smallestCat2=smallestCat;
            }
            if(m[0].equals("koer")){
                biggestDog=Integer.parseInt(m[1]);
                smallestDog=Integer.parseInt(m[1]);
                dog++;
                dogsWeightSum+=Integer.parseInt(m[1]);
                dogHeight+=Integer.parseInt(m[2]);
                if(biggestDog2<biggestDog){
                    biggestDog2=biggestDog;
                }
                if(smallestDog2>smallestDog){
                    smallestDog2=smallestDog;
                }
            }

            weightSum=dogsWeightSum+catsWeightsSum;
            line=br.readLine();

        }
        System.out.println("Masside summa koertel on:"+dogsWeightSum);
        System.out.println("Masside summa kassidel on :"+catsWeightsSum);
        System.out.println("Koerte ja kasside masside summa on:"+weightSum);
        System.out.println("Suurima koera mass on:"+biggestDog2);
        System.out.println("Suurima kassi mass on:"+biggestCat2);
        System.out.println("Väikseima koera mass on:"+smallestDog2);
        System.out.println("Väikseima kassi mass on:"+smallestCat2);
        if(dogsWeightSum<catsWeightsSum){
            System.out.println("Kasside masside summa on suurem kui koerte oma.");
        }else{
            System.out.println("Koerte masside summa on suurem kui kasside oma.");
        }
    }
}
