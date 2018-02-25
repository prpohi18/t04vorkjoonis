import java.awt.image.*;
import javax.imageio.*;
import java.awt.*;
import java.net.*;
import java.io.*;
public class Joonis{
    public static void main(String[] arg) throws Exception{
        BufferedImage bi=new BufferedImage(250, 300, BufferedImage.TYPE_INT_RGB);
        Graphics g=bi.createGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 250, 300);
        String aadress="http://www.tlu.ee/~jaagup/andmed/muu/5klass.txt";
        BufferedReader br=new BufferedReader(new InputStreamReader(
          new URL(aadress).openStream()));
        String rida=br.readLine();
        rida=br.readLine();
        int mMass = 0;
        int mPikkus = 0;
        int nMass = 0;
        int nPikkus = 0;
        int im = 0;
        int in = 0;
        while(rida!=null){
            String[] m=rida.split(",");
            if(m[3].equals("m")){
                mMass+=Integer.parseInt(m[2]);
                mPikkus+=Integer.parseInt(m[1]);
                im++;
            }else{
                nMass+=Integer.parseInt(m[2]);
                nPikkus+=Integer.parseInt(m[1]);
                in++;
            }
            rida=br.readLine();
        }
        int a = mMass/im;
        int b = mPikkus/im;
        g.setColor(Color.blue);
        g.fillRect(a, b,6,6);
        a = nMass/in;
        b = nPikkus/in;
        g.setColor(Color.red);
        g.fillRect(a, b,6,6);
        ImageIO.write(bi, "png", new File("5.png"));
    }
}