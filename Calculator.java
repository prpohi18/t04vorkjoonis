import java.net.*;
import java.io.*;

public class Calculator {
    
    //muutujad
    protected String aadress;
    
    protected int suurimmass;
    protected int vaikseimmass;
    protected int suurimkorgus;
    protected int vaikseimkorgus;
    
    protected int kassidemassidesumma = 0;
    protected int koertemassidesumma = 0;
    
    protected int koertekeskminekorgus;
    protected int koertekeskminemass;
    
    protected int kassidekeskminekorgus;
    protected int kassidekeskminemass;

    protected int kassidekorgustesumma = 0;
    protected int koertekorgustesumma = 0;

    protected int koertearv = 0;
    protected int kassidearv = 0;
    
    public void Calculator() throws Exception {
        
        //tekita uus lugeja
        BufferedReader br = new BufferedReader(new InputStreamReader(new URL(aadress).openStream()));
        
        //loe rida nr0
        String rida = br.readLine();
        
        //ebasobiv fail
        if(!rida.startsWith("liik")) {
            System.out.println("Error: Sobiva pealkirjata fail.");
            System.exit(0);
        }
        
        //loe rida nr1
        rida = br.readLine();
        
        //jaga rida osadeks
        String[] suurused = rida.split(",");
        
        //anna esialgsed väärtused
        suurimmass = Integer.parseInt(suurused[1]);
        vaikseimmass = Integer.parseInt(suurused[1]);
        suurimkorgus = Integer.parseInt(suurused[2]);
        vaikseimkorgus = Integer.parseInt(suurused[2]);
        
        //loe faili ja arvuta
        while(rida != null) {
            String[] m = rida.split(",");
            
            //koerte ja kasside masside summa
            if(m[0].equals("kass")) {
                kassidemassidesumma += Integer.parseInt(m[1]);
                kassidekorgustesumma += Integer.parseInt(m[2]);
                kassidearv += 1;
            } else if (m[0].equals("koer")) {
                koertemassidesumma += Integer.parseInt(m[1]);
                koertekorgustesumma += Integer.parseInt(m[2]);
                koertearv += 1;
            }
            //suurim ja väikseim mass
            if (Integer.parseInt(m[1]) > suurimmass) {
                suurimmass = Integer.parseInt(m[1]);
            } else if (Integer.parseInt(m[1]) < vaikseimmass) {
                vaikseimmass = Integer.parseInt(m[1]);
            }
            //suurim ja väiksiem korgus
            if (Integer.parseInt(m[2]) > suurimkorgus) {
                suurimkorgus = Integer.parseInt(m[2]);
            } else if (Integer.parseInt(m[2]) < vaikseimkorgus) {
                vaikseimkorgus = Integer.parseInt(m[2]);
            }
            rida = br.readLine();
        }
        
        //arvuta keskmised
        kassidekeskminemass = kassidemassidesumma / kassidearv;
        kassidekeskminekorgus = kassidekorgustesumma / kassidearv;
        
        koertekeskminemass = koertemassidesumma / koertearv;
        koertekeskminekorgus = koertekorgustesumma / koertearv;
        
        //sulge lugeja
        br.close();
        
        this.suurimmass = suurimmass;
        this.vaikseimmass = vaikseimmass;
        
        this.suurimkorgus = suurimkorgus;
        this.vaikseimkorgus = vaikseimkorgus;
        
        this.kassidemassidesumma = kassidemassidesumma;
        this.koertemassidesumma = koertemassidesumma;
        
        this.kassidekeskminekorgus = kassidekeskminekorgus;
        this.koertekeskminekorgus = koertekeskminekorgus;
        
        this.kassidekeskminemass = kassidekeskminemass;
        this.koertekeskminemass = koertekeskminemass;
        
        this.kassidekorgustesumma = kassidekorgustesumma;
        this.koertekorgustesumma = koertekorgustesumma;
    }
}