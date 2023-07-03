package DIP.violation;

public class Car {

     Engine e;

     public Car()
     {
          e = new Engine();
     }
     public void printEngineName()
     {
          System.out.println(e.getEngineName());
     }


}
