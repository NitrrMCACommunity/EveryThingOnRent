import java.sql.*;
import java.util.*;
public class SearchOperation {
    public static String getCategoryString()
	{
		try
		{
			String str=null;
			Connection con=Dbopr.getConnection();
			PreparedStatement p= con.prepareStatement("select cat from item");
			ResultSet rs=p.executeQuery();
			while(rs.next())
			{
				str=str+" "+rs.getString(1);
			}
			return str;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return null;
		}
	}
    public static String getCityString()
	{
		try
		{
			String str=null;
			Connection con=Dbopr.getConnection();
			PreparedStatement p= con.prepareStatement("select city from item");
			ResultSet rs=p.executeQuery();
			while(rs.next())
			{
				str=str+" "+rs.getString(1);
			}
			return str;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return null;
		}
}
    public static String getnameString()
{
	try
	{
		String str=null;
		Connection con=Dbopr.getConnection();
		PreparedStatement p= con.prepareStatement("select name from item");
		ResultSet rs=p.executeQuery();
		while(rs.next())
		{
			str=str+" "+rs.getString(1);
		}
		return str;
	}
	catch(Exception e)
	{
		System.out.println(e);
		return null;
	}
}
    public static LinkedList<Item>searchResult(String city,String name,String category)
    {
    	if(city==null&&category==null&&name==null)
    	{
    		return null;
    	}
    	try
    	{
    	Connection con=Dbopr.getConnection();
    	if(city==null)
    		city=SearchOperation.getCityString();
    	if(category==null)
    		category=SearchOperation.getCategoryString();
    	if(name==null)
    		name=SearchOperation.getnameString();
    	PreparedStatement p=con.prepareStatement("Select *from item where city LIKE"+city+"%AND cat LIKE"+category+"%AND name LIKE"+name+"%");
    		ResultSet rs=p.executeQuery();
    	LinkedList<Item> al=new LinkedList<Item>();
    	while(rs.next())
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
			al.add(i);
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
   public static LinkedList<Item> getSearchResult(String key)
   {
	   try {
	   Connection con=Dbopr.getConnection();
	   PreparedStatement p=con.prepareStatement("Select *from items where cat LIKE '"+key+"%' OR name LIKE '"+key+"%' OR description LIKE '"+key+"%'");
	  ResultSet rs=p.executeQuery();
	LinkedList<Item> al=new LinkedList<Item>();
	while(rs.next())
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
		al.add(i);
	}
	con.close();
	return al;
	}catch(Exception e)
	   {
		System.out.println("Exception at getSearchResult()\t"+e);
		return null;
	   }
   }
}