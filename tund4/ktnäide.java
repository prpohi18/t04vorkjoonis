/*Esimese kt näide

* Sisesta 2 arvu koerte massideks ning kolm arvu kasside massideks. Näita, kummast liigist loomade masside summa on suurem
* Kasside ja koerte andmed on failis http://greeny.cs.tlu.ee/~lahtsten/Programmeerimine/tund4/loomad.txt
Kuva loomade kõrgused ja massid XY-joonisel, tähista liigid eri värvi. Kuva joonisel kummagi liigi keskmine mass ja kõrgus:
Koosta klass arvuliste väärtuste hoidmiseks. Lisa funktsioonid suurima, vähima ja aritmeetilise keskmise väärtuse leidmiseks. Koosta funktsioon tostring()-käsklus nende andmete väljastamiseks.
Loe eelnevast failist koerte ja kasside andmed eraldi eksemplaridesse. Salvesta eksemplaride toString()-käskluste väljundid faili. Salvesta eksemplaride toString()-käskluste väljundid faili.   

*/
import java.util.Scanner;
public class ktnäide{
	public static void main (String[] args){
		String name;
		int koertemass1;
		int koertemass2;
		int kassidemass1;
		int kassidemass2;
		int kassidemass3;
		int koertesumma;
		int kassidesumma;
		
		Scanner input = new Scanner (System.in);
		
		System.out.println("Programm küsib sult kolme kassi massi ja kahe koera massi ning kuvab selle liigi summa, mis on suurem");
		System.out.println("Sisesta kolme kassi massid");
		kassidemass1= input.nextInt();
		kassidemass2= input.nextInt();
		kassidemass3= input.nextInt();
		
		System.out.println("Sisesta kahe koera massid");
		koertemass1= input.nextInt();
		koertemass2= input.nextInt();
		
		input.close();
		
		koertesumma=(koertemass1+koertemass2);
		kassidesumma=(kassidemass1+kassidemass2+kassidemass3);
		
		if (koertesumma>kassidesumma){
			System.out.println("Koerte summa on suurem ja nende summa on: " + koertesumma);
		} else{
			if (kassidesumma==koertesumma){
				System.out.println("Kasside ja koerte summa on võrdne ja summa on: " + kassidesumma);
			} else{
			System.out.println("Kasside summa on suurem ja nende summa on: " + kassidesumma);
		}
		}
		
		
		
		
	}
	
}
		
		
