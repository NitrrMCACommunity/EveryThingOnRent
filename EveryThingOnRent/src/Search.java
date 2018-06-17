
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Search
 */
@WebServlet({ "/Search", "/CatSearch" })
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String key=request.getParameter("key");
		if(key==null)
		{
			response.sendRedirect("Index");
		}
		final int total=6;
		int page;
		String p=request.getParameter("page");
		if(p==null)
		page=1;
		else
		page=Integer.parseInt(p);
		LinkedList<Item> list=SearchOperation.getSearchResult(key);
		int record=((page-1)*total)+1;
		if(list==null)
			out.print("No record");
		if(record>list.size())
		{
			HttpResponseHandler.topViews(request, out);
			out.print("No Product found");
			HttpResponseHandler.bottomView(out);
		}
		else
		{
			HttpResponseHandler.topViews(request, out);
			HttpResponseHandler.showResult(out, list, record);
			HttpResponseHandler.bottomView(out);
			
		}
		}catch(Exception e)
		{
			System.out.println(e);
			response.sendRedirect("Index");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
