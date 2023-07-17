package assign2_complexnumber;

public class ComplexNumbers {
	private int real;
	private int imaginary;
	
	public ComplexNumbers(int real, int imaginary)
	{
		this.real = real;
		this.imaginary = imaginary;
	}

	public void plus (ComplexNumbers c2)
	{
		this.real = this.real + c2.real;
		this.imaginary = this.imaginary + c2.imaginary;
		
	}

		public void multiply (ComplexNumbers c2)
	{
		// this.real = this.real * c2.real;
		// this.imaginary = this.imaginary * c2.imaginary;
		    int temp=this.real;  
	this.real = (this.real*c2.real)-(this.imaginary*c2.imaginary);
	    this.imaginary =temp*c2.imaginary+this.imaginary*c2.real; 
		
	}

	public void print()
	{
		System.out.println(this.real+" + i"+this.imaginary);
	}

}
