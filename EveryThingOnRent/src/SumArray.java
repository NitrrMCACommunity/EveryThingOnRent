
public class SumArray {
    	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    int arr[]={3,4,7,1,2,9,8};
	    int i,j,k,l;
	   // System.out.println(arr.length);
	    for(i=0;i<7;i++)
	    {
	    	
	    	for(j=i+1;i<7;j++)
	    	{
	    		//System.out.println(j);
	    		for(k=j+1;j<7;k++)
	    		{
	    			//System.out.println(k);
	    			for(l=k+1;l<7;l++)
	    			{
	    				System.out.println(l);
	    					if((arr[i]+arr[j])==(arr[k]+arr[l]))
	    					System.out.println("("+arr[i]+","+arr[j]+")"+"("+arr[k]+","+arr[l]+")");
	    			}
	    		}
	    	}
	    }

	}

}
