package super_keyword;

public class Car extends Vehicle{
	int numDoors;
    int maxSpeed;

    public void print(){
        super.print();
        System.out.println("Car "+ " numdoors "+ numDoors);
    }

    public void printMaxspeed(){
        super.maxSpeed = 15;
        System.out.println(maxSpeed+ " " + super.maxSpeed);
    }

}
