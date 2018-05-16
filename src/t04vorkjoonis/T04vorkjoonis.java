package t04vorkjoonis;

import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
import java.net.URL;
public class T04vorkjoonis{
    
    public static void main(String[] arg) throws Exception{
        
        //joonistan aluskasti
        BufferedImage bi=new BufferedImage(800, 300, BufferedImage.TYPE_INT_RGB);
        Graphics g=bi.createGraphics();
        g.setColor(Color.gray);
        g.fillRect(0, 0, 800, 300);
        //avan faili ja loen teksti
        String aadress="http://iot.knowbase.ee/t04vorkjoonis.txt";
        BufferedReader br=new BufferedReader(new InputStreamReader(
          new URL(aadress).openStream()));
        String rida=br.readLine();
        rida=br.readLine();
        
        //counter graafikute tulpade jaoks
        int counter = 1;
       
        // mootejooned
        for(int i =0; i<11; i++){
        g.setColor(Color.red);
        g.fillRect(0, (300-(i*20)), 800, 1);
        }
        
        //tulpade joonistamine
        while(rida!=null){
           // System.out.println(rida);
            counter++;
            g.setColor(Color.black);
            
            // X, Y telg, width, height
            g.fillRect(counter*10, (300-Integer.parseInt(rida)*20), 9, 299-(300-Integer.parseInt(rida)*20));
            
            rida=br.readLine();
        }
        
        System.out.println("Graafik joonistatud!");
        ImageIO.write(bi, "png", new File("graafik.png"));
    }
   
}