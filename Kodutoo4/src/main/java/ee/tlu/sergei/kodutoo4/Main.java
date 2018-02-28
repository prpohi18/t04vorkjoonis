
package ee.tlu.sergei.kodutoo4;



public class Main{
    public static void main(String[] args) throws Exception{
        int koerMass1 = 4528;
        int koerMass2 = 7856;
        int kassMass1 = 565;
        int kassMass2 = 458;
        int kassMass3 = 785;
        int koerad = koerMass1 + koerMass2;
        int kassid = kassMass1 + kassMass2 + kassMass3;
        if (koerad > kassid) {
            System.out.println("Koerte masside summa suurem!");
        } else if (kassid > koerad){
            System.out.println("Kasside masside summa suurem!");
        } else {
            System.out.println("Massid on võrdsed!");
        }
        
        Loomad loom = new Loomad();
        Graph.graph();
        Loomad.faili();
        System.out.println(loom);
    }
}

/*
output

Koerte masside summa suurem!
Koerte suurim mass on: 12000
Koerte suurim kõrgus on: 100
Koerte väikseim mass on: 2000
Koerte väikseim kõrgus on: 30
Kasside suurim mass on: 2000
Kasside suurim kõrgus on: 35
Kasside väikseim mass on: 800
Kasside väikseim kõrgus on: 20
*/