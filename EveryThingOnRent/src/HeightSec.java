import java.util.TreeMap;

public class HeightSec {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      TreeMap<Integer,Integer> tm=new TreeMap<Integer,Integer>();
      tm.put(5,1);
      tm.put(6,2);
      tm.put(7,3);
      tm.put(11,4);
      tm.put(15,5);
      System.out.println("height is"+tm.lastKey());
      tm.remove(tm.lastKey());
      System.out.println("second Height is"+tm.lastKey());
	}

}
