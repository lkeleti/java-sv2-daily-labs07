package day01;

public class NameValidator {

    public boolean isValidName(String name) {
        if (name == null || name.trim().length() == 0 || name.trim().split(" ").length < 2) {
            throw new IllegalArgumentException("Invalid name!");
        }
        return true;
    }

}
