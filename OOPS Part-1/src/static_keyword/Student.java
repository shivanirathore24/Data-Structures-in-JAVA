package static_keyword;

public class Student {
	    public String name;
	    final private int rollNumber;
	    double cgpa;
	    final double converisonFactor= 0.95;
	    static int numStudents;

	    public Student(String name){
	      this.name=name;
	      numStudents++;
	      this.rollNumber= numStudents;   
	    }

	    
	    

}
