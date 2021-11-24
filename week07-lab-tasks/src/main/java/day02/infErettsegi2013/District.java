package day02.infErettsegi2013;

public class District {
    private int disrtictID;
    private String firstName;
    private String lastName;
    private PartyNameAbbreviation party;
    private int votes;

    public District(int disrtictID, String firstName, String lastName, PartyNameAbbreviation party, int votes) {
        this.disrtictID = disrtictID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.party = party;
        this.votes = votes;
    }

    public int getDisrtictID() {
        return disrtictID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public PartyNameAbbreviation getParty() {
        return party;
    }

    public int getVotes() {
        return votes;
    }

    public void incVotes(int votes) {
        this.votes += votes;
    }


}
