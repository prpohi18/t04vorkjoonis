import java.net.*;
import java.io.*;

public class Vork1{
	int Komassidesumma=0;
	int Kamassidesumma=0;
	int koerteArv=0;
	int kassideArv=0;
	
	public void andmed() throws Exception {
		String aadress="http://www.tlu.ee/~rihon/loomad.txt";
		BufferedReader br= new BufferedReader(new InputStreamReader(new URL(aadress).openStream()));
		String rida= br.readLine();
		if(!rida.startsWith("liik")){
			System.out.println("sobiva pealkirjata fail");
			return;
		}
		rida=br.readLine();
		int kassideMassideSumma=0;
		int koerteMassideSumma=0;
		while(rida!=null){
			//System.out.println(rida);
			String[] m=rida.split(",");
			if(m[0].equals("kass")){
				kassidemassidesumma(Integer.parseInt(m[1]));
			}
			if(m[0].equals("koer")){
				koertemassidesumma(Integer.parseInt(m[1]));
			}
			rida=br.readLine();
		}
	}
	
	public int koertemassidesumma(int koer){
		Komassidesumma+=koer;
		koerteArv+=1;
		return Komassidesumma;
	}
	
	public int kassidemassidesumma(int kass){
		Kamassidesumma+=kass;
		kassideArv+=1;
		return Kamassidesumma;
	}
	
	public String vordlus(){
		String vastus="Andmed puuduvad";
		if (Komassidesumma>Kamassidesumma){
			vastus=  "Koerte mass on suurem ning nende mass on: "+Komassidesumma;
		}
		if (Kamassidesumma>Komassidesumma){
			vastus=  "Kasside mass on suurem ning nende mass on: "+Kamassidesumma;
		}
		return vastus;
	}
	
}

