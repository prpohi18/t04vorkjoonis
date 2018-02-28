package vorkjoonis;
public class Koer {
    protected int mass;
    protected int korgus;

    public Koer(int mass, int korgus) {
        this.mass = mass;
        this.korgus = korgus;
    }

    public int getMass() {
        return mass;
    }

    public void setMass(int mass) {
        this.mass = mass;
    }

    public int getKorgus() {
        return korgus;
    }

    public void setKorgus(int korgus) {
        this.korgus = korgus;
    }

    @Override
    public String toString() {
        return "Koer{" + "mass=" + mass + ", korgus=" + korgus + '}';
    }
    
    
}
