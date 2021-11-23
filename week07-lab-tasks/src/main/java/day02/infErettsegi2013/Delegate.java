package day02.infErettsegi2013;

public class Delegate {
    private String firstName;
    private String lastName;
    private int votes;
    private PartyNameAbbreviation party;

    public Delegate(String firstName, String lastName, int votes, PartyNameAbbreviation party) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.votes = votes;
        this.party = party;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getVotes() {
        return votes;
    }

    public PartyNameAbbreviation getParty() {
        return party;
    }

    public void incVotes(int votes) {
        this.votes += votes;
    }
}
