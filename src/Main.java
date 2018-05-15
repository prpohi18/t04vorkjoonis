import java.net.*;
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] arg) throws Exception {
		try {
			String aadress = "http://www.tlu.ee/~jaagup/veeb1/loomad.txt";
			BufferedReader br = new BufferedReader(new InputStreamReader(new URL(aadress).openStream()));

			String rida = br.readLine();
			System.out.println();
			rida = br.readLine();
			int catWeight = 0;
			int catHeight = 0;
			int dogWeight = 0;
			int dogHeight = 0;
			int catCount = 0;
			int dogCount = 0;
			int catWeightAvg = 0;
			int dogWeightAvg = 0;
			int catHeightAvg = 0;
			int dogHeightAvg = 0;
			List<Integer[]> catList = new ArrayList<>();
			List<Integer[]> dogList = new ArrayList<>();
			while (rida != null) {

				String[] andmed = rida.split(",");

				if (andmed[0].equals("kass")) {
					catWeight = catWeight + Integer.parseInt(andmed[1]);
					catHeight = catHeight + Integer.parseInt(andmed[2]);
					catList.add(new Integer[] { Integer.parseInt(andmed[1]), Integer.parseInt(andmed[2]) });
					catCount++;

				} else if (andmed[0].equals("koer")) {
					dogWeight = dogWeight + Integer.parseInt(andmed[1]);
					dogHeight = dogHeight + Integer.parseInt(andmed[2]);
					dogList.add(new Integer[] { Integer.parseInt(andmed[1]), Integer.parseInt(andmed[2]) });
					dogCount++;
				}
				rida = br.readLine();// loeb järgmise rea
			}
			catWeightAvg = catWeight / catCount;
			catHeightAvg = catHeight / catCount;
			dogWeightAvg = dogWeight / dogCount;
			dogHeightAvg = dogHeight / dogCount;
			System.out.println("kasside keskmine mass on " + catWeightAvg + " yhikut");
			System.out.println("kasside keskmine korgus on " + catHeightAvg + " yhikut");
			System.out.println("koerte keskmine mass on " + dogWeightAvg + " yhikut");
			System.out.println("koerte keskmine korgus on " + dogHeightAvg + " yhikut");

			br.close();
			Image.createImage(catWeightAvg, catHeightAvg, dogWeightAvg, dogHeightAvg, catList, dogList);
		} catch (Exception ex) {
			System.out.println("Probleem: " + ex);

		}

	}
}
