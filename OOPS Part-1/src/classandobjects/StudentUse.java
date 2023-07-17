package classandobjects;

public class StudentUse {
	 public static void main(String[] args)
	 {
		 
	        //Scanner s= new Scanner(source)
	        Student s1= new Student();
	        Student s2= new Student();
	        System.out.println(s1);
	        s1.name="Shivani";
	        s1.rollNumber = 10;
	        System.out.println(s1.name + " "+ s1.rollNumber);

	        s2.name= "Ajinkya";
	        s2.rollNumber= 50;

	        System.out.println(s2.name + " " + s2.rollNumber);
	 }

}
