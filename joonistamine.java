import java.awt.image.*;
import javax.imageio.*;
import java.awt.*;
import java.io.*;
import java.net.*;

public class joonistamine{
	

	public void joonistamine() throws Exception{
		
		int Mcount=0;
		int Msumma=0;
		int Mmax=0;
		int Mmin=99999;
		double Mkeskmine=0;
		
		int Kcount=0;
		int Ksumma=0;
		int Kmax=0;
		int Kmin=99999;
		double Kkeskmine=0;
		
		
		BufferedImage bi= new BufferedImage(600,500,BufferedImage.TYPE_INT_RGB);
		Graphics g=bi.createGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(0,0,600,500);
		g.setColor(Color.BLACK);
		
		g.drawLine(5,5,5,490);
		g.drawLine(5,490,590,490);
		int x=21;
		int y=31;
		while (x<590){
			g.drawLine(x,487,x,493);
			g.drawLine(2,y,8,y);
			x+=16;
			y+=24;
			//Xi alla läheb mass
			//yi alla läheb korgus
		}
		String aadress="http://www.tlu.ee/~rihon/loomad.txt";
		BufferedReader br= new BufferedReader(new InputStreamReader(new URL(aadress).openStream()));
		String rida= br.readLine();
		if(!rida.startsWith("liik")){
			System.out.println("sobiva pealkirjata fail");
			return;
		}
		rida=br.readLine();

		while(rida!=null){
			String[] m=rida.split(",");
			Mcount+=1;
			if (Integer.parseInt(m[1])>Mmax) {
				Mmax=Integer.parseInt(m[1]);
			}
			if (Integer.parseInt(m[1])<Mmin) {
				Mmin=Integer.parseInt(m[1]);
			}
			Msumma+=Integer.parseInt(m[1]);
			Kcount+=1;
			if (Integer.parseInt(m[2])>Kmax) {
				Kmax=Integer.parseInt(m[2]);
			}
			if (Integer.parseInt(m[2])<Kmin) {
				Kmin=Integer.parseInt(m[2]);
			}
			Ksumma+=Integer.parseInt(m[2]);
			if(m[0].equals("kass")){g.setColor(Color.gray);}
		else{g.setColor(Color.red);}
		g.drawOval((Integer.parseInt(m[1])/500)*16+21,(Integer.parseInt(m[2])/5)*24+31,4,4);
		rida=br.readLine();
		}
		//keskmise massi joonistamine
		Mkeskmine = Msumma/Mcount;
		g.setColor(Color.cyan);
		g.drawLine((int)((Mkeskmine/500)*16),0,(int)((Mkeskmine/500)*16),485);
		Kkeskmine = Ksumma/Kcount;
		g.setColor(Color.yellow);
		g.drawLine(0,(int)((Kkeskmine/5)*24),485,(int)((Kkeskmine/5)*24));
		
		
		//g.drawOval(40,40,2,2);

		//g.drawLine(21,487,21,493);
		
		
		
		ImageIO.write(bi, "png", new File("joonis.png"));
	}
}	


//Xil on ruumi 585px 16px kaupa 500 Algus 21px MASS 1000px==
//Yil on ruumi 485px 24px kaupa 5