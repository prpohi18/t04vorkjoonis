import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.*;
import java.util.*;
import java.awt.image.*;
import javax.imageio.*;


public class vork{
    public static void main(String[] arg) throws Exception{
		int suurim = 0, vahim = 99999999;
        String aadress="http://www.tlu.ee/~jaagup/veeb1/pikkused.txt";
        BufferedReader br=new BufferedReader(new InputStreamReader(
           new URL(aadress).openStream()
        ));
        String rida=br.readLine();
        int loendur=0;
		ArrayList<Integer> arvud = new ArrayList<Integer>();
        while(rida!=null){
			if (suurim < Integer.parseInt(rida)){
				suurim = Integer.parseInt(rida);
				}
			if (vahim > Integer.parseInt(rida)){
				vahim = Integer.parseInt(rida);
				}
			arvud.add(Integer.parseInt(rida));
			loendur += 1;
			rida=br.readLine();
        }
		System.out.println("Vähem = " + vahim);
		Collections.sort(arvud); 
		double abi25 = loendur * 0.25;
		double abi50 = loendur * 0.50;
		double abi75 = loendur * 0.75;
		int a25 = vaartused(arvud, abi25);
		int b50 = vaartused(arvud, abi50);
		int c75 = vaartused(arvud, abi75);
		System.out.println("Väärtus, millest 0.25% on väiksemad = " + a25);
		System.out.println("Väärtus, millest 0.50% on väiksemad = " + b50);
		System.out.println("Väärtus, millest 0.75% on väiksemad = " + c75);
		System.out.println("Suurim = " + suurim);
		printCircleLength(suurim, a25, b50, c75);
        br.close();
    }
	public static int vaartused(ArrayList<Integer> Arvud, double Abi)throws Exception{
		int suurim1 = Arvud.get((int)(Math.ceil(Abi)));
		int vahim1 = Arvud.get((int)(Math.floor(Abi)));
		int tulemus = vahim1+(suurim1-vahim1)/2;
		return tulemus;
	}
	public static void printCircleLength(int Suurim1, int A,int B, int C)throws Exception{
		BufferedImage bi=new BufferedImage(Suurim1+50, 100, BufferedImage.TYPE_INT_RGB);
        Graphics g=bi.createGraphics();
        g.setColor(Color.BLUE);
        g.fillRect(0, 0, Suurim1+50, 100);
        g.setColor(Color.RED);
		g.fillRect(25 + A, 40, C-A, 20);
		g.setColor(Color.BLACK);
		g.drawLine(25, 50, Suurim1+25, 50);
		g.setColor(Color.GREEN);
		g.drawLine(B+25, 40, B+25, 60);
        ImageIO.write(bi, "png", new File("pilt1.png")); 
	}
}
