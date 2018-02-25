import java.awt.image.*;
import javax.imageio.*;
import java.awt.*;
import java.net.*;
import java.io.*;
public class Joonis1{
	public static void main(String[] arg) throws Exception{
		BufferedImage bi=new BufferedImage(400, 300, BufferedImage.TYPE_INT_RGB);
		Graphics g=bi.createGraphics();
		g.setColor(Color.BLUE);
		g.fillRect(10, 20, 380, 260);
		String aadress="http://greeny.cs.tlu.ee/~lahtsten/Programmeerimine/tund4/loomad.txt";
		BufferedReader br=new BufferedReader(new InputStreamReader(
		new URL(aadress).openStream()));
		String rida=br.readLine();
		rida=br.readLine();
		int kassidemassidesumma=0;
		int koertemassidesumma=0;
		int kassidekorgustesumma=0;
		int koertekorgustesumma=0;
		while(rida!=null){
			String[]m=rida.split(",");
			if(m[0].equals("kass")){g.setColor(Color.gray);}
			else{g.setColor(Color.red);}
			if(m[0].equals("kass")){
				kassidemassidesumma+=Integer.parseInt(m[1]);
				kassidekorgustesumma+=Integer.parseInt(m[2]);
			} else{
				if(m[0].equals("koer")){
					koertemassidesumma+=Integer.parseInt(m[1]);
					koertekorgustesumma+=Integer.parseInt(m[2]);
				}
			}
			
			g.fillRect(Integer.parseInt(m[1])/30, 300-Integer.parseInt(m[2])*2, 10, 10);
			rida=br.readLine();
		}
		g.setColor(Color.BLACK);
		g.fillRect(kassidemassidesumma/30/7, 300-(kassidekorgustesumma/7)*2, 15, 15);
		g.setColor(Color.WHITE);
		g.fillRect(koertemassidesumma/30/8, 300-(koertekorgustesumma/8)*2, 15, 15);
		
		System.out.println("Koerte masside keskmine on: " + kassidemassidesumma/30/7);
		ImageIO.write(bi, "png", new File("loomad11.png"));
		//System.out.println("Koerte masside keskmine on: " + koertemassidekeskmine);
			
		/*g.setColor(Color.GREEN);
		g.drawLine(130, 90, 130, 280);
		g.drawOval(100, 50, 60, 40);
		g.drawString("Tere", 110, 70);
		g.drawOval(200, 50, 60, 40);
		g.drawLine(230, 90, 230, 280);
		g.drawOval(300, 50, 60, 40);
		g.drawLine(330, 90, 330, 280);
		ImageIO.write(bi, "png", new File("pilt1.png"));
		*/
	}
}
		