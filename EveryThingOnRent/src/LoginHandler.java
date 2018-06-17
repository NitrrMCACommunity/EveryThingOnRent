
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginHandler
 */
@WebServlet("/LoginHandler")
public class LoginHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginHandler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.setContentType("text/html");
		String password=req.getParameter("pass");
		String userid=req.getParameter("user");
		     User u=Dbopr.getUser(userid);
		     if(u==null)
		     {
		    	 System.out.println("Entred");
		    	   res.sendRedirect("login?error-log=Sorry!!! You Entered wrong user name&userid="+userid);
		    	   return;
		     }
		     else
		    	 if(password.equals(u.getpassword()))
		    	 {
		    		 //if(u.getActive()==true) {
		    		 HttpSession session=req.getSession();
		    		 session.setAttribute("username",userid);
		    		 res.sendRedirect("Profile?userid="+userid);
				
		    		 //}
		    		// else
		    			// res.sendRedirect("Otp?user="+u.getId());
		    		 
		    	 }
		    	 else
		    	 {
		    		 String msg="Sorry!!!You Entered wrong password.";
		    		 res.sendRedirect("Login?error-log="+msg+"&userid="+userid);
	}
	}
}
