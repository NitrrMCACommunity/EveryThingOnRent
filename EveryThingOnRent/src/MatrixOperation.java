class Matrix
{ 
	int i,j;
	int r,c,m[][];
	Matrix(int r1,int c1,int m1[][])
	{
		r=r1;
		c=c1;
		m=m1;
	}
	int find( int x)
	{
		for(i=0;i<r;i++)
		{
			for(j=0;j<c;j++)
				if(m[i][j]==x)
				{
					System.out.println(x);
					return i;
				}
		}
		return 0;
	}
	int rowsum(int rno)
	{
		int sum=0;int j;
		for(j=0;j<c;j++)
		{
			sum=sum+m[rno][j];
		}
		return sum;
	}
	int colsum(int colno)
	{
		int sum=0;int i;
		for(i=0;i<r;i++)
		{
			sum=sum+m[i][colno];
		}
		return sum;
		
	}
	void print()
	{
		for(i=0;i<r;i++)
		{
			for(j=0;j<c;j++)
			{
				System.out.print(m[i][j]);
			}
		System.out.println("");
		}
	}
	void transpose()
	{
		for(i=0;i<r;i++)
		{
			for(j=i+1;j<c;j++)
			{
				int temp=m[i][j];
				m[i][j]=m[j][i];
				m[j][i]=temp;
				
			}
		}
		int temp=c;
		c=r;
		r=temp;
	}
	int getrow()
	{
		return r;
	}
	int getcoloumn()
	{
		return c;
	}
	int getElement(int i,int j)
	{
		return m[i][j];
	}
	
}
public class MatrixOperation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int  m[][]= {{1,2,3},{4,5,6},{7,8,9}};
		Matrix obj=new Matrix(3,3,m);
		obj.find(7);
		System.out.println("Sum of row1="+obj.rowsum(1));
		System.out.println("sum of colu="+obj.colsum(1));
		obj.transpose();
		obj.print();
		
		
		

	}

}
