

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ChartSer
 */
@WebServlet("/ChartSer")
public class ChartSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChartSer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession ses=request.getSession(false);
		if(ses==null)
		{
			response.sendRedirect("Login");
		}
		else
		{
			PrintWriter out=response.getWriter();
			String userid=(String)ses.getAttribute("username");
			String flag=request.getParameter("flag");
			String itemid=request.getParameter("itemid");
			if(flag==null)
			{
				printErrorMsg("Something going wrong please try again",request,response,out);
			}
			else if(flag.equals("1")&&itemid!=null) 
			{
			MyCart c=new MyCart();
			c.setitemid(itemid);
			c.setuserid(userid);
			CartOperation.insert(c);
			response.sendRedirect("Index");
			}
			else if(flag.equals("2")&&itemid!=null)
			{
				CartOperation.deleteCart(itemid,userid);
				response.sendRedirect("Index");
			}
			else if(flag.equals("3"))
			{
				CartOperation.clearCart(userid);
				response.sendRedirect("Index");
			}
			else
			{
				response.sendRedirect("Index");
			}
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
