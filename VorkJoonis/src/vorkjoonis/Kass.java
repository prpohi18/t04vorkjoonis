package vorkjoonis;
public class Kass {
    protected int mass;
    protected int korgus;

    public Kass(int mass, int korgus) {
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
        return "Kass{" + "mass=" + mass + ", korgus=" + korgus + '}';
    }
    
    
}
