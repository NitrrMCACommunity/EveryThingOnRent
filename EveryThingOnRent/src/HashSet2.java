import java.util.Iterator;
import java.util.*;
public class HashSet2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<String> set=new HashSet<String>();
		int flag=0;
		set.add("ravi");
		set.add("vijay");
		set.add("raj");
		set.add("ajay");
		HashSet<String> set1=new HashSet<String>();
		set1.add("madhavi");
		set1.add("ravi");
		set1.add("raj");
		set1.add("sita");
		set1.add("rita");
		Iterator<String> itr=set1.iterator();
		while(itr.hasNext())
		{
			String name=itr.next();
				if(set.contains(name))
				{
					flag=1;
					break;
				}
			}
		if(flag==1)
			System.out.println("jointset");
			else
				System.out.println("disjointset");


	}

}
