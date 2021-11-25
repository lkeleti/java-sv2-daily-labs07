package day04;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class CourierFileManagerTest {
    CourierFileManager courierFileManager;
    Courier courier;

    @BeforeEach
    void init() {
        courierFileManager = new CourierFileManager();
        courier = courierFileManager.crateCourierByFile(Paths.get("src/test/resources/rides.txt"));
    }
    @Test
    void createCourierByFileTest() {
        assertEquals(6, courier.getRides().size());
    }

    @Test
    void CourierTest() {
        assertEquals(1, courier.getRides().get(0).getNumberOfDay());
        assertEquals(1, courier.getRides().get(0).getNumberOfRide());
        assertEquals(12, courier.getRides().get(0).getDistance());
    }

    @Test
    void errorReadingFileTest() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                ()-> new CourierFileManager().crateCourierByFile(Paths.get("src/test/resources/rides_.txt"))
        );
        assertEquals("Cannot read file!", iae.getMessage());
    }
}