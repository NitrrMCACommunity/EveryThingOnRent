

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet({ "/Login", "/login.html", "/login", "/signin" })
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out =response.getWriter();
		String msg=request.getParameter("error-log");
		String user=request.getParameter("userid");
		if(user==null)
			user="";
		HttpResponseHandler.topViewForOthers(out);
		out.print("<div class=\"login\">\r\n" + 
				"          <div class=\"wrap\">\r\n" + 
				"				<div class=\"col_1_of_login span_1_of_login\">\r\n" + 
				"					<h4 class=\"title\">New Customers</h4>\r\n" + 
				"					<h5 class=\"sub_title\">Register Account</h5>\r\n" + 
				"					<p>We are providing the best services to our customer. We have a lots of things on rent near to you. Just login with us or signup if you are not a register user. You can also login with social here.</p>\r\n" + 
				"					<div class=\"button1\">\r\n" + 
				"					   <a href=\"register.html\"><input type=\"submit\" name=\"Submit\" value=\"Continue\"></a>\r\n" + 
				"					   <a href=\"register.html\"><input type=\"submit\" name=\"Submit\" value=\"Login with Google\"></a>\r\n" + 
				"					    <a href=\"register.html\"><input type=\"submit\" name=\"Submit\" value=\"Login with Facebook\"></a>\r\n" + 
				"					 </div>\r\n" + 
				"					 <div class=\"clear\"></div>\r\n" + 
				"				</div>\r\n" + 
				"				<div class=\"col_1_of_login span_1_of_login\">\r\n" + 
				"				  <div class=\"login-title\">\r\n" + 
				"	           		<h4 class=\"title\">Registered Customers</h4>\r\n" + 
				"					 <div class=\"comments-area\">");
		if(msg!=null)
			out.println("<font color=red size=\"2\">"+msg+"</font>");
		out.println("<form action=\"LoginHandler\"method =\"post\">\r\n" + 
				"							<p>\r\n" + 
				"								<label>User Id</label>\r\n" + 
				"								<span>*</span>\r\n" + 
				"								<input type=\"text\"name=\"user\" value=\""+user+"\" required=\"required\">\r\n" + 
				"							</p>\r\n" + 
				"							<p>\r\n" + 
				"								<label>Password</label>\r\n" + 
				"								<span>*</span>\r\n" + 
				"								<input type=\"password\"name=\"pass\" value=\"\"required=\"required\">\r\n" + 
				"							</p>\r\n" + 
				"							 <p id=\"login-form-remember\">\r\n" + 
				"								<label><a href=\"forget.html\">Forget Your Password ? </a></label>\r\n" + 
				"							 </p>\r\n" + 
				"							 <p>\r\n" + 
				"								<input type=\"submit\" value=\"Login\">\r\n" + 
				"							</p>\r\n" + 
				"						</form>\r\n" + 
				"					</div>\r\n" + 
				"			      </div>\r\n" + 
				"				</div>\r\n" + 
				"				<div class=\"clear\"></div>\r\n" + 
				"			</div>\r\n" + 
				"		</div>");
		HttpResponseHandler.bottomView(out);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
}
}