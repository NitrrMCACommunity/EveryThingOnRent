
public class Recursion2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     reverseNu(100);
	}
	static void reverseNu(int n)
	{
		if(n<1)
			return;
		System.out.println(n);
		reverseNu(n-1);
	}

}
