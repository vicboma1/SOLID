package isp.test;

import isp.api.Vehicle;
import isp.src.Bus;
import isp.src.Car;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class VehicleTest {

    private Vehicle vehicle;

    @Test
    public void setVehicleInterface() throws Exception {
        vehicle = new Car("V8");
        assertTrue("fail vehicle interface", (vehicle instanceof Vehicle) && (vehicle instanceof Car));
        vehicle = new Bus();
        assertTrue("fail vehicle interface", (vehicle instanceof Vehicle) && (vehicle instanceof Bus));
    }
}