package lsp.src;

/**
 * Created by vicboma on 23/06/14.
 */
public class Car extends Vehicle {
    private String engine;
    private String lights;

    public Car(String engine) {
        this.engine = engine;
        this.lights = "Xenon";
    }

    @Override
    public String engine() {
        return this.engine;
    }

    @Override
    public String lights() {
        return this.lights;
    }
}
