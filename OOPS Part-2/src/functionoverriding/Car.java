package functionoverriding;

public class Car extends Vehicle{

    int numDoors;

    public void print(){
        System.out.println("Car "+ " color "+ getColor()+" maxspeed " + maxSpeed + " numdoors "+ numDoors);
    }
}
