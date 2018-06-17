

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ItemView
 */
@WebServlet({ "/ItemView", "/ProductView", "/ProductDetails" })
public class ItemView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemView() {
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
		HttpResponseHandler.topViews(request, out);
		String itemid=request.getParameter("itemid");
		if(itemid==null)
		{
			response.sendRedirect("ErrorPage");
		}
		Item i=Dbitemopr.getItem(itemid);
		User u=Dbopr.getUser(i.getuserid());
		//String uerid=request.getParameter("userid");
		out.print("<div class=\"register_account\">\r\n" + 
				"          	<div class=\"wrap\">\r\n" + 
				"    	      <h4 class=\"title\"><font color=\"blue\">"+i.getName()+"</font></h4>\r\n" + 
				"    		   <form>\r\n" + 
				"    			 <div class=\"col_1_of_2 span_1_of_2\">\r\n" + 
				"\r\n" + 
				"		   			 <div>\r\n" + 
				"					 <img height='300' width='300' src=DisplayImage?userid="+i.getitemid()+"&flag=2></img>\r\n"+
				"			          </div>");
		
		String suserid=null;
		HttpSession ses=request.getSession(false);
		if(HttpResponseHandler.isLogin(request))
			suserid=(String)ses.getAttribute("username");
		System.out.print("At views sessio  "+suserid);
	//	System.out.print("from item object "+userid);
		if(u.getId().equals(suserid))
		{
			out.println("<div><a href=\"EditProfile\">Edit Product Details</a>\r\n" + 
					"				 </div>\r\n" + 
					"				 <div> <a href=uploadImage.jsp?id="+i.getitemid()+"&flag=2>Add more Image to product</a></div>");
		}
		else
		{
			out.println("\r\n" + 	
					"		   <br/>      <a href=\"Chat?rid="+i.getuserid()+"\">Chat</a>\r\n" +
					"				 </div>\r\n" + 
					"				 \r\n" + 
					"			\r\n" + 
					"				 \r\n" + 
					"				    <div>\r\n" + 
					"		         \r\n"
							+ "<a href=\"Order?itemid="+i.getitemid()+"\">Order Now</a>");
		}
		out.println("</div><div class=\"col_1_of_2 span_1_of_2\">	\r\n" + 
				"		    		\r\n" + 
				"					\r\n" + 
				"					<div>\r\n" + 
				"					<h2>Details: <b>"+i.getName()+", "+i.getdescription()+"</b></h2>\r\n" + 
				"					</div>\r\n" + 
				"					\r\n" + 
				"					<br/>\r\n" + 
				"					\r\n" + 
				"					<div>\r\n" + 
				"					<b> Address :"+i.getstreet()+"</b>\r\n" +  
				"					</div>\r\n" + 
				"		    		\r\n" + 
				"					<br/>\r\n" + 
				"					\r\n" + 
				"					<div>\r\n" + 
				"					<b> Price :-</b>\r\n" + 
				"					Rs "+i.getrent()+"/ Month\r\n" + 
				"					</div>\r\n" + 
				"					\r\n" + 
				"					<br/>\r\n" + 
				"					\r\n" + 
				"					<div>\r\n" + 
				"					<b> Owner :-</b>\r\n" + 
				"					 "+u.getName()+","+u.getPhone()+"+<br/>Email:-  "+u.getEmail()+"\r\n" + 
				"					</div>\r\n" + 
				"						  \r\n" + 
				"				     <br/>\r\n" + 
				"		          \r\n" + 
				"					\r\n" + 
				"		          </div></div>"
				+ "              <div class=\"clear\"></div>\r\n" + 
				"		    </form>\r\n" + 
				"    	  </div> \r\n" + 
				"        </div>");
		HttpResponseHandler.bottomView(out);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
