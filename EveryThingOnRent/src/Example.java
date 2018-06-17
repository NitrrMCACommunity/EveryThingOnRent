class Name
{
	String First_name;
	String Last_name;
	Name(String f,String l)
	{
		First_name=f;
		Last_name=l;
	}
	public String toString()
	{
		return String.format("%s%s",First_name,Last_name);
	}
}
public class Example {

	public static void main(String[] args) {
		// TODO Auto-generated method stubk
		Name n=new Name("madhavi","kumari");
		System.out.println(n);

	}

}
