import java.net.*;
import java.io.*;

public class Andmed{
	public static void main(String[] arg) throws Exception{
		String address="http://www.tlu.ee/~jaagup/andmed/muu/5klass.txt";
		BufferedReader br=new BufferedReader(new InputStreamReader(new URL(address).openStream()));
		String rida=br.readLine();
		if(!rida.startsWith("eesnimi")){
			System.out.println("Õige fail");
		}
		rida=br.readLine();
		int tydrukud = 0;
		int poisid=0;
		while(rida!=null){
			System.out.println(rida);
			String[] m=rida.split(",");
			if(m[3].equals("n")){
				tydrukud+=1;
			}else{
				poisid+=1;
			}
			rida=br.readLine();
		}
		System.out.println("Klassis on "+tydrukud+" tüdrukut");
		System.out.println("Klassis on "+poisid+" poissi");
	}
}