import java.util.*;
public class ManagerEmp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hashtable<String,Integer> ht=new Hashtable<String,Integer>();
		String emp[]= {"A","B","C","D","E","F"};
		String man[]= {"C","C","F","E","F","F"};
		for(int i=0;i<man.length;i++)
		{
			if(ht.containsKey(man[i]))
			{
				int c=ht.get(man[i]);
				c=c+1;
				ht.put(man[i],c);
			}
			else
				ht.put(man[i],1);
		}
		System.out.println(ht);


	}

}
