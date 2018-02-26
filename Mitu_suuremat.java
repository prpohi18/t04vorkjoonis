import java.io.*;
import java.util.*;

public class Mitu_suuremat{
	public static void main(String[] args) throws IOException{
		Random randomGenerator = new Random();
		BufferedReader sisse=new BufferedReader(new InputStreamReader(System.in));
		
		int loendur=0;
		
		System.out.println("Arvuti, palun vali üks juhuslik number 0-100.");
		int randomInt = randomGenerator.nextInt(101);
		
		System.out.println("Mitu arvu sisestate?");
		String Mitu=sisse.readLine();
		int mitu=Integer.parseInt(Mitu);
		
		for(int i=0; i<mitu; i++){
			System.out.println("Sisesta arv (0-100):");
			String Arv=sisse.readLine();
			int arv=Integer.parseInt(Arv);
			if(randomInt<arv){
				loendur+=1;
			}
		}
		
		if(loendur==0){
			System.out.println("Arvuti juhuslikult valitud arvust ei pakkunud sa yhtegi suuremat arvu.");
		}else if(loendur==1){
			System.out.println("Arvuti juhuslikult valitud arvust pakkusid sa 1 suurema arvu.");
		}else if(loendur>1){
			System.out.println("Arvuti juhuslikult valitud arvust pakkusid sa " +loendur+ " suuremat arvu.");
		}
	}
}