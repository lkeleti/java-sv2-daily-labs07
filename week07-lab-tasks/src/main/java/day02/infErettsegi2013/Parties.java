package day02.infErettsegi2013;

public class Parties {
    private String name;
    private int votes;

    public Parties(String name, int votes) {
        this.name = name;
        this.votes = votes;
    }

    public String getName() {
        return name;
    }

    public int getVotes() {
        return votes;
    }

    public void incVotes(int votes) {
        this.votes += votes;
    }
}
