Liskov's Substitution Principle
===============================
If a program module is using a Base class, then the reference to the Base class can be replaced with a Derived class
without affecting the functionality of the program module.

Intent

Derived types must be completely substitutable for their base types.


Example
```

public abstract class Vehicle {
    abstract String engine();
    abstract String lights();
}


public class Bus extends Vehicle {

    @Override
    public String engine() {
        return "Electric";
    }

    @Override
    public String lights() {
        return "Lamp Bulb A";
    }
}


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


```

