import java.io.*;

public class TextOutput {
    
    //muutujad
    protected int suurimmass;
    protected int vaikseimmass;

    protected int suurimkorgus;
    protected int vaikseimkorgus;
    
    protected int kassidekorgustesumma;
    protected int koertekorgustesumma;

    protected int kassidemassidesumma;
    protected int koertemassidesumma;

    protected int kassidekeskminekorgus;
    protected int koertekeskminekorgus;

    protected int kassidekeskminemass;
    protected int koertekeskminemass;
    
    public void TextOutput() throws Exception {
        
        //tekita uus lugeja
        PrintWriter pw = new PrintWriter(new FileWriter("informatsioon.txt"));
        
        //kirjuta read
        pw.println("Suurim mass: " + suurimmass);
        pw.println("Väikseim mass: " + vaikseimmass);
        
        pw.println("Suurim kõrgus: " + suurimkorgus);
        pw.println("Väikseim kõrgus: " + vaikseimkorgus);
        
        pw.println("Kasside kõrguste summa: " + kassidekorgustesumma);
        pw.println("Koerte kõrguste summa: " + koertekorgustesumma);
        
        pw.println("Kasside masside summa: " + kassidemassidesumma);
        pw.println("Koerte masside summa: " + koertemassidesumma);
        
        pw.println("Kasside keskmine kõrgus: " + kassidekeskminekorgus);
        pw.println("Koerte keskmine kõrgus: " + koertekeskminekorgus);
        
        pw.println("Kasside keskmine mass: " + kassidekeskminemass);
        pw.println("Koerte keskmine mass: " + koertekeskminemass);
        
        //võrdle masside summasid
        if (kassidemassidesumma > koertemassidesumma) {
            pw.println("\nKasside masside summa on suurem.");
        } else if (koertemassidesumma > kassidemassidesumma) {
            pw.println("\nKoerte masside summa on suurem.");
        } else {
            pw.println("\nMasside summad on võrdsed.");
        }

        //sulge failikirjutaja
        pw.close();
    }
}