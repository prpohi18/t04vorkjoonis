import java.io.FileWriter;
import java.io.PrintWriter;

public class OutputData {

    void SaveData(Calculator calc)
    {
        String Kassid = "kassideinfo"+ ".txt";
        String Koerad = "koerteinfo"+ ".txt";
        //tryki kasside andmed .txt faili
        try{
            PrintWriter pw=new PrintWriter(new FileWriter(Kassid));
            pw.println("Kasse kokku: "+calc.kassideloendur);
            pw.println("Kasside v2him mass: "+calc.kassidemiinimummass);
            pw.println("Kasside suurim mass: "+calc.kassidemaksimummass);
            pw.println("Kasside massi kogusumma: "+calc.kassidemassisumma);
            pw.println("Kasside massi aritmeetiline keskmine: "+calc.kassidemassikeskmine);
            pw.println("Kasside lyhim: "+calc.kassidemiinimumkorgus);
            pw.println("Kasside pikim: "+calc.kassidemaksimumkorgus);
            pw.println("Kasside kogupikkus: "+calc.kassidekorgustesumma);
            pw.println("Kasside keskmine pikkus: "+calc.kassidekorgustekeskmine);
            pw.close();
        } catch(Exception ex){
            ex.printStackTrace();
        }
        //tryki koerte andmed .txt faili
        try{
            PrintWriter pw=new PrintWriter(new FileWriter(Koerad));
            pw.println("Koeri kokku: "+calc.koerteloendur);
            pw.println("Koerte v2him mass: "+calc.koertemiinimummass);
            pw.println("Koerte suurim mass: "+calc.koertemaksimummass);
            pw.println("Koerte massi kogusumma: "+calc.koertemassisumma);
            pw.println("Koerte massi aritmeetiline keskmine: "+calc.koertemassikeskmine);
            pw.println("Koerte lyhim: "+calc.koertemiinimumkorgus);
            pw.println("Koerte pikim: "+calc.koertemaksimumkorgus);
            pw.println("Koerte kogupikkus: "+calc.koertekorgustesumma);
            pw.println("Koerte keskmine pikkus: "+calc.koertekorgustekeskmine);
            pw.close();
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }

}
