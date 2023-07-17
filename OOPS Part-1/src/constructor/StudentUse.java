package constructor;

public class StudentUse {
	 public static void main(String[] args){
	        
	        Student s1 = new Student("Manisha",50);
	        s1.print();
	        
	        Student s2= new Student("Ankush");
	        s2.print();

	        Student s3 = new Student();
	        s3.print();
	    }

}
