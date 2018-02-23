package com.mycompany.kodutoo;
import java.awt.image.*;
import javax.imageio.*;
import java.awt.*;
import java.net.*;
import java.io.*;
public class joonis{
    public static void main(String[] arg) throws Exception{
        BufferedImage bi=new BufferedImage(400, 300, BufferedImage.TYPE_INT_RGB);
        Graphics g=bi.createGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 1000, 1000);
        String aadress="http://www.tlu.ee/~jaagup/veeb1/loomad.txt";
        BufferedReader br=new BufferedReader(new InputStreamReader(
          new URL(aadress).openStream()));
        String rida=br.readLine();
        rida=br.readLine();
        
        //muutujad:
        String mass=new String("");
        String kõrg=new String("");
        int kasskeskmass=0;
        int save1=0;
        int save2=0;
        int save3=0;
        int save4=0;
        int koerkeskmass=0;
        int i=0;
        int b=0;
        int kasskeskkõrg=0;
        int koerkeskkõrg=0;
        
        
        while(rida!=null){
            String[] m=rida.split(",");
            if(m[0].equals("kass")){
                g.setColor(Color.orange);
                mass= m[1];
                kõrg=m[2];
                save1=save1+Integer.parseInt(m[1]);//masside summa 
                save3=save3+Integer.parseInt(m[2]);//kõrguste summa
                i++;//mitu kassi oli
                kasskeskkõrg=save3/i;
                kasskeskmass=save1/i;
                
            }
            else{
                g.setColor(Color.white);
                mass= m[1];
                kõrg=m[2];
                save2=save2+Integer.parseInt(m[1]);//masside summa
                save4=save4+Integer.parseInt(m[2]);//kõrguste  summa
                b++;
                koerkeskmass=save2/b;
                koerkeskkõrg=save4/b;
               
            }
           
            
            //joonised
            //g.fillRect(Integer.parseInt(m[1])/30, 300-Integer.parseInt(m[2])*2, 5, 5);
            g.drawString(mass,Integer.parseInt(m[1]),Integer.parseInt(m[1]));//string,int x, int y
            g.drawString(kõrg,Integer.parseInt(m[2]),Integer.parseInt(m[2]));//string intx int y
            g.drawRect(kasskeskmass,kasskeskmass,10,10);
            g.drawRect(koerkeskmass,koerkeskmass,10,10);
            g.drawOval(kasskeskkõrg, kasskeskkõrg, 10, 10);
            g.drawOval(koerkeskkõrg, koerkeskkõrg, 10, 10);
            
            rida=br.readLine();
        }
        ImageIO.write(bi, "png", new File("loomad.png"));
    }
}
