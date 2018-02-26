import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.lang.*;

public class Teisip3{
  public static void main(String[] args) throws Exception{
//teen graafika
    BufferedImage bi = new BufferedImage(300, 300, BufferedImage.TYPE_INT_RGB);
    Graphics g = bi.createGraphics();
    g.setColor(Color.WHITE);
    g.fillRect(0,0,300,300); //vasakult, ülalt, x, y
//võtan andmed
    String aadress = "http://www.tlu.ee/~jaagup/veeb1/pikkused.txt";
    BufferedReader br = new BufferedReader(new InputStreamReader(new URL(aadress).openStream()));
    String rida = br.readLine();
//väljastan andmed
    float keskmine = 0;
    int counter = 0;
    while(rida!=null){
      counter ++;
      keskmine = keskmine + Integer.parseInt(rida);
      rida = br.readLine();
    }
//    br.close();
    BufferedReader br1=new BufferedReader(new InputStreamReader(new URL(aadress).openStream()));
    keskmine = keskmine / counter;
//joonistan aritmeetlilise keskmise joone
    g.setColor(Color.BLACK);
    g.drawLine(0, 300-Math.round(keskmine),300,300-Math.round(keskmine));
//koostan teise bufferreaderi ja loop'i, kust tulevad kõik suurused
    int muutuja = 15;
    double halve = 0;
    double summa = 0;
    int laius = 300 / counter;


    for(int n = 0; n < counter; n++){

      rida = br1.readLine();
      laius = laius + muutuja;
      g.setColor(Color.RED);
      g.drawLine(laius, 300, laius, 300 - Integer.parseInt(rida));
      //halve = halve + Math.abs(Integer.parseInt(rida)-keskmine);
      //halve = Math.sqrt(halve);
      halve = Math.abs(keskmine - Integer.parseInt(rida));
      halve = (halve * halve);
      summa += halve;

}
    summa = Math.sqrt(summa/16);

    g.setColor(Color.BLUE);
    g.drawLine(0, 300-Math.round(keskmine)-(int)summa, 300, 300 - Math.round(keskmine)-(int)summa);
    g.drawLine(0, 300-Math.round(keskmine)+(int)summa, 300, 300 - Math.round(keskmine)+(int)summa);
    g.setColor(Color.YELLOW);
    g.drawLine(0, 300-Math.round(keskmine)-2*(int)summa, 300, 300 - Math.round(keskmine)-2*(int)summa);
    g.drawLine(0, 300-Math.round(keskmine)+2*(int)summa, 300, 300 - Math.round(keskmine)+2*(int)summa);



br1.close();
ImageIO.write(bi,"png", new File("graafik.png"));
  }
}
