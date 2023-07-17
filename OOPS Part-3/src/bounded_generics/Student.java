package bounded_generics;

public class Student implements PrintInterface{
	int rollNumber;

	public Student(int rollNumber) {
		this.rollNumber = rollNumber;
	}

	@Override
	public void print() {
		System.out.println(rollNumber);	
	}
	

}
