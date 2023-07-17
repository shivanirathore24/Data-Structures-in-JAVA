package interface_multipleInheritence;

public class Vehicle implements VehicleInterface {
	 @Override
	    public boolean isMotorized(){
	      return false;
	    }

	    @Override
	    public String getCompany(){
	      return null;
	    }

	    void prnt(){
	      System.out.println(PI);
	    }

}
