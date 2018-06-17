import java.util.TreeMap;

public class FrqTreeMap {
	public static void main(String args[])
	{
		TreeMap<Integer,Integer> hm=new TreeMap<Integer,Integer>();
		int arr[]= {10,9,2,10,2,7,11,9,2,10};
		int i;
		for(i=0;i<arr.length;i++)
		{
			if(!hm.containsKey(arr[i]))
			hm.put(arr[i],1);
			else
			{
				int c=hm.get(arr[i]);
			hm.put(arr[i],++c);
			}
		}
		System.out.println(hm);
	}

}
