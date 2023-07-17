package finalvariable;

public class Student {
	public String name;
    final private int rollNumber;
    double cgpa;
    final double converisonFactor= 0.95;

    public Student(String name, int rollNumber)
    {
      this.name=name;
      this.rollNumber= rollNumber;
    }


}
