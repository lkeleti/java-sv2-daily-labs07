package day02.infErettsegi2013;

import java.util.Comparator;

public class SortDistrictByID implements Comparator<District> {
    public int compare(District a, District b)
    {

        return a.getDisrtictID() - b.getDisrtictID();
    }
}
