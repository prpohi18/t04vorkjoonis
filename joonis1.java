import java.awt.image.*;
import javax.imageio.*;
import java.awt.*;
import java.net.*;
import java.io.*;
public class joonis1{
  public static void main(String[] arg) throws Exception{
    BufferedImage bi=new BufferedImage(500, 400, BufferedImage.TYPE_INT_RGB);
    Graphics g=bi.createGraphics();
    g.setColor(Color.WHITE);
    g.fillRect(0, 0, 500, 400);
    String address="http://www.tlu.ee/~jaagup/andmed/muu/5klass.txt";
    BufferedReader br=new BufferedReader(new InputStreamReader(
      new URL(address).openStream()));
    String rida=br.readLine();
    rida=br.readLine();
    int firstparam=50;
    int boysamount = 0;
    int girlsamount = 0;
    int boysl=0;
    int girlsl=0;

    while(rida!=null){
      g.drawLine(20, 220, 20, 350);
      g.drawLine(20, 350, 360, 350);
      g.drawString("Kasv", 25, 230);
      g.drawString("Õppilased", 300, 346);
      g.setColor(Color.black);
      firstparam+=5;


      String[] m=rida.split(",");
      if(m[3].equals("m")){g.setColor(Color.blue); boysamount+=1; boysl+=Integer.parseInt(m[1]);}
      else{g.setColor(Color.red ); girlsamount+=1; girlsl+=Integer.parseInt(m[1]);}

      g.fillRect(300-firstparam, (400-Integer.parseInt(m[1])*2)+200, 5, 5);
      rida=br.readLine();
    }
    int boysavg=boysl/boysamount;
    g.setColor(Color.blue);
    g.drawLine(20,(400-boysavg*2)+200, 360,(400-boysavg*2)+200);
    int girlsavg=girlsl/girlsamount;
    g.setColor(Color.red);
    g.drawLine(20, (400-girlsavg*2)+200, 360, (400-girlsavg*2)+200);


    ImageIO.write(bi, "png", new File("pikkused.png"));
  }
}
