package abstract_keyword;

public abstract class Vehicle {
	private String color;
    int maxSpeed;

    public Vehicle(){
      color="red";
      System.out.println("Vehicle's Constructor");
      maxSpeed= 60;
    }

    public Vehicle(int maxSpeed){
      System.out.println("Vehicle's Constructor");
      this.maxSpeed = maxSpeed;
    }

    public String getColor(){
      return color;
    }

    public void setColor(String color){
      this.color = color;
    }

    public void print(){
      System.out.println("Vehicle"+"color"+color);
    }

    public abstract boolean isMotorized();
    public abstract String getCompany();

}
