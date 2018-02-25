import java.net.*;
import java.io.*;


public class Vork1{
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
		int kassidemassidesumma=0;
		int koertemassidesumma=0;
		int kassidekorgustesumma=0;
		int koertekorgustesumma=0;
		while (rida!=null){
			System.out.println(rida);
			String[] m=rida.split(",");
			if(m[0].equals("kass")){
				kassidemassidesumma+=Integer.parseInt(m[1]);
				kassidekorgustesumma+=Integer.parseInt(m[2]);
			} else{
				if(m[0].equals("koer")){
					koertemassidesumma+=Integer.parseInt(m[1]);
					koertekorgustesumma+=Integer.parseInt(m[2]);
				}
		}
		
		rida=br.readLine();
		}
		public void keskmised(){
		int kassidemassidekeskmine = kassidemassidesumma/7;
		int koertemassidekeskmine = koertemassidesumma/8;
		int koertekorgustekeskmine = koertekorgustesumma/8;
		int kassidekorgustekeskmine = kassidekorgustesumma/7;
		
		}
		
		
		System.out.println("Kasside masside keskmine on: " + kassidemassidekeskmine);
		System.out.println("Koerte masside keskmine on: " + koertemassidekeskmine);
		System.out.println("Kasside kõrguste keskmine on : " + kassidekorgustekeskmine);
		System.out.println("Koerte kõrguste keskmine on: " + koertekorgustekeskmine);
		
		
	protected static List<Integer> koertemassid = new ArrayList<Integer>();
	protected static List<Integer> koertekorgused = new ArrayList<Integer>();
	protected static List<Integer> kassidemassid = new ArrayList<Integer>();
	protected static List<Integer> kassidekorgused = new ArrayList<Integer>();
		
		
	}
}

		