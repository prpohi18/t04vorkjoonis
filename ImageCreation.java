import java.awt.image.*;
import javax.imageio.*;
import java.awt.*;
import java.io.*;
import java.net.*;

public class ImageCreation{
    public static void graph() throws Exception{
        BufferedImage bi = new BufferedImage(500, 400, BufferedImage.TYPE_INT_RGB);
        Graphics g = bi.createGraphics();
        g.setColor(Color.GRAY);
        g.fillRect(0, 0, 500, 400);
        String aadress = "http://www.tlu.ee/~jaagup/veeb1/loomad.txt";
        BufferedReader br = new BufferedReader(new InputStreamReader(
            new URL(aadress).openStream()));
        String rida = br.readLine();
        rida = br.readLine();
        int CatMass = 0;
        int DogMass = 0;
        int CatHeight = 0;
		int DogHeight = 0;
		int dogs = 0;
		int cats = 0;
        while (rida != null) {
            String[] m = rida.split(",");
            if (m[0].equals("kass")){
                ImageData cat = new ImageData();
                cat.CatsToList(Integer.parseInt(m[1]), Integer.parseInt(m[2]));
                g.setColor(Color.BLUE);
                CatMass = CatMass + Integer.parseInt(m[1]);
				CatHeight = CatHeight + Integer.parseInt(m[2]);
				cats++;
            } else {
            	ImageData koer = new ImageData();
                koer.DogsToList(Integer.parseInt(m[1]), Integer.parseInt(m[2]));
				g.setColor(Color.GREEN);
				DogMass = DogMass + Integer.parseInt(m[1]);
				DogHeight = DogHeight +Integer.parseInt(m[2]);
				dogs++;
            }
            g.fillOval(Integer.parseInt(m[1]) / 30 + 25, 400-Integer.parseInt(m[2])*2 - 30, 5, 5);
            rida = br.readLine();
        }
        
        
        //Kasside ja koerte keskmiste v22rtuste leidmine
		CatMass = CatMass / cats;
        CatHeight = CatHeight / cats;
		DogMass = DogMass / dogs;
		DogHeight = DogHeight / dogs;
        
		g.setColor(Color.RED);
		g.fillOval(CatMass / 30 + 25, 400-CatHeight*2 - 30, 10, 10);
		g.setColor(Color.YELLOW);
		g.fillOval(DogMass / 30 + 25, 400-DogHeight*2 - 30, 10, 10);

        g.setFont(new Font("Calibri", Font.BOLD, 12));
        g.setColor(Color.BLUE);
        g.fillOval(15, 30, 5, 5);
        g.setColor(Color.GREEN);
        g.fillOval(15, 50, 5, 5);
        g.setColor(Color.RED);
        g.fillOval(15, 70, 10, 10);
        g.setColor(Color.YELLOW);
        g.fillOval(15, 90, 10, 10);
        g.setColor(Color.BLUE);
        g.drawString("Kassid", 30, 40);
        g.setColor(Color.GREEN);
        g.drawString("Koerad", 30, 60);
        g.setColor(Color.WHITE);
        g.drawString("Kasside keskmine mass on " + CatMass+"g" + " ja keskmine k6rgus on " + CatHeight+"cm", 30, 80);
        g.drawString("Koerte keskmine mass on " + DogMass+"g" + " ja keskmine k6rgus on " + DogHeight+"cm", 30, 100);

        g.setColor(Color.BLACK);
        g.drawLine(10, 370, 440, 370);
        g.drawLine(30, 170, 30, 390);
        g.setFont(new Font("Calibri", Font.BOLD, 12));
        g.drawString("MASS(g)", 230, 390);
        g.drawString("12000g", 445, 375);
        g.drawString("KORGUS(cm)", 10, 140);
        g.drawString("100cm", 10, 160);
        
        ImageIO.write(bi, "png", new File("loomad.png"));
    }
}