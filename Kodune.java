import java.awt.image.*;
import javax.imageio.*;
import java.awt.*;
import java.awt.image.*;
import java.net.*;
import java.io.*;
import java.util.List;
import java.util.*;

public class Kodune{
  public static void main (String[] arg)throws Exception{
    int maxArea = 0, maxPopulation = 0, minArea = 0, minPopulation = 0, yTelg = 20, maxValue = 600000,
    canvasValue = 600;
    String maxAreaPlace = "", maxPopulationPlace = "", minAreaPlace = "", minPopulationPlace = "";
    BufferedImage bi=new BufferedImage(600, 600, BufferedImage.TYPE_INT_RGB);
		Graphics g=bi.createGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 600, 600);
    String aadress="http://www.tlu.ee/~jaagup/andmed/muu/maakonnad2012.txt";
    BufferedReader br=new BufferedReader(new InputStreamReader(
    new URL(aadress).openStream()
    ));
    String rida=br.readLine();
    ArrayList<Integer> population = new ArrayList<Integer>();
    ArrayList<Integer> area = new ArrayList<Integer>();
    ArrayList<String> places = new ArrayList<String>();
    rida=br.readLine();
    while(rida!=null){
      g.setColor(Color.black);
      g.drawString("rahvaarv", 5, 15);
      g.setColor(Color.red);
      g.drawString("pindala", 5, 30);
      String[] m=rida.split(",");
      if (m[0] == "maakonnanimi"){
  
      }
      if (m[0] != "maakonnanimi" ){
        places.add(m[0]);
        population.add(Integer.parseInt(m[1]));
        area.add(Integer.parseInt(m[2]));
        g.setColor(Color.black);
        g.fillRect(yTelg, 600-Integer.parseInt(m[1])/1000, 5, 5);
        g.setColor(Color.red);
        g.fillRect(yTelg, 600-Integer.parseInt(m[2])/50, 5, 5);
        if(Integer.parseInt(m[1]) > maxPopulation){
          maxPopulation = Integer.parseInt(m[1]);
          maxPopulationPlace = m[0];
        }
        if(Integer.parseInt(m[2]) > maxArea){
          maxArea = Integer.parseInt(m[2]);
          maxAreaPlace = m[0];
        }
        yTelg += 40;
        rida = br.readLine();
      }
    }
    g.setColor(Color.blue);
    g.drawLine(0, 48, 600, 48);
    g.drawString("kõige suurem rahvaarv(" + maxPopulation + ")", 300, 48);
    g.setColor(Color.cyan);
    g.drawLine(0, 504, 600, 504);
    g.drawString("kõige suurem pindala(" + maxArea + ")", 300, 504);
    System.out.println("Kõike suurema populatsiooniga on "+ maxPopulationPlace + "ja selle rahvaarv on " + maxPopulation);
    System.out.println("Kõike suurema pindalaga on "+ maxAreaPlace + "ja selle pindala on " + maxArea);
    
    ImageIO.write(bi, "png", new File("kohad.png"));
  }
}