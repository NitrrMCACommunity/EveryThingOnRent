

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.mail.iap.Response;

/**
 * Servlet implementation class Order
 */
@WebServlet({ "/Order", "/Ordered" })
public class Order extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Order() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		if(!HttpResponseHandler.isLogin(request))
		{
			response.sendRedirect("Login?msg=Please Login First for order product");
		}
		String flag=request.getParameter("flag");
		String itemid=request.getParameter("itemid");
		String msg=request.getParameter("msg");
		if(msg==null)
			msg="";
		HttpResponseHandler.topViews(request, out);
		out.print("  <div class=\"register_account\">\r\n" + 
				"          	<div class=\"wrap\">\r\n" + 
				"    	      <h4 class=\"title\">Order</h4>\r\n");
					if(msg!=null)
					out.println(msg);
							if(flag==null)
				    		  out.print("<form action=\"Order?itemid="+itemid+"\" method=\"post\">"); 
							else
								  out.print("<form action=\"PlaceCart\" method=\"post\">"); 
				out.print("<div class=\"col_1_of_2 span_1_of_2\">\r\n" + 
				"\r\n" + 
				"		   			 <div>\r\n" + 
				"					 <b>Dilevery Address </b>\r\n" + 
				"					 <input type=\"text\" name=\"addr\" required= \"required\" value=\"\" onfocus=\"this.value = '';\" onblur=\"if (this.value == '') {this.value = 'Dilevery Address';}\"></div>\r\n" + 
				"		    			\r\n" + 
				"					<div>\r\n" + 
				"					<b>City</b>\r\n" + 
				"					<input type=\"text\" name=\"city\" required= \"required\" value=\"\" onfocus=\"this.value = '';\" onblur=\"if (this.value == '') {this.value = 'City';}\"></div>\r\n" + 
				"		    			<div>\r\n" + 
				"						<b>Pin Code</b>\r\n" + 
				"						<input type=\"text\" name=\"pin\"  required= \"required\" value=\"\" onfocus=\"this.value = '';\" onblur=\"if (this.value == '') {this.value = 'Pin';}\">\r\n" + 
				"			\r\n" + 
				"						</div>\r\n" + 
				"                      \r\n" + 
				"					  <div>\r\n" + 
				"					  <b>Mobile Number</b>\r\n" + 
				"					  <input type=\"text\"name=\"phone\" value=\"\" onfocus=\"this.value = '';\" onblur=\"if (this.value == '') {this.value = 'Mobile Number';}\"></div>\r\n" + 
				"		  \r\n" + 
				"		       <div>\r\n" + 
				"		         <input type=\"submit\" name=\"submit\" value=\"Order Now\" onclick=\"\" />\r\n" + 
				"				 </div>\r\n" + 
				"		  \r\n" + 
				"		  </div>\r\n" + 
				"		    	  <div class=\"col_1_of_2 span_1_of_2\">	\r\n" + 
				"		    		\r\n" + 
				"				  </div>\r\n" + 
				"		        \r\n" + 
				"		         <div class=\"clear\"></div>\r\n" + 
				"		    </form>\r\n" + 
				"    	  </div> ");
		HttpResponseHandler.bottomView(out);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String itemid=request.getParameter("itemid");
		try {
		String fulladdr=request.getParameter("addr");
		String city=request.getParameter("city");
		String pin=request.getParameter("pin");
		if(pin.length()!=6)
		{
			printMsg("Not a valid pin",out);
			return;
		}
		String phone=request.getParameter("phone");
		if(InputRestrictions.isPhone(phone)) {
			String msg="Not a valid phone number,Please fill ll details urrctly";
			printMsg(msg,out);
			return;
		}
		HttpSession ses=request.getSession();
		if(ses!=null)
		{
			String userid=(String)ses.getAttribute("username");
			User u=Dbopr.getUser(userid);
			Item i=Dbitemopr.getItem(itemid);
			CalogOperations.insert(itemid, userid, i.getuserid(), 1);
			Message m=new Message();
			String msg="You have an order request for the Product "+i.getName()+"  From :<a href=\"Profile?userid="+u.getId()+"\">"+u.getName()+"</a>"+
					 "   With Delevry Address Details:"+fulladdr+","+city+",pin:-"+pin+" phone:-"+phone+" Click on the blow link for corfom order"+
					"     you can also send message to customer from blow box"+"<a href=\"ConformOrder?itemid="+i.getitemid()+"&custid="+userid+"\">Conform Order</a>";
			
			String msg1="You have an order request for the Product "+i.getName()+"  From :"+u.getName()+","+
					 "   With Delevry Address Details:"+fulladdr+","+city+",pin:-"+pin+" phone:-"+phone+" Click on the blow link for corfom order"+
					"     http://localhost:8090AvartanProject/ConformOrder?itemid="+i.getitemid()+"From:Everything On Rent";
			m.setmsg(msg);
			m.setsender(userid);
			m.setreceiver(i.getuserid());
			User vendor=Dbopr.getUser(i.getuserid());
			UserVarifyCode.SendEmail(vendor.getEmail(),"Everything On rent :Order for"+i.getdescription()+"",msg1);
			StringBuffer strbuf=null;
			UserVarifyCode.SendSMS(vendor.getPhone(), msg1,strbuf);
			m.Sendmsg();
			response.sendRedirect("Chat?rid="+i.getuserid());
			System.out.println(i.getuserid());
		}
		else
			response.sendRedirect("Login?msg=Please Login First for order product");
		}catch(Exception e)
		{
			System.out.println(e);
			response.sendRedirect("Index");
		}
}
	protected void printMsg(String msg,PrintWriter out)
	{
		out.print(msg+" please go back and fill the detils currectly");
	}
}
