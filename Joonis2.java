import java.awt.image.*;
import java.net.*;
import javax.imageio.*;
import java.awt.*;
import java.io.*;
public class Joonis2{
    public static void main(String[] arg) throws Exception{
        
        int counter_koer = 0;
        int counter_kass = 0;

        int kassidekorgustesumma = 0;
        int kassidemassidesumma = 0;
        int koertekorgustesumma = 0;
        int koertemassidesumma = 0;

        int koerteKeskmineKorgus = 0;
        int koerteKeskmineMass = 0;
        int kassideKeskmineKorgus = 0;
        int kassideKeskmineMass = 0;


        BufferedImage bi=new BufferedImage(400, 300, BufferedImage.TYPE_INT_RGB);
        Graphics g=bi.createGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 400, 300);
        String aadress="http://greeny.cs.tlu.ee/~sulgdenn/veeb1/loomad.txt";
        BufferedReader br=new BufferedReader(new InputStreamReader(
            new URL(aadress).openStream()));
        String rida=br.readLine();
        rida=br.readLine();
        while(rida!=null){
            String[] m=rida.split(",");
            if(m[0].equals("kass")){
                counter_kass += 1;
                g.setColor(Color.gray);
                kassidekorgustesumma+=Integer.parseInt(m[2]);
                kassidemassidesumma+=Integer.parseInt(m[1]);
            } else {
                counter_koer += 1;
                g.setColor(Color.red);
                koertekorgustesumma+=Integer.parseInt(m[2]);
                koertemassidesumma+=Integer.parseInt(m[1]);
            }
            g.fillRect(Integer.parseInt(m[1])/300, 300-Integer.parseInt(m[2])*2, 5, 5);
            rida=br.readLine();
        }


        //Counter lines
        g.setColor(Color.yellow);
        g.drawLine(400 , counter_koer * 10, counter_koer * 10, counter_koer * 10);

        g.setColor(Color.orange);
        g.drawLine(400 , counter_kass * 10, counter_kass * 10, counter_kass * 10);
       
       
        //Kasside kõrguste summa
        g.setColor(Color.cyan);
        g.drawLine(400 , kassidekorgustesumma, kassidekorgustesumma, kassidekorgustesumma);

        ImageIO.write(bi, "png", new File("loomad.png"));
    }
}