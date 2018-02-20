import java.net.*;
import java.io.*;
import java.lang.Math;
  

public class Kt_osa1 {
  public static void main(String[] arg) throws Exception {
    String aadress="http://www.tlu.ee/~jaagup/veeb1/pikkused.txt";
    BufferedReader br=new BufferedReader(new InputStreamReader(
      new URL(aadress).openStream()
    ));
    String rida=br.readLine();

    int count=0;
    int summa=0;
    int maks=0;
    int min=10000;
    double keskmine=0;

    while(rida!=null){
      count+=1;
      //Trükkida arvude ette reanumbrid 
      if (Integer.parseInt(rida)>maks) {
        maks=Integer.parseInt(rida);
      }
      if (Integer.parseInt(rida)<min) {
        min=Integer.parseInt(rida);
      }
      summa+=Integer.parseInt(rida);
      rida=br.readLine();
    }
    keskmine = summa*1.0/count;
    //Kuvada arvude summad ja aritmeetiline keskmine
    System.out.println("Keskmine on "+keskmine);
    System.out.println("Maks: "+maks+" ja min: "+min);
    br.close();
  }
}


