import java.util.Scanner;
import java.net.*;
import java.io.*;
import java.lang.Math;
import java.awt.*;


public class kt{
	public static void main(String[] arg) throws Exception{
		String aadress="http://www.tlu.ee/~basshead/pikkused.txt";
		BufferedReader br=new BufferedReader(new InputStreamReader(
			new URL(aadress).openStream()
		));
		String rida=br.readLine();
	
		int counter=0;
		int sum= 0;
		double avarage= 0;
		double max = 0;
		double min = 10000;


		while(rida !=null){
			System.out.println(++counter+ ". "+rida);

			if (Integer.parseInt(rida)>max) { 
				max=Integer.parseInt(rida);
			}
			if (Integer.parseInt(rida)<min) { 
				min=Integer.parseInt(rida);
			}
			sum+=Integer.parseInt(rida); 
			rida=br.readLine();
		}
		
		System.out.println("Pikkuste summa: "+sum); 
		avarage = sum*1.0/counter; 
		System.out.println("Kekmine on : "+avarage); 
		
		double squreroot = Math.sqrt(avarage); 
        System.out.println("Hälve on : "+ squreroot);
		
		System.out.println("Pikkuste suurim: "+max);
		
		System.out.println("Pikkuste vähim: "+min);
		
		br.close();
		
	}
}

/*
1. 169
2. 158
3. 147
4. 136
5. 125
6. 145
7. 196
8. 187
9. 198
10. 156
11. 123
12. 108
13. 109
14. 137
Pikkuste summa: 2094
Kekmine on : 149.57142857142858
Hälve on : 12.229939843328282
Pikkuste suurim: 198.0
Pikkuste vähim: 108.0

*/