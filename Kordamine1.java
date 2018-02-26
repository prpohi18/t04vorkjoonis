/*Esimese kontrolltöö näide

* Kuva arvude suurim, vähim ja aritmeetiline keskmine
* Arvud tulevad veebisolevast failist näiteks (http://www.tlu.ee/~ojagre/pikkused.txt)
Koosta alamprogramm, mis väljastaks etteantud aadressilt loetud arvudest standardhaälbe
* Kuva arvud kriipsudena joonisel. Näita joonisel samuti välja aritmeetilise keskmise asukoht ning sealt ühe ja kahe standardhälbe  kaugusel olevad vahemikud*/

import java.net.*;
import java.io.*;
import java.awt.*; 
import java.awt.image.*;
import javax.imageio.*;

public class Kordamine1{
	public static void main(String[] arg) throws Exception{
		String aadress="http://www.tlu.ee/~ojagre/pikkused.txt";
		BufferedImage bi=new BufferedImage(400, 300, BufferedImage.TYPE_INT_RGB);
		Graphics g=bi.createGraphics();
		g.setColor(Color.ORANGE);
		g.drawLine(100,250, 100, 20);
		
		BufferedReader br=new BufferedReader(new InputStreamReader(new URL(aadress).openStream()));
		String rida=br.readLine();
		int loendur=0;
		int summa=0;
		int maks=0;
		int min=300;
		int y1=20;			
		int ylekesk=0;
		int allakesk=0;
		while(rida!=null){
			loendur=loendur+1;
			y1=y1+15;
			g.drawString(rida, 60, y1);//pikkused
			g.drawLine(100,y1,Integer.parseInt(rida),y1);
			summa+=Integer.parseInt(rida);
			int arv1 = Integer.parseInt(rida);
			int arv2 = Integer.parseInt(rida);
			for(int i=0; i<arv1; i++){
				if(arv1>maks){
					maks=arv1;
				}
			}
			for(int i=0; i<arv2; i++){
				if(arv2<min){
					min=arv2;
				}
			}
            //Üle ja alla keskmiste kogus
			int arv =Integer.parseInt(rida);
			if(arv > aritmeetiline()){
			    ylekesk=ylekesk + 1;
		    } else {
		        allakesk = allakesk + 1; 
		    }
			rida=br.readLine();
		}
		
		System.out.println("Aritmeetiline keskmine on: "+aritmeetiline());
		System.out.println("Üle aritmeetilise keskmise on pikkuseid: "+ylekesk);
		System.out.println("Alla aritmeetilise keskmise on pikkuseid: "+allakesk);

        int ymAritm= (int) Math.round(aritmeetiline());
	    g.setColor(Color.RED); //Aritmeetiline keskmine
		g.drawLine(ymAritm,250,ymAritm,20);		
		System.out.println("Maksimum pikkus on: " +maks);
		System.out.println("Miinimum pikkus on: " +min);
		System.out.println("Standardhälve on: "+standardHalve());
		
		g.setColor(Color.GREEN);
		int ymHalve = (int)Math.round(standardHalve());
		int vah1= ymAritm - ymHalve;
		g.drawLine(vah1,250,vah1,20);
		int vah2= ymAritm + ymHalve;
		g.drawLine(vah2,250,vah2,20);
		int vah3= vah1 - ymHalve;
		g.drawLine(vah3,250,vah3,20);
		int vah4= vah2 + ymHalve;
		g.drawLine(vah4,250,vah4,20);
		br.close();
		
		ImageIO.write(bi, "png", new File("Kordamine1.png"));
	}
	
	public static double standardHalve() throws Exception{
		String aadress="http://www.tlu.ee/~ojagre/pikkused.txt";
		BufferedReader br=new BufferedReader(new InputStreamReader(new URL(aadress).openStream()));
		String rida=br.readLine();
		int loendur=0;
		int summa=0;
		double halve=0;
		int aritm=0;
		double hSumma=0;
		double sHalve=0;
		while(rida!=null){
			loendur=loendur+1;
			summa+=Integer.parseInt(rida);
			aritm=summa/loendur;
			halve= Math.pow((Integer.parseInt(rida)- aritm),2);
			hSumma = hSumma + halve;
			rida=br.readLine();
		}
		sHalve= Math.sqrt(hSumma/loendur);
		br.close();
		return sHalve;
	}
	public static double aritmeetiline() throws Exception{
		String aadress="http://www.tlu.ee/~ojagre/pikkused.txt";
		BufferedReader br=new BufferedReader(new InputStreamReader(new URL(aadress).openStream()));
		String rida=br.readLine();
		int loendur=0;
		int summa=0;
		double aritm=0;
		while(rida!=null){
			loendur=loendur+1;
			summa+=Integer.parseInt(rida);
			rida=br.readLine();
		}			
		aritm=summa * 1.0/loendur;
		br.close();
		return aritm;
	}
}


/*
Aritmeetiline keskmine on: 173.92857142857142
Üle aritmeetilise keskmise on pikkuseid: 7
Alla aritmeetilise keskmise on pikkuseid: 7
Maksimum pikkus on: 193
Miinimum pikkus on: 154
Standardhälve on: 10.319883720275147
*/