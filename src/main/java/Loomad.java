import java.awt.image.*;
import javax.imageio.*;
import java.awt.*;
import java.net.*;
import java.io.*;


public class Loomad {
    public static void main(String[] arg) throws Exception{

        int dogCount = 0;
        int dogMass = 0;
        int dogHeight = 0;
        int catCount = 0;
        int catMass = 0;
        int catHeight = 0;
        String ln;

        BufferedImage bi=new BufferedImage(400, 300, BufferedImage.TYPE_INT_RGB);
        Graphics g=bi.createGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 400, 300);
        String webPage="http://www.tlu.ee/~jaagup/veeb1/loomad.txt";
        BufferedReader br=new BufferedReader(new InputStreamReader(
                new URL(webPage).openStream()));
        String line=br.readLine();
        line=br.readLine();
        while(line!=null){
            String[] i=line.split(",");
            if(i[0].equals("kass")){
                g.setColor(Color.blue);
                catMass += Integer.parseInt(i[1]);
                catHeight += Integer.parseInt(i[2]);
                catCount += 1;
            }
            else{
                g.setColor(Color.red);
                dogMass += Integer.parseInt(i[1]);
                dogHeight += Integer.parseInt(i[2]);
                dogCount += 1;
            }
            g.fillRect(Integer.parseInt(i[1])/30, 300-Integer.parseInt(i[2])*2, 5, 5);
            line=br.readLine();
        }
        g.setColor(Color.pink);
        g.fillRect((dogMass/dogCount)/30, 300-(dogHeight/dogCount)*2, 8, 8);
        g.setColor(Color.cyan);
        g.fillRect((catMass/catCount)/30, 300-(catHeight/catCount)*2, 8, 8);
        ImageIO.write(bi, "png", new File("animals.png"));
        if (dogMass > catMass){
            System.out.println("Koerte kogumass on suurem: " + dogMass);
        } else {
            System.out.println("Kasside kogumass on suurem: " + catMass);
        }
    }
}