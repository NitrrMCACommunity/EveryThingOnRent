import java.util.*;
public class Frequency {

	public static void main(String[] args) {
		int arr[]= {10,9,2,10,2,7,11,9,2,10};
		ArrayList<Integer> dis=new ArrayList<Integer>(); 
		int i;
		HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
		for(i=0;i<arr.length;i++)
		{
			if(!hm.containsKey(arr[i])) {
				hm.put(arr[i],1);
				dis.add(arr[i]);
			}
			else {
				int c=hm.get(arr[i]);
				hm.put(arr[i], ++c);
			}
		}
			System.out.println(hm);
	}

}
