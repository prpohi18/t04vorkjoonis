import java.net.*;
import java.io.*;
import java.util.*;
public class Teisip2{
  public static void main(String[] args) throws Exception{
    Float summa = 0.0f;
    Float summa1 = 0.0f;
    int i = 0;
    float keskmine;
    List<Float> myList = new ArrayList<>();
    //koostan veebilehest stringi
    String aadress = "http://www.tlu.ee/~jaagup/veeb1/pikkused.txt";
    //teen buffereaderi, mis avab aadressi
    BufferedReader br = new BufferedReader(new InputStreamReader(new URL(aadress).openStream()));
    //koostan stringi rida ja hakkan sealt ridu lugema
    String rida = br.readLine();
    //nii kaua kuni rida ei ole null prindib konsool read ja bufferedreader loeb igat järgmistrida
    while(rida!=null){
      i++;
      Float arv = Float.parseFloat(rida);
      rida = br.readLine();
      System.out.println("1. "+arv);
      summa+=arv;
      myList.add(arv);
    }
    keskmine = summa / i;

    for(int n = 0; n < myList.size(); n++){
      float uus = Math.abs(myList.get(n)-keskmine);
      uus = uus * uus;
      summa1 += uus;

    }
    System.out.println("Standardhäve on:"+Math.sqrt(summa1/myList.size()));


    System.out.println("Aritmeetiline keskmine on "+keskmine);
    br.close();
}
}
