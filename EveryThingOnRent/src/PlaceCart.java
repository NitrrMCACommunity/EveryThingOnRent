

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class PlaceCart
 */
@WebServlet("/PlaceCart")
public class PlaceCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlaceCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		try {
		String fulladdr=request.getParameter("addr");
		String city=request.getParameter("city");
		String pin=request.getParameter("pin");
		String phone=request.getParameter("phone");
		HttpSession ses=request.getSession();
		if(ses!=null)
		{
			String userid=(String)ses.getAttribute("username");
			User u=Dbopr.getUser(userid);
			LinkedList<MyCart> list=CartOperation.getCart(userid);
			if(list==null)
			{
				printErrorMsg("You have no Product in cart",request,response,out);
			}
			else
			{
				for(MyCart c:list)
				{
					Item i=Dbitemopr.getItem(c.getitemid());
					CalogOperations.insert(c.getitemid(), userid, i.getuserid(), 1);
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
					StringBuffer strbuf=new StringBuffer();
					UserVarifyCode.SendSMS(vendor.getPhone(), msg1,strbuf);
					m.Sendmsg();
					CartOperation.deleteCart(c.getitemid(), userid);
					System.out.println(i.getuserid());
				}
				printErrorMsg("Order has been placed Succefully",request,response,out);
			}
			
	}
		else
		{
			response.sendRedirect("Login");
		}
}catch(Exception e)
		{
	System.out.println("Problem at place order  "+e);
	printErrorMsg("Something went wrong please try again",request,response,out);
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	protected void printErrorMsg(String msg,HttpServletRequest req,HttpServletResponse res,PrintWriter out)
	{
		
		HttpResponseHandler.topViews(req, out);
		out.print(msg);
		HttpResponseHandler.bottomView(out);
	}

}
