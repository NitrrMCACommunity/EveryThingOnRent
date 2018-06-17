abstract class shape
{
	abstract void draw();
}
class TwoD extends shape
{
	void draw()
	{
		System.out.println("2D drawing");
	}
}
class Tringle extends TwoD
{
	void draw()
	{
		System.out.println("triangle is drawing");
	}
}
public class Abstract1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
   TwoD t=new TwoD();
   Tringle tr=new Tringle();
   t.draw();
   tr.draw();
	}

}
