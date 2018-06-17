import java.util.HashMap;

public class Hashmap1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Integer,String> Map=new HashMap<Integer,String>();
		Map.put(101,"let us c");
		Map.put(102,"operating system");
		Map.put(103,"unix");
		System.out.println("values before remove:"+Map);
		Map.remove(102);
		System.out.println("values after remove:"+Map);

	}

}
