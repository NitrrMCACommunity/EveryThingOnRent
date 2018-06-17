import java.sql.Connection;
import java.sql.PreparedStatement;

import org.apache.catalina.User;

public class Message {

private String sender;
 private String receiver;
 private String msg;
   public void setsender(String sender1)
   {
	   sender=sender1;
   }
   public String getsender()
   {
	   return sender;
   }
	   public void setreceiver(String receiver1 )
		{
			receiver=receiver1;
		}
		public String getreceiver()
		{
			return receiver;
		} 
		public void setmsg(String msgcontents1)
		{
			msg=msgcontents1;
		}
		public String getmsg()
		{
			return msg;
		}
		public boolean Sendmsg()
		{
		try {
			Connection con=Dbopr.getConnection();
			PreparedStatement p=con.prepareStatement("insert into Message values(?,?,?)"); 
			p.setString(1,sender);
			p.setString(2,receiver);
			p.setString(3,msg);
			int m=p.executeUpdate();
			if(m>0)
				return true;
			else
				return false;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
		}
}

