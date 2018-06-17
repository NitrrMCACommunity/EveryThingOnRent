import java.sql.*;
import java.util.LinkedList;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Chat
 */
@WebServlet("/Chat")
public class Chat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Chat() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String rid=request.getParameter("rid");
		System.out.println(rid);
		HttpSession session=request.getSession(false);
		if(session!=null)
		{
			User u=Dbopr.getUser(rid);
			User s=Dbopr.getUser((String)session.getAttribute("username"));
			Connection con=Dbopr.getConnection();
        	PreparedStatement p= con.prepareStatement("select *from message where sender=? and receiver=? OR receiver=? And sender=?");
        	p.setString(1,s.getId());
        	p.setString(2,u.getId());
        	p.setString(3, s.getId());
        	p.setString(4,u.getId());
        	ResultSet rs=p.executeQuery();
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
        			"<title>chat</title>\r\n" + 
        			"<link rel=\"stylesheet\" type=\"text/css\" href=\"StyleChat.css\">\r\n" + 
        			"</head>\r\n" + 
        			"<body>\r\n" + 
        			"\r\n" + 
        			"<a href=\"Index\"><img src=\"image/rent.jpg\" margin=\"10px 10px auto\" alt=\"\"/></a>\r\n" + 
        			"\r\n" + 
        			"<div class=\"chatbox\">\r\n" + 
        			"<a href=\" Chat?rid="+u.getId()+"\">Refresh</a>\r\n" + 
        			"<div class =\"chatlogs\">");
        	for(Message m:list)
        	{
        		if(m.getsender().equals(s.getId()))
        			out.println("<div class=\"chat self\">\r\n" + 
        					"<div class =\"user-photo\"><img width='50' height='50' src=DisplayImage?userid="+s.getId()+"&flag=1></img></div>\r\n" + 
        					"<p class =\"chat-message\">"+m.getmsg()+"</p>\r\n" + 
        					"</div>");
        		else if(m.getsender().equals(u.getId()))
        			out.println("<div class=\"chat friend\">\r\n" + 
        					"<div class =\"user-photo\"><img width='50' height='50' src=DisplayImage?userid="+u.getId()+"&flag=1></img></div>\r\n" + 
        					"<p class =\"chat-message\">"+m.getmsg()+"</p>\r\n" + 
        					"</div>");
        	}
        	out.println("\r\n" + 
        			"</div>\r\n" + 
        			"\r\n" + 
        			"\r\n" + 
        			"<div class=\"chat-form\">\r\n" + 
        			"<form action =\"SendMessage\" method=\"post\">\r\n" + 
        			"<input type=\"text\" name=\"msg\" required=\"required\">\r\n" +
        			"<input type=\"hidden\" name=rid value=\""+u.getId()+"\">"+
        			"<input type=\"submit\" value =\"send\" name=\"sub\">\r\n" + 
        			"</form>\r\n" + 
        			"</div>");
	}
			else
			{
				response.sendRedirect("Login?msg=Please Login first to View your Message");	
			}
		}catch(Exception e)
		{
			System.out.println("Problem at Chat  "+e);
			response.sendRedirect("Index");
		}
}
}
