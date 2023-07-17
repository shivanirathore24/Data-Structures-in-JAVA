package static_function;

public class StudentUse {
public static void main(String[] args) {
	//Scanner s = new Scanner(System.in);
    Student s1 = new Student("Manisha",7);

    Student s2= new Student("Ankush",8);
    Student s3 = new Student();
    //Student s3= new Student("Ankush");
	
    System.out.println(Student.getNumStudent());
    



}
}
