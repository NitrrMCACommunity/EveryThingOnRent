class MyThread extends Thread
{
	public void run()
	{
		for(int i=0;i<10;i++)
			System.out.println("Thraed at "+i);
	}
}
public class SuspandedThread {
public static void main(String [] args)
{
	Thread  t=new MyThread();
	t.start();
	t.suspend();
	System.out.println("After Suspand");
	t.resume();
}
}
