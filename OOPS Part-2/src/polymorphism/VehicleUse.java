package polymorphism;

import java.util.Scanner;

public class VehicleUse {
	public static void main(String[] args){

	      Object o= new Vehicle(100);
	     // Vehicle v= new Vehicle();
	      
	    //Vehicle v= new Car(4, 100);
	  //  Car c= (Car) v;
	  //  c.numDoors=3;

	      Vehicle v;
	      Scanner s= new Scanner(System.in);
	      int n= s.nextInt();
	      if(n<10){
	          v= new Car(4, 100);
	      }else{
	          v= new Vehicle(100);
	      }
	      v.print();

	    //  Car c= new Vehicle();  -- as per statement, every vehicle is car ---> error

	}

}
