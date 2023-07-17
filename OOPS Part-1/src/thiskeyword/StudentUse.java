package thiskeyword;

public class StudentUse {
	public static void main(String[] args) {
		
		Student s1 = new Student();
		s1.name = "Shivani";
		System.out.println("s1 "+ s1);
		
		s1.setRollno(7);
		System.out.println(s1.name+", "+s1.getRollno());
		
		
		Student s2 = new Student();
		s2.name = "Sati";
		System.out.println("s2 "+s2);
		
		s2.setRollno(8);
		System.out.println(s2.name+", "+s2.getRollno());
		
		
		
	}

}
