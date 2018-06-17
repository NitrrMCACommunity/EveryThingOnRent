
public class Exceptionh {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			String name="Spy";
			System.out.println("Before Exception");
			if(name.equals("Spy"))
			throw new IllegalAccessException("ExceptionOccur");
			System.out.println("after exception");
		}
		catch(IllegalAccessException e)
		{
			System.out.println("exception caught:"+e);
		}

	}

}
