import java.util.*;
public class SubsetHat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]= {5,6,4,3,8,1,9};
		int a2[]= {5,1,4};
		java.util.HashTable<Integer,Integer> ht=new HashTable<Integer,In>();
		int i;
		for(i=0;i<a.length;i++)
		{
			ht.add(a[i]);
		}
		for(i=0;i<a2.length;i++)
		{
			if(!ht.contains(a2[i]))
			{
				System.out.println("not subset");
				return;
			}
		}
		System.out.println("subset");

	}
}
