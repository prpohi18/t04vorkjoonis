import java.util.Scanner;
import java.net.*;
import java.io.*;
import java.lang.Math;
import java.awt.*;


public class kt{
	public static void main(String[] arg) throws Exception{
		String aadress="http://www.tlu.ee/~piksar/pikkused.txt";
		BufferedReader br=new BufferedReader(new InputStreamReader(
			new URL(aadress).openStream()
		));
		String rida=br.readLine();
	
		int loendur=0;
		int summa= 0;
		double keskmine= 0;
		double max = 0;
		double min = 10000;


		while(rida !=null){
			System.out.println(++loendur+ ". "+rida); //reanumbrid

			if (Integer.parseInt(rida)>max) { //max
				max=Integer.parseInt(rida);
			}
			if (Integer.parseInt(rida)<min) { //min
				min=Integer.parseInt(rida);
			}
			summa+=Integer.parseInt(rida); //summa
			rida=br.readLine();
		}
		
		System.out.println("Pikkuste summa: "+summa); //summa
		
		keskmine = summa*1.0/loendur; //keskmine
		System.out.println("Keskmine summa: "+keskmine); 
		
		double ruutjuur = Math.sqrt(keskmine); //keskmise ruutjuur
        System.out.println("Hälve: "+ ruutjuur);
		
		System.out.println("Pikkuste suurim: "+max);
		
		System.out.println("Pikkuste vähim: "+min);
		
		br.close();
		
	}
}

/*

1. 165
2. 163
3. 185
4. 167
5. 175
6. 179
7. 158
8. 168
9. 142
10. 163
11. 185
Pikkuste summa: 1850
Keskmine summa: 168.1818181818182
Hälve: 12.96849328880646
Pikkuste suurim: 185.0
Pikkuste vähim: 142.0

*/