package day04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CourierFileManager {
    public Courier crateCourierByFile(Path path) {
        List<String> lines;
        Courier courier = new Courier();
        try {
            lines = Files.readAllLines(path);
            courier = createCourierByStringList(lines);
        }
        catch (IOException ioe) {
            throw new IllegalArgumentException("Cannot read file!");
        }
        return courier;
    }

    private Courier createCourierByStringList(List<String> lines) {
        Courier courier = new Courier();
        for (String line: lines) {
            String[] datas = line.split(" ");
            courier.addRide(new Ride(Integer.parseInt(datas[0]), Integer.parseInt(datas[1]),Integer.parseInt(datas[2])));
        }
        return courier;
    }
}
