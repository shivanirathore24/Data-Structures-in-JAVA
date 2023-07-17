package protectedmodifier;

import functionoverriding.Vehicle;

public class Truck extends Vehicle{

    int maxLoadingCapacity;

    public void print(){
        System.out.println("Vehicle "+" color "+ getColor()+" maxspeed "+ maxSpeed +" maxLoadingCapacity "+maxLoadingCapacity);
    }
    //maxspeed is accessible outside the package but withing child class -- protected property
}
