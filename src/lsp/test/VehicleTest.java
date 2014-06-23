package lsp.test;

import lsp.src.Bus;
import lsp.src.Car;
import lsp.src.Vehicle;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VehicleTest {

    private Vehicle vehicle;

    @Test
    public void setVehicle() throws Exception {
        vehicle = new Car("V8");
        assertEquals("fail Car derived class", Vehicle.class, vehicle.getClass().getGenericSuperclass());
        vehicle = new Bus();
        assertEquals("fail Bus derived class", Vehicle.class, vehicle.getClass().getGenericSuperclass());

        Car car = new Car("V10");
        assertEquals("fail Car derived class", Vehicle.class, car.getClass().getGenericSuperclass());
        Bus bus = new Bus();
        assertEquals("fail Bus derived class", Vehicle.class, bus.getClass().getGenericSuperclass());
    }
}