package static_function;

public class Student {
	public String name;
    final private int rollNumber;
    double cgpa;
    final double converisonFactor= 0.95;
    static int numStudents;

    public Student(String name, int rollNumber){
      this.name=name;
      this.rollNumber= rollNumber;
      numStudents++;

    }

    public Student(){
      name="abc";
      numStudents++;
      this.rollNumber=numStudents;
    }

    public static int getNumStudent(){
      //System.out.println(rollNumber);
      return numStudents;
    }

    public void print(){
      System.out.println(name+" "+rollNumber);
    }

}
