import java.io.PrintWriter;
import java.util.LinkedList;

public class ShowResult {
	public static void displayRecords(PrintWriter out,int page)
	{
		int total=6;
		if(page==1) {}
		else
		{
			page=page-1;
			page=page*total+1;
		}
		LinkedList<Item> list=Dbitemopr.fetchItems(page, page+total);
		int c=1;
		for(Item i:list)
		{
			if(c>6)
				break;
			else
				c++;
			out.print(" 		  <div class=\"clear\"></div>			\r\n" + 
					"				   </div>\r\n" + 
					"				  <div class=\"content-bottom\">\r\n" + 
					"				   <div class=\"box1\">\r\n" + 
					"				    <div class=\"col_1_of_3 span_1_of_3\"><a href=\"ItemView?itemid="+i.getitemid()+"\">\r\n" + 
					"				     <div class=\"view view-fifth\">\r\n" + 
					"				  	  <div class=\"top_box\">\r\n" + 
					"					  	<h3 class=\"m_1\">"+i.getName()+"</h3>\r\n" + 
					"					  	<p class=\"m_2\">Item</p>\r\n" + 
					"				         <div class=\"grid_img\">\r\n" + 
					"						   <div class=\"css3\"><img width='250' height='250' src=DisplayImage?userid="+i.getitemid()+"&flag=2></img></div>\r\n" + 
					"					          <div class=\"mask\">\r\n" + 
					"	                       		<div class=\"info\">Quick View</div>\r\n" + 
					"			                  </div>\r\n" + 
					"	                    </div>\r\n" + 
					"                       <div class=\"price\">Rs"+i.getrent()+"<font color=white>............................... </font>"
							+ "<font color=red><a href=\"ChartSer?flag=1&itemid="+i.getitemid()+"\">Add to Cart</a></font></div>\r\n" + 
					"					   </div>\r\n" + 
					"					    </div>\r\n" + 
					"					   <span class=\"rating\">\r\n" + 
					"				        <input type=\"radio\" class=\"rating-input\" id=\"rating-input-1-5\" name=\"rating-input-1\">\r\n" + 
					"				        <label for=\"rating-input-1-5\" class=\"rating-star1\"></label>\r\n" + 
					"				        <input type=\"radio\" class=\"rating-input\" id=\"rating-input-1-4\" name=\"rating-input-1\">\r\n" + 
					"				        <label for=\"rating-input-1-4\" class=\"rating-star1\"></label>\r\n" + 
					"				        <input type=\"radio\" class=\"rating-input\" id=\"rating-input-1-3\" name=\"rating-input-1\">\r\n" + 
					"				        <label for=\"rating-input-1-3\" class=\"rating-star1\"></label>\r\n" + 
					"				        <input type=\"radio\" class=\"rating-input\" id=\"rating-input-1-2\" name=\"rating-input-1\">\r\n" + 
					"				        <label for=\"rating-input-1-2\" class=\"rating-star\"></label>\r\n" + 
					"				        <input type=\"radio\" class=\"rating-input\" id=\"rating-input-1-1\" name=\"rating-input-1\">\r\n" + 
					"				        <label for=\"rating-input-1-1\" class=\"rating-star\"></label>&nbsp;\r\n" + 
					"		        	  (45)\r\n" + 
					"		    	      </span>\r\n" + 
					"						 <ul class=\"list\">\r\n" + 
					"						  <li>\r\n" + 
					"						  	<img src=\"images/plus.png\" alt=\"\"/>\r\n" + 
					"						  	<ul class=\"icon1 sub-icon1 profile_img\">\r\n" + 
					"							  <li><a class=\"active-icon c1\" href=\"Order?itemid="+i.getitemid()+"\">Order Now </a>\r\n" + 
					"								<ul class=\"sub-icon1 list\">\r\n" + 
					"									<li><h3>sAt "+i.getName()+"</h3><a href=\"#\"></a></li>\r\n" + 
					"									<li><p> "+i.getdescription()+" at "+i.getcity()+"<a href=ItemView?itemid="+i.getitemid()+">View</a></p></li>\r\n" + 
					"								</ul>\r\n" + 
					"							  </li>\r\n" + 
					"							 </ul>\r\n" + 
					"						   </li>\r\n" + 
					"					     </ul>");
		}
		out.println(" 	  <div class=\"clear\"></div>\r\n" + 
				"			    	</a></div>\r\n" + 
				"				  <div class=\"clear\"></div>\r\n" + 
				"			    </div>\r\n" + 
				"			  </div>\r\n" + 
				"			 </div>\r\n" + 
				"        </div>");
		
	}

}
