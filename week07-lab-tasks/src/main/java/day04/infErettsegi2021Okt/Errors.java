package day04.infErettsegi2021Okt;

public enum Errors {
    RESERVED("A helyet már kitöltötték"),
    INTHEROW("Az adott sorban már szerepel a szám"),
    INTHECOL("Az adott oszlopban már szerepel a szám"),
    INTHESEGMENT("Az adott résztáblázatban már szerepel a szám"),
    OK("A lépés megtehető");

    private String valueHun;

    Errors(String valueHun) {
        this.valueHun = valueHun;
    }

    public String getValueHun() {
        return valueHun;
    }
}
