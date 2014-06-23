package isp.src;

import isp.api.Vehicle;

/**
 * Created by vicboma on 23/06/14.
 */
public class Bus implements Vehicle {

    @Override
    public String engine() {
        return "Electric";
    }

    @Override
    public String lights() {
        return "Lamp Bulb A";
    }
}
