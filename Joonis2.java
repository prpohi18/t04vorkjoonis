import java.awt.image.*;
import javax.imageio.*;
import java.awt.*;
import java.awt.image.*;
import java.net.*;
import java.io.*;
import java.util.List;

public class Joonis2{
	public static void main(String[] arg) throws Exception{
		int catCounter = 0;
		int catMass = 0;
		int catHeight = 0;
		int dogCounter = 0;
		int dogMass = 0;
		int dogHeight = 0;
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
				catMass += Integer.parseInt(m[1]);
				catHeight += Integer.parseInt(m[2]);
				catCounter += 1;
			}
			else{
				g.setColor(Color.red);
				dogMass += Integer.parseInt(m[1]);
				dogHeight += Integer.parseInt(m[2]);
				dogCounter += 1;
			}
			g.fillRect(Integer.parseInt(m[1])/30, 300-Integer.parseInt(m[2])*2, 5, 5);
			rida=br.readLine();
				
		}
		g.setColor(Color.YELLOW);
		g.drawLine((catMass/catCounter/30), (catHeight/catCounter), 5,5);
		ImageIO.write(bi, "png", new File("loomad.png"));	
	}
}