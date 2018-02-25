import java.awt.image.*;
import javax.imageio.*;
import java.awt.*;
import java.io.*;
import java.net.*;

public class Ktnaide{
    public static void main(String[] args) throws Exception{
        int koer1 = 2000;
        int koer2 = 6000;
        int kass1 = 1000;
        int kass2 = 2000;
        int kass3 = 800;
        int koerad = koer1 + koer2;
        int kassid = kass1 + kass2 + kass3;
        if (koerad > kassid) {
            System.out.println("Koerte summa suurem!");
        } else {
            System.out.println("Kasside summa suurem!");
        }
        
        Graafik.graph();

        Arvud.maxMin();
        Arvud.failideks();
    }
}