
public class Recursion1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        pNumber(1);
	}

static void pNumber(int n)
{
	  if(n>100)
		  return;
	  pNumber(n+1);
	  System.out.println(n);
	  
}
}

