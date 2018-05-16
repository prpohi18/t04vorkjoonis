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

    public int getHeight() {
        return korgus;
    }

    public void setHeigth(int korgus) {
        this.korgus = korgus;
    }
}
