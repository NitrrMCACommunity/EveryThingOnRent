import java.sql.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sun.rmi.transport.Connection;

/**
 * Servlet implementation class Inbox
 */
@WebServlet("/Inbox")
public class Inbox extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Inbox() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		try {
			HttpSession ses=request.getSession(false);
			if(ses!=null)
			{
				String muser=(String)ses.getAttribute("username");
				java.sql.Connection con=Dbopr.getConnection();
				PreparedStatement ps=con.prepareStatement("select *from message where sender=? or receiver=?");
				ps.setString(1,muser);
				ps.setString(2,muser);
				ResultSet rs=ps.executeQuery();
				LinkedList<Message> list=new LinkedList<Message>();
				while(rs.next())
				{
					Message m=new Message();
					m.setsender(rs.getString(1));
					m.setreceiver(rs.getString(2));
					m.setmsg(rs.getString(3));
					list.add(m);
				}
				con.close();
				out.print("<html>\r\n" + 
						"<head>\r\n" + 
						"<title>inbox</title>\r\n" + 
						"<link rel=\"stylesheet\" type=\"text/css\" href=\"StyleInbox.css\">\r\n" + 
						"</head>\r\n" + 
						"<body>\r\n" + 
						"\r\n" + 
						"<div>\r\n" + 
						"<a href=\"Index\"><img src=\"image/rent.jpg\" alt=\"\"/></a>\r\n" + 
						"</div>\r\n" + 
						"\r\n" + 
						"\r\n" + 
						"\r\n" + 
						"<div class=\"chating\">\r\n" + 
						"\r\n" + 
						"\r\n" + 
						"\r\n" + 
						"<style> \r\n" + 
						"input[type=text] {\r\n" + 
						"    width: 130px;\r\n" + 
						"    box-sizing: border-box;\r\n" + 
						"    border: 1px solid #ccc;\r\n" + 
						"    border-radius: 4px;\r\n" + 
						"    font-size: 12px;\r\n" + 
						"    background-color: white;\r\n" + 
						"    background-image: url('image/searchicon.png');\r\n" + 
						"    background-position: 5px 5px; \r\n" + 
						"    background-repeat: no-repeat;\r\n" + 
						"    padding: 12px 20px 12px 40px;\r\n" + 
						"    -webkit-transition: width 0.4s ease-in-out;\r\n" + 
						"    transition: width 0.4s ease-in-out;\r\n" + 
						"}\r\n" + 
						"\r\n" + 
						"input[type=text]:focus {\r\n" + 
						"    width: 70%;\r\n" + 
						"}\r\n" + 
						"</style>\r\n" + 
						"\r\n" + 
						"<form>\r\n" + 
						"  <input type=\"text\" name=\"search\" placeholder=\"Search..\">\r\n" + 
						"</form>\r\n" + 
						"\r\n" + 
						"\r\n" + 
						"\r\n" + 
						"<div class =\"chatlog\">");
				LinkedList<String> header=new LinkedList<String>();
				for(Message m:list)
				{
					
					String userid;
					if(m.getsender().equals(muser))
						userid=m.getreceiver();
					else
						userid=m.getsender();
					if(!header.contains(userid))
					{
						header.add(userid);
						User u=Dbopr.getUser(userid);
						out.println(" <div class=\"chatting friend\">"+
								"<div class =\"user-photo\"><img width='50' height='50' src=DisplayImage?userid="+u.getId()+"&flag=1></img></div>\r\n" + 
								"<p class =\"chat-message\"><a href=\"Chat?rid="+u.getId()+"\">"+u.getName()+"</a></p>\r\n" + 
								"</div>");
					}
				}
				out.println("\r\n" + 
						"</div>\r\n" + 
						"</div>\r\n" + 
						"\r\n" + 
						"\r\n" + 
						"</body>\r\n" + 
						"</html>");
			}
			else {
				response.sendRedirect("Login?msg=Please Login first to View your Inbox");
			}
		}
		catch(Exception e)
			{
				System.out.println("Problemat inbox "+e);
				response.sendRedirect("Index");
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
