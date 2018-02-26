import java.awt.image.*;
import javax.imageio.*;
import java.awt.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Calculator calculator = new Calculator();
        OutputData outputData = new OutputData();
        outputData.SaveData(calculator);
        //DoGraph(calculator);
		ImageCreation.graph();
    }

    /*public static void DoGraph(Calculator calc) throws Exception{
        BufferedImage bi=new BufferedImage(500, 400, BufferedImage.TYPE_INT_RGB);
        Graphics g=bi.createGraphics();
        g.setColor(Color.GRAY);
        g.fillRect(0, 0, 500, 400);

        for (int i : calc.CatMassesList) {
            g.setColor(Color.RED);
            g.fillRect(i, 400-i*2, 5, 5);
            System.out.println(i);
        }
      
        for (int i : calc.DogHeightList) {
            g.setColor(Color.YELLOW);
            g.fillRect(i, 400-i, 5, 5);
            System.out.println(i);
        }
      
        g.setColor(Color.RED);
        g.fillRect(calc.kassidemassikeskmine / 30 + 30, 400-calc.kassidekorgustekeskmine*2 - 30, 8, 8);
        g.setColor(Color.YELLOW);
        g.fillRect(calc.koertemassikeskmine / 30 + 30, 400-calc.koertekorgustekeskmine*2 - 30, 8, 8);        
             
        g.setFont(new Font("Calibri", Font.BOLD, 16));
        g.setColor(Color.RED);
        g.fillRect(15, 28, 8, 8);
        g.setColor(Color.YELLOW);
        g.fillRect(15, 47, 8, 8);
        g.setColor(Color.BLACK);
        g.drawString("Kasside keskmine mass on " + calc.kassidemassikeskmine+"g" + " ja keskmine k6rgus on " + calc.kassidekorgustekeskmine + "cm", 30, 80);
        g.drawString("Koerte keskmine mass on " + calc.koertemassikeskmine+"g" + " ja keskmine k6rgus on " + calc.koertekorgustekeskmine + "cm", 30, 100);

        g.setColor(Color.BLACK);
        g.drawLine(30, 370, 440, 370);
        g.drawLine(30, 170, 30, 370);
        g.setFont(new Font("Calibri", Font.BOLD, 16));
        g.drawString("MASS(g)", 230, 390);
        g.drawString("12000g", 445, 375);
        g.drawString("KORGUS(cm)", 10, 140);
        g.drawString("100cm", 10, 160);

        ImageIO.write(bi, "png", new File("loomad.png"));
    }
*/
}
