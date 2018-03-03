package kodutoo2;
public class Kodutoo2 {
    String nimetus1;
    double aatommasside_summa1;
    int laeng1;
    String nimetus2;
    double aatommasside_summa2;
    int laeng2;

    public Kodutoo2(String uusnimetus1, double uusaatommasside_summa1, int uuslaeng1, String uusnimetus2, double uusaatommasside_summa2, int uuslaeng2) {
        nimetus1 = uusnimetus1;
        nimetus2 = uusnimetus2;
        aatommasside_summa1 = uusaatommasside_summa1;
        aatommasside_summa2 = uusaatommasside_summa2;
        laeng1 = uuslaeng1;
        laeng2 = uuslaeng2;
    }
    public boolean tehtav() {
        double aine_laeng = laeng1 + laeng2;
        return aine_laeng == 0;
    }
    public double molekulmass() {
        return aatommasside_summa1 + aatommasside_summa2;
    }
    public String toString() {
        if (tehtav()) {
            return "Aine("+nimetus1+" + "+nimetus2+") on tehtav, molekulmass: "+molekulmass();
        } else {
            return "Aine("+nimetus1+" + "+nimetus2+") ei ole tehtav, molekulmass: "+molekulmass();
        }
    }
}
