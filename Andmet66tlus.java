import java.io.*;
import java.net.*;
import java.util.*;

class Andmet66tlus{
	public static void main(String args[])  throws Exception{
		BufferedReader sisse=new BufferedReader(new InputStreamReader(System.in));
		
		ArrayList<Integer> meeste_pikkused=new ArrayList<Integer>();
		ArrayList<Integer> meeste_massid=new ArrayList<Integer>();
		ArrayList<Integer> naiste_pikkused=new ArrayList<Integer>();
		ArrayList<Integer> naiste_massid=new ArrayList<Integer>();
		ArrayList<Integer> klassi_pikkused=new ArrayList<Integer>();
		ArrayList<Integer> klassi_massid=new ArrayList<Integer>();
		
		Andmed objekt1=new Andmed();
		
		System.out.println("Millise soo andmeid soovite võrrelda (mehed/naised/m6lemad)?");
		String sugu=sisse.readLine();
		
		String aadress="http://www.tlu.ee/~jaagup/andmed/muu/5klass.txt";
		BufferedReader br=new BufferedReader (new InputStreamReader(
			new URL(aadress).openStream()));
		String rida=br.readLine();
		rida=br.readLine();
		
		if(sugu.equals("mehed")){
			while(rida!=null){
				String[] m=rida.split(",");
				if(m[3].equals("m")){
					meeste_pikkused.add(Integer.parseInt(m[1]));
					meeste_massid.add(Integer.parseInt(m[2]));
				}
				rida=br.readLine();
			}
			double meeste_keskmine_pikkus=objekt1.keskmine(meeste_pikkused);
			double meeste_mediaanpikkus=objekt1.mediaan(meeste_pikkused);
			double meeste_keskmine_mass=objekt1.keskmine(meeste_massid);
			double meeste_mediaanmass=objekt1.mediaan(meeste_massid);
			
			System.out.println("Meeste keskmine pikkus on " +meeste_keskmine_pikkus+ "cm.");
			System.out.println("Meeste mediaanpikkus on " +meeste_mediaanpikkus+ "cm.");
			if(meeste_keskmine_pikkus>meeste_mediaanpikkus){
				System.out.println(objekt1.esimeneMituProtsentiSuurem(meeste_keskmine_pikkus, meeste_mediaanpikkus, 
				"Meeste", "keskmine pikkus", "mediaanpikkusest"));
			}
			if(meeste_keskmine_pikkus<meeste_mediaanpikkus){
				System.out.println(objekt1.teineMituProtsentiSuurem(meeste_keskmine_pikkus, meeste_mediaanpikkus, 
				"Meeste", "mediaanpikkus", "keskmisest pikkusest"));
			}
			if(meeste_keskmine_pikkus==meeste_mediaanpikkus){
				System.out.println(objekt1.esimeneJaTeineV6rdsed(meeste_keskmine_pikkus, meeste_mediaanpikkus, 
				"Meeste", "mediaanpikkus", "keskmisest pikkusest"));
			}
			
			System.out.println("Meeste keskmine mass on " +meeste_keskmine_mass+ "kg.");
			System.out.println("Meeste mediaanmass on " +meeste_mediaanmass+ "kg.");
			if(meeste_keskmine_mass>meeste_mediaanmass){
				System.out.println(objekt1.esimeneMituProtsentiSuurem(meeste_keskmine_mass, meeste_mediaanmass, 
				"Meeste", "keskmine mass", "mediaanmassist"));
			}
			if(meeste_keskmine_mass<meeste_mediaanmass){
				System.out.println(objekt1.teineMituProtsentiSuurem(meeste_keskmine_mass, meeste_mediaanmass, 
				"Meeste", "mediaanmass", "keskmisest massist"));
			}
			if(meeste_keskmine_mass==meeste_mediaanmass){
				System.out.println(objekt1.esimeneJaTeineV6rdsed(meeste_keskmine_mass, meeste_keskmine_mass, 
				"Meeste", "mediaanmass", "keskmisest massist"));
			}
		}
	
		if(sugu.equals("naised")){
			while(rida!=null){
				String[] m=rida.split(",");
				if(m[3].equals("n")){
					naiste_pikkused.add(Integer.parseInt(m[1]));
					naiste_massid.add(Integer.parseInt(m[2]));
				}
				rida=br.readLine();
			}
			double naiste_keskmine_pikkus=objekt1.keskmine(naiste_pikkused);
			double naiste_mediaanpikkus=objekt1.mediaan(naiste_pikkused);
			double naiste_keskmine_mass=objekt1.keskmine(naiste_massid);
			double naiste_mediaanmass=objekt1.mediaan(naiste_massid);
			
			System.out.println("Naiste keskmine pikkus on " +naiste_keskmine_pikkus+ "cm.");
			System.out.println("Naiste mediaanpikkus on " +naiste_mediaanpikkus+ "cm.");
			if(naiste_keskmine_pikkus>naiste_mediaanpikkus){
				System.out.println(objekt1.esimeneMituProtsentiSuurem(naiste_keskmine_pikkus, naiste_mediaanpikkus, 
				"Naiste", "keskmine pikkus", "mediaanpikkusest"));
			}
			if(naiste_keskmine_pikkus<naiste_mediaanpikkus){
				System.out.println(objekt1.teineMituProtsentiSuurem(naiste_keskmine_pikkus, naiste_mediaanpikkus, 
				"Naiste", "mediaanpikkus", "keskmisest pikkusest"));
			}
			if(naiste_keskmine_pikkus==naiste_mediaanpikkus){
				System.out.println(objekt1.esimeneJaTeineV6rdsed(naiste_keskmine_pikkus, naiste_mediaanpikkus, 
				"Naiste", "mediaanpikkus", "keskmisest pikkusest"));
			}
			
			System.out.println("Naiste keskmine mass on " +naiste_keskmine_mass+ "kg.");
			System.out.println("Naiste mediaanmass on " +naiste_mediaanmass+ "kg.");
			if(naiste_keskmine_mass>naiste_mediaanmass){
				System.out.println(objekt1.esimeneMituProtsentiSuurem(naiste_keskmine_mass, naiste_mediaanmass, 
				"Naiste", "keskmine mass", "mediaanmassist"));
			}
			if(naiste_keskmine_mass<naiste_mediaanmass){
				System.out.println(objekt1.teineMituProtsentiSuurem(naiste_keskmine_mass, naiste_mediaanmass, 
				"Naiste", "mediaanmass", "keskmisest massist"));
			}
			if(naiste_keskmine_mass==naiste_mediaanmass){
				System.out.println(objekt1.esimeneJaTeineV6rdsed(naiste_keskmine_mass, naiste_keskmine_mass, 
				"Naiste", "mediaanmass", "keskmisest massist"));
			}
		}
		
		if(sugu.equals("m6lemad")){
			while(rida!=null){
				String[] m=rida.split(",");
				if(m[3].equals("m") || m[3].equals("n")){
					klassi_pikkused.add(Integer.parseInt(m[1]));
					klassi_massid.add(Integer.parseInt(m[2]));
				}
				rida=br.readLine();
			}
			double klassi_keskmine_pikkus=objekt1.keskmine(klassi_pikkused);
			double klassi_mediaanpikkus=objekt1.mediaan(klassi_pikkused);
			double klassi_keskmine_mass=objekt1.keskmine(klassi_massid);
			double klassi_mediaanmass=objekt1.mediaan(klassi_massid);
			
			System.out.println("Klassi keskmine pikkus on " +klassi_keskmine_pikkus+ "cm.");
			System.out.println("Klassi mediaanpikkus on " +klassi_mediaanpikkus+ "cm.");
			if(klassi_keskmine_pikkus>klassi_mediaanpikkus){
				System.out.println(objekt1.esimeneMituProtsentiSuurem(klassi_keskmine_pikkus, klassi_mediaanpikkus, 
				"Klassi", "keskmine pikkus", "mediaanpikkusest"));
			}
			if(klassi_keskmine_pikkus<klassi_mediaanpikkus){
				System.out.println(objekt1.teineMituProtsentiSuurem(klassi_keskmine_pikkus, klassi_mediaanpikkus, 
				"Klassi", "mediaanpikkus", "keskmisest pikkusest"));
			}
			if(klassi_keskmine_pikkus==klassi_mediaanpikkus){
				System.out.println(objekt1.esimeneJaTeineV6rdsed(klassi_keskmine_pikkus, klassi_mediaanpikkus, 
				"Klassi", "mediaanpikkus", "keskmisest pikkusest"));
			}
			
			System.out.println("Klassi keskmine mass on " +klassi_keskmine_mass+ "kg.");
			System.out.println("Klassi mediaanmass on " +klassi_mediaanmass+ "kg.");
			if(klassi_keskmine_mass>klassi_mediaanmass){
				System.out.println(objekt1.esimeneMituProtsentiSuurem(klassi_keskmine_mass, klassi_mediaanmass, 
				"Klassi", "keskmine mass", "mediaanmassist"));
			}
			if(klassi_keskmine_mass<klassi_mediaanmass){
				System.out.println(objekt1.teineMituProtsentiSuurem(klassi_keskmine_mass, klassi_mediaanmass, 
				"Klassi", "mediaanmass", "keskmisest massist"));
			}
			if(klassi_keskmine_mass==klassi_mediaanmass){
				System.out.println(objekt1.esimeneJaTeineV6rdsed(klassi_keskmine_mass, klassi_keskmine_mass, 
				"Klassi", "mediaanmass", "keskmisest massist"));
			}
		}
	}  
}  