package day02.infErettsegi2013;

public class Vote {
    private int districtID;
    private int voteNumber;
    private String firstName;
    private String lastName;
    private PartyNameAbbreviation party;

    public Vote(int districtID, int voteNumber, String firstName, String lastName, PartyNameAbbreviation party) {
        this.districtID = districtID;
        this.voteNumber = voteNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.party = party;
    }

    public int getDistrictID() {
        return districtID;
    }

    public int getVoteNumber() {
        return voteNumber;
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
}
