import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
import javax.imageio.ImageIO;

public class joonis1 {
  public static void main(String[] arg) throws Exception {
    BufferedImage bi=new BufferedImage(300, 300, BufferedImage.TYPE_INT_RGB);
    Graphics g=bi.createGraphics();
    g.setColor(Color.WHITE);
    g.fillRect(0, 0, 300, 300);

    g.setColor(Color.BLACK);
    g.drawLine(60, 300, 60, 135);
    g.drawLine(75, 300, 75, 137);
    g.drawLine(90, 300, 90, 129);
    g.drawLine(105, 300, 105, 135);
    g.drawLine(120, 300, 120, 122);
    g.drawLine(135, 300, 135, 135);
    g.drawLine(150, 300, 150, 137);
    g.drawLine(165, 300, 165, 129);
    g.drawLine(180, 300, 180, 119);
    g.drawLine(195, 300, 195, 135);
    g.drawLine(210, 300, 210, 117);

	
	g.drawString("pikkused", 30, 20); //vasakult, ülevalt
    g.fillRect(10, 10, 10, 10);
    

    g.setColor(Color.RED);
    g.fillRect(10, 30, 10, 10);
    g.drawString("keskmine", 30, 40);
    g.drawLine(0, 131, 300, 131);

    //ühe standardhälbe kaugusel olev vahemik
    g.setColor(Color.GREEN);
    g.fillRect(10, 50, 10, 10);
    g.drawString("ühe hälbe kaugus", 30, 60);
    g.drawLine(0, 123, 300, 123);
    g.drawLine(0, 139, 300, 139);

    //kahe standardhälbe kaugusel olev vahemik
    g.setColor(Color.BLUE);
    g.fillRect(10, 70, 10, 10);
    g.drawString("kahe hälbe kaugus", 30, 80);
    g.drawLine(0, 114, 300, 114);
    g.drawLine(0, 148, 300, 148);

    ImageIO.write(bi, "png", new File("pilt1.png"));
  }
}