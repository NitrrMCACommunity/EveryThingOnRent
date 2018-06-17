import java.util.Iterator;
import java.util.*;
public class Hashse1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.util.HashSet<String> set=new HashSet<String>();
		set.add("ravi");
		set.add("vijay");
		set.add("raj");
		set.add("ajay");
		java.util.HashSet<String> set1=new HashSet<String>();
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
				System.out.println(name);
		}

	}

}
