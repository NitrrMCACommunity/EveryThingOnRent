class Matrixop
{
	int m1[][];
	int m2[][];
	int col1,col2;
	int row1,row2;
	Matrixop(int m11[][],int m22[][],int c,int c2,int r,int r2 )
	{
		m1=m11;
		m2=m22;
		 col1=c;
		 col2=c2;
		 row1=r;
		 row2=r2;
	}
	int [][]addition()
	{
		int sum[][]=new int[row1][col1];
		if(row1!=row2||col1!=col2)
		return null;
		for(int i=0;i<row1;i++)
		{
			for( int j=0;j<col1;j++)
				sum[i][j]=m1[i][j]+m2[i][j];
		}
		return sum;
	}
	int [][]multiplication()
	{
		int mul[][]=new int[row1][col2];
		if(col1!=row2)
			return null;
		for(int i=0;i<row1;i++)
		{
			int sum=0;
			for(int j=0;j<col1;j++)
			{
				for(int k=0;k<col1;k++)
					sum+=m1[i][k]*m2[k][j];
			mul[i][j]=sum;	
			}
		}
		return mul;
	}
}
public class Additionop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int  m1[][]= {{1,2,3},{4,5,6},{7,8,9}};
		int m2[][]= {{1,0,0},{2,0,1},{3,0,1}};
		Matrixop obj=new Matrixop(m1,m2,3,3,3,3);
		int sum[][]=obj.addition();
		int mul[][]=obj.multiplication();
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			System.out.print(mul[i][j]);
			System.out.println("");
			
		}
	}

}
