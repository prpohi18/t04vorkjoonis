import java.awt.image.*;
import javax.imageio.*;
import java.awt.*;
import java.net.*;
import java.io.*;
public class Joonis{
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
	int algus=50;
	int tydrukud = 0;
	int poisid = 0;
	int tydrukutearv = 0;
	int poistearv = 0;

    while(rida!=null){
      g.drawLine(20, 220, 20, 350);
      g.drawLine(20, 350, 360, 350);
      g.drawString("Pikkus", 25, 230);
      g.drawString("Õpilased", 300, 346);
      g.setColor(Color.BLACK);
	  algus+=5;

      String[] m=rida.split(",");
      if(m[3].equals("n")){g.setColor(Color.PINK); tydrukutearv+=1; tydrukud+=Integer.parseInt(m[1]);}
      else{g.setColor(Color.BLUE ); poistearv+=1; poisid+=Integer.parseInt(m[1]);}
	  
	  g.fillRect(300-algus, (400-Integer.parseInt(m[1])*2)+200, 5, 5);
      rida=br.readLine();
	}
    ImageIO.write(bi, "png", new File("Joonis.png"));
  }
}