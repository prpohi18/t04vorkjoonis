public class Basketball {
    protected String name;
    protected String team;
    protected int points;

    public Basketball(String name, String team, int points) {
        this.name = name;
        this.team = team;
        this.points = points;
    }
    public float getPoints(){
        return points;
    }
    public String getTeam(){
        return team;
    }
    public String getName(){
        return name;
    }
}