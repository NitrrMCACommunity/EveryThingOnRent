
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.http.Part;

import org.omg.CORBA.portable.OutputStream;
public class Dbopr {
   public static Connection getConnection()
	{
	   Connection con=null;
	   try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","gudiya");
	   }catch(Exception e)
	   {
		   System.out.print(e);
	   }
	   return con;
	}
	public static boolean insert(User u1)
	{
		try {
		Connection con=Dbopr.getConnection();
		PreparedStatement p=con.prepareStatement("insert into users values(?,?,?,?,?,?,?,?,?)");
		p.setString(1,u1.getId());
		p.setString(2,u1.getName());
		p.setString(3,u1.getEmail());
		p.setString(4,u1.getpassword());
		p.setString(5,u1.getStreet());
		p.setString(6,u1.getCity());
		p.setString(7,u1.getState());
		p.setString(8,u1.getPhone());
		p.setInt(9,0);
		int m=p.executeUpdate();
		con.close();
		if(m==1) {
			System.out.print("success");
			return true;}
		else {
			System.out.print("not save");return false;}
	}
		catch(Exception e)
		{
			System.out.print(e);
			return false;
		}
	}
	public static void update(User u1)
	{
		try {
		Connection con=Dbopr.getConnection();
		PreparedStatement p=con.prepareStatement("update users set name=?,id=?,city=?,street=?,email=?, password=?,phone=?,status=? where id=?");
		p.setString(1,u1.getName());
		p.setString(2,u1.getId());
		p.setString(3,u1.getCity());
		p.setString(4,u1.getStreet());
		p.setString(5,u1.getEmail());
		p.setString(6,u1.getpassword());
		p.setString(7,u1.getPhone());
		p.setString(8,u1.getId());
		p.setInt(9, 1);
		int m=p.executeUpdate();
		con.close();
		if(m==1)
			System.out.print("success");
		else
			System.out.print("not save");
		}catch(Exception e)
		{
			System.out.print(e);
		}
	}
public static void delete(String uid)
{
	try {
		Connection con=Dbopr.getConnection();
		PreparedStatement p=con.prepareStatement("delete from users where id=?");
		p.setString(1,uid);
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
}
public static boolean isUniqueUserId(String userid)
{
	try {
		Connection con=Dbopr.getConnection();
		PreparedStatement st=con.prepareStatement("Select *from user where userid=?");
		st.setString(1,userid);
		ResultSet rs=st.executeQuery();
		con.close();
		if(rs.next())
			return false;
		else
			return true;
	}catch(Exception e)
	{
		System.out.println(e);
		return false;
	}
}
public static boolean isUniquePhone(String phone)
{
	try {
		Connection con=Dbopr.getConnection();
		PreparedStatement st=con.prepareStatement("Select *from users where phone=?");
		st.setString(1,phone);
		ResultSet rs=st.executeQuery();
		if(rs.next()) {
			
			con.close();
			return false;}
		else {con.close();
			return true;}
	}catch(Exception e)
	{
		System.out.println(e);
		return false;
	}
}
public static User getUser(String userid)
{
	try {
		Connection con=Dbopr.getConnection();
		PreparedStatement p=con.prepareStatement("select *from users where userid=?");
		p.setString(1,userid);
		ResultSet rs=p.executeQuery();
		User u=new User();
		if(rs.next())
		{
			u.setId(rs.getString(1));
			u.setName(rs.getString(2));
			u.setEmail(rs.getString(3));
			u.setPassword(rs.getString(4));
			u.setStreet(rs.getString(5));
			u.setCity(rs.getString(6));
			u.setState(rs.getString(7));
			u.setPhone(rs.getString(8));
			int act=rs.getInt(9);
			if(act==1)
			u.setActive(true);
			else
				u.setActive(false);
			con.close();
			return u;
		}
		return null;
	}
		catch(Exception e)
		{
			System.out.println(e);
			return null;
		}
}
public static boolean storeImage(HttpServletRequest req,String itemid)
{
	try {
		InputStream inputStream=null;
		Part filePart=req.getPart("photo");
		if(filePart!=null) {
			System.out.println("inserted");
			inputStream=(org.omg.CORBA_2_3.portable.InputStream) filePart.getInputStream();
		Connection con=Dbopr.getConnection();
				PreparedStatement ps=con.prepareStatement("insert into images values(?,?)");
				ps.setString(1, itemid);
				if(inputStream!=null) 
					ps.setBlob(2,inputStream);
				int m=ps.executeUpdate();
				con.close();
				if(m>1)
				return true;
				else
					return false;
		}
		return true;
	}catch(Exception e)
	{
		System.out.println("Image could not inserted"+e);
		return false;
	}
}
public static void displayImages(PrintWriter out,String itemid)
{
	try {
		Connection con=Dbopr.getConnection();
		PreparedStatement ps=con.prepareStatement("select from profilepic where userid=?");
		ps.setString(1, itemid);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			Blob b=rs.getBlob(2);
			InputStream i=(org.omg.CORBA_2_3.portable.InputStream) b.getBinaryStream();
			int length=(int)b.length();
			int buffersize=1024;		
			byte barr[]= new byte[buffersize];
			while((length=i.read(barr))!=-1)
				out.write(length);
		}
		con.close();
	}catch(Exception e) {
		System.out.println("Problem displaying image"+e);
	}
}
public static boolean isProfileUpdated(String userid)
{
	try {
			Connection con=Dbopr.getConnection();
			PreparedStatement ps=con.prepareStatement("select *from profilepic where userid=?");
			ps.setString(1, userid);
			int m=ps.executeUpdate();
			con.close();
			if(m>0)
				return true;
			else
				return false;
	}catch(Exception e)
	{
		System.out.println("Exception at isProfileUpdated");
		return false;
	}
}
public static boolean removeProfile(String userid)
{
	System.out.println("removeProfile() is calling");
	try {
	Connection con=Dbopr.getConnection();
	PreparedStatement ps=con.prepareStatement("delete from profilepic where userid=?");
	ps.setString(1, userid);
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
}
public static Blob displayProfile(String userid,Connection con)
{
	try
	{ 	Blob b1=null;
		PreparedStatement ps=con.prepareStatement("select *from profilepic where userid=?");
		ps.setString(1, userid);
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
			  b1= rs.getBlob("image");
		        return b1;
		}
		return null;
	}catch(Exception e) {
		System.out.println("Exception at displayProfile");
		return null;
	}
}
}