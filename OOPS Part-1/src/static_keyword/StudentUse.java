package static_keyword;

public class StudentUse {
	public static void main(String[] args) {
		    System.out.println(Student.numStudents);
	        //System.out.println(Student.name);

	        Student s1 = new Student("Manisha");

	        Student s2= new Student("Ankush");
	        Student s3= new Student("Ankush");

	        System.out.println(s1.numStudents);
	        System.out.println(s2.numStudents);
	        System.out.println(Student.numStudents);
		
	}

}
