class HashTable<A>
{
	private int arr[];
	private A data[];
	HashTable()
	{
		arr[]=new int[100];
		data[]=new A[100];
		size=0;
	}
	void add(A n)
	{
		size++;
		data[size]=n;
		arr[n]=size;
	}
	int getsize()
	{
		return size;
	}
	boolean contains(int a2A 5)
	{
		if(arr[5]==0)
			return false;
		return true;
	}
	int get(K key)
	{
		return data[key];
	}
		public boolean isEmpty()
		{
			return size()==0;
		}
		 A remove (int key)
		 {
			 arr[data[key]]==0;
			 return data[key];
		 }
}
public class OwnHashTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashTable<Integer> ht=new HashTable<Integer>();
        ht.add(5);
        ht.add(6);
        ht.add(8);
        ht.add(9);
        System.out.println(ht.getsize());
        System.out.println(ht.remove(8));
        System.out.println(ht.remove(5));
        System.out.println(ht.remove(6));
	}

}
