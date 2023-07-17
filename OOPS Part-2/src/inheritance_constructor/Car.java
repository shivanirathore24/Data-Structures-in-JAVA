package inheritance_constructor;

public class Car  extends Vehicle{

    int numDoors;
//    int maxSpeed;

    public Car(int numDoors, int maxspeed){
      super(maxspeed);
      System.out.println("Car's Constructor");
      this.numDoors = numDoors;
    }

    public void print(){
        super.print();
        System.out.println("Car "+ " numdoors "+ numDoors);
    }

    public void printMaxspeed(){
        super.maxSpeed = 15;
        System.out.println(maxSpeed+ " " + super.maxSpeed);
    }

}
