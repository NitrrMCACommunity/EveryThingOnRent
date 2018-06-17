import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Otp
 */
@WebServlet("/Otp")
public class Otp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Otp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("Text/html");
		PrintWriter out=response.getWriter();
		String otp=request.getParameter("otp");
		String userid=request.getParameter("userid");
		if(userid==null)
			response.sendRedirect("ErrorPage");
		String p="You have resister sucessfully. Enter your OTP send to your mobile number.";
		System.out.println("Inside Varify OTP"+otp);
		String msg=request.getParameter("msg");
		if(msg!=null)
			otp=null;
		if(otp!=null)
		{
			try {
				
				Connection con=Dbopr.getConnection();
				PreparedStatement ps=con.prepareStatement("select *from onetp where userid=?");
				ps.setString(1,userid);
				ResultSet rs=ps.executeQuery();
				if(rs.next())
				if(otp.equals(rs.getString(2))) {
					con.close();
					User u=Dbopr.getUser(userid);
					Dbopr.update(u);
					con.close();
					response.sendRedirect("Login?error-log=Registered Successfully Now You can login");
				}
				else
				{
					System.out.println("test");
					response.sendRedirect("Otp?msg=mismatch&userid="+userid);
					return;
				}
			}catch(Exception e) {
					System.out.println("Otp Varify error"+e);
					response.sendRedirect("ErrorPage");
				}
		}
		if(msg!=null)
		if(msg.equals("mismatch")) {
		 p="You Entered Wrong Otp Please currect this";}
			HttpResponseHandler.topViewForOthers(out);
			out.print("<div class=\"register_account\">\r\n" + 
					"          	<div class=\"wrap\">\r\n" + 
					"    	      <h4 class=\"title\"></h4>\r\n" + 
					"    		   <form action=Otp \"method\"=\"post\">\r\n" + 
					"    			 <div class=\"col_1_of_2 span_1_of_2\">\r\n" + 
					"                                    \r\n" + 
					"                                      <font color=\"red\">"+p+"</font> \r\n" + 
					"					<input type=\"hidden\"name=\"userid\"value="+userid+">\r\n" + 
					"		   			 <div><input type=\"text\" name=\"otp\"></div>\r\n" + 
					"		    			\r\n" + 
					"		    	 </div>\r\n" + 
					"		          \r\n" + 
					"		       <br/><br/><br/><br/>\r\n" + 
					"                        <button class=\"grey\">Submit</button>\r\n" + 
					"		         <p class=\"terms\"><a href=\"#\">Resend &amp; OTP</a>.</p>\r\n" + 
					"		         <div class=\"clear\"></div>\r\n" + 
					"		    </form>\r\n" + 
					"    	  </div> \r\n" + 
					"        </div>");
			HttpResponseHandler.bottomView(out);
		}
	}

