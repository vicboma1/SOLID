Single Responsibility Principle
===============================

In this context a responsibility is considered to be one reason to change. 
This principle states that if we have 2 reasons to change for a class, we have to split the functionality in two classes. 
Each class will handle only one responsibility and on future if we need to make one change we are going to make it in the class which handle it.
When we need to make a change in a class having more responsibilities the change might affect the other functionality of the classes.

Intent

A class should have only one reason to change.


Example - Bad design
```
public interface Vehicle {
    abstract String engine();
    abstract String lights();
}

public class Bus implements Vehicle {

    @Override
    public String engine() {
        return "Electric";
    }

    @Override
    public String lights() {
        return "";
    }
}


public class Car implements Vehicle {
    private String engine;

    public Car(String engine) {
        this.engine = engine;
    }

    @Override
    public String engine() {
        return this.engine;
    }

    @Override
    public String lights() {
        return "";
    }
}

```

We apply single responsibility principle - Good design

```

public interface Engine {
    String engine();
}

public interface Lights {
    String lights();
}

public interface Vehicle extends Engine, Lights{
}

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

public class Car implements Vehicle {
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

