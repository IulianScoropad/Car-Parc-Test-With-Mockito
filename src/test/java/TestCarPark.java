
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.DoubleStream;


@ExtendWith(MockitoExtension.class) class TestCarPark {
    private CarPark carPark;
    @Mock
    private CarDatabase carDb;

    @BeforeEach
    void setUp()
    {
        MockitoAnnotations.initMocks(this);
        carPark = new CarPark();
        carPark.setCarDatabase(carDb);
    }

    @Test
    void testGetPowerOfNthCarInKw()
    {
        List<Integer> carPowers = new ArrayList<>(Arrays.asList(100,200,300));
        when (carDb.getCarPowers()).thenReturn(carPowers);
        int result = carPark.getPowerOfNthCarInKw(1);
        assertEquals(223,result);

    }

    @Test
    void testGetPowerOfNthCarInKwBad()
    {
        List<Integer> carPowers = new ArrayList<>(Arrays.asList());
        when (carDb.getCarPowers()).thenReturn(carPowers);
        Exception exception = assertThrows(RuntimeException.class, () -> carPark.getPowerOfNthCarInKw(1));
        // assertEquals("Mesaj", exception.getMessage());

    }



    @Test
    void setCarDatabase() {
    }

    @Test
    void getPowerOfNthCarInKw() {
    }

    @Test
    void getTheAverageHorsePowerOfTheCarsThatHaveTheName() {

        List <String> possibleNames = Arrays.asList("Audi","Mercedes","BMW");
        Car Car1 = new Car ("Audi",210);
        Car Car2 = new Car ("Mercedes",131);
        Car Car3 = new Car ("Bmw",184);

        when(carDb.getCarByName("Audi")).thenReturn(Car1);
        when(carDb.getCarByName("Mercedes")).thenReturn(Car2);
        when(carDb.getCarByName("BMW")).thenReturn(Car3);


        double result = carPark.getTheAverageHorsePowerOfTheCarsThatHaveTheName(possibleNames);
        assertEquals(175,result,0.005);
        //  System.out.println(Car1 + " + "+ Car2 + " + " + Car3 + " = " + result);
    }
    @Test
    void testGetTheAverageHorsePowerWithCarsNotFound() {
        List<String> carNames = Arrays.asList("Car1", "Car2", "Car3");
        when(carDb.getCarByName(Mockito.anyString())).thenReturn(null);

        assertThrows(RuntimeException.class, () -> carPark.getTheAverageHorsePowerOfTheCarsThatHaveTheName(carNames));

    }



  /*  @Test
    void testupdateThePowerOfACarWithName() {

        List <String> carsInThePark = new ArrayList<>(Arrays.asList(new Car("Audi", 210),new Car("Mercedes",131)));
        when(carDb. getCarByName("Audi")).thenReturn(carsInThePark.get(0));
        boolean result = carPark.updateThePowerOfACarWithName("Audi",184, carsInThePark);
        assertEquals(true,result);

    }
*/
}