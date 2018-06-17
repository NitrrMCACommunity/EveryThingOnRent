

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Additem
 */
@WebServlet("/Additem")
public class InsertItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertItem() {
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
		String msg=request.getParameter("msg");
		if(msg==null)
			msg="";
		HttpResponseHandler.topViews(request, out);
		out.print("      <div class=\"register_account\">\r\n" + 
				"          	<div class=\"wrap\">\r\n" + 
				"    	      <h4 class=\"title\"><b>Add an Product</b><font color='red'>"+msg+"</font></h4>\r\n" + 
				"    		   <form action=\"AddItems\" method=\"post\">\r\n" + 
				"    			 <div class=\"col_1_of_2 span_1_of_2\">\r\n" + 
				"\r\n" + 
				"		   			 <div>\r\n" + 
				"					 <b>Details about Product:</b>\r\n" + 
				"					 <input type=\"text\" name=\"i_name\" value=\"\" onfocus=\"this.value = '';\" onblur=\"if (this.value == '') {this.value = 'itemname';}\"></div>\r\n" + 
				"		    			\r\n" + 
				"						\r\n" +
				"						 <div>\r\n" + 
				"					 <b>Category:</b>\r\n" + 
				"					 <input type=\"text\" name=\"cat\" value=\"\" onfocus=\"this.value = '';\" onblur=\"if (this.value == '') {this.value = 'Product Category';}\"></div>\r\n" + 
			
				"		    			"+
				"				 \r\n" + 
				"						\r\n" + 
				"						\r\n" + 
				"						\r\n" + 
				"						\r\n" + 
				"						\r\n" + 
				"						\r\n" + 
				"					  <b>Product Description:</b>		        \r\n" + 
				"		          <div><input type=\"text\"name=\"dec\" value=\"\" onfocus=\"this.value = '';\" onblur=\"if (this.value == '') {this.value = 'itemdescription';}\"></div>\r\n" + 
				"		           \r\n" + 
				"				     <b>Rent/Month:</b>				  \r\n" + 
				"		    		<div><input type=\"text\"name=\"rent\" value=\"\" onfocus=\"this.value = '';\" onblur=\"if (this.value == '') {this.value = 'month';}\"></div>\r\n" + 
				"            \r\n" + 
				"					 \r\n" + 
				"					 </div>\r\n" + 
				"				 \r\n" + 
				"		    	  <div class=\"col_1_of_2 span_1_of_2\">\r\n" + 
				"                  \r\n" + 
				"			       	\r\n" + 
				"				  <b>Location of product:</b>\r\n" + 
				"					  <div><input type=\"text\"name=\"addr\" value=\"\" onfocus=\"this.value = '';\" onblur=\"if (this.value == '') {this.value = 'fulladdress';}\"></div>\r\n" + 
				"		    			  \r\n" + 
				"				\r\n" + 
				"                 	<div>\r\n" + 
				"					<b>States</b>\r\n" + 
				"					<select id=\"state\" name=\"state\"onchange=\"change_state(this.value)\" class=\"frm-field required\">\r\n" + 
				"		                      <option value=\"\">select state</option> \r\n" + 
				"					      <option value=\"AP\">Andhra Pradesh</option> \r\n" + 
				"						     <option value=\"AR\">Arunachal pradesh</option> \r\n" + 
				"							    <option value=\"AS\">Assam</option> \r\n" + 
				"								   <option value=\"BH\">Bihar</option> \r\n" + 
				"								      <option value=\"CH\">Chandigarh</option> \r\n" + 
				"									     <option value=\"CG\">Chhatisgarh</option> \r\n" + 
				"										    <option value=\"DL\">Delhi</option>   \r\n" + 
				"											   <option value=\"GO\">Goa</option> \r\n" + 
				"											      <option value=\"GU\">Gujarat</option> \r\n" + 
				"												     <option value=\"HR\">Haryana</option> \r\n" + 
				"						                                 <option value=\"HP\">Himachal Pradesh</option> \r\n" + 
				"														    <option value=\"JK\">Jammu & Kashmir</option> \r\n" + 
				"															   <option value=\"JH\">Jharkhand</option> \r\n" + 
				"															      <option value=\"KR\">Karnataka</option> \r\n" + 
				"																     <option value=\"KL\">Kerala</option> \r\n" + 
				"																	    <option value=\"MP\">Madhya Pardesh</option> \r\n" + 
				"																		   <option value=\"MH\">Maharashtra</option> \r\n" + 
				"																		   <option value=\"OR\">Orissa</option> \r\n" + 
				"                                                                               <option value=\"PJ\">Punjab</option> \r\n" + 
				"                                                                                <option value=\"RJ\">Rajasthan</option> \r\n" + 
				"																				   <option value=\"TN\">Tamil Nadu</option> \r\n" + 
				"																				      <option value=\"TR\">Tripura</option> \r\n" + 
				"																					     <option value=\"UP\">Uttar Pardesh</option> \r\n" + 
				"																						    <option value=\"UT\">Uttaranchal</option>   \r\n" + 
				"																							   <option value=\"WB\">West Bengal</option> \r\n" + 
				"																							  \r\n" + 
				"		          </select>\r\n" + 
				"				  </div>	\r\n" + 
				"				  \r\n" + 
				"				  \r\n" + 
				"                    <b>Product City:</b>\r\n" + 
				"					  <div><input type=\"text\"name=\"city\" value=\"\" onfocus=\"this.value = '';\" onblur=\"if (this.value == '') {this.value = 'itemcity';}\"></div>\r\n" + 
				"					 			<br/>\r\n" + 
				"  				  <b>:Mention all neccessary information in product description related to avilable quantity and you terms and condition :</b>\r\n" + 
				"		          </div>\r\n" + 
				"				  \r\n" + 
				"				 \r\n" + 
				"		         <button class=\"grey\">Submit</button>\r\n" + 
				"				 \r\n" + 
				"		         <div class=\"clear\"></div>\r\n" + 
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
