import java.sql.Connection;
import java.sql.PreparedStatement;

public class CalogOperations {
public static void insert(String itemid,String cust_id,String w_id,int status)
{
	try {
		Connection con=Dbopr.getConnection();
		PreparedStatement ps=con.prepareStatement("insert into catalog1 values(?,?,?,?)");
		ps.setString(1, itemid);
		ps.setString(2, cust_id);
		ps.setString(3, w_id);
		ps.setInt(4, status);
		int m=ps.executeUpdate();
		con.close();
		if(m>0)
		{
			System.out.println("Catalog Recored Updated with itemid ="+itemid);
		}
		else
		{
			System.out.println("Catalog Recored could not Updated with request  itemid ="+itemid);
		}
	}catch(Exception e)
	{
		System.out.println("Exception at CatalogOperation.insert()  "+e);
	}
}
}
