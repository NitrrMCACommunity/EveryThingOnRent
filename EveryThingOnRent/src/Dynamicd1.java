class A
{
	void print()
	{
		System.out.println("class A");
	}
}
class B extends A
{
	void print()
	{
		System.out.println("class B");
	}
}
class C extends B
{
	void print()
	{
		System.out.println("class c");
	}
}
public class Dynamicd1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a=new A();
		B b=new B();
		C c=new C();
		a.print();
		b.print();
		c.print();
		a=b;
		a.print();
		b.print();
		b=c;
		b.print();
		c.print();
		
		
	}
}
