import java.util.*;
import java.io.*;

public class Arvud{
	protected static List<Integer> koertemassidList = new ArrayList<Integer>();
	protected static List<Integer> koertekorgusedList = new ArrayList<Integer>();
	protected static List<Integer> kassidemassidList = new ArrayList<Integer>();
	protected static List<Integer> kassidekorgusedList = new ArrayList<Integer>();

	public int koeradListi(int mass, int korgus){
		koertemassidList.add(mass);
		koertekorgusedList.add(korgus);
		return 0;
	}

	public int kassidListi(int mass, int korgus){
		kassidemassidList.add(mass);
		kassidekorgusedList.add(korgus);
		return 0;
	}

	public static void print(){
		System.out.println(koertemassidList);
		System.out.println(koertekorgusedList);
		System.out.println(kassidemassidList);
		System.out.println(kassidekorgusedList);
	}

	public static void maxMin(){
		System.out.println("Koerte suurim mass on: " + Collections.max(koertemassidList));
		System.out.println("Koerte suurim kõrgus on: " + Collections.max(koertekorgusedList));
		System.out.println("Koerte väikseim mass on: " + Collections.min(koertemassidList));
		System.out.println("Koerte väikseim kõrgus on: " + Collections.min(koertekorgusedList));
		System.out.println("Kasside suurim mass on: " + Collections.max(kassidemassidList));
		System.out.println("Kasside suurim kõrgus on: " + Collections.max(kassidekorgusedList));
		System.out.println("Kasside väikseim mass on: " + Collections.min(kassidemassidList));
		System.out.println("Kasside väikseim kõrgus on: " + Collections.min(kassidekorgusedList));
	}

	public static int[] keskmisedKassid(){
		int massid = 0;
		int korgused = 0;
		for(int i=0; i<kassidemassidList.size(); i++){
			massid += kassidemassidList.get(i);
			korgused += kassidekorgusedList.get(i);
		}
		int[] kassideKeskmised = {massid/kassidemassidList.size(), korgused/kassidekorgusedList.size()};
		return kassideKeskmised;
	}

	public static int[] keskmisedKoerad(){
		int massid = 0;
		int korgused = 0;
		for(int i=0; i<koertemassidList.size(); i++){
			massid += koertemassidList.get(i);
			korgused += koertekorgusedList.get(i);
		}
		int[] koerteKeskmised = {massid/koertemassidList.size(), korgused/koertekorgusedList.size()};
		return koerteKeskmised;
	}

	public static void failideks(){
		try{
			PrintWriter pw = new PrintWriter(new FileWriter("kassid" + ".txt"));

			pw.println("liik,mass,korgus");
			for(int i=0; i<kassidemassidList.size(); i++){
				pw.println("kass," + kassidemassidList.get(i) + "," + kassidekorgusedList.get(i));
			}
			int[] kass = keskmisedKassid();
			pw.println("\nKasside keskmine mass: " + kass[0]);
			pw.println("Kasside keskmine kõrgus: " + kass[1]);
			pw.close();


			pw = new PrintWriter(new FileWriter("koerad" + ".txt"));
			
			pw.println("liik,mass,korgus");
			for(int k=0; k<kassidemassidList.size(); k++){
				pw.println("koer," + koertemassidList.get(k) + "," + koertekorgusedList.get(k));
			}
			int[] koer = keskmisedKoerad();
			pw.println("\nKoerte keskmine mass: " + koer[0]);
			pw.println("Koerte keskmine kõrgus: " + koer[1]);
			pw.close();

		} catch(Exception ex){
			System.out.println(ex);
		}
	}
}