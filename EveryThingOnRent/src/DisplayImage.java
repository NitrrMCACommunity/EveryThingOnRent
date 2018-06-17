

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.corba.se.pept.transport.Connection;

/**
 * Servlet implementation class DisplayImage
 */
@WebServlet("/DisplayImage")
public class DisplayImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()    public DisplayImage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("image/jpg");
		String userid=request.getParameter("userid");
		String flag=request.getParameter("flag");
		System.out.println(flag);
		ServletOutputStream o = response.getOutputStream();
		java.sql.Connection con=Dbopr.getConnection();
		try {
			Blob images=null;
			if(flag.equals("1"))
				images=Dbopr.displayProfile(userid,con);
			else if(flag.equals("2"))
				images=Dbitemopr.displayImage(userid,con);
        if(images!=null) {
        	System.out.println("Imaage not null");
        	java.io.InputStream in=images.getBinaryStream();
        	 int length = (int) images.length();
        	 int bufferSize = 1024;
        	  byte[] buffer = new byte[bufferSize];
        	  response.setContentType("image/jpg");
        	  while ((length = in.read(buffer)) != -1) 
        	  {
        		  o.write(buffer, 0, length);
        	  }
        	  }
        con.close();
        System.out.println("Done At displayimages"+userid);
        }catch(Exception e)
		{
        	System.out.println("Exception at DisplayImages.java  "+e);
		}
		finally {
	        try {
	            if (con != null && !con.isClosed())
	                {
	                con.close();
	                Thread.sleep(1000);
	                 }
	            }
	        catch (SQLException e) {
	            e.printStackTrace();} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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

}
