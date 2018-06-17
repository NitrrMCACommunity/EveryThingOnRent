

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationHandler
 */
@WebServlet({ "/RegistrationHandler", "/RHandler", "/SingupHandler" })
public class RegistrationHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationHandler() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			int flag=0;
			String msg=null;
			String f_name=request.getParameter("fname");
			if(!InputRestrictions.isName(f_name)) {
				flag=1;
				msg=f_name+",Not a Name";
			}
			String l_name=request.getParameter("lname");
			if(!InputRestrictions.isName(l_name)) {
				flag=1;
				msg=l_name+",Not a Name";}
			String email=request.getParameter("email");
			if(!InputRestrictions.isEmail(email)) {
				flag=1;
				msg=email+"  ,Not an email, fill this currectly";}
			String userid=request.getParameter("id");
			if(!InputRestrictions.isUniqueUser(userid)) {
				flag=1;
			msg=userid+", Already Exist please choose another";}
			String pass=request.getParameter("pass");
			if(pass.length()<6) {
				flag=1;
				msg="Password must be atleast 6 char or numbers";}
			String addr=request.getParameter("addr");
			if(addr==null)
				addr="";
			String state=request.getParameter("state");
			if(state==null) {
				flag=1;
				msg="Please select your state";}
			String city=request.getParameter("city");
			if(city==null) {
				flag=1;
				msg="City Can't be blank , please fill this";}
			//if(InputRestrictions.isName(city)) {
				//flag=1;
				//msg=city+",Not a city";}
			String phone=request.getParameter("phone");
			//if(InputRestrictions.isPhone(phone)) {
				//flag=1;
					//	msg=phone+",Not a Phone........Phone number is  required";}
			if(!InputRestrictions.isPhone(phone))
				msg=phone+"  Not a phone number, requeired";
			if(!Dbopr.isUniquePhone(phone))
		    {
				flag=1;
				msg="This phone number is already register with other account";
		    }
			if(flag==1)
			{
				request.setAttribute("error-log", msg);
				RequestDispatcher rd=request.getRequestDispatcher("Register?error-log="+msg);
				rd.forward(request, response);
				return;
			}
		User u=new User();
		u.setName(f_name+" "+l_name);
		u.setEmail(email);
		u.setPassword(pass);
		u.setStreet(addr);
		u.setCity(city);
		u.setState(state);
		u.setPhone(phone);
	    u.setActive(false);
	    u.setId(userid);
	    System.out.println("Data currect");
	    	if(Dbopr.insert(u)) {
	    	UserVarifyCode.varifyUser(u);
	    	response.sendRedirect("Otp?userid="+u.getId());
	    	}	
	}
	}


