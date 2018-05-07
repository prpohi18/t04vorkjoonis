import java.awt.image.*;
import javax.imageio.*;
import java.awt.*;
import java.net.*;
import java.io.*;


public class Joonis2{
    public static void main(String[] arg) throws Exception{
        int koerteKorgusteKeskmine = 0;
        int koerteMassideKeskmine = 0;
        int koerteLoendur = 0;
        int kassideKorgusteKeskmine = 0;
        int kassideMassideKeskmine = 0;
        int kassideLoendur = 0;
        BufferedImage bi=new BufferedImage(400, 300, BufferedImage.TYPE_INT_RGB);
        Graphics g=bi.createGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 400, 300);
        String aadress="http://www.tlu.ee/~jaagup/veeb1/loomad.txt";
        BufferedReader br=new BufferedReader(new InputStreamReader(
          new URL(aadress).openStream()));
        String rida=br.readLine();
        rida=br.readLine();
        while(rida!=null){
            String[] m=rida.split(",");
            if(m[0].equals("kass")){
                g.setColor(Color.gray);
                kassideKorgusteKeskmine += Integer.parseInt(m[1]);
                kassideMassideKeskmine += Integer.parseInt(m[2]);
                kassideLoendur += 1;
            }
            else{
                g.setColor(Color.red);
                koerteKorgusteKeskmine += Integer.parseInt(m[1]);
                koerteMassideKeskmine += Integer.parseInt(m[2]);
                koerteLoendur += 1;
            }
            g.fillRect(Integer.parseInt(m[1])/30, 300-Integer.parseInt(m[2])*2, 5, 5);
            rida=br.readLine();
        }
        g.setColor(Color.blue);
        g.fillRect((koerteKorgusteKeskmine/koerteLoendur)/30, 300-(koerteMassideKeskmine/koerteLoendur)*2, 5, 5);
        g.setColor(Color.green);
        g.fillRect((kassideKorgusteKeskmine/kassideLoendur)/30, 300-(kassideMassideKeskmine/kassideLoendur)*2, 5, 5);
        ImageIO.write(bi, "png", new File("loomad123.png"));
        if (kassideMassideKeskmine > koerteMassideKeskmine){
            System.out.println("Kasside masside summa on suurem kui koerte masside summa. Kasside masside summa on "+kassideMassideKeskmine);
        } else {
            System.out.println("Koerte masside summa on suurem kui kasside masside summa. Koerte masside summa on "+koerteMassideKeskmine);
        }
    }
}