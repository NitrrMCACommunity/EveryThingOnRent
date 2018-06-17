import javax.servlet.annotation.MultipartConfig;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.omg.CORBA_2_3.portable.InputStream;
import javax.servlet.*;
/**
 * Servlet implementation class uploadser
 */

@WebServlet({ "/UpdateProfile", "/uploadser", "/UploadProfile" })
@MultipartConfig(maxFileSize = 16177215)
public class UpdateProfile extends HttpServlet {
	private static final long serialVersionUID = -1623656324694499109L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProfile() {
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
		String userid=request.getParameter("userid");
		String flag=request.getParameter("flag");
		try {
	        java.io.InputStream inputStream=null;
			Part filePart=request.getPart("photo");
			if(filePart!=null) {
				System.out.println("Entered at ");
				System.out.println("inserted");
				inputStream=filePart.getInputStream();
			Connection con=Dbopr.getConnection();
					PreparedStatement ps=null;
					if(flag.equals("1")) {						
						if(Dbopr.isProfileUpdated(userid))
							Dbopr.removeProfile(userid);
					ps=con.prepareStatement("insert into profilepic values(?,?)");
					}
					else if(flag.equals("2")) {
						if(Dbitemopr.isProfileUpdated(userid))
							Dbitemopr.removeProfile(userid);				
					ps=con.prepareStatement("insert into itempic values(?,?)");
					}
					ps.setString(1, userid);
						ps.setBinaryStream(2, inputStream, inputStream.available());
					int m=ps.executeUpdate();
					if(m>0) {
								System.out.print("success");
								if(flag.equals("1"))
								response.sendRedirect("Profile?userid="+userid+"&flag=2");
								if(flag.equals("2"))
									response.sendRedirect("ItemView?itemid="+userid+"&flag=1");
					}
					else  
						response.sendRedirect("Profile?userid="+userid+"&flag=1");
						System.out.print("Could not");
			}
		}catch(Exception e)
		{
			System.out.println("Image could not inserted"+e);
		}
	}
}
