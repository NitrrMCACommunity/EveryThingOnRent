import java.util.TreeMap;

public class EqualTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
   TreeMap<Integer,Integer> tm=new TreeMap<Integer,Integer>();
   tm.put(1,5);
   tm.put(2,12);
   tm.put(5,13);
   tm.put(6,17);
   TreeMap<Integer,Integer> tm1=new TreeMap<Integer,Integer>();
   tm1.put(1, 5);
   tm1.put(2,12);
   tm1.put(5,13);
   tm1.put(6,17);
   if(tm.size()!=tm1.size())
   {
	   System.out.println("Not equals");
	   return;
   }
   while(tm.size()>0)
   {
	   int key=tm.firstKey();
	   int Key=tm1.firstKey();
	   if(!tm1.containsKey(key))
	   {
		   System.out.println("not equals");
		   return;
	   }
	   int value=tm.get(key);
	   if(!tm1.containsValue(value)) {
		   System.out.println("not equals");
		   return;
	   }
	   tm.remove(key);
   }
   System.out.println("both are equal");
	   
   
   
   
	}

}
