import java.util.Scanner;
import java.net.*;
import java.io.*;
import java.lang.Math;
import java.awt.*;





public class Kodutöö4{
	public static void main(String[] arg) throws Exception{
		String aadress="http://www.tlu.ee/~jaagup/veeb1/pikkused.txt";
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
		System.out.println("Keskmine on: "+keskmine); 
		double ruutjuur = Math.sqrt(keskmine); //keskmise ruutjuur
		double ruutjuur2 = ruutjuur*2;
        System.out.println("Hälve: "+ ruutjuur);
		System.out.println("Hälve2: "+ ruutjuur2);
		System.out.println("Pikkuste suurim: "+max);
		System.out.println("Pikkuste vähim: "+min);
		br.close();
	}
}
/*
1. 165
2. 163
3. 171
4. 165
5. 178
6. 187
7. 164
8. 173
9. 181
10. 165
11. 183
12. 172
13. 159
14. 163
15. 167
16. 163
Pikkuste summa: 2719
Keskmine on: 169.9375
Hälve: 13.03600782448369
Hälve2: 26.07201564896738
Pikkuste suurim: 187.0
Pikkuste vähim: 159.0
*/