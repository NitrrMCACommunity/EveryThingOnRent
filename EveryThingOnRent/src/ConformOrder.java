

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ConformOrder
 */
@WebServlet("/ConformOrder")
public class ConformOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConformOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
		String pmsg=null;
		if(HttpResponseHandler.isLogin(request))
		{
			HttpSession ses=request.getSession();
			String vendorid=(String)ses.getAttribute("username");
			User vender=Dbopr.getUser(vendorid);
			String custid=request.getParameter("custid");
			System.out.println(custid);
			String itemid=request.getParameter("itemid");
			Item i=Dbitemopr.getItem(itemid);
			if(i!=null)
			{
				if(vendorid.equals(i.getitemid()))
				{
					System.out.println("!=");
					System.out.println(i.getuserid()+" ,"+vendorid);
					response.sendRedirect("Index");
				}
				else
				{
					String msg="Your Order for the pruduct "+i.getName()+" On everything on rent has been varify by the Vendore you can communicate with vendore using our chat system "
							+ ",Owner's phone:"+vender.getPhone()+" Name:-"+vender.getName()+"\n, From: Everything On rent";
					Message m=new Message();
					User cust=Dbopr.getUser(custid);
					m.setmsg(msg);
					m.setsender(vendorid);
					m.setreceiver(custid);
					StringBuffer str = new StringBuffer();
					System.out.println("Before phone");
					int nResult=UserVarifyCode.SendSMS(cust.getPhone(), msg, str);
					System.out.println(str+"  "+nResult);
					UserVarifyCode.SendEmail(cust.getEmail(), "EverythingOnRent:Varify order", msg);
					m.Sendmsg();
					response.sendRedirect("Chat?rid="+custid);
				}
		}
			else
			{
				printErrorMsg("There is something wrong with the page you request",request,response,out);
			}
	}
		else
			printErrorMsg("There is something wrong with the page you request",request,response,out);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response,String msg) throws ServletException, IOException {
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
