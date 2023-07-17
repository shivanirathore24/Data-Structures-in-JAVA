package interface_multipleInheritence;

public class Car extends Vehicle implements VehicleInterface, CarInterface {
	@Override
    public boolean isMotorized(){
      return true;
    }

    @Override
    public String getCompany(){
      return null;
     }

     @Override
     public int numGears(){
       return 5;
      }

      void print(){
          System.out.println(PI);
      }

}
