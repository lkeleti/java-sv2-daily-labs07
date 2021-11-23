package day02.infErettsegi2013;

public enum PartyNameAbbreviation {

    GYEP("Gyümölcsevők Pártja"), HEP("Húsevők Pártja"), TISZ("Tejivók Szövetsége"), ZEP("Zöldségevők Pártja"), FUG("Független jelölt");

    private String fullName;

    PartyNameAbbreviation(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }
}
