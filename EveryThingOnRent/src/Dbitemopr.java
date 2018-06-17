
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
public class Dbitemopr {
	public static boolean insert(Item i1)
	{
		Connection con=Dbopr.getConnection();
		try
		{
			PreparedStatement p=con.prepareStatement("insert into items values(?,?,?,?,?,?,?,?,?)");
			p.setString(1,i1.getName());
			p.setString(2,i1.getitemid());
			p.setString(3,i1.getuserid());
			p.setString(4, i1.getstate());
			p.setString(5, i1.getcity());
			p.setString(6,i1.getAddr());
			p.setString(7,i1.getrent());
			p.setString(8,i1.getcategory());
			p.setString(9,i1.getdescription());
			int m=p.executeUpdate();
			con.close();
			if(m==1) {
				System.out.print("sucess Inserted");
				return true;}
			con.close();
			return false;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
		finally {
	        try {
	            if (con != null && !con.isClosed())
	                {
	                con.close();
	                Thread.sleep(1000);
	                 }
	            }
	        catch (SQLException e) {
	            e.printStackTrace();} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	}
		public static void update(Item i1)
		{
			Connection con=Dbopr.getConnection();
			try {
			PreparedStatement p=con.prepareStatement("update items set itemname=?,itemid=?,userid=?,state=?,city=?,addr=?,rent=?, category=?,description=? where itemid=?)");
			p.setString(1,i1.getName());
			p.setString(2,i1.getitemid());
			p.setString(3,i1.getuserid());
			p.setString(4, i1.getstate());
			p.setString(5, i1.getcity());
			p.setString(6,i1.getAddr());
			p.setString(7,i1.getrent());
			p.setString(8,i1.getcategory());
			p.setString(9,i1.getdescription());
			int m=p.executeUpdate();
			con.close();
			if(m==1)
				System.out.print("sucess");
			else
				System.out.println("not sucess");
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		}
			public static void deleteItem(String itemid)
			{
				Connection con=Dbopr.getConnection();
				try {
					PreparedStatement p=con.prepareStatement("delete from items where itemid=?");
					p.setString(1,itemid);
					int m=p.executeUpdate();
					con.close();
					if(m==1)
					System.out.print("deleted");
					else
						System.out.print("not deleted");
				}
				catch(Exception e)
				{
					System.out.print(e);
				}
				finally {
			        try {
			            if (con != null && !con.isClosed())
			                {
			                con.close();
			                Thread.sleep(1000);
			                 }
			            }
			        catch (SQLException e) {
			            e.printStackTrace();} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
			}
			public static Item getItem(String iid)
			{
				Connection con=Dbopr.getConnection();
				try {
					PreparedStatement p=con.prepareStatement("select *from items where id=?");
					p.setString(1,iid);
					ResultSet rs=p.executeQuery();
					if(rs.next())
					{
						Item i=new Item();
						i.setName(rs.getString(1));
						i.setitemid(rs.getString(2));
						i.setuserid(rs.getString(3));
						i.setstate(rs.getString(4));
						i.setCity(rs.getString(5));
						i.setfulladdress(rs.getString(6));
						i.setrent(rs.getString(7));
						i.setcategory(rs.getString(8));
						i.setdescription(rs.getString(9));
						return i;
					}
					con.close();
					return null;
				}catch(Exception e)
				{
					System.out.println(e);
					return null;
				}
				finally {
			        try {
			            if (con != null && !con.isClosed())
			                {
			                con.close();
			                Thread.sleep(1000);
			                 }
			            }
			        catch (SQLException e) {
			            e.printStackTrace();} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
			}
public static void insertInCount()
{
	try {
	Connection con=Dbopr.getConnection();
	PreparedStatement ps=con.prepareStatement("insert into itemcount values(1)");
	int m=ps.executeUpdate();
	con.close();
	if(m>0)
		if(m>0)
			System.out.println(" !st Inserted Updated");
		else
			System.out.println(" !st Not Updated");
	}catch(Exception e)
	{
		System.out.println("Exception at InsertIncount()"+e);
	}
}
public static void updateCount(int count)
{
	Connection con=Dbopr.getConnection();
	try {
	PreparedStatement p=con.prepareStatement("update itemcount set count=? where count=?");
	p.setInt(1, count+1);
	p.setInt(2, count);
	int m=p.executeUpdate();
	con.close();
	if(m>0)
		if(m>0)
			System.out.println("  Inserted Updated");
		else
			System.out.println("  Not Updated");
	}catch(Exception e)
	{
		System.out.println("Exception at InsertIncount()"+e);
	}
	finally {
        try {
            if (con != null && !con.isClosed())
                {
                con.close();
                Thread.sleep(1000);
                 }
            }
        catch (SQLException e) {
            e.printStackTrace();} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
}
	
			
public static String nextItemIdGenerator()
{
	int count=0;
	String str="item";
	Connection con=Dbopr.getConnection();
	try {
		PreparedStatement ps=con.prepareStatement("select count from itemcount");
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			count=rs.getInt(1);
			str=str+count;
			Dbitemopr.updateCount(count);
		}
		else {
				Dbitemopr.insertInCount();
		}
		con.close();
		return str;
	}catch(Exception e)
	{
		System.out.println("Exception at nextItemid"+e);
		return null;
	}
	finally {
        try {
            if (con != null && !con.isClosed())
                {
                con.close();
                Thread.sleep(1000);
                 }
            }
        catch (SQLException e) {
            e.printStackTrace();} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
}
public static Blob displayImage(String itemid,Connection con)
{
	try
	{ 	
		System.out.println("Call to Dbitemopr.displayImages with itemid  "+itemid);
		Blob b1=null;
		PreparedStatement ps=con.prepareStatement("select *from itempic where id=?");
		ps.setString(1, itemid);
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
			  b1= rs.getBlob("image");
		        return b1;
		}
		else {
			System.out.println("Item images Does not exits");
		return null;
		}
	}catch(Exception e) {
		System.out.println("Exception at displayProfile"+e);
		return null;
	}
}
public static boolean removeProfile(String itemid)
{
	System.out.println("removeProfile() is calling");
	Connection con=Dbopr.getConnection();
	try {
	PreparedStatement ps=con.prepareStatement("delete from itempic where id=?");
	ps.setString(1, itemid);
	int m=ps.executeUpdate();
	con.close();
	if(m>1)
		return true;
	else
		return false;
	}catch(Exception e)
	{
		System.out.println("Exception at removeProfile() method    "+e);
		return false;
	}
	finally {
        try {
            if (con != null && !con.isClosed())
                {
                con.close();
                Thread.sleep(1000);
                 }
            }
        catch (SQLException e) {
            e.printStackTrace();} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
}
public static boolean isProfileUpdated(String id)
{
	Connection con=Dbopr.getConnection();
	try {
			PreparedStatement ps=con.prepareStatement("select *from itempic where id=?");
			ps.setString(1, id);
			int m=ps.executeUpdate();
			if(m>0)
				return true;
			else
				return false;
	}catch(Exception e)
	{
		System.out.println("Exception at isProfileUpdated");
		return false;
	}
	finally {
        try {
            if (con != null && !con.isClosed())
                {
                con.close();
                Thread.sleep(1000);
                 }
            }
        catch (SQLException e) {
            e.printStackTrace();} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
	
}
public static int totalRecords()
{
	Connection con=Dbopr.getConnection();
	try {
		int totalRows=0;
		PreparedStatement ps=con.prepareStatement("select count(*) from items");
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
			totalRows=rs.getInt(1);
			con.close();
		}
		con.close();
		return totalRows;
	}catch(Exception e)
	{
		System.out.println("Problem in TotalRecords() method\t"+e);
		return -1;
	}
	finally {
        try {
            if (con != null && !con.isClosed())
                {
                con.close();
                Thread.sleep(1000);
                 }
            }
        catch (SQLException e) {
            e.printStackTrace();} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
}
public static LinkedList<Item> fetchItems(int start,int end)
{
	Connection con=Dbopr.getConnection();
	try {
		PreparedStatement ps=con.prepareStatement("select *from(select ROWNUM R,ITEMS.* from ITEMS where ROWNUM <=?) where R>=?");
		ps.setInt(1, end);
		ps.setInt(2, start);
		ResultSet rs=ps.executeQuery();
		LinkedList<Item> itemlist=new LinkedList<Item>();
		while(rs.next())
		{
			Item i=new Item();
			i.setName(rs.getString(2));
			i.setitemid(rs.getString(3));
			i.setuserid(rs.getString(4));
			i.setstate(rs.getString(5));
			i.setCity(rs.getString(6));
			i.setfulladdress(rs.getString(7));
			i.setrent(rs.getString(8));
			i.setcategory(rs.getString(9));
			i.setdescription(rs.getString(10));
			itemlist.add(i);
		}
		con.close();
		return itemlist;
	}catch(Exception e)
	{
		System.out.println("Problem At Fetching records\t"+e);
		return null;
	}
	finally {
        try {
            if (con != null && !con.isClosed())
                {
                con.close();
                Thread.sleep(1000);
                 }
            }
        catch (SQLException e) {
            e.printStackTrace();} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
}
}

