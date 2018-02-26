import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Calculator {
    //Kasside muutujad
    int kassideloendur=0;
    int kassidemassisumma=0;
    int kassidekorgustesumma=0;
    int kassidemiinimummass=200000;
    int kassidemaksimummass=0;
    int kassidemiinimumkorgus=200000;
    int kassidemaksimumkorgus=0;
    //Koerte muutujad
    int koerteloendur=0;
    int koertemassisumma=0;
    int koertekorgustesumma=0;
    int koertemiinimummass=200000;
    int koertemaksimummass=0;
    int koertemiinimumkorgus=200000;
    int koertemaksimumkorgus=0;

    int kassidemassikeskmine=0;
    int koertemassikeskmine=0;

    int kassidekorgustekeskmine=0;
    int koertekorgustekeskmine=0;

    protected static List<Integer> DogMassesList = new ArrayList<Integer>();
	protected static List<Integer> DogHeightList = new ArrayList<Integer>();
	protected static List<Integer> CatMassesList = new ArrayList<Integer>();
	protected static List<Integer> CatHeightList = new ArrayList<Integer>();
	protected static List<Integer> CatMassesAndHeights = new ArrayList<Integer>();
	protected static List<Integer> DogMassesAndHeights = new ArrayList<Integer>();


    public Calculator()
    {
        Calculate();
    }

    public void Calculate()
    {
        try {

        String aadress="http://www.tlu.ee/~jaagup/veeb1/loomad.txt";

        BufferedReader br= null;
            br = new BufferedReader(new InputStreamReader(
                    new URL(aadress).openStream()));

        String rida=br.readLine();
        if(!rida.startsWith("liik")){
            System.out.println("sobiva pealkirjata fail");
            return;
        }
        rida=br.readLine();

            while(rida!=null){
                System.out.println(rida);
                String[] m=rida.split(",");
                if(m[0].equals("kass")){
                    CatMassesList.add(Integer.parseInt(m[1]));
                    CatHeightList.add(Integer.parseInt(m[2]));
                    CatMassesAndHeights.add(Integer.parseInt(m[1]));
                    CatMassesAndHeights.add(Integer.parseInt(m[2]));

                    kassidemassisumma+=Integer.parseInt(m[1]);
                    kassidekorgustesumma+=Integer.parseInt(m[2]);
                    kassideloendur+=1;
                    //arvutab kasside miinimum ja maksimum massi
                    if (Integer.parseInt(m[1]) > kassidemaksimummass) {
                        kassidemaksimummass = Integer.parseInt(m[1]);
                    }
                    if (Integer.parseInt(m[1]) < kassidemiinimummass) {
                        kassidemiinimummass = Integer.parseInt(m[1]);
                    }
                    //arvutab kasside miinimum ja maksimum k�rguse
                    if (Integer.parseInt(m[2]) > kassidemaksimumkorgus) {
                        kassidemaksimumkorgus = Integer.parseInt(m[2]);
                    }
                    if (Integer.parseInt(m[2]) < kassidemiinimumkorgus) {
                        kassidemiinimumkorgus = Integer.parseInt(m[2]);
                    }
                }

                if(m[0].equals("koer")){
                    DogMassesList.add(Integer.parseInt(m[1]));
                    DogHeightList.add(Integer.parseInt(m[2]));
                    DogMassesAndHeights.add(Integer.parseInt(m[1]));
                    DogMassesAndHeights.add(Integer.parseInt(m[2]));

                    koertemassisumma+=Integer.parseInt(m[1]);
                    koertekorgustesumma+=Integer.parseInt(m[2]);
                    koerteloendur+=1;
                    //arvutab koerte miinimum ja maksimum massi
                    if (Integer.parseInt(m[1]) > koertemaksimummass) {
                        koertemaksimummass = Integer.parseInt(m[1]);
                    }
                    if (Integer.parseInt(m[1]) < koertemiinimummass) {
                        koertemiinimummass = Integer.parseInt(m[1]);
                    }
                    //arvutab korte miinimum ja maksimum k�rguse
                    if (Integer.parseInt(m[2]) > koertemaksimumkorgus) {
                        koertemaksimumkorgus = Integer.parseInt(m[2]);
                    }
                    if (Integer.parseInt(m[2]) < koertemiinimumkorgus) {
                        koertemiinimumkorgus = Integer.parseInt(m[2]);
                    }
                }

                rida=br.readLine();
            }

             kassidemassikeskmine = kassidemassisumma/kassideloendur;
             koertemassikeskmine = koertemassisumma/koerteloendur;
             kassidekorgustekeskmine = kassidekorgustesumma/kassideloendur;
             koertekorgustekeskmine = koertekorgustesumma/koerteloendur;



        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public String toString(){
        return "";
    }
}
