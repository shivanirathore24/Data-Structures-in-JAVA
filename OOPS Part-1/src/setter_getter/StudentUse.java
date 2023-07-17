package setter_getter;

public class StudentUse {
	public static void main(String[] args) {
		
		Student s1 = new Student();
		s1.name = "Shivani";
		s1.setRollno(-100);
		System.out.println(s1.name+", "+s1.getRollno());
		
		s1.setRollno(7);
		System.out.println(s1.name+", "+s1.getRollno());
		
		
		
	}

}
