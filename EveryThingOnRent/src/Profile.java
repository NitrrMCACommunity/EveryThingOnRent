

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Blob;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.portable.InputStream;

/**
 * Servlet implementation class Profile
 */
@WebServlet({ "/Profile", "/me", "/user" })
public class Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Profile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	if(HttpResponseHandler.isLogin(request))
	{
		PrintWriter out=response.getWriter();
		String userid=(String)((request.getSession()).getAttribute("username"));
		User u=Dbopr.getUser(userid);
		System.out.println(u);
		HttpResponseHandler.topViews(request, out);
		out.println("<div class=\"register_account\">\r\n" + 
				"          	<div class=\"wrap\">\r\n" + 
				"    	      <h2 class=\"title\"><font color=\"black\" size=\"5\"><b>Profiles Details</b></font></h2>\r\n" + 
				"    		   <form>\r\n" + 
				"    			 <div class=\"col_1_of_2 span_1_of_2\">           \r\n" + 
				"			       <br/>		   		\r\n" + 
				"		    		<div>\r\n" + 
				"					<b>Name :   "+u.getName()+" </b>\r\n" + 
				"					</div>															\r\n" + 
				"					<br/>		\r\n" + 
				"					<div>\r\n" + 
				"					<b>Address :   "+u.getStreet()+"\n"+u.getCity()+","+u.getState()+"</b>\r\n" + 
				"					</div>\r\n" + 
				"					<br/>\r\n" + 
				"					<div>\r\n" + 
				"					<b>Mobile :   "+u.getPhone()+"</b>\r\n" + 
				"					</div>\r\n" + 
				"				   <br/>\r\n" + 
				"	                <div>\r\n" + 
				"					<b>E-mail :   "+u.getEmail()+"</b>\r\n" + 
				"					</div>					\r\n" + 
				"					<br/>\r\n" + 
				"						<div>\r\n" + 
				"					<a href=\"Search?key=computer science\"\">My-Products</a>\r\n" + 
				"					</div>\r\n" + 
				"					<br/>\r\n" + 
				"						<div>\r\n" + 
				"							 <p>\r\n" + 
				"								<a href=\"Additem?userid=\""+u.getId()+"/>Add Product</a>\r\n" + 
				"							</p>\r\n" + 
				"					</div>\r\n" + 
				"		    	 </div>\r\n" + 
				"				<div class=\"col_1_of_2 span_1_of_2\">		\r\n" + 
				"								 <div>");
        	out.print("<img width='200' height='200' src=DisplayImage?userid="+u.getId()+"&flag=1></img>\r\n" + 
        		"					</div>\r\n" + 
        		"					<br/>\r\n" + 
        		"					<div>\r\n" + 
        		"		    		<div><input type=\"file\"name=\"file\" value=\"\" onfocus=\"this.value = '';\" onblur=\"if (this.value == '') {this.value = 'month';}\"></div>\r\n" + 
        		"					</div>\r\n" + 
        		"					 <br/>\r\n" + 
        		"                     <div>\r\n" + 
        		"					<p>\r\n" + 
        		"					<a href=\"uploadImage.jsp?id="+u.getId()+"&flag=1\"/>Update Profile Picture</a>\r\n" + 
        		"					</p> \r\n" + 
        		"					</div>\r\n" + 
        		"					</div>\r\n" + 
        		"		         <div class=\"clear\"></div>\r\n" + 
        		"		    </form></div>");
        HttpResponseHandler.bottomView(out);
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
