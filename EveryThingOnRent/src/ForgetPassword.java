

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ForgetPassword
 */
@WebServlet("/ForgetPassword")
public class ForgetPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgetPassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		HttpResponseHandler.topViewForOthers(out);
		String msg=request.getParameter("msg");
		if(msg==null)
			msg="";
		out.print("<div class=\"col_1_of_login span_1_of_login\">\r\n" + 
				"				  <div class=\"login-title\">\r\n" + 
				"	           		<h4 class=\"title\">Forget Password</h4>\r\n" + 
				"					 <div class=\"comments-area\">\r\n" +
				"                     <h3>"+msg+"</h3>"+
				"						<form action=\"ForgetHandler\"method=\"post\">\r\n" + 
				"							\r\n" + 
				"								USER ID\r\n" + 
				"								<span>*</span>\r\n" + 
				"								<input type=\"text\" value=\"\"name=\"id\">\r\n" + 
				"\r\n" + 
				"						\r\n" + 
				"								MOBILE NUMBER\r\n" + 
				"								<span>*</span>\r\n" + 
				"								<input type=\"password\" value=\"\"name=\"pass\">\r\n" + 
				"								\r\n" + 
				"							 <p id=\"login-form-remember\">\r\n" + 
				"								<label><a href=\"otp.html\"></a></label>\r\n" + 
				"							 </p>\r\n" + 
				"							 <p>\r\n" + 
				"								<input type=\"submit\" value=\"Forget\">\r\n" + 
				"							</p>\r\n" + 
				"						</form>\r\n" + 
				"					</div>\r\n" + 
				"			      </div>\r\n" + 
				"				</div>\r\n" + 
				"				<div class=\"clear\"></div>\r\n" + 
				"			</div>\r\n" + 
				"		</div> ");
		HttpResponseHandler.bottomView(out);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	}

}
