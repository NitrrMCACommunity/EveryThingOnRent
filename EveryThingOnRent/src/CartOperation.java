import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
public class CartOperation {
public static void insert(MyCart cr)
{
	try {
		Connection con=Dbopr.getConnection();
		PreparedStatement p=con.prepareStatement("insert into cart values(?,?)");
		p.setString(1,cr.getitemid());
		p.setString(2,cr.getuserid());
		int m=p.executeUpdate();
		if(m==1) {
			System.out.print("success");
			}
		else {
			System.out.print("not save");
			}
		con.close();
	}
		catch(Exception e)
		{
			System.out.print(e);
		}
}
public static void deleteCart(String itemid,String userid)
{
	try {
		Connection con=Dbopr.getConnection();
		PreparedStatement p=con.prepareStatement("delete from cart where itemid=? And userid=?");
		p.setString(1,itemid);
		p.setString(2, userid);
		int m=p.executeUpdate();
		if(m==1)
		System.out.print("deleted");
		else
			System.out.print("not deleted");
		con.close();
	}
	catch(Exception e)
	{
		System.out.print(e);
	}
}
public static java.util.LinkedList<MyCart> getCart(String userid)
{
	try
	{
		Connection con=Dbopr.getConnection();
		PreparedStatement p= con.prepareStatement("select *from cart where userid=?");
		p.setString(1, userid);
		ResultSet rs=p.executeQuery();
		java.util.LinkedList<MyCart> al=new java.util.LinkedList<MyCart>();
		while(rs.next())
		{
			MyCart c=new MyCart();
		c.setitemid(rs.getString(1));
		c.setuserid(rs.getString(2));
		al.add(c);
		}
		con.close();
		return al;	
}
	catch(Exception e)
	{
		System.out.println(e);
		return null;
	}
}
public static void clearCart(String userid)
{
	try {
		Connection con=Dbopr.getConnection();
		PreparedStatement p=con.prepareStatement("delete from cart where userid=?");
		p.setString(1,userid);
		int m=p.executeUpdate();
		if(m==1)
		System.out.print("deleted");
		else
			System.out.print("not deleted");
		con.close();
	}
	catch(Exception e)
	{
		System.out.print(e);
	}
}
}

