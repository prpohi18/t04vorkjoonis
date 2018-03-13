package kodut664;

public class Soccer {
    protected String name;
    protected String position;
    protected int points;

    public Soccer(String name, String position, int points) {
        this.name = name;
        this.position = position;
        this.points = points;
    }
    public float getPoints(){
        return points;
    }
    public String getPosition(){
        return position;
    }
    public String getName(){
        return name;
    }
}
