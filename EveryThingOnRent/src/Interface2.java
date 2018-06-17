interface vichle
{
	final String TAG="honda";
	void setmodel(String model);
}
interface twowhleer extends vichle
{
	void speedincr(int s);
	void gearincre(int gear);
}
class bike implements twowhleer
{
	public int speed;
	 public int gear;
	bike()
	{
		speed=0;
		gear=0;
	}
}
	public setmodel(String model)
	{
	public void speedincr(int s)
	{
		this.speedincr=this.speedincr+s;
	}
	
	
}
public class Interface2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
