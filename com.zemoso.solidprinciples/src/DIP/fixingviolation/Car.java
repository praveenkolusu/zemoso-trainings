package DIP.fixingviolation;

import DIP.violation.Engine;

public class Car {

    Engine e;

    public Car(Engine e)
    {
        this.e = e;
    }

    public void printEngineName()
        {
        System.out.println(e.getEngineName());
        }

}
