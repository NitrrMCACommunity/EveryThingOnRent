
public class Shuffle1 {
 static void shuffle(Object[] array)
 {
	 int size=array.length;
	 int i;
	 for(i=0;i<array.length;i++)
	 {
		 int index=1+(int)((Math.random())*(size-1));
		 Object temp=array[i];
		// System.out.print(index);
		array[i]=array[index];
		 array[index]=temp;
	 }
 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
 Integer a[]= {0,2,1,9,4,5};
 shuffle(a);
 for(int i=0;i<a.length;i++)
 {
	 System.out.print(" "+a[i]);
 }
	}

}
