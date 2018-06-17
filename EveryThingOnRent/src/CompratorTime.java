import java.util.List;

class Time2
{
	private int hour,minute,second;
	Time2(int h,int m,int s)
	{
		hour=h;
		minute=m;
		second=s;
	}
	void sethour(int hour1)
	{
		hour=hour1;
	}
	void setminute(int minute1)
	{
		minute=minute1;
	}
	void setsecond(int second1)
	{
		second=second1;
	}
	int gethour()
	{
		return hour;
	}
	int getminute()
	{
		return minute;
	}
	int getsecond()
	{
		return second;
	}
}
public class TimeComparator implements Comparator<Time2>
{
	public int compare(Time2 time1,Time2 time2)
	{
		int hourCompare=time1.gethour()-time2.gethour();
		if(hourCompare!=0)
			return hourCompare;
		int minuteCompare=time1.getminute()-time2.getminute();
		if(hourCompare!=0)
			return minuteCompare;
		int secondCompare=time1.getsecond()-time2.getsecond();
		return secondCompare;
	}
}

public class CompratorTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Time2> list=new ArrayList<Time2>();
		list.add( new Time2(6,24,34));
		list.add(new Time2(18,14,58));
		list.add(new Time2(6,05,34));
		list.add(new Time2(12,14,58));
		System.out.println("unsorted array element",list);
		Collection.ort(list,new TimeComparator());
		System.out.println("sorted list elements",list);
		

	}

}
