import java.awt.image.*;
import java.io.*;
import java.util.List;

import javax.imageio.ImageIO;
import java.awt.*;


public class Image {

	public static void createImage(int catWeightAvg, int catHeightAvg, int dogWeightAvg, int dogHeightAvg,
			List<Integer[]> catList, List<Integer[]> dogList) {
		try {
			BufferedImage bi = new BufferedImage(500, 400, BufferedImage.TYPE_INT_RGB);
			Graphics g = bi.createGraphics();
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, 500, 400);
			g.setColor(Color.BLUE);
			g.drawLine(50, 100, 50, 350);
			g.drawLine(50, 350, 350, 350);
			g.drawString("Keskmine kasside mass: " + catWeightAvg, 20, 20);
			g.drawString("Keskmine kasside korgus: " + catHeightAvg, 20, 35);
			g.drawString("Keskmine koerte mass: " + dogWeightAvg, 20, 50);
			g.drawString("Keskmine koerte korgus: " + dogHeightAvg, 20, 65);
			for (Integer[] cat : catList) {
				g.fillOval(50 + (cat[0] / 50), 350 - cat[1], 5, 5);
			}
			g.setColor(Color.RED);
			for (Integer[] dog : dogList) {
				g.fillOval(50 + (dog[0] / 50), 350 - dog[1], 5, 5);
			}
			g.setColor(Color.BLACK);
			g.fillOval(50 + catWeightAvg / 50, 350 - catHeightAvg, 10, 10);
			g.setColor(Color.GREEN);
			g.fillOval(50 + dogWeightAvg / 50, 350 - dogHeightAvg, 10, 10);

			ImageIO.write(bi, "png", new File("joonis.png"));

		} catch (Exception ie) {
			ie.printStackTrace();
		}

	}

}
