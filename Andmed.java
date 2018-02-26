import java.io.*;
import java.util.*;

public class Andmed{
	ArrayList<Integer> data=new ArrayList<Integer>();
	double arv1;
	double arv2;
	String suurus1;
	String suurus2;
	String sugu;
	
	public double keskmine(ArrayList<Integer> data){
		int summa=0;
		int loendur=0;
		for(int i=0; i<data.size(); i++){
			summa+=data.get(i);
			loendur+=1;
		}
		double keskmine=(double) summa/loendur;
		return keskmine;
	}
	
	public double mediaan(ArrayList<Integer> data){
		Collections.sort(data);
		if(data.size()%2==1){
			int keskmiseNr=data.size()/2;
			double mediaan=data.get(keskmiseNr);
			return mediaan;
		}else{
			int keskmiseNr1=data.size()/2-1;
			int keskmiseNr2=keskmiseNr1+1;
			double summa=data.get(keskmiseNr1)+data.get(keskmiseNr2);
			double mediaan=summa/2;
			return mediaan;
		}
	}
	public String esimeneMituProtsentiSuurem(double arv1, double arv2, String sugu, String suurus1, String suurus2){
		double vahe=arv1-arv2;
		double protsent=100*vahe/arv2;
		String lause=sugu+ " " +suurus1+ " on " +suurus2+ " "  +protsent+ " protsenti suurem.";
		return lause;
	}
	
	public String teineMituProtsentiSuurem(double arv1, double arv2, String sugu, String suurus1, String suurus2){
		double vahe=arv2-arv1;
		double protsent=100*vahe/arv1;
		String lause=sugu+ " " +suurus1+ " on " +suurus2+ " "  +protsent+ " protsenti suurem.";
		return lause;
	}
	
	public String esimeneJaTeineV6rdsed(double arv1, double arv2, String sugu, String suurus1, String suurus2){
		String lause=sugu+ " " +suurus1+ " ja " +suurus2+ " on v6rdsed.";
		return lause;
	}
}