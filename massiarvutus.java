import java.awt.image.*;
import javax.imageio.*;
import java.awt.*;
import java.io.*;
import java.net.*;

public class massiarvutus{
	public static void main(String[] arg) throws Exception{
		String address="http://www.tlu.ee/~jaagup/andmed/muu/5klass.txt";
		BufferedReader br=new BufferedReader(new InputStreamReader(new URL(address).openStream()));
		String rida=br.readLine();
		if(!rida.startsWith("mass")){
			System.out.println("sobiva pealkirjaga fail");
			return;
		}
		rida=br.readLine();
		int poisidkokku=0;
		int tüdrukudkokku=0;
		int poisidmassidekeskmine=0;
		int tüdrukudmassidekeskmine=0;
		while(rida!=null){
			System.out.println(rida);
			String[] m=rida.split(",");
			if(m[3].equals("m")){
				poisidkokku=poisidkokku+1;
				poisidmassidekeskmine+=Integer.parseInt(m[2]) / poisidkokku;
			}
			rida=br.readLine();
			if(m[3].equals("n")){
				tüdrukudkokku=tüdrukudkokku+1;
				tüdrukudmassidekeskmine+=Integer.parseInt(m[2]) / tüdrukudkokku;
			}
			rida=br.readLine();
		}
		System.out.println("Poisse kokku: "+poisidkokku);
		System.out.println("Tüdrukud kokku: "+tüdrukudkokku);
		System.out.println("Poiste masside keskmine: "+poisidmassidekeskmine);
		System.out.println("Tüdrukute masside keskmine: "+tüdrukudmassidekeskmine);
		if (poisidmassidekeskmine > tüdrukudmassidekeskmine) {
            System.out.println("Poiste keskmine suurem!");
        } else {
            System.out.println("Tüdrukute keskmine suurem!");
        }
	}
}