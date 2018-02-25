import java.util.*;
import java.io.*;
import java.net.*;
import java.io.FileWriter;


public class koeradjakassid{
		protected static List<Integer> koertemassidList = new ArrayList<Integer>();
		protected static List<Integer> koertekorgusedList = new ArrayList<Integer>();
		protected static List<Integer> kassidemassidList = new ArrayList<Integer>();
		protected static List<Integer> kassidekorgusedList = new ArrayList<Integer>();
		protected static List<String> koeradList = new ArrayList<String>();
		protected static List<String> kassidList = new ArrayList<String>();
		
		public static void main(String[] arg) throws Exception{
		String aadress="http://greeny.cs.tlu.ee/~lahtsten/Programmeerimine/tund4/loomad.txt";
		BufferedReader br=new BufferedReader(new InputStreamReader(
		new URL(aadress).openStream()));
		String rida=br.readLine();
		if(!rida.startsWith("liik")){
			System.out.println("sobiva pealkirja fail");
			return;
		}
		rida=br.readLine();
		int kassidemassid=0;
		int koertemassid=0;
		int kassidekorgused=0;
		int koertekorgused=0;
		int kassidemassidesumma=0;
		int koertemassidesumma=0;
		int kassidekorgustesumma=0;
		int koertekorgustesumma=0;
		int koertekorgustekeskmine=0;
		int koertemassidekeskmine=0;
		int kassidekorgustekeskmine=0;
		int kassidemassidekeskmine=0;
		String kassid;
		String koerad;
		while (rida!=null){
			String[] m=rida.split(",");
			if(m[0].equals("kass")){
				kassid= (m[0]);
				kassidemassid=Integer.parseInt(m[1]);
				kassidekorgused=Integer.parseInt(m[2]);
				kassidemassidesumma+= Integer.parseInt(m[1]);
				kassidekorgustesumma+= Integer.parseInt(m[2]);
				kassidemassidList.add(kassidemassid);
				kassidekorgusedList.add(kassidekorgused);
				kassidList.add(kassid);
			
			} else{
				if(m[0].equals("koer")){
					koerad = (m[0]);
					koertemassid=Integer.parseInt(m[1]);
					koertekorgused=Integer.parseInt(m[2]);
					koertemassidesumma += Integer.parseInt(m[1]);
					koertekorgustesumma += Integer.parseInt(m[2]);
					koertemassidList.add(koertemassid);
					koertekorgusedList.add(koertekorgused);
					koeradList.add(koerad);
				}
		}
		rida=br.readLine();
		
		}
		koertekorgustekeskmine =  koertekorgustesumma/8;
		koertemassidekeskmine = koertemassidesumma/8;
		kassidemassidekeskmine = kassidemassidesumma/7;
		kassidekorgustekeskmine = kassidekorgustesumma/7;
		
		System.out.println(kassidList);
		System.out.println(koeradList);
		System.out.println(kassidemassidList);
		System.out.println(kassidekorgusedList);
		System.out.println(koertemassidList);
		System.out.println(koertekorgusedList);
		System.out.println(koertekorgustesumma);
		System.out.println(koertekorgustekeskmine);
		System.out.println(koertemassidekeskmine);
		System.out.println(kassidekorgustekeskmine);
		System.out.println(kassidemassidekeskmine);
		
		/*FileWriter writer = new FileWriter("output.txt"); 
		for(String str: kassidList) {
			writer.write(str + "\n");
		}
		for(int str2: kassidemassidList){
			writer.write(str2);
		}
		writer.close();
*/		


		
		PrintWriter pw = new PrintWriter(new FileWriter("kassid.txt"));
		pw.println("kass," + kassidemassidList.get(0) + "," + kassidekorgusedList.get(0));
		pw.println("kass," + kassidemassidList.get(1) + "," + kassidekorgusedList.get(1));
		pw.println("kass," + kassidemassidList.get(2) + "," + kassidekorgusedList.get(2));
		pw.println("kass," + kassidemassidList.get(3) + "," + kassidekorgusedList.get(3));
		pw.println("kass," + kassidemassidList.get(4) + "," + kassidekorgusedList.get(4));
		pw.println("kass," + kassidemassidList.get(5) + "," + kassidekorgusedList.get(5));
		pw.println("kass," + kassidemassidList.get(6) + "," + kassidekorgusedList.get(6));
		pw.println("Kasside masside keskmine on: " + kassidemassidekeskmine);
		pw.println("Kasside korguste keskmine on: " + kassidekorgustekeskmine);
		
		
		pw.close();
		
		pw = new PrintWriter(new FileWriter("koerad.txt"));
		
		pw.println("koer," + koertemassidList.get(0) + "," + koertekorgusedList.get(0));
		pw.println("koer," + koertemassidList.get(1) + "," + koertekorgusedList.get(1));
		pw.println("koer," + koertemassidList.get(2) + "," + koertekorgusedList.get(2));
		pw.println("koer," + koertemassidList.get(3) + "," + koertekorgusedList.get(3));
		pw.println("koer," + koertemassidList.get(4) + "," + koertekorgusedList.get(4));
		pw.println("koer," + koertemassidList.get(5) + "," + koertekorgusedList.get(5));
		pw.println("koer," + koertemassidList.get(6) + "," + koertekorgusedList.get(6));
		pw.println("koer," + koertemassidList.get(7) + "," + koertekorgusedList.get(7));
		pw.println("Koerte masside keskmine on: " + koertemassidekeskmine);
		pw.println("Koerte korguste keskmine on: " + koertekorgustekeskmine);
		
		pw.close();
		
		
		
		
		
		/*System.out.println("Kasside masside keskmine on: " + kassidemassidekeskmine);
		System.out.println("Koerte masside keskmine on: " + koertemassidekeskmine);
		System.out.println("Kasside kõrguste keskmine on : " + kassidekorgustekeskmine);
		System.out.println("Koerte kõrguste keskmine on: " + koertekorgustekeskmine);
		*/
		
		
	 
		
	
	
		}
	
		
}	
	
	