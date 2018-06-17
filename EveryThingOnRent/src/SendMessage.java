

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SendMessage
 */
@WebServlet({ "/SendMessage", "/Send" })
public class SendMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendMessage() {
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
		HttpSession ses=request.getSession(false);
		String reciever=request.getParameter("rid");
		String msg=request.getParameter("msg");
		if(ses!=null)
		{
			System.out.println("inside send msg");
			String sender=(String)ses.getAttribute("username");
			Message m=new Message();
			m.setmsg(msg);
			m.setsender(sender);
			m.setreceiver(reciever);
			if(m.Sendmsg()) {
			  RequestDispatcher rd=request.getRequestDispatcher("Chat?rid="+reciever+"");
			  rd.forward(request, response);
				System.out.println("sent");}
			else {
				
				response.sendRedirect("Chat?rid="+reciever+"");
				System.out.println("Not sent");
		}
	}

	}
}

