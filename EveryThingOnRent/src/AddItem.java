
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddItem
 */
@WebServlet({ "/AddItem", "/AddProduct", "/additems", "/AddItems" })
public class AddItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddItem() {
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
		response.setContentType("text/html");
		try {
		PrintWriter out=response.getWriter();
		Item i=new Item();
		i.setName(request.getParameter("i_name"));
		if(i.getName()==null)
			i.setName("");	
		i.setitemid(Dbitemopr.nextItemIdGenerator());
		if(i.getitemid()==null)
			i.setitemid("null");
		i.setCity(request.getParameter("city"));
		i.setfulladdress(request.getParameter("addr"));
		i.setrent(request.getParameter("rent"));
		i.setcategory(request.getParameter("cat"));
		i.setdescription(request.getParameter("dec"));
		i.setstate(request.getParameter("state"));
		if(HttpResponseHandler.isLogin(request))
		{
			System.out.println("Logen In");
			HttpSession ses=request.getSession(false);
			String userid=(String)ses.getAttribute("username");
			System.out.println(userid);
				i.setuserid(userid);
				Dbitemopr.insert(i);
				response.sendRedirect("ItemView?itemid="+i.getitemid()+"&userid="+userid+"");
		}
		else
		{
			out.println("please login first");
			RequestDispatcher rd=request.getRequestDispatcher("login.html");
			rd.forward(request, response);				
			}
			}catch(Exception e)
				{
			response.sendRedirect("Additem?msg=Sorry!!!!!Please Fill the details currectly aagai");
				}
		doGet(request, response);
	}
}

