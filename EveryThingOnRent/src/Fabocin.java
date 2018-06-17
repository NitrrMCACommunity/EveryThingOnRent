
public class Fabocin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("0,1");
      febonacci(0,1);
	}
	static void febonacci(int i,int j)
	{
		int k=i+j;
		if(k>100)
			return;
		System.out.print(k+",");
		febonacci(j,k);
	}

}
