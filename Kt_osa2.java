import java.net.*;
import java.io.*;
import java.lang.Math;

public class Kt_osa2 {
  public static void main(String[] args) throws Exception {
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
    double rea_hälve=0;
    double kokku_hälve=0;
    double hälve=0;
    

    while(rida!=null){
      count+=1;
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

    BufferedReader brr=new BufferedReader(new InputStreamReader(
      new URL(aadress).openStream()
    ));
    String Rida=brr.readLine();

    while(Rida!=null){
      rea_hälve=(Integer.parseInt(Rida)-keskmine)*(Integer.parseInt(Rida)-keskmine);
      kokku_hälve+=rea_hälve;
      Rida=brr.readLine();
    }

    hälve=Math.sqrt((kokku_hälve)/(count-1));

    System.out.println("Keskmine on "+keskmine);
    System.out.println("Maksimum: "+maks+" ja minimum: "+min);
    System.out.println("Hälve: "+hälve);
    br.close();
  }
}