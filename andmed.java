import java.net.*;
import java.io.*;

public class andmed{
  public static void main (String[] arg) throws Exception{
    String address="http://www.tlu.ee/~jaagup/andmed/muu/5klass.txt";
    BufferedReader br=new BufferedReader( new InputStreamReader(
      new URL(address).openStream()));
    String rida=br.readLine();
    if(!rida.startsWith("eesnimi")){
      System.out.println("that's correct file");
      return;
    }
    rida=br.readLine();
    int boysamount = 0;
    int girlsamount = 0;
    while(rida!=null){
      System.out.println(rida);
      String[] m=rida.split(",");
      if(m[3].equals("m")){
        boysamount+=1;
      }else{
        girlsamount+=1;
      }
      rida=br.readLine();
    }
    System.out.println("Poisse klassis: "+boysamount);
    System.out.println("Tüdrukuid klassis: "+girlsamount);
  }
}
