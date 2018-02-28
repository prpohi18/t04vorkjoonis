
package ee.tlu.sergei.kodutoo4;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Loomad{
	protected static List<Integer> koerMassidList = new ArrayList<Integer>();
	protected static List<Integer> koerKorgusedList = new ArrayList<Integer>();
	protected static List<Integer> kassMassidList = new ArrayList<Integer>();
	protected static List<Integer> kassKorgusedList = new ArrayList<Integer>();

	public int koeradListi(int mass, int korgus){
		koerMassidList.add(mass);
		koerKorgusedList.add(korgus);
		return 0;
	}

	public int kassidListi(int mass, int korgus){
		kassMassidList.add(mass);
		kassKorgusedList.add(korgus);
		return 0;
	}



	public static int[] kassKeskMass(){
		int massid = 0;
		int korgused = 0;
		for(int i=0; i<kassMassidList.size(); i++){
			massid += kassMassidList.get(i);
			korgused += kassKorgusedList.get(i);
		}
		int[] kassKeskMass = {massid/kassMassidList.size(), korgused/kassKorgusedList.size()};
		return kassKeskMass;
	}

	public static int[] koerKeskMass(){
		int massid = 0;
		int korgused = 0;
		for(int i=0; i<koerMassidList.size(); i++){
			massid += koerMassidList.get(i);
			korgused += koerKorgusedList.get(i);
		}
		int[] koerteKeskmised = {massid/koerMassidList.size(), korgused/koerKorgusedList.size()};
		return koerteKeskmised;
	}

	public static void faili(){
		try{
			PrintWriter pw = new PrintWriter(new FileWriter("kassid.txt"));

			pw.println("liik,mass,korgus");
			for(int i=0; i<kassMassidList.size(); i++){
				pw.println("kass," + kassMassidList.get(i) + "," + kassKorgusedList.get(i));
			}
			int[] kass = kassKeskMass();
			pw.println("\nKasside keskmine mass: " + kass[0]);
			pw.println("Kasside keskmine kõrgus: " + kass[1]);
			pw.close();


			pw = new PrintWriter(new FileWriter("koerad.txt"));
			
			pw.println("liik,mass,korgus");
			for(int k=0; k<koerMassidList.size(); k++){
				pw.println("koer," + koerMassidList.get(k) + "," + koerKorgusedList.get(k));
			}
			int[] koer = koerKeskMass();
			pw.println("\nKoerte keskmine mass: " + koer[0]);
			pw.println("Koerte keskmine kõrgus: " + koer[1]);
			pw.close();

		} catch(Exception ex){
			System.out.println(ex);
		}
	}
        @Override
        public String toString(){
            return "Koerte suurim mass on: " + Collections.max(koerMassidList) +
		"\nKoerte suurim kõrgus on: " + Collections.max(koerKorgusedList) +
		"\nKoerte vähim mass on: " + Collections.min(koerMassidList) + 
		"\nKoerte vähim kõrgus on: " + Collections.min(koerKorgusedList) + 
		"\nKasside suurim mass on: " + Collections.max(kassMassidList) + 
		"\nKasside suurim kõrgus on: " + Collections.max(kassKorgusedList) + 
		"\nKasside vähim mass on: " + Collections.min(kassMassidList) + 
		"\nKasside vähim kõrgus on: " + Collections.min(kassKorgusedList);
        }
        
}