import java.awt.image.*;
import javax.imageio.*;
import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.*;

public class XYtasand{
	public static void main(String[] arg) throws Exception{
		BufferedReader sisse=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Millise soo andmeid n2ha soovite(mehed/naised/m6lemad)?");
		String sugu=sisse.readLine();
		
		BufferedImage bi=new BufferedImage(400, 300, BufferedImage.TYPE_INT_RGB);
		Graphics g=bi.createGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 300, 200);		
		String aadress="http://www.tlu.ee/~jaagup/andmed/muu/5klass.txt";
		BufferedReader br=new BufferedReader (new InputStreamReader(
			new URL(aadress).openStream()));
		
		if(sugu.equals("mehed")){
			String rida=br.readLine();
			rida=br.readLine();
			while(rida!=null){
				String[] m=rida.split(",");
				if(m[3].equals("m")){
					g.setColor(Color.blue);
					g.fillRect(Integer.parseInt(m[1]), Integer.parseInt(m[2]), 3, 3);
				}
				rida=br.readLine();
			}
			ImageIO.write(bi, "png", new File("6pilased1.png"));
		}
		
		if(sugu.equals("naised")){
			String rida=br.readLine();
			rida=br.readLine();
			while(rida!=null){
				String[] m=rida.split(",");
				if(m[3].equals("n")){
					g.setColor(Color.red);
					g.fillRect(Integer.parseInt(m[1]), Integer.parseInt(m[2]), 3, 3);
				}
				rida=br.readLine();
			}
			ImageIO.write(bi, "png", new File("6pilased2.png"));
		}
		
		if(sugu.equals("m6lemad")){
			String rida=br.readLine();
			rida=br.readLine();
			while(rida!=null){
				String[] m=rida.split(",");
				if(m[3].equals("m")){
					g.setColor(Color.blue);
					g.fillRect(Integer.parseInt(m[1]), Integer.parseInt(m[2]), 3, 3);
				}else{
					g.setColor(Color.red);
					g.fillRect(Integer.parseInt(m[1]), Integer.parseInt(m[2]), 3, 3);
				}
				rida=br.readLine();
			}
			ImageIO.write(bi, "png", new File("6pilased3.png"));
		}
	}
}