class MyThread1 implements Runnable
{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName()+" Running");
		
	}
	
}
public class ThreadGropImp {
public static void main(String [] args)
{
	Runnable runnable=new MyThread1();	
	ThreadGroup t=new ThreadGroup("Group1");
	Thread t1=new Thread(t,runnable,"Thread1");
	t1.start();
	Thread t2=new Thread(t,runnable,"Thread2");
	t2.start();
	Thread t3=new Thread(t,runnable,"Thread3");
	t3.start();
	Thread t4=new Thread(t,runnable,"Thread4");
	t4.start();
	t.list();
	//t.destroy();
	System.out.println(t.activeGroupCount());
}
}
