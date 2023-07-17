package bounded_generics;

public class Print 
{
    public static<T extends PrintInterface> void printArray(T arr[])
    {
        for(int i=0;i<arr.length;i++){
          arr[i].print();
//     System.out.println(arr[i]);
        }
    }

 public static void main(String[] args) {
	
      Vehicle v[] = new Vehicle[5];
      for(int i=0;i < v.length;i++){
        v[i]= new Vehicle(10*i, "Shiv");
      }
      printArray(v);

      Student students[] = new Student[5];
      for(int i=0;i<students.length;i++){
        students[i]= new Student(10*i+1);
      }
      printArray(students);

    }

}
