interface Vichle
{
	final String TAG="honda";
	void speedincrease(int speed);
	void gearincre(int gear);
	int getspeed();
	int getgear();
	default boolean isLightOn()
	{
		return true;
	}
}
class Car implements Vichle
{
	public int speed;
	 public int gear;
	Car()
	{
		speed=0;
		gear=0;
	}
	public void speedincrease(int speed)
	{
		this.speed=this.speed+speed;
	}
	public void gearincre(int gear)
	{
		this.gear=this.gear+gear;
	}
	
	public int getspeed()
	{
		return speed;
	}
	public int getgear()
	{
		return gear;
	}
}
public class InterfaceDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car c=new Car();
		c.speedincrease(150);
		c.gearincre(4);
		System.out.println("speed"+c.getspeed()+"gear"+c.getgear());
		if(c.isLightOn())
			System.out.println("light is on");

	}

}
