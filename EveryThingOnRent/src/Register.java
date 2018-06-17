

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet({ "/Register", "/Registration", "/Signup" })
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
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
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String f_name=request.getParameter("fname");
		if(f_name==null)
			f_name="";
		String l_name=request.getParameter("lname");
		if(l_name==null)
			l_name="";
		String email=request.getParameter("email");
		if(email==null)
			email="";
		String userid=request.getParameter("id");
		if(userid==null)
			userid="";
		String pass=request.getParameter("pass");
		if(pass==null)
			pass="";
		String addr=request.getParameter("addr");
		if(addr==null)
			addr="";
		String state=request.getParameter("state");
		if(state==null)
			state="";
		String city=request.getParameter("city");
		if(city==null)
			city="";
		String phone=request.getParameter("phone");
		if(phone==null)
			phone="";
		String msg=request.getParameter("error-log");
		if(msg==null)
			msg="";
		HttpResponseHandler.topViewForOthers(out);
		out.print("    <div class=\"register_account\">\r\n" + 
				"          	<div class=\"wrap\">\r\n" + 
				"    	      <h4 class=\"title\">Create an Account</h4>\r\n" + 
				"				<font color=\"red\">"+msg+"</font>\r\n" + 
				"    		     <form action=RegistrationHandler method=post>\r\n" + 
				"    			 <div class=\"col_1_of_2 span_1_of_2\">\r\n" + 
				"\r\n" + 
				"		   			 <div>\r\n" + 
				"					 <b>First Name</b>\r\n" + 
				"					 <input type=\"text\" name=\"fname\" value=\""+f_name+"\"  required=\"required\" onfocus=\"this.value = '';\" onblur=\"if (this.value == '') {this.value = 'First Name';}\"></div>\r\n" + 
				"		    			\r\n" + 
				"					<div>\r\n" + 
				"					<b>Last Name</b>\r\n" + 
				"					<input type=\"text\" name=\"lname\" value=\""+l_name+"\"  required=\"required\"  onfocus=\"this.value = '';\" onblur=\"if (this.value == '') {this.value = 'Last Name';}\"></div>\r\n" + 
				"		    			<div>\r\n" + 
				"						<b>E-mail</b>\r\n" + 
				"						<input type=\"text\" name=\"email\" value=\""+email+"\" required=\"required\"  onfocus=\"this.value = '';\" onblur=\"if (this.value == '') {this.value = 'E-Mail';}\"></div>\r\n" + 
				"                      <div>\r\n" + 
				"					  <b>User Id</b>\r\n" + 
				"					  <input type=\"text\"name=\"id\" value=\""+userid+"\"  required=\"required\"  onfocus=\"this.value = '';\" onblur=\"if (this.value == '') {this.value = 'userid';}\"></div>\r\n" + 
				"		    			    	\r\n" + 
				"				<div>\r\n" + 
				"				<b>Password</b><br/>\r\n" + 
				"				<input type=\"text\"name=\"pass\" value=\""+pass+"\"  required=\"required\" onfocus=\"this.value = '';\" onblur=\"if (this.value == '') {this.value = 'Password';}\"></div>\r\n" + 
				"		    	 </div>\r\n" + 
				"		    	  <div class=\"col_1_of_2 span_1_of_2\">	\r\n" + 
				"		    		<div>\r\n" + 
				"					<b>Address</b>\r\n" + 
				"					<input type=\"text\"name=\"addr\" value=\""+addr+"\"   required=\"required\"  onfocus=\"this.value = '';\" onblur=\"if (this.value == '') {this.value = '';}\"></div>\r\n" + 
				"		    		<div>\r\n" + 
				"					<b>Select States</b>\r\n" + 
				"					<select id=\"state\" name=\"state\"  required=\"required\" onchange=\"change_state(this.value)\" class=\"frm-field required\">\r\n" + 
				"		                      <option value=\"\">select state</option> \r\n" + 
				"					      <option value=\"AP\">Andhra Pradesh</option> \r\n" + 
				"						     <option value=\"AR\">Arunachal pradesh</option> \r\n" + 
				"							    <option value=\"AS\">Assam</option> \r\n" + 
				"								   <option value=\"BH\">Bihar</option> \r\n" + 
				"								      <option value=\"CH\">Chandigarh</option> \r\n" + 
				"									     <option value=\"CG\">Chhatisgarh</option> \r\n" + 
				"										    <option value=\"DL\">Delhi</option>   \r\n" + 
				"											   <option value=\"GO\">Goa</option> \r\n" + 
				"											      <option value=\"GU\">Gujarat</option> \r\n" + 
				"												     <option value=\"HR\">Haryana</option> \r\n" + 
				"						                                 <option value=\"HP\">Himachal Pradesh</option> \r\n" + 
				"														    <option value=\"JK\">Jammu & Kashmir</option> \r\n" + 
				"															   <option value=\"JH\">Jharkhand</option> \r\n" + 
				"															      <option value=\"KR\">Karnataka</option> \r\n" + 
				"																     <option value=\"KL\">Kerala</option> \r\n" + 
				"																	    <option value=\"MP\">Madhya Pardesh</option> \r\n" + 
				"																		   <option value=\"MH\">Maharashtra</option> \r\n" + 
				"																		   <option value=\"OR\">Orissa</option> \r\n" + 
				"                                                                               <option value=\"PJ\">Punjab</option> \r\n" + 
				"                                                                                <option value=\"RJ\">Rajasthan</option> \r\n" + 
				"																				   <option value=\"TN\">Tamil Nadu</option> \r\n" + 
				"																				      <option value=\"TR\">Tripura</option> \r\n" + 
				"																					     <option value=\"UP\">Uttar Pardesh</option> \r\n" + 
				"																						    <option value=\"UT\">Uttarakhand</option>   \r\n" + 
				"																							   <option value=\"WB\">West Bengal</option> \r\n" + 
				"																							  \r\n" + 
				"		          </select>\r\n" + 
				"				  </div>		        \r\n" + 
				"		          <div>\r\n" + 
				"				  <b>City</b>\r\n" + 
				"				  <input type=\"text\" value=\""+city+"\"name=\"city\"  required=\"required\" onfocus=\"this.value = '';\" onblur=\"if (this.value == '') {this.value = '';}\"></div>\r\n" + 
				"		             <b>Mobile Number</b><br/>\r\n" + 
				"					<input type=\"text\" name=\"phone\" value=\""+phone+"\" required=\"required\"  class=\"number\">\r\n" + 
				"		          	\r\n" + 
				"		          </div>\r\n" + 
				"		         <button class=\"grey\">Submit</button>\r\n" + 
				"		         <p class=\"terms\">By clicking 'Submit' you agree to the <a href=\"#\">Terms &amp; Conditions</a>.</p>\r\n" + 
				"		         <div class=\"clear\"></div>\r\n" + 
				"		    </form>\r\n" + 
				"    	  </div> \r\n" + 
				"        </div>");
		HttpResponseHandler.bottomView(out);
		}
	}

