import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class InputRestrictions {
	 static boolean isPhone(String phone)
	 {
		 if(phone.length()==10)
		 {
			 if(phone.matches("[0-9]+"))
				 return true;
		 }
		 return false;
	 }
	static boolean isUniqueUser(String userid)
	{
		try {
		Connection con=Dbopr.getConnection();
		PreparedStatement ps=con.prepareStatement("select *from users where userid=?");
		ps.setString(1, userid);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			con.close();
			return false;
		}
		return true;
		}catch(Exception e)
		{
			System.out.println("At isUniqueUser() "+e);
			return false;
		}
	}
	static boolean isEmail(String email)
	{
		if(email.contains("@")&&email.contains("."))
		return true;
		return false;
	}
	static boolean isName(String name)
	{
		if(name.matches("[0-9]+"))
			return false;
		return true;
	}
}
