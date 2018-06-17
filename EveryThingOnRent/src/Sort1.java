import java.util.*;
public class Sort1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] s= {"hearts","diamond","clubs","spades"};
		List<String> list=Arrays.asList(s);
		System.out.println("unsorted array element "+list);
		Collections.sort(list);
		System.out.println("sorted array element "+list);
				

	}

}
